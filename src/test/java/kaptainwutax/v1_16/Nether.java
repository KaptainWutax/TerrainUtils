package kaptainwutax.v1_16;

import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.mcutils.block.Block;
import kaptainwutax.mcutils.state.Dimension;
import kaptainwutax.mcutils.version.MCVersion;
import kaptainwutax.terrainutils.ChunkGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static kaptainwutax.TestFramework.randomChunkGen;
import static kaptainwutax.mcutils.block.Blocks.*;
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
	public Block[] column2 = {NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK};
	public Block[] column3 = {NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, AIR, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK, NETHERRACK,};


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
		assertEquals(column.length, this.column.length);
		for (int y = 0; y < column.length; y++) {
			assertEquals(column[y],this.column[y],"Invalid at y:"+y);
		}
	}

	@Test
	@DisplayName("Test Height map version 1.16 heightmap 2")
	public void column2() {
		BiomeSource bs = BiomeSource.of(Dimension.NETHER, MCVersion.v1_16, 541515181818L);
		ChunkGenerator cg = ChunkGenerator.of(Dimension.NETHER, bs);
		assert cg != null;
		Block[] column = cg.getColumnAt(0, 0);
		assertEquals(column.length, this.column.length);
		for (int y = 0; y < column.length; y++) {
			assertEquals(column[y],this.column[y],"Invalid at y:"+y);
		}
	}

    @Test
    @DisplayName("Test Height map version 1.16.5 heightmap 2")
    public void column3() {
        BiomeSource bs = BiomeSource.of(Dimension.NETHER, MCVersion.v1_16_5, 7948314503011477316L);
        ChunkGenerator cg = ChunkGenerator.of(Dimension.NETHER, bs);
        assert cg != null;
        Block[] column = cg.getColumnAt(-176,-200);
        System.out.println(Arrays.toString(column));
        assertEquals(column.length, this.column3.length);
        for (int y = 0; y < column.length; y++) {
			assertEquals(column[y],this.column3[y],"Invalid at y:"+y);
        }
    }


    //   Bootstrap.bootStrap();
    //        MutableRegistry<Biome> biomeRegistry=DynamicRegistries.builtin().registryOrThrow(Registry.BIOME_REGISTRY);
    //        OverworldBiomeProvider overworldBiomeProvider=new OverworldBiomeProvider(1437905338718953247L,false, false,biomeRegistry );
    ////        Biome biome=overworldBiomeProvider.getNoiseBiome(3611,0,-141);
    //        BiomeManager biomeManager=new BiomeManager(overworldBiomeProvider,BiomeManager.obfuscateSeed(1437905338718953247L), FuzzedBiomeMagnifier.INSTANCE);
    ////        System.out.print(biomeRegistry.getId(biomeManager.getNoiseBiomeAtQuart(3611-8,0,-141))+" ");
    //        System.out.print(biomeRegistry.getId(biomeManager.getNoiseBiomeAtQuart(225,0,-9))+" ");
    ////        for (int x = -8; x <= 8; x++) {
    ////            for (int z = -8; z <= 8; z++) {
    ////                System.out.print(biomeRegistry.getId(biomeManager.getNoiseBiomeAtQuart(3611+x,0,-141+z))+" ");
    ////            }
    ////            System.out.println();
    ////        }
    //        DynamicRegistries.Impl builtin = DynamicRegistries.builtin();
    //        Registry<Biome> biomes = builtin.registryOrThrow(Registry.BIOME_REGISTRY);
    //        Registry<DimensionType> dimensionTypes = builtin.registryOrThrow(Registry.DIMENSION_TYPE_REGISTRY);
    //        Registry<DimensionSettings> noiseGeneratorSettings = builtin.registryOrThrow(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY);
    //        SimpleRegistry<Dimension> registry= defaultDimensions(dimensionTypes,biomes,noiseGeneratorSettings,7948314503011477316L);
    //        ChunkGenerator generator= Objects.requireNonNull(registry.get(Dimension.NETHER)).generator();
    //        Blockreader blockReader= (Blockreader) generator.getBaseColumn(-176,-200);
    //        System.out.println(Arrays.toString(blockReader.column));
    //        System.out.print("{");
    //        for (BlockState blockState:blockReader.column){
    //            System.out.print(Registry.BLOCK.getKey(blockState.getBlock()).getPath().toUpperCase()+",");
    //        }
    //        System.out.print("};");
    //        System.out.println();

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
