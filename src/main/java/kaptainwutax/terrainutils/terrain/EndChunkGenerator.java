package kaptainwutax.terrainutils.terrain;


import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.biomeutils.source.EndBiomeSource;
import kaptainwutax.terrainutils.utils.NoiseSettings;

public class EndChunkGenerator extends SurfaceChunkGenerator {

    public EndChunkGenerator(BiomeSource biomeSource) {
        super(biomeSource, 128,2, 1,
                NoiseSettings.create(2.0, 1.0, 80.0, 160.0)
                        .addTopSlide(-3000, 64, -46)
                        .addBottomSlide(-30, 7, 1),
                0.0, 0.0, true);
    }

    @Override
    protected double[] getDepthAndScale(int x, int z) {
        double[] depthAndScale = new double[2];
        depthAndScale[0] = ((EndBiomeSource) this.biomeSource).height.sample(x, 0, z) - 8.0f;
        depthAndScale[1] = depthAndScale[0] > 0.0 ? 0.25 : 1.0;
        return depthAndScale;
    }

    @Override
    public int getSeaLevel() {
        return 0;
    }
}