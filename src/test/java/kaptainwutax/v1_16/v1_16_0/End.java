package kaptainwutax.v1_16.v1_16_0;

import kaptainwutax.TestFramework;
import kaptainwutax.mcutils.state.Dimension;
import kaptainwutax.mcutils.version.MCVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static kaptainwutax.TestFramework.randomChunkGen;
import static kaptainwutax.TestFramework.randomHashGen;

@DisplayName("Minecraft v1.16 End")
@Tag("v1.16")
@TestFramework.End
public class End {
	public static final MCVersion VERSION = MCVersion.v1_16;
	public static final Dimension DIMENSION = Dimension.END;
	private static final int[] size16 = {
		57 ,0 ,0 ,0 ,0 ,0 ,61 ,0 ,0 ,54 ,0 ,0 ,0 ,58 ,0 ,0 ,
		0 ,0 ,0 ,64 ,0 ,0 ,57 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,58 ,
		0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,63 ,0 ,0 ,0 ,57 ,57 ,0 ,
		0 ,0 ,0 ,0 ,0 ,38 ,0 ,0 ,62 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,
		0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,
		0 ,0 ,0 ,0 ,62 ,55 ,0 ,0 ,0 ,0 ,0 ,51 ,0 ,0 ,0 ,57 ,
		0 ,57 ,61 ,0 ,58 ,57 ,0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,59 ,0 ,
		0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,60 ,0 ,65 ,57 ,
		0 ,0 ,57 ,59 ,62 ,0 ,0 ,0 ,0 ,0 ,58 ,0 ,0 ,62 ,58 ,60 ,
		58 ,0 ,0 ,55 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,57 ,0 ,0 ,0 ,
		0 ,0 ,0 ,60 ,0 ,0 ,0 ,63 ,59 ,0 ,0 ,0 ,61 ,58 ,0 ,0 ,
		0 ,62 ,0 ,0 ,48 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,45 ,57 ,0 ,0 ,
		0 ,0 ,0 ,57 ,0 ,0 ,61 ,61 ,0 ,61 ,0 ,0 ,0 ,57 ,0 ,0 ,
		57 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,60 ,0 ,61 ,0 ,0 ,57 ,0 ,0 ,
		0 ,0 ,0 ,59 ,62 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,
		61 ,0 ,61 ,57 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,57 ,0 ,0 ,59 ,0 ,
		};


	private static final int[] size32 = {
		57 ,0 ,0 ,0 ,0 ,0 ,61 ,0 ,0 ,54 ,0 ,0 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,64 ,0 ,0 ,57 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,58 ,
		0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,63 ,0 ,0 ,0 ,57 ,57 ,0 ,0 ,0 ,0 ,0 ,0 ,38 ,0 ,0 ,62 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,
		0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,62 ,55 ,0 ,0 ,0 ,0 ,0 ,51 ,0 ,0 ,0 ,57 ,
		0 ,57 ,61 ,0 ,58 ,57 ,0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,60 ,0 ,65 ,57 ,
		0 ,0 ,57 ,59 ,62 ,0 ,0 ,0 ,0 ,0 ,58 ,0 ,0 ,62 ,58 ,60 ,58 ,0 ,0 ,55 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,57 ,0 ,0 ,0 ,
		0 ,0 ,0 ,60 ,0 ,0 ,0 ,63 ,59 ,0 ,0 ,0 ,61 ,58 ,0 ,0 ,0 ,62 ,0 ,0 ,48 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,45 ,57 ,0 ,0 ,
		0 ,0 ,0 ,57 ,0 ,0 ,61 ,61 ,0 ,61 ,0 ,0 ,0 ,57 ,0 ,0 ,57 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,60 ,0 ,61 ,0 ,0 ,57 ,0 ,0 ,
		0 ,0 ,0 ,59 ,62 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,61 ,0 ,61 ,57 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,57 ,0 ,0 ,59 ,0 ,
		61 ,0 ,0 ,40 ,61 ,0 ,60 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,0 ,57 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,57 ,60 ,0 ,0 ,0 ,0 ,58 ,0 ,62 ,
		0 ,0 ,0 ,0 ,0 ,0 ,62 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,60 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,61 ,0 ,41 ,0 ,46 ,0 ,
		0 ,0 ,0 ,0 ,61 ,58 ,0 ,39 ,0 ,0 ,63 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,62 ,59 ,60 ,0 ,33 ,0 ,60 ,0 ,0 ,0 ,0 ,0 ,0 ,
		60 ,0 ,0 ,62 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,62 ,0 ,0 ,57 ,0 ,0 ,0 ,0 ,0 ,59 ,61 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,
		59 ,59 ,0 ,58 ,62 ,57 ,59 ,0 ,60 ,0 ,0 ,0 ,0 ,52 ,0 ,0 ,0 ,0 ,0 ,0 ,63 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,
		49 ,0 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,60 ,60 ,0 ,0 ,0 ,57 ,64 ,60 ,0 ,0 ,0 ,63 ,0 ,59 ,0 ,0 ,0 ,0 ,55 ,59 ,0 ,
		0 ,0 ,0 ,0 ,59 ,57 ,0 ,0 ,61 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,55 ,0 ,0 ,0 ,0 ,56 ,0 ,0 ,
		0 ,0 ,0 ,0 ,0 ,0 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,0 ,65 ,59 ,0 ,0 ,0 ,0 ,0 ,62 ,0 ,0 ,0 ,62 ,47 ,0 ,58 ,0 ,0 ,0 ,
		0 ,0 ,64 ,0 ,60 ,0 ,63 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,59 ,60 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,0 ,60 ,0 ,0 ,0 ,0 ,0 ,0 ,48 ,
		0 ,0 ,59 ,47 ,0 ,0 ,0 ,0 ,62 ,0 ,57 ,0 ,59 ,61 ,0 ,60 ,57 ,62 ,0 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,49 ,0 ,0 ,63 ,59 ,
		57 ,0 ,61 ,0 ,62 ,59 ,0 ,57 ,0 ,0 ,0 ,0 ,61 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,63 ,0 ,0 ,0 ,63 ,60 ,0 ,58 ,63 ,
		0 ,45 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,48 ,0 ,0 ,57 ,0 ,58 ,0 ,59 ,61 ,0 ,58 ,60 ,61 ,0 ,0 ,0 ,57 ,
		0 ,60 ,0 ,61 ,0 ,0 ,60 ,0 ,0 ,0 ,57 ,0 ,59 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,
		0 ,0 ,62 ,58 ,0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,59 ,63 ,0 ,0 ,0 ,0 ,0 ,61 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,
		60 ,0 ,59 ,0 ,0 ,62 ,0 ,0 ,62 ,0 ,0 ,0 ,0 ,0 ,57 ,0 ,62 ,0 ,0 ,0 ,61 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,
		59 ,0 ,49 ,0 ,0 ,0 ,0 ,61 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,58 ,0 ,0 ,57 ,0 ,0 ,57 ,0 ,0 ,0 ,0 ,0 ,0 ,
		57 ,0 ,0 ,0 ,0 ,55 ,60 ,0 ,0 ,58 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,46 ,0 ,60 ,0 ,58 ,0 ,0 ,
		0 ,0 ,0 ,0 ,41 ,38 ,0 ,57 ,67 ,57 ,60 ,0 ,61 ,64 ,0 ,61 ,0 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,30 ,0 ,58 ,
		0 ,0 ,0 ,57 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,62 ,58 ,0 ,44 ,0 ,0 ,0 ,0 ,0 ,0 ,59 ,58 ,0 ,57 ,0 ,
		0 ,61 ,0 ,0 ,0 ,0 ,0 ,0 ,60 ,0 ,0 ,0 ,0 ,0 ,48 ,0 ,57 ,58 ,0 ,54 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,
		0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,61 ,0 ,0 ,0 ,60 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,61 ,62 ,
		0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,57 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,52 ,0 ,61 ,58 ,0 ,0 ,0 ,0 ,0 ,0 ,61 ,0 ,0 ,
		58 ,0 ,0 ,59 ,0 ,59 ,57 ,0 ,0 ,0 ,0 ,0 ,34 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,59 ,0 ,
		0 ,0 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,57 ,0 ,62 ,59 ,0 ,0 ,0 ,62 ,58 ,0 ,0 ,0 ,61 ,57 ,0 ,0 ,0 ,61 ,0 ,59 ,0 ,0 ,0 ,
		};

	@Test
	@DisplayName("Test Height map version 1.16 size 16")
	public void size16() {
		randomChunkGen(VERSION, 213232132139149124L, DIMENSION, 16, 21382138983289132L, size16);
	}

	@Test
	@DisplayName("Test Height version 1.16 map size 32")
	public void size32() {
		randomChunkGen(VERSION, 213232132139149124L, DIMENSION, 32, 21382138983289132L, size32);
	}

	@Test
	@DisplayName("Test Height version 1.1 map size 128")
	public void size128() {
		randomHashGen(VERSION, 213232132139149124L, DIMENSION, 128, 21382138983289132L, -2403508787974715586L);
	}


	//		Bootstrap.bootStrap();
	//		MutableRegistry<Biome> biomeRegistry = DynamicRegistries.builtin().registryOrThrow(Registry.BIOME_REGISTRY);
	//		Registry<DimensionSettings> dimensionSettingsRegistry = DynamicRegistries.builtin().registryOrThrow(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY);
	//		long seed = 213232132139149124L;
	//		NoiseChunkGenerator noiseChunkGenerator;
	//		int dimension = 1;
	//		if (dimension == 0) {
	//			// OVERWORLD
	//			noiseChunkGenerator = new NoiseChunkGenerator(
	//					new OverworldBiomeProvider(seed, false, false, biomeRegistry), seed,
	//					() -> dimensionSettingsRegistry.getOrThrow(DimensionSettings.OVERWORLD));
	//		} else if (dimension == -1) {
	//			// Nether
	//			noiseChunkGenerator = new NoiseChunkGenerator(
	//					NetherBiomeProvider.Preset.NETHER.biomeSource(biomeRegistry, seed), seed,
	//					() -> dimensionSettingsRegistry.getOrThrow(DimensionSettings.NETHER));
	//		} else {
	//			// End
	//			noiseChunkGenerator = new NoiseChunkGenerator(
	//					new EndBiomeProvider(biomeRegistry, seed), seed,
	//					() -> dimensionSettingsRegistry.getOrThrow(DimensionSettings.END));
	//		}
	//		int size = 8;
	//		Random r = new Random(21382138983289132L);
	//		boolean PRINT = false;
	//		if (PRINT) System.out.println("{");
	//		long hash = 0;
	//		for (int i = 0; i < size; i++) {
	//			for (int j = 0; j < size; j++) {
	//				int x = r.nextInt(512000)-25600;
	//				int z = r.nextInt(512000)-25600;
	//				if (dimension==-1){
	//					Blockreader blockReader= (Blockreader) noiseChunkGenerator.getBaseColumn(x,z);
	//					if (PRINT) System.out.print("{");
	//					int y=0;
	//					for (BlockState blockState:blockReader.column){
	//						String block=Registry.BLOCK.getKey(blockState.getBlock()).getPath().toUpperCase();
	//						if (PRINT)System.out.print(block+",");
	//						hash = hash * 0xFF51AFD7ED558CCDL + 0xC4CEB9FE1A85EC53L | (long) block.hashCode()*y++;
	//					}
	//					if (PRINT)System.out.print("},");
	//					if (PRINT)System.out.println();
	//				}else{
	//					int y = noiseChunkGenerator.getHeightOnGround(x, z, Heightmap.Type.OCEAN_FLOOR_WG);
	//					hash = hash * 0xFF51AFD7ED558CCDL + 0xC4CEB9FE1A85EC53L | y;
	//					if (PRINT) System.out.printf("%d ,", y);
	//				}
	//			}
	//			if (PRINT && dimension!=-1) System.out.println();
	//		}
	//		if (PRINT) System.out.print("};");
	//		if (PRINT) System.out.println();
	//		if (!PRINT) System.out.println(hash+"L");
}
