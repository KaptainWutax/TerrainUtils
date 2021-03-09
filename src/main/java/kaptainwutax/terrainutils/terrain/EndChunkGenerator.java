package kaptainwutax.terrainutils.terrain;


import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.biomeutils.source.EndBiomeSource;
import kaptainwutax.noiseutils.simplex.SimplexNoiseSampler;
import kaptainwutax.seedutils.mc.ChunkRand;
import kaptainwutax.seedutils.util.UnsupportedVersion;

public class EndChunkGenerator extends SurfaceChunkGenerator {
	private SimplexNoiseSampler islandSimplexNoise;

	public EndChunkGenerator(BiomeSource biomeSource) {
		super(biomeSource, 2, 1, 128, true);
		ChunkRand endGenRand=new ChunkRand(biomeSource.getWorldSeed());
		endGenRand.advance(17292);
		islandSimplexNoise=new SimplexNoiseSampler(endGenRand);
	}

	@Override
	protected double[] computeNoiseRange(int x, int z) {
		double[] ds = new double[2];
		ds[0] = ((EndBiomeSource)this.biomeSource).height.sample(x,0,z) - 8.0f;
		ds[1]  = ds[0]  > 0.0 ? 0.25 : 1.0;
		return ds;
	}

	@Override
	public int getSeaLevel() {
		return 0;
	}

	@Override
	protected void sampleNoiseColumn(double[] buffer, int x, int z) {
		this.sampleNoiseColumn(buffer, x, z, 684.4119873046875D, 684.4119873046875D, 8.555149841308594D, 4.277574920654297D, 3, -10);
	}

}