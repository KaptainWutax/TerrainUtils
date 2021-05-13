package kaptainwutax.v1_16;

import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.mcutils.block.Block;
import kaptainwutax.mcutils.state.Dimension;
import kaptainwutax.mcutils.version.MCVersion;
import kaptainwutax.terrainutils.ChunkGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static kaptainwutax.TestFramework.randomChunkGen;
import static kaptainwutax.mcutils.block.Blocks.NETHERRACK;
import static kaptainwutax.mcutils.block.Blocks.LAVA;
import static kaptainwutax.mcutils.block.Blocks.AIR;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Nether {
    public int[] size16 = {
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128,
            128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128
    };

    public Block[] column = {NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, LAVA, LAVA, LAVA, LAVA, LAVA, LAVA, LAVA, LAVA, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, AIR, AIR, AIR, AIR, AIR, AIR, AIR, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, NETHERRACK, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK};
    public Block[] column2 ={NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK};


    @Test
    @DisplayName("Test Height map version 1.16 size 16")
    public void size16() {
        randomChunkGen(MCVersion.v1_16, 541515181818L, Dimension.NETHER, 16, 8312312322222L, size16);
    }

    @Test
    @DisplayName("Test Height map version 1.16 heightmap")
    public void column() {
        BiomeSource bs = BiomeSource.of(Dimension.NETHER, MCVersion.v1_16, 541515181818L);
        ChunkGenerator cg = ChunkGenerator.of(Dimension.NETHER, bs);
        assert cg != null;
        Block[] column = cg.getColumnAt(0, 0);
        assertEquals(column.length,this.column.length);
        for (int y = 0; y < column.length; y++) {
            assertEquals(column[y],this.column[y]);
        }
    }

    @Test
    @DisplayName("Test Height map version 1.16 heightmap 2")
    public void column2() {
        BiomeSource bs = BiomeSource.of(Dimension.NETHER, MCVersion.v1_16, 541515181818L);
        ChunkGenerator cg = ChunkGenerator.of(Dimension.NETHER, bs);
        assert cg != null;
        Block[] column = cg.getColumnAt(0, 0);
        assertEquals(column.length,this.column.length);
        for (int y = 0; y < column.length; y++) {
            assertEquals(column[y],this.column[y]);
        }
    }

    //        Bootstrap.register();
    //        long seed = 541515181818L;
    //        NoiseChunkGenerator noiseChunkGenerator =new NoiseChunkGenerator(NetherBiomeProvider.Preset.NETHER.apply(seed), seed, DimensionSettings.Preset.NETHER.getDimensionSettings());
    //        System.out.println(Arrays.toString(noiseChunkGenerator.getColumnAt(0, 0)));
    //        NoiseChunkGenerator noiseChunkGenerator =new NoiseChunkGenerator(new EndBiomeProvider(seed), seed, DimensionSettings.Preset.END.getDimensionSettings());
    //        int size = 32;
    //        Random r = new Random(21382138983289132L);
    //        System.out.print("{");
    //        for (int i = 0; i < size; i++) {
    //            for (int j = 0; j < size; j++) {
    //                int x = r.nextInt(512);
    //                int z = r.nextInt(512);
    //                int y = noiseChunkGenerator.getOffset(x, z, Heightmap.Type.OCEAN_FLOOR_WG);
    //                System.out.printf("%d ,", y);
    //            }
    //            System.out.println();
    //        }
    //        System.out.print("};");
    //        System.out.println();

    // in NoiseChunkGenerator
    //    public Object[] getColumnAt(int x,int z){
    //        BlockState[] column = new BlockState[this.noiseSizeY * this.verticalNoiseGranularity];
    //        this.generateColumn(x, z, column, null);
    //        return Arrays.stream(column).map(blockState ->  Registry.BLOCK.getKey(blockState.getBlock()).getPath()).toArray();
    //    }
}
