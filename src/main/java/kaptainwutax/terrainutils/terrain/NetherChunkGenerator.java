package kaptainwutax.terrainutils.terrain;

import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.seedutils.mc.MCVersion;

public class NetherChunkGenerator extends SurfaceChunkGenerator {

	public NetherChunkGenerator(BiomeSource biomeSource) {
		super(biomeSource, 1, 2, 128, false);
	}

	@Override
	public int getSeaLevel() {
		return 32;
	}

	@Override
	protected double[] computeNoiseRange(int x, int z) {
		if (this.version.isNewerOrEqualTo(MCVersion.v1_16)){
			return super.computeNoiseRange(x,z);
		}
		return new double[]{0.0,0.0};
	}


	@Override
	protected void sampleNoiseColumn(double[] buffer, int x, int z) {
		this.sampleNoiseColumn(buffer, x, z, 684.4119873046875D, 684.4119873046875D, 8.555149841308594D, 4.277574920654297D, 3, -10);
	}

}