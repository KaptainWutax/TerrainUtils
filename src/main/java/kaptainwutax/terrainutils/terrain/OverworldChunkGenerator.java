package kaptainwutax.terrainutils.terrain;

import kaptainwutax.biomeutils.source.BiomeSource;

public class OverworldChunkGenerator extends SurfaceChunkGenerator {

	public OverworldChunkGenerator(BiomeSource biomeSource) {
		super(biomeSource, 4, 8, 256, true);
	}

	@Override
	protected void sampleNoiseColumn(double[] buffer, int x, int z) {
		this.sampleNoiseColumn(buffer, x, z, 684.4119873046875D, 684.4119873046875D, 8.555149841308594D, 4.277574920654297D, 3, -10);
	}

}