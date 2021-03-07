package kaptainwutax.terrainutils.terrain;

import kaptainwutax.biomeutils.source.BiomeSource;

public class OverworldChunkGenerator extends SurfaceChunkGenerator {

	public OverworldChunkGenerator(BiomeSource biomeSource) {
		super(biomeSource, 4, 8, 256, true);
	}

	@Override
	protected double computeNoiseFalloff(double depth, double scale, int y) {
		double fallOff = ((double) y - (8.5D + depth * 8.5D / 8.0D * 4.0D)) * 12.0D * 128.0D / 256.0D / scale;

		if(fallOff < 0.0D) {
			fallOff *= 4.0D;
		}

		return fallOff;
	}

	@Override
	protected void sampleNoiseColumn(double[] buffer, int x, int z) {
		this.sampleNoiseColumn(buffer, x, z, 684.4119873046875D, 684.4119873046875D, 8.555149841308594D, 4.277574920654297D, 3, -10);
	}

}