package kaptainwutax.terrainutils.terrain;

import kaptainwutax.biomeutils.Biome;
import kaptainwutax.noiseutils.utils.MathHelper;
import kaptainwutax.terrainutils.ChunkGenerator;
import kaptainwutax.noiseutils.noise.NoiseSampler;
import kaptainwutax.noiseutils.perlin.OctavePerlinNoiseSampler;
import kaptainwutax.noiseutils.simplex.OctaveSimplexNoiseSampler;
import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.seedutils.mc.ChunkRand;
import kaptainwutax.seedutils.mc.MCVersion;

import java.util.HashMap;
import java.util.Map;

import static kaptainwutax.noiseutils.utils.MathHelper.maintainPrecision;
import static kaptainwutax.terrainutils.utils.MathHelper.clampedLerp;
import static kaptainwutax.terrainutils.utils.MathHelper.sqrt;

public abstract class SurfaceChunkGenerator extends ChunkGenerator {

    private final int verticalNoiseResolution;
    private final int horizontalNoiseResolution;
    private final int noiseSizeX;
    private final int noiseSizeY;
    private final int noiseSizeZ;
    private final OctavePerlinNoiseSampler minLimitPerlinNoise;
    private final OctavePerlinNoiseSampler maxLimitPerlinNoise;
    private final OctavePerlinNoiseSampler mainPerlinNoise;
    protected final OctavePerlinNoiseSampler noiseSampler;
    private final NoiseSampler surfaceDepthNoise;
    protected final ChunkRand random;
    protected static final float[] BIOME_WEIGHT_TABLE;

    private final Map<Long, double[]> noiseColumnCache = new HashMap<>();

    public SurfaceChunkGenerator(BiomeSource biomeSource, int horizontalNoiseResolution, int verticalNoiseResolution, int worldHeight, boolean useSimplexNoise) {
        super(biomeSource);
        this.verticalNoiseResolution = verticalNoiseResolution;
        this.horizontalNoiseResolution = horizontalNoiseResolution;
        this.noiseSizeX = 16 / this.horizontalNoiseResolution;
        this.noiseSizeY = worldHeight / this.verticalNoiseResolution;
        this.noiseSizeZ = 16 / this.horizontalNoiseResolution;
        this.random = new ChunkRand(biomeSource.getWorldSeed());
        this.minLimitPerlinNoise = new OctavePerlinNoiseSampler(this.random, 16);
        this.maxLimitPerlinNoise = new OctavePerlinNoiseSampler(this.random, 16);
        this.mainPerlinNoise = new OctavePerlinNoiseSampler(this.random, 8);
        if (useSimplexNoise) {
            this.surfaceDepthNoise = new OctaveSimplexNoiseSampler(this.random, 4);
        } else {
            this.surfaceDepthNoise = new OctavePerlinNoiseSampler(this.random, 4);
        }
        this.random.advance(2620);
        this.noiseSampler = new OctavePerlinNoiseSampler(this.random, 16);
    }

    public int getNoiseSizeY() {
        return this.noiseSizeY + 1;
    }

    private double sampleNoise(int x, int y, int z, double d, double e, double f, double g) {
        double h = 0.0D;
        double i = 0.0D;
        double j = 0.0D;
        double k = 1.0D;

        for (int l = 0; l < 16; ++l) {
            double m = maintainPrecision((double) x * d * k);
            double n = maintainPrecision((double) y * e * k);
            double o = maintainPrecision((double) z * d * k);
            double p = e * k;
            h += this.minLimitPerlinNoise.getOctave(l).sample(m, n, o, p, (double) y * p) / k;
            i += this.maxLimitPerlinNoise.getOctave(l).sample(m, n, o, p, (double) y * p) / k;
            if (l < 8) {
                j += this.mainPerlinNoise.getOctave(l).sample(
                        maintainPrecision((double) x * f * k),
                        maintainPrecision((double) y * g * k),
                        maintainPrecision((double) z * f * k),
                        g * k,
                        (double) y * g * k) / k;
            }
            k /= 2.0D;
        }

        return clampedLerp(h / 512.0D, i / 512.0D, (j / 10.0D + 1.0D) / 2.0D);
    }

    protected void sampleNoiseColumn(double[] buffer, int x, int z, double d, double e, double f, double g, int i, int j) {
        double[] ds = this.computeNoiseRange(x, z);
        double h = ds[0];
        double k = ds[1];
        double scale = this.getNoiseSizeY() - 4;
        double m = 0.0D;

        for (int ry = 0; ry < this.getNoiseSizeY(); ++ry) {
            double noise = this.sampleNoise(x, ry, z, d, e, f, g);
            noise -= this.computeNoiseFalloff(h, k, ry);
            if ((double) ry > scale) {
                noise = clampedLerp(noise, j, ((double) ry - scale) / (double) i);
            } else if ((double) ry < m) {
                noise = clampedLerp(noise, -30.0D, (m - (double) ry) / (m - 1.0D));
            }
            buffer[ry] = noise;
        }
    }

    protected double[] sampleNoiseColumn(int x, int z) {
        long key = ((((long) x) & 0xFFFFFFFFL) << 32) | (((long) z) & 0xFFFFFFFFL);
        if (noiseColumnCache.containsKey(key)) {
            return noiseColumnCache.get(key);
        } else {
            double[] ds = new double[this.noiseSizeY + 1];
            this.sampleNoiseColumn(ds, x, z);
            noiseColumnCache.put(key, ds);
            return ds;
        }
    }

    @Override
    public int getHeightOnGround(int x, int z) {
        // those are the coordinates of the region in the grid chosen
        int cellX = Math.floorDiv(x, this.horizontalNoiseResolution);
        int cellZ = Math.floorDiv(z, this.horizontalNoiseResolution);
        // those are the coordinates in the chosen region
        int posX = Math.floorMod(x, this.horizontalNoiseResolution);
        int posZ = Math.floorMod(z, this.horizontalNoiseResolution);
        double percentX = (double) posX / (double) this.horizontalNoiseResolution;
        double percentZ = (double) posZ / (double) this.horizontalNoiseResolution;
        double[][] ds = new double[][] {
                this.sampleNoiseColumn(cellX, cellZ),
                this.sampleNoiseColumn(cellX, cellZ + 1),
                this.sampleNoiseColumn(cellX + 1, cellZ),
                this.sampleNoiseColumn(cellX + 1, cellZ + 1)
        };

        for (int cellY = this.noiseSizeY - 1; cellY >= 0; --cellY) {
            double xyz = ds[0][cellY];
            double xyz1 = ds[1][cellY];
            double x1yz = ds[2][cellY];
            double x1yz1 = ds[3][cellY];
            double xy1z = ds[0][cellY + 1];
            double xy1z1 = ds[1][cellY + 1];
            double x1y1z = ds[2][cellY + 1];
            double x1y1z1 = ds[3][cellY + 1];

            for (int posY = this.verticalNoiseResolution - 1; posY >= 0; --posY) {
                double percentY = (double) posY / (double) this.verticalNoiseResolution;
                // this is not a bug, mojang does not respect order
                double noise = MathHelper.lerp3(percentY, percentX, percentZ, xyz, xy1z, x1yz, x1y1z, xyz1, xy1z1, x1yz1, x1y1z1);
                int y = cellY * this.verticalNoiseResolution + posY;
                if (noise > 0.0D) {
                    return y + 1;
                }
            }
        }

        return 0;
    }

    protected abstract void sampleNoiseColumn(double[] buffer, int x, int z);

    protected double[] computeNoiseRange(int x, int z) {
        double[] depthAndScale = new double[2];
        float weightedScale = 0.0F;
        float weightedDepth = 0.0F;
        float totalWeight = 0.0F;
        float depthAtCenter = this.biomeSource.getBiomeForNoiseGen(x, 0, z).getDepth();

        for (int rx = -2; rx <= 2; ++rx) {
            for (int rz = -2; rz <= 2; ++rz) {
                Biome biome = this.biomeSource.getBiomeForNoiseGen(x + rx, 0, z + rz);
                float depth = biome.getDepth();
                float scale = biome.getScale();
                if (this.amplified && depth > 0.0F) {
                    depth = 1.0F + depth * 2.0F;
                    scale = 1.0F + scale * 4.0F;
                }

                float weight = BIOME_WEIGHT_TABLE[rx + 2 + (rz + 2) * 5] / (depth + 2.0F);
                if (biome.getDepth() > depthAtCenter) {
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
        if (this.biomeSource.getVersion().isNewerOrEqualTo(MCVersion.v1_16)) {
            depthAndScale[0] = weightedDepth * 0.265625;
            depthAndScale[1] = 96.0 / weightedScale;
        } else {
            depthAndScale[0] = (double) weightedDepth + this.sampleNoise(x, z);
            depthAndScale[1] = weightedScale;
        }
        return depthAndScale;
    }

    private double sampleNoise(int x, int y) {
        double noise = this.noiseSampler.sample(x * 200, 10.0D, y * 200, 1.0D, 0.0D, true) / 8000.0D;
        if (noise < 0.0D) {
            noise = -noise * 0.3D;
        }

        noise = noise * 3.0D - 2.0D;
        if (noise < 0.0D) {
            noise /= 28.0D;
        } else {
            if (noise > 1.0D) {
                noise = 1.0D;
            }
            noise /= 40.0D;
        }

        return noise;
    }

    protected double computeNoiseFalloff(double depth, double scale, int y){
        double fallOff = ((double) y - (8.5D + depth * 8.5D / 8.0D * 4.0D)) * 12.0D * 128.0D / 256.0D / scale;

        if(fallOff < 0.0D) {
            fallOff *= 4.0D;
        }

        return fallOff;
    }


    static {
        BIOME_WEIGHT_TABLE = new float[25];
        for (int rx = -2; rx <= 2; ++rx) {
            for (int rz = -2; rz <= 2; ++rz) {
                float f = 10.0F / sqrt((float) (rx * rx + rz * rz) + 0.2F);
                BIOME_WEIGHT_TABLE[rx + 2 + (rz + 2) * 5] = f;
            }
        }
    }
}