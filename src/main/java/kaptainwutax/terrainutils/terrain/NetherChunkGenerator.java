package kaptainwutax.terrainutils.terrain;

import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.seedutils.mc.MCVersion;
import kaptainwutax.terrainutils.utils.NoiseSettings;

public class NetherChunkGenerator extends SurfaceChunkGenerator {

	public NetherChunkGenerator(BiomeSource biomeSource) {
		super(biomeSource, 128,1, 2,
				NoiseSettings.create(1.0, 3.0, 80.0, 60.0)
						.addTopSlide(120, 3, 0)
						.addBottomSlide(320, 4, -1),
				false);
	}

	@Override
	public int getSeaLevel() {
		return 32;
	}

	@Override
	protected double[] getDepthAndScale(int x, int z) {
		if (this.version.isNewerOrEqualTo(MCVersion.v1_16)){
			return super.getDepthAndScale(x,z);
		}
		return new double[]{0.0,0.0};
	}
}