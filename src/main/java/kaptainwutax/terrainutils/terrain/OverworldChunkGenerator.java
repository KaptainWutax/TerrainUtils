package kaptainwutax.terrainutils.terrain;

import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.mcutils.block.Block;
import kaptainwutax.mcutils.block.Blocks;
import kaptainwutax.terrainutils.utils.NoiseSettings;

public class OverworldChunkGenerator extends SurfaceChunkGenerator {

    public OverworldChunkGenerator(BiomeSource biomeSource) {
        super(biomeSource, 256, 1, 2,
                NoiseSettings.create(0.9999999814507745, 0.9999999814507745, 80.0, 160.0)
                        .addTopSlide(-10, 3, 0)
                        .addBottomSlide(-30, 0, 0),
                1.0D, -0.46875D, true);
    }

    @Override
    public Block getDefaultBlock() {
        return Blocks.STONE;
    }

    @Override
    public Block getDefaultFluid() {
        return Blocks.WATER;
    }
}