package kaptainwutax.terrainutils.terrain;

import kaptainwutax.biomeutils.biome.Biome;
import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.mcutils.block.Block;
import kaptainwutax.mcutils.block.Blocks;
import kaptainwutax.mcutils.rand.ChunkRand;
import kaptainwutax.mcutils.state.Dimension;
import kaptainwutax.mcutils.version.MCVersion;
import kaptainwutax.noiseutils.noise.NoiseSampler;
import kaptainwutax.noiseutils.perlin.OctavePerlinNoiseSampler;
import kaptainwutax.noiseutils.simplex.OctaveSimplexNoiseSampler;
import kaptainwutax.noiseutils.utils.MathHelper;
import kaptainwutax.terrainutils.TerrainGenerator;
import kaptainwutax.terrainutils.utils.NoiseSettings;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static kaptainwutax.noiseutils.utils.MathHelper.maintainPrecision;
import static kaptainwutax.terrainutils.utils.MathHelper.clampedLerp;
import static kaptainwutax.terrainutils.utils.MathHelper.sqrt;

public abstract class SurfaceGenerator extends TerrainGenerator {

	protected static final float[] BIOME_WEIGHT_TABLE;

	static {
		BIOME_WEIGHT_TABLE = new float[25];
		for(int rx = -2; rx <= 2; ++rx) {
			for(int rz = -2; rz <= 2; ++rz) {
				float f = 10.0F / sqrt((float)(rx * rx + rz * rz) + 0.2F);
				BIOME_WEIGHT_TABLE[rx + 2 + (rz + 2) * 5] = f;
			}
		}
	}

	protected final OctavePerlinNoiseSampler depthNoise;
	protected final ChunkRand random;
	private final int chunkHeight;
	private final int chunkWidth;
	private final int noiseSizeX;
	private final int noiseSizeY;
	private final int noiseSizeZ;
	private final NoiseSettings noiseSettings;
	private final OctavePerlinNoiseSampler minLimitPerlinNoise;
	private final OctavePerlinNoiseSampler maxLimitPerlinNoise;
	private final OctavePerlinNoiseSampler mainPerlinNoise;
	private final NoiseSampler surfaceDepthNoise;
	private final double densityFactor;
	private final double densityOffset;
	private final Map<Long, double[]> noiseColumnCache = new HashMap<>();
	private final Map<Long, Block[]> columnCache = new HashMap<>();
	private final int worldHeight;

	public SurfaceGenerator(BiomeSource biomeSource,
							int worldHeight,
							int horizontalNoiseResolution,
							int verticalNoiseResolution,
							NoiseSettings noiseSettings,
							double densityFactor,
							double densityOffset,
							boolean useSimplexNoise) {
		super(biomeSource);
		this.worldHeight = worldHeight;
		this.chunkHeight = verticalNoiseResolution * 4;
		this.chunkWidth = horizontalNoiseResolution * 4;
		this.noiseSettings = noiseSettings;
		this.noiseSizeX = 16 / this.chunkWidth;
		this.noiseSizeY = worldHeight / this.chunkHeight;
		this.noiseSizeZ = 16 / this.chunkWidth;
		this.random = new ChunkRand(biomeSource.getWorldSeed());
		if(version.isOlderThan(MCVersion.v1_15)) {
			// those lines can be simplified to setting the lacunarity correctly to the lowest (FIXME)
			this.minLimitPerlinNoise = new OctavePerlinNoiseSampler(this.random, 16);
			this.maxLimitPerlinNoise = new OctavePerlinNoiseSampler(this.random, 16);
			this.mainPerlinNoise = new OctavePerlinNoiseSampler(this.random, 8);
		} else {
			this.minLimitPerlinNoise = new OctavePerlinNoiseSampler(this.random, IntStream.rangeClosed(-15, 0));
			this.maxLimitPerlinNoise = new OctavePerlinNoiseSampler(this.random, IntStream.rangeClosed(-15, 0));
			this.mainPerlinNoise = new OctavePerlinNoiseSampler(this.random, IntStream.rangeClosed(-7, 0));
		}

		if(useSimplexNoise) {
			if(version.isOlderThan(MCVersion.v1_15)) {
				this.surfaceDepthNoise = new OctaveSimplexNoiseSampler(this.random, 4);
			} else {
				this.surfaceDepthNoise = new OctaveSimplexNoiseSampler(this.random, IntStream.rangeClosed(-3, 0));
			}
		} else {
			if(version.isOlderThan(MCVersion.v1_15)) {
				this.surfaceDepthNoise = new OctavePerlinNoiseSampler(this.random, 4);
			} else {
				this.surfaceDepthNoise = new OctavePerlinNoiseSampler(this.random, IntStream.rangeClosed(-3, 0));
			}

		}
		this.random.advance(2620);
		if(version.isOlderThan(MCVersion.v1_15)) {
			this.depthNoise = new OctavePerlinNoiseSampler(this.random, 16);
		} else {
			this.depthNoise = new OctavePerlinNoiseSampler(this.random, IntStream.rangeClosed(-15, 0));
		}
		this.densityFactor = densityFactor;
		this.densityOffset = densityOffset;
	}

	public int getMinWorldHeight() {
		return 0;
	}

	public int getMaxWorldHeight() {
		return getWorldHeight() - getMinWorldHeight();
	}

	public int getWorldHeight() {
		return worldHeight;
	}

	public abstract Block getDefaultBlock();

	public abstract Block getDefaultFluid();

	public int noiseSizeY() {
		return this.noiseSizeY + 1;
	}

	public double getMaxNoiseY() {
		return (double)this.noiseSizeY() - 4.0D;
	}

	public double getMinNoiseY() {
		return 0.0D;
	}

	private double sampleNoise(int x, int y, int z) {
		double xzScale = 684.412 * noiseSettings.samplingSettings.xzScale;
		double yScale = 684.412 * noiseSettings.samplingSettings.yScale;
		double xzStep = xzScale / noiseSettings.samplingSettings.xzFactor;
		double yStep = yScale / noiseSettings.samplingSettings.yFactor;

		double minNoise = 0.0D;
		double maxNoise = 0.0D;
		double mainNoise = 0.0D;
		double persistence = 1.0D;

		for(int octave = 0; octave < 16; ++octave) {
			double cellX = maintainPrecision((double)x * xzScale * persistence);
			double cellY = maintainPrecision((double)y * yScale * persistence);
			double cellZ = maintainPrecision((double)z * xzScale * persistence);
			double sy = yScale * persistence;
			minNoise += this.minLimitPerlinNoise.getOctave(octave).sample(cellX, cellY, cellZ, sy, (double)y * sy) / persistence;
			maxNoise += this.maxLimitPerlinNoise.getOctave(octave).sample(cellX, cellY, cellZ, sy, (double)y * sy) / persistence;
			if(octave < 8) {
				mainNoise += this.mainPerlinNoise.getOctave(octave).sample(
					maintainPrecision((double)x * xzStep * persistence),
					maintainPrecision((double)y * yStep * persistence),
					maintainPrecision((double)z * xzStep * persistence),
					yStep * persistence,
					(double)y * yStep * persistence) / persistence;
			}
			persistence /= 2.0D;
		}

		return clampedLerp(minNoise / 512.0D, maxNoise / 512.0D, (mainNoise / 10.0D + 1.0D) / 2.0D);
	}

	private double sampleNoise(OctavePerlinNoiseSampler sampler,int x,int y,int z, double noiseScaleX, double noiseScaleY, double noiseScaleZ,int octaveCount){
		// replace octave count with the one in noiseutils
		double noise = 0.0D;
		double persistence = 1.0D;
		for(int octave = 0; octave < octaveCount; ++octave) {
			double X = (double)x * persistence * noiseScaleX;
			double Y = (double)y * persistence * noiseScaleY;
			double Z = (double)z * persistence * noiseScaleZ;
			long intX = MathHelper.lfloor(X);
			long intZ = MathHelper.lfloor(Z);
			X = X - (double)intX;
			Z = Z - (double)intZ;
			intX = intX % 16777216L;
			intZ = intZ % 16777216L;
			X = X + (double)intX;
			Z = Z + (double)intZ;
			noise+=sampler.getOctave(octave).sample(X*noiseScaleX*persistence,Y*noiseScaleX*persistence,Z*noiseScaleX*persistence,0.0D,0.0D)/persistence;
			persistence /= 2.0D;
		}
		return noise;
	}

	protected void sampleNoiseColumn(double[] buffer, int x, int z) {
		double[] ds = this.getDepthAndScale(x, z);
		double depth = ds[0];
		double scale = ds[1];
		double sizeY = this.getMaxNoiseY();
		double minY = this.getMinNoiseY();
		double randomOffset = this.biomeSource.getDimension() == Dimension.OVERWORLD ? this.sampleNoise(x, z) : 0.0D;
		for(int y = 0; y < this.noiseSizeY(); ++y) {
			if (version.isOlderOrEqualTo(MCVersion.v1_13_2)){
				// find how to merge this with sampleNoise logic
				double fallOff=computeNoiseFalloff(depth,scale,y);
				double minNoise=this.sampleNoise(this.minLimitPerlinNoise,x,y,z,684.412F,684.412F,684.412F,16)/512.0D;
				double maxNoise=this.sampleNoise(this.maxLimitPerlinNoise,x,y,z,684.412F,684.412F,684.412F,16)/512.0D;
				double mainNoise=this.sampleNoise(this.mainPerlinNoise,x,y,z,684.412F/80.0f,684.412F/160.0f,684.412F/80.0f,8);
				mainNoise=(mainNoise/10.0D+1.0D)/2.0D;
				double noise= kaptainwutax.terrainutils.utils.MathHelper.clampedLerp(minNoise,maxNoise,mainNoise)-fallOff;
				if (y>29){
					double offset=(float)(y-29)/3.0F;
					noise=noise*(1.0D-offset)-10.0D*offset;
				}
				buffer[y] = noise;
				continue;
			}
			// everything below is only for 1.14+
			double noise = this.sampleNoise(x, y, z);
			if(version.isNewerOrEqualTo(MCVersion.v1_16)) {
				double fallOff = 1.0D - (double)y * 2.0D / (double)this.noiseSizeY + randomOffset;
				fallOff = fallOff * densityFactor + densityOffset;
				fallOff = (fallOff + depth) * scale;
				noise = fallOff > 0.0 ? noise + fallOff * 4.0D : noise + fallOff;
				if(this.noiseSettings.topSlideSettings.size > 0.0D) {
					noise = clampedLerp(this.noiseSettings.topSlideSettings.target, noise, ((double)(this.noiseSizeY - y) - this.noiseSettings.topSlideSettings.offset) / this.noiseSettings.topSlideSettings.size);
				}
				if(this.noiseSettings.bottomSlideSettings.size > 0.0D) {
					noise = clampedLerp(this.noiseSettings.bottomSlideSettings.target, noise, ((double)y - this.noiseSettings.bottomSlideSettings.offset) / this.noiseSettings.bottomSlideSettings.size);
				}
			} else {
				noise -= this.computeNoiseFalloff(depth, scale, y);
				if((double)y > sizeY) {
					noise = clampedLerp(noise, this.noiseSettings.topSlideSettings.target, (y - sizeY - this.noiseSettings.topSlideSettings.offset) / (double)this.noiseSettings.topSlideSettings.size);
				} else if((double)y < minY) {
					noise = clampedLerp(noise, this.noiseSettings.bottomSlideSettings.target, (minY - (double)y) / (minY - 1.0D));
				}
			}
			buffer[y] = noise;
		}
	}

	protected double[] sampleNoiseColumn(int x, int z) {
		long key = ((((long)x) & 0xFFFFFFFFL) << 32) | (((long)z) & 0xFFFFFFFFL);
		if(noiseColumnCache.containsKey(key)) {
			return noiseColumnCache.get(key);
		} else {
			double[] ds = new double[this.noiseSizeY + 1];
			this.sampleNoiseColumn(ds, x, z);
			noiseColumnCache.put(key, ds);
			return ds;
		}
	}

	public Block[] getColumnAt(int x, int z) {
		long key = ((((long)x) & 0xFFFFFFFFL) << 32) | (((long)z) & 0xFFFFFFFFL);
		if(columnCache.containsKey(key)) {
			return columnCache.get(key);
		} else {
			assert getWorldHeight() == (this.noiseSizeY * this.chunkHeight);
			Block[] buffer = new Block[this.getWorldHeight()];
			int y = this.generateColumn(buffer, x, z, null);
			assert y == 0;
			columnCache.put(key, buffer);
			return buffer;
		}
	}

	public Block getBlockAt(int x, int y, int z) {
		// long key = ((((long) y) & 0x3fff) << 50)  |((((long) x) & 0x1FFFFFF) << 25) | (((long) z) & 0x1FFFFFF);
		if(y > this.getMaxWorldHeight() || y < this.getMinWorldHeight()) {
			throw new UnsupportedOperationException(String.format("Y=%d value outside of [%d;%d]", y, getMinWorldHeight(), getMaxWorldHeight()));
		}
		return getColumnAt(x, z)[y];
	}

	public int generateColumn(Block[] buffer, int x, int z, Predicate<Block> blockPredicate) {
		// those are the coordinates of the region in the grid chosen
		int cellX = Math.floorDiv(x, this.chunkWidth);
		int cellZ = Math.floorDiv(z, this.chunkWidth);
		// those are the coordinates in the chosen region
		int posX = Math.floorMod(x, this.chunkWidth);
		int posZ = Math.floorMod(z, this.chunkWidth);
		double percentX = (double)posX / (double)this.chunkWidth;
		double percentZ = (double)posZ / (double)this.chunkWidth;
		double[][] ds = new double[][] {
			this.sampleNoiseColumn(cellX, cellZ),
			this.sampleNoiseColumn(cellX, cellZ + 1),
			this.sampleNoiseColumn(cellX + 1, cellZ),
			this.sampleNoiseColumn(cellX + 1, cellZ + 1)
		};

		for(int cellY = this.noiseSizeY - 1; cellY >= 0; --cellY) {
			double xyz = ds[0][cellY];
			double xyz1 = ds[1][cellY];
			double x1yz = ds[2][cellY];
			double x1yz1 = ds[3][cellY];
			double xy1z = ds[0][cellY + 1];
			double xy1z1 = ds[1][cellY + 1];
			double x1y1z = ds[2][cellY + 1];
			double x1y1z1 = ds[3][cellY + 1];

			for(int posY = this.chunkHeight - 1; posY >= 0; --posY) {
				double percentY = (double)posY / (double)this.chunkHeight;
				// this is not a bug, mojang does not respect order
				double noise = MathHelper.lerp3(percentY, percentX, percentZ, xyz, xy1z, x1yz, x1y1z, xyz1, xy1z1, x1yz1, x1y1z1);
				int y = cellY * this.chunkHeight + posY;
				Block block = this.getBlockFromNoise(noise, y);
				// we assume you actually have correctly filled the buffer
				if(buffer != null) {
					buffer[y] = block;
				}
				if(blockPredicate != null && blockPredicate.test(block)) {
					return y + 1;
				}
			}
		}
		return 0;
	}

	@Override
	public int getHeightOnGround(int x, int z) {
		return this.generateColumn(null, x, z, (block) -> block == this.getDefaultBlock());
	}

	@Override
	public int getFirstHeightInColumn(int x, int z, Predicate<Block> predicate) {
		return this.generateColumn(null, x, z, predicate);
	}

	protected double[] getDepthAndScale(int x, int z) {
		double[] depthAndScale = new double[2];
		int sampleRange = 2;
		float weightedScale = 0.0F;
		float weightedDepth = 0.0F;
		float totalWeight = 0.0F;
		Biome biome = this.biomeSource.getBiomeForNoiseGen(x, this.getSeaLevel(), z);
		float depthAtCenter = biome.getDepth();
		for(int rx = -sampleRange; rx <= sampleRange; ++rx) {
			for(int rz = -sampleRange; rz <= sampleRange; ++rz) {
				biome = this.biomeSource.getBiomeForNoiseGen(x + rx, this.getSeaLevel(), z + rz);
				float depth = biome.getDepth();
				float scale = biome.getScale();
				if(this.amplified && depth > 0.0F) {
					depth = 1.0F + depth * 2.0F;
					scale = 1.0F + scale * 4.0F;
				}

				float weight = BIOME_WEIGHT_TABLE[rx + 2 + (rz + 2) * 5] / (depth + 2.0F);
				if(biome.getDepth() > depthAtCenter) {
					weight /= 2.0F;
				}

				weightedScale += scale * weight;
				weightedDepth += depth * weight;
				totalWeight += weight;
			}
		}
		weightedScale /= totalWeight;
		weightedDepth /= totalWeight;
		weightedScale = weightedScale * 0.9F + 0.1F;
		weightedDepth = (weightedDepth * 4.0F - 1.0F) / 8.0F;
		// weightedDepth = (weightedDepth * 0.5F - 0.125F);
		if(this.biomeSource.getVersion().isNewerOrEqualTo(MCVersion.v1_16)) {
			depthAndScale[0] = weightedDepth * 17.0D / 64.0D;
			depthAndScale[1] = 96.0D / weightedScale;
		} else {
			double noise = this.sampleNoise(x, z);
			depthAndScale[0] = (double)weightedDepth + noise;
			if(version.isOlderOrEqualTo(MCVersion.v1_13_2)) {

				// double depth = weightedDepth;
				//		depth = depth + noise * 0.2D;
				//		depth = depth * this.settings.spread() / 8.0D;
				//		depth = this.settings.spread() + depth * 4.0D;
				depthAndScale[0] = weightedDepth + noise * 0.2D;
			}
			depthAndScale[1] = weightedScale;
		}
		return depthAndScale;
	}

	private double sampleNoise(int x, int z) {
		double noise = this.depthNoise.sample(x * 200, 10.0D, z * 200, 1.0D, 0.0D, true);
		if(version.isOlderThan(MCVersion.v1_16)) {
			if(version.isNewerOrEqualTo(MCVersion.v1_15)) {
				noise *= 65535.0D;
			}
			noise /= 8000.0D;
		}
		noise = noise < 0.0D ? -noise * 0.3D : noise;
		if(version.isNewerOrEqualTo(MCVersion.v1_16)) {
			noise = noise * 3.0D * 65535.0D / 8000.0D - 2.0D;
//			noise = noise * 24.575625D - 2.0D;
			if(noise < 0.0D) {
				// return noise * 0.009486607142857142D;
				return 17.0D * noise / 28.0D / 64.0D;
			}
			//return Math.min(noise, 1.0D) * 0.006640625D;
			return Math.min(noise, 1.0D) * 17.0D / 40.0D / 64.0D;
		}

		noise = noise * 3.0D - 2.0D;
		if(version.isOlderOrEqualTo(MCVersion.v1_13_2)) {
			if(noise < 0.0D) {
				noise = noise / 2.0D;
				if(noise < -1.0D) {
					noise = -1.0D;
				}

				noise = noise / 1.4D;
				noise = noise / 2.0D;
			} else {
				if(noise > 1.0D) {
					noise = 1.0D;
				}
				noise = noise / 8.0D;
			}
			return noise;
		}

		if(noise < 0.0D) {
			return noise / 28.0D;
		}
		return Math.min(noise, 1.0D) / 40.0D;
	}

	protected double computeNoiseFalloff(double depth, double scale, int y) {
		double fallOff = ((double)y - (8.5D + depth * 8.5D / 8.0D * 4.0D)) * 12.0D * 128.0D / 256.0D / scale;
		if(fallOff < 0.0D) {
			fallOff *= 4.0D;
		}
		return fallOff;
	}

	public Block getBlockFromNoise(double noise, int y) {
		Block block;
		if(noise > 0.0D) {
			block = this.getDefaultBlock();
		} else if(y < this.getSeaLevel()) {
			block = this.getDefaultFluid();
		} else {
			block = Blocks.AIR;
		}

		return block;
	}


}
