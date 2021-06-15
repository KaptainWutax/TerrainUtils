package kaptainwutax.v1_16.v1_16_5;

import kaptainwutax.TestFramework;
import kaptainwutax.mcutils.state.Dimension;
import kaptainwutax.mcutils.version.MCVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static kaptainwutax.TestFramework.randomChunkGen;
import static kaptainwutax.TestFramework.randomHashGen;

@DisplayName("Minecraft v1.16.5 End")
@Tag("v1.16.5")
@TestFramework.End
public class End {
	public static final MCVersion VERSION = MCVersion.v1_16_5;
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
	@DisplayName("Test Height map version 1.16.5 size 16")
	public void size16() {
		randomChunkGen(VERSION, 213232132139149124L, DIMENSION, 16, 21382138983289132L, size16);
	}

	@Test
	@DisplayName("Test Height version 1.16.5 map size 32")
	public void size32() {
		randomChunkGen(VERSION, 213232132139149124L, DIMENSION, 32, 21382138983289132L, size32);
	}

	@Test
	@DisplayName("Test Height version 1.16.5 map size 128")
	public void size128() {
		randomHashGen(VERSION, 213232132139149124L, DIMENSION, 128, 21382138983289132L, -2403508787974715586L);
	}


	public static void getProgram() {
		System.out.println("Bootstrap.bootStrap();\n" +
			"\t\tMutableRegistry<Biome> biomeRegistry = DynamicRegistries.builtin().registryOrThrow(Registry.BIOME_REGISTRY);\n" +
			"\t\tRegistry<DimensionSettings> dimensionSettingsRegistry = DynamicRegistries.builtin().registryOrThrow(Registry.NOISE_GENERATOR_SETTINGS_REGISTRY);\n" +
			"\t\tlong seed = 213232132139149124L;\n" +
			"\t\tNoiseChunkGenerator noiseChunkGenerator;\n" +
			"\t\tint dimension = 1;\n" +
			"\t\tif (dimension == 0) {\n" +
			"\t\t\t// OVERWORLD\n" +
			"\t\t\tnoiseChunkGenerator = new NoiseChunkGenerator(\n" +
			"\t\t\t\t\tnew OverworldBiomeProvider(seed, false, false, biomeRegistry), seed,\n" +
			"\t\t\t\t\t() -> dimensionSettingsRegistry.getOrThrow(DimensionSettings.OVERWORLD));\n" +
			"\t\t} else if (dimension == -1) {\n" +
			"\t\t\t// Nether\n" +
			"\t\t\tnoiseChunkGenerator = new NoiseChunkGenerator(\n" +
			"\t\t\t\t\tNetherBiomeProvider.Preset.NETHER.biomeSource(biomeRegistry, seed), seed,\n" +
			"\t\t\t\t\t() -> dimensionSettingsRegistry.getOrThrow(DimensionSettings.NETHER));\n" +
			"\t\t} else {\n" +
			"\t\t\t// End\n" +
			"\t\t\tnoiseChunkGenerator = new NoiseChunkGenerator(\n" +
			"\t\t\t\t\tnew EndBiomeProvider(biomeRegistry, seed), seed,\n" +
			"\t\t\t\t\t() -> dimensionSettingsRegistry.getOrThrow(DimensionSettings.END));\n" +
			"\t\t}\n" +
			"\t\tint size = 8;\n" +
			"\t\tRandom r = new Random(21382138983289132L);\n" +
			"\t\tboolean PRINT = false;\n" +
			"\t\tif (PRINT) System.out.println(\"{\");\n" +
			"\t\tlong hash = 0;\n" +
			"\t\tfor (int i = 0; i < size; i++) {\n" +
			"\t\t\tfor (int j = 0; j < size; j++) {\n" +
			"\t\t\t\tint x = r.nextInt(512000)-25600;\n" +
			"\t\t\t\tint z = r.nextInt(512000)-25600;\n" +
			"\t\t\t\tif (dimension==-1){\n" +
			"\t\t\t\t\tBlockreader blockReader= (Blockreader) noiseChunkGenerator.getBaseColumn(x,z);\n" +
			"\t\t\t\t\tif (PRINT) System.out.print(\"{\");\n" +
			"\t\t\t\t\tint y=0;\n" +
			"\t\t\t\t\tfor (BlockState blockState:blockReader.column){\n" +
			"\t\t\t\t\t\tString block=Registry.BLOCK.getKey(blockState.getBlock()).getPath().toUpperCase();\n" +
			"\t\t\t\t\t\tif (PRINT)System.out.print(block+\",\");\n" +
			"\t\t\t\t\t\thash = hash * 0xFF51AFD7ED558CCDL + 0xC4CEB9FE1A85EC53L | (long) block.hashCode()*y++;\n" +
			"\t\t\t\t\t}\n" +
			"\t\t\t\t\tif (PRINT)System.out.print(\"},\");\n" +
			"\t\t\t\t\tif (PRINT)System.out.println();\n" +
			"\t\t\t\t}else{\n" +
			"\t\t\t\t\tint y = noiseChunkGenerator.getHeightOnGround(x, z, Heightmap.Type.OCEAN_FLOOR_WG);\n" +
			"\t\t\t\t\thash = hash * 0xFF51AFD7ED558CCDL + 0xC4CEB9FE1A85EC53L | y;\n" +
			"\t\t\t\t\tif (PRINT) System.out.printf(\"%d ,\", y);\n" +
			"\t\t\t\t}\n" +
			"\t\t\t}\n" +
			"\t\t\tif (PRINT && dimension!=-1) System.out.println();\n" +
			"\t\t}\n" +
			"\t\tif (PRINT) System.out.print(\"};\");\n" +
			"\t\tif (PRINT) System.out.println();\n" +
			"\t\tif (!PRINT) System.out.println(hash+\"L\");");
	}
}
