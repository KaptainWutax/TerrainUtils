package kaptainwutax;

import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.seedutils.mc.Dimension;
import kaptainwutax.seedutils.mc.MCVersion;
import kaptainwutax.terrainutils.ChunkGenerator;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFramework {
    public static boolean DEBUG = false;

    public static void randomChunkGen(MCVersion version, long seed, Dimension dimension, int size, long randomSeed, int[] heightmap) {
        BiomeSource bs = BiomeSource.of(dimension, version, seed);
        ChunkGenerator cg = ChunkGenerator.of(dimension, bs);
        assert cg != null;
        Random r = new Random(randomSeed);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int x = r.nextInt(512);
                int z = r.nextInt(512);
                int y = cg.getHeightOnGround(x, z);
                if (DEBUG) System.out.println(x + " " + z);
                assertEquals(heightmap[i * size + j], y);
            }
        }
    }

    public static void testSinglePoint(MCVersion version, long seed, Dimension dimension, int x, int z, int expectedY) {
        BiomeSource bs = BiomeSource.of(dimension, version, seed);
        ChunkGenerator cg = ChunkGenerator.of(dimension, bs);
        assert cg != null;
        assertEquals(cg.getHeightOnGround(x, z), expectedY);
    }
}
