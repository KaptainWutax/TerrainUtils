package kaptainwutax;

import kaptainwutax.biomeutils.source.OverworldBiomeSource;
import kaptainwutax.terrainutils.terrain.OverworldChunkGenerator;
import kaptainwutax.terrainutils.ChunkGenerator;
import kaptainwutax.seedutils.mc.Dimension;
import kaptainwutax.seedutils.mc.MCVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

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

    private static final int[] heightmap_16 = {
            75, 64, 56, 78, 65, 90, 59, 59, 66, 62, 71, 61, 64, 64, 76, 61,
            79, 55, 65, 66, 61, 65, 78, 61, 62, 92, 63, 58, 79, 60, 56, 69,
            65, 63, 63, 65, 63, 64, 111, 129, 60, 71, 65, 57, 70, 61, 64, 63,
            68, 73, 62, 80, 78, 63, 67, 73, 71, 68, 68, 98, 62, 112, 61, 64,
            71, 90, 63, 80, 76, 62, 62, 56, 69, 60, 67, 77, 64, 66, 107, 74,
            60, 65, 59, 63, 76, 100, 60, 92, 78, 76, 75, 64, 71, 60, 111, 64,
            59, 99, 66, 65, 64, 73, 72, 77, 60, 59, 88, 66, 63, 70, 64, 63,
            85, 61, 67, 106, 61, 67, 62, 58, 77, 61, 64, 63, 69, 69, 62, 64,
            73, 80, 63, 63, 91, 68, 69, 68, 64, 102, 60, 69, 103, 62, 67, 61,
            68, 128, 68, 63, 62, 105, 72, 68, 125, 70, 62, 71, 58, 62, 59, 98,
            62, 64, 64, 64, 74, 69, 80, 62, 64, 64, 69, 71, 61, 73, 79, 65,
            83, 74, 60, 70, 89, 64, 79, 84, 60, 63, 61, 66, 61, 71, 67, 58,
            62, 64, 60, 60, 62, 70, 64, 65, 79, 72, 72, 64, 60, 69, 73, 60,
            72, 63, 64, 58, 64, 73, 63, 61, 61, 72, 66, 66, 59, 65, 63, 61,
            73, 69, 67, 58, 60, 67, 59, 60, 78, 61, 62, 73, 67, 61, 72, 64,
            60, 67, 74, 62, 61, 59, 75, 56, 63, 56, 71, 80, 67, 75, 69, 117
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

    @Test
    @DisplayName("Test Height map for 1.16")
    public void test1_16() {
        // NOT CORRECT YET FIXME
        OverworldBiomeSource bs = new OverworldBiomeSource(MCVersion.v1_16, 541515181818L);
        ChunkGenerator cg = ChunkGenerator.of(Dimension.OVERWORLD, bs);
        int size = 16;
        assert cg != null;
        Random r = new Random(4227552225777L);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int x = r.nextInt(512);
                int z = r.nextInt(512);
                int y = cg.getHeightOnGround(x, z);
                System.out.println(x + " " + z);
                assertEquals(heightmap_16[i * size + j], y);

            }
        }
    }

}
