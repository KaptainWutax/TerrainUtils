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
    private static final int[] heightmap = {
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
        OverworldChunkGenerator cg = (OverworldChunkGenerator) ChunkGenerator.of(Dimension.OVERWORLD,bs);
        for (int i = 0; i < 16 * 16; i++) {
            assertEquals(heightmap[i], cg.getHeightOnGround(i / 16, i % 16));
        }

    }

    @Test
    @DisplayName("Test Height map for 1.16")
    public void test1_16() {
        // NOT CORRECT YET FIXME
        OverworldBiomeSource bs = new OverworldBiomeSource(MCVersion.v1_16, 541515181818L);
        ChunkGenerator cg = ChunkGenerator.of(Dimension.OVERWORLD,bs);
        System.out.println(cg.getHeightOnGround(100,100));
        assert cg != null;
        int size=16;
        Random r= new Random(4227552225777L);
        for (int i = 0; i < size; i++) {
            // System.out.print("[");
            for (int j = 0; j < size; j++) {
                int x = r.nextInt(512);
                int z = r.nextInt(512);
                int y=cg.getHeightOnGround(x,z);
                System.out.printf("%d ",y);
            }
            //System.out.println("]");
            System.out.println();
        }

    }

}
