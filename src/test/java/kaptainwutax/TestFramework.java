package kaptainwutax;

import kaptainwutax.biomeutils.source.OverworldBiomeSource;
import kaptainwutax.seedutils.mc.Dimension;
import kaptainwutax.seedutils.mc.MCVersion;
import kaptainwutax.terrainutils.ChunkGenerator;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFramework {
    public static void randomChunkGen(MCVersion version, long seed, Dimension dimension, int size, long randomSeed, int[] heightmap) {
        OverworldBiomeSource bs = new OverworldBiomeSource(version, seed);
        ChunkGenerator cg = ChunkGenerator.of(dimension, bs);
        assert cg != null;
        Random r = new Random(randomSeed);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int x = r.nextInt(512);
                int z = r.nextInt(512);
                int y = cg.getHeightOnGround(x, z);
                assertEquals(heightmap[i * size + j], y);

            }
        }
    }
}
