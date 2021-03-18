package kaptainwutax.v1_16;

import kaptainwutax.biomeutils.source.OverworldBiomeSource;
import kaptainwutax.terrainutils.terrain.OverworldChunkGenerator;
import kaptainwutax.terrainutils.ChunkGenerator;
import kaptainwutax.seedutils.mc.Dimension;
import kaptainwutax.seedutils.mc.MCVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static kaptainwutax.TestFramework.randomChunkGen;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TerrainTest {
    private static final int[] heightmap_14 = {
            46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 45,
            46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46,
            46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46,
            46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46,
            46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46,
            46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46,
            46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46,
            45, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46,
            45, 45, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46, 46,
            45, 45, 45, 46, 46, 46, 46, 46, 47, 46, 46, 46, 46, 46, 46, 46,
            44, 45, 45, 46, 46, 46, 46, 47, 47, 47, 47, 47, 47, 47, 47, 47,
            44, 45, 45, 46, 46, 46, 47, 47, 47, 47, 47, 47, 47, 47, 47, 47,
            44, 44, 45, 46, 46, 46, 47, 47, 48, 48, 48, 48, 48, 48, 47, 47,
            43, 45, 45, 46, 47, 47, 47, 48, 48, 48, 48, 48, 48, 48, 47, 47,
            43, 45, 46, 47, 47, 48, 48, 48, 48, 48, 48, 48, 48, 47, 47, 47,
            43, 45, 46, 47, 48, 48, 48, 48, 48, 48, 48, 48, 48, 47, 47, 46
    };




    @Test
    @DisplayName("Test Height map for 1.14")
    public void testHeight() {
        OverworldBiomeSource bs = new OverworldBiomeSource(MCVersion.v1_14, 1L);
        OverworldChunkGenerator cg = (OverworldChunkGenerator) ChunkGenerator.of(Dimension.OVERWORLD, bs);
        for (int i = 0; i < 16 * 16; i++) {
            assertEquals(heightmap_14[i], cg.getHeightOnGround(i / 16, i % 16));
        }

    }
//
//    @Test
//    @DisplayName("Test Height map for 1.16")
//    public void test1_16() {
//        randomChunkGen(MCVersion.v1_16, 541515181818L,Dimension.OVERWORLD,16,hei)
//    }
//
//    @Test
//    @DisplayName("Test Height map 2 for 1.16")
//    public void test1_16_2() {
//        // NOT CORRECT YET FIXME
//        OverworldBiomeSource bs = new OverworldBiomeSource(MCVersion.v1_16, 541515181818L);
//        ChunkGenerator cg = ChunkGenerator.of(Dimension.OVERWORLD, bs);
//        int size = 32;
//        assert cg != null;
//        Random r = new Random(21382138983289132L);
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                int x = r.nextInt(512);
//                int z = r.nextInt(512);
//                int y = cg.getHeightOnGround(x, z);
//                System.out.println(x + " " + z);
//                assertEquals(heightmap_16_2[i * size + j], y);
//            }
//        }
//    }
//
//
//     Bootstrap.register();
//    long seed = 541515181818L;
//    //        BiomeManager biomeManager = new BiomeManager(new OverworldBiomeProvider(seed, false, false), BiomeManager.func_235200_a_(seed), FuzzedBiomeMagnifier.INSTANCE);
//    NoiseChunkGenerator noiseChunkGenerator = new NoiseChunkGenerator(new OverworldBiomeProvider(seed, false, false), seed, OverworldPreset(new DimensionStructuresSettings(true), false));
//    int yy = noiseChunkGenerator.getOffset(203 ,49, Heightmap.Type.WORLD_SURFACE_WG);
//        System.out.printf("%d%n ", yy);
//    int size = 32;
//    Random r = new Random(21382138983289132L);
//        System.out.print("{");
//        for (int i = 0; i < size; i++) {
//        // System.out.print("[");
//        for (int j = 0; j < size; j++) {
//            int x = r.nextInt(512);
//            int z = r.nextInt(512);
//            int y = noiseChunkGenerator.getOffset(x, z, Heightmap.Type.OCEAN_FLOOR_WG);
//            System.out.printf("%d ,", y);
//        }
//        //System.out.println("]");
//        System.out.println();
//    }
//        System.out.print("};");
//        System.out.println();

}
