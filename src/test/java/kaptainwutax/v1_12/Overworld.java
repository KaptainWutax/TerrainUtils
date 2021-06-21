package kaptainwutax.v1_12;

import kaptainwutax.TestFramework;
import kaptainwutax.mcutils.state.Dimension;
import kaptainwutax.mcutils.version.MCVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static kaptainwutax.TestFramework.randomChunkGen;
import static kaptainwutax.TestFramework.randomHashGen;

@DisplayName("Minecraft v1.12 Overworld")
@Tag("v1.12")
@TestFramework.Overworld
public class Overworld {
	public static final MCVersion VERSION = MCVersion.v1_12;
	public static final Dimension DIMENSION = Dimension.OVERWORLD;
	private static final int[] size16 = {
		70 ,89 ,50 ,63 ,37 ,67 ,80 ,34 ,64 ,78 ,50 ,69 ,76 ,47 ,65 ,68 ,
		59 ,64 ,72 ,59 ,80 ,80 ,78 ,80 ,71 ,67 ,69 ,34 ,78 ,39 ,68 ,61 ,
		60 ,68 ,74 ,64 ,33 ,67 ,76 ,64 ,63 ,32 ,64 ,69 ,36 ,84 ,67 ,61 ,
		48 ,38 ,70 ,31 ,72 ,79 ,65 ,39 ,62 ,64 ,61 ,70 ,92 ,64 ,43 ,64 ,
		63 ,37 ,63 ,70 ,74 ,52 ,32 ,68 ,71 ,33 ,37 ,47 ,71 ,38 ,63 ,31 ,
		80 ,48 ,63 ,76 ,65 ,67 ,73 ,32 ,63 ,69 ,70 ,63 ,67 ,68 ,65 ,69 ,
		68 ,49 ,37 ,39 ,80 ,48 ,32 ,32 ,76 ,113 ,38 ,67 ,74 ,31 ,66 ,32 ,
		69 ,69 ,55 ,64 ,44 ,85 ,63 ,48 ,35 ,65 ,85 ,51 ,64 ,64 ,67 ,70 ,
		32 ,97 ,71 ,67 ,77 ,33 ,47 ,39 ,78 ,68 ,32 ,77 ,71 ,50 ,64 ,40 ,
		63 ,37 ,55 ,52 ,51 ,44 ,44 ,60 ,46 ,74 ,79 ,64 ,76 ,69 ,72 ,64 ,
		37 ,30 ,101 ,88 ,32 ,63 ,63 ,64 ,71 ,60 ,47 ,71 ,86 ,76 ,31 ,43 ,
		39 ,61 ,80 ,73 ,84 ,72 ,34 ,48 ,67 ,54 ,40 ,63 ,44 ,74 ,40 ,70 ,
		47 ,31 ,64 ,70 ,70 ,53 ,66 ,35 ,76 ,66 ,33 ,45 ,32 ,71 ,64 ,47 ,
		80 ,52 ,45 ,72 ,62 ,71 ,38 ,63 ,78 ,64 ,43 ,64 ,65 ,63 ,72 ,120 ,
		94 ,46 ,68 ,39 ,34 ,67 ,65 ,46 ,47 ,69 ,47 ,72 ,64 ,64 ,113 ,69 ,
		92 ,71 ,76 ,47 ,69 ,32 ,68 ,62 ,63 ,67 ,66 ,55 ,66 ,110 ,70 ,63 ,
		};


	private static final int[] size32 = {
		70 ,89 ,50 ,63 ,37 ,67 ,80 ,34 ,64 ,78 ,50 ,69 ,76 ,47 ,65 ,68 ,59 ,64 ,72 ,59 ,80 ,80 ,78 ,80 ,71 ,67 ,69 ,34 ,78 ,39 ,68 ,61 ,
		60 ,68 ,74 ,64 ,33 ,67 ,76 ,64 ,63 ,32 ,64 ,69 ,36 ,84 ,67 ,61 ,48 ,38 ,70 ,31 ,72 ,79 ,65 ,39 ,62 ,64 ,61 ,70 ,92 ,64 ,43 ,64 ,
		63 ,37 ,63 ,70 ,74 ,52 ,32 ,68 ,71 ,33 ,37 ,47 ,71 ,38 ,63 ,31 ,80 ,48 ,63 ,76 ,65 ,67 ,73 ,32 ,63 ,69 ,70 ,63 ,67 ,68 ,65 ,69 ,
		68 ,49 ,37 ,39 ,80 ,48 ,32 ,32 ,76 ,113 ,38 ,67 ,74 ,31 ,66 ,32 ,69 ,69 ,55 ,64 ,44 ,85 ,63 ,48 ,35 ,65 ,85 ,51 ,64 ,64 ,67 ,70 ,
		32 ,97 ,71 ,67 ,77 ,33 ,47 ,39 ,78 ,68 ,32 ,77 ,71 ,50 ,64 ,40 ,63 ,37 ,55 ,52 ,51 ,44 ,44 ,60 ,46 ,74 ,79 ,64 ,76 ,69 ,72 ,64 ,
		37 ,30 ,101 ,88 ,32 ,63 ,63 ,64 ,71 ,60 ,47 ,71 ,86 ,76 ,31 ,43 ,39 ,61 ,80 ,73 ,84 ,72 ,34 ,48 ,67 ,54 ,40 ,63 ,44 ,74 ,40 ,70 ,
		47 ,31 ,64 ,70 ,70 ,53 ,66 ,35 ,76 ,66 ,33 ,45 ,32 ,71 ,64 ,47 ,80 ,52 ,45 ,72 ,62 ,71 ,38 ,63 ,78 ,64 ,43 ,64 ,65 ,63 ,72 ,120 ,
		94 ,46 ,68 ,39 ,34 ,67 ,65 ,46 ,47 ,69 ,47 ,72 ,64 ,64 ,113 ,69 ,92 ,71 ,76 ,47 ,69 ,32 ,68 ,62 ,63 ,67 ,66 ,55 ,66 ,110 ,70 ,63 ,
		33 ,72 ,47 ,38 ,63 ,80 ,72 ,49 ,64 ,93 ,47 ,67 ,71 ,81 ,66 ,63 ,68 ,78 ,64 ,56 ,55 ,69 ,78 ,80 ,52 ,43 ,72 ,71 ,81 ,33 ,63 ,72 ,
		48 ,64 ,38 ,55 ,69 ,36 ,63 ,83 ,65 ,68 ,70 ,113 ,50 ,41 ,71 ,80 ,37 ,54 ,40 ,93 ,64 ,55 ,72 ,70 ,71 ,64 ,68 ,36 ,64 ,35 ,64 ,35 ,
		59 ,82 ,72 ,35 ,38 ,46 ,36 ,64 ,63 ,36 ,64 ,73 ,64 ,39 ,69 ,69 ,45 ,84 ,66 ,75 ,67 ,62 ,30 ,61 ,64 ,80 ,68 ,32 ,32 ,76 ,62 ,67 ,
		44 ,70 ,36 ,53 ,48 ,73 ,64 ,50 ,67 ,60 ,45 ,80 ,37 ,48 ,68 ,37 ,60 ,64 ,32 ,62 ,36 ,64 ,61 ,56 ,64 ,57 ,33 ,48 ,64 ,38 ,39 ,79 ,
		76 ,83 ,63 ,75 ,51 ,31 ,55 ,82 ,63 ,48 ,90 ,64 ,65 ,38 ,64 ,36 ,61 ,65 ,65 ,64 ,70 ,61 ,94 ,79 ,31 ,63 ,80 ,75 ,46 ,54 ,75 ,65 ,
		31 ,32 ,36 ,57 ,61 ,77 ,47 ,38 ,63 ,59 ,66 ,64 ,97 ,68 ,72 ,63 ,47 ,55 ,68 ,70 ,70 ,50 ,75 ,65 ,46 ,67 ,64 ,56 ,48 ,62 ,64 ,71 ,
		32 ,50 ,67 ,39 ,82 ,63 ,62 ,67 ,31 ,73 ,67 ,45 ,33 ,37 ,67 ,69 ,42 ,107 ,31 ,32 ,44 ,84 ,37 ,68 ,47 ,68 ,46 ,68 ,64 ,62 ,47 ,69 ,
		57 ,64 ,60 ,71 ,75 ,70 ,46 ,93 ,38 ,71 ,75 ,38 ,69 ,67 ,59 ,64 ,42 ,76 ,38 ,65 ,91 ,99 ,35 ,68 ,71 ,71 ,72 ,87 ,56 ,76 ,66 ,49 ,
		62 ,69 ,47 ,37 ,64 ,98 ,38 ,68 ,54 ,77 ,69 ,49 ,32 ,53 ,71 ,32 ,63 ,35 ,80 ,32 ,32 ,64 ,32 ,78 ,55 ,65 ,69 ,63 ,36 ,106 ,31 ,32 ,
		71 ,62 ,48 ,66 ,38 ,39 ,59 ,64 ,67 ,32 ,36 ,67 ,40 ,31 ,68 ,72 ,67 ,36 ,67 ,75 ,37 ,32 ,78 ,52 ,77 ,88 ,47 ,39 ,64 ,68 ,64 ,66 ,
		64 ,49 ,48 ,56 ,35 ,64 ,35 ,85 ,69 ,85 ,64 ,62 ,75 ,47 ,30 ,47 ,70 ,35 ,62 ,47 ,69 ,62 ,64 ,69 ,64 ,67 ,79 ,66 ,48 ,61 ,67 ,43 ,
		32 ,62 ,69 ,51 ,56 ,36 ,48 ,86 ,67 ,67 ,68 ,63 ,35 ,32 ,42 ,48 ,42 ,36 ,72 ,31 ,68 ,73 ,56 ,68 ,65 ,68 ,43 ,64 ,33 ,36 ,72 ,34 ,
		47 ,65 ,72 ,52 ,69 ,50 ,31 ,61 ,56 ,79 ,58 ,80 ,64 ,69 ,72 ,74 ,31 ,57 ,31 ,62 ,31 ,32 ,83 ,66 ,63 ,48 ,30 ,86 ,66 ,67 ,93 ,71 ,
		32 ,64 ,91 ,69 ,83 ,32 ,34 ,73 ,76 ,48 ,52 ,37 ,64 ,62 ,69 ,48 ,33 ,69 ,32 ,94 ,62 ,65 ,63 ,67 ,65 ,74 ,36 ,117 ,66 ,71 ,39 ,65 ,
		78 ,68 ,38 ,66 ,31 ,49 ,72 ,69 ,40 ,35 ,66 ,63 ,64 ,39 ,48 ,48 ,84 ,96 ,77 ,33 ,34 ,61 ,78 ,61 ,34 ,59 ,69 ,67 ,71 ,48 ,72 ,50 ,
		86 ,68 ,76 ,55 ,48 ,70 ,65 ,66 ,63 ,78 ,35 ,46 ,69 ,48 ,60 ,63 ,32 ,86 ,110 ,69 ,62 ,36 ,67 ,65 ,84 ,32 ,71 ,41 ,65 ,56 ,48 ,63 ,
		36 ,48 ,90 ,69 ,59 ,56 ,70 ,59 ,64 ,66 ,35 ,58 ,90 ,50 ,38 ,35 ,64 ,48 ,35 ,62 ,66 ,63 ,76 ,69 ,79 ,64 ,74 ,86 ,34 ,47 ,63 ,64 ,
		64 ,67 ,64 ,75 ,68 ,63 ,48 ,66 ,74 ,63 ,69 ,46 ,65 ,64 ,67 ,63 ,68 ,64 ,45 ,73 ,53 ,45 ,39 ,69 ,64 ,64 ,59 ,44 ,80 ,74 ,50 ,82 ,
		82 ,33 ,67 ,77 ,56 ,31 ,67 ,61 ,68 ,63 ,81 ,49 ,64 ,48 ,64 ,74 ,66 ,64 ,64 ,68 ,65 ,35 ,38 ,63 ,33 ,43 ,31 ,67 ,67 ,63 ,71 ,35 ,
		38 ,54 ,72 ,32 ,72 ,36 ,88 ,86 ,65 ,64 ,68 ,70 ,33 ,35 ,73 ,40 ,71 ,32 ,70 ,63 ,66 ,62 ,60 ,59 ,83 ,64 ,68 ,45 ,79 ,67 ,61 ,64 ,
		65 ,64 ,56 ,56 ,32 ,74 ,67 ,32 ,35 ,63 ,64 ,40 ,32 ,70 ,76 ,66 ,65 ,70 ,37 ,64 ,49 ,76 ,67 ,38 ,59 ,32 ,68 ,35 ,44 ,70 ,65 ,30 ,
		67 ,50 ,65 ,70 ,35 ,88 ,48 ,64 ,68 ,64 ,33 ,37 ,33 ,70 ,68 ,76 ,82 ,118 ,74 ,64 ,68 ,64 ,37 ,77 ,68 ,60 ,37 ,64 ,77 ,70 ,32 ,76 ,
		72 ,62 ,38 ,69 ,72 ,38 ,78 ,35 ,63 ,72 ,71 ,47 ,67 ,66 ,32 ,68 ,39 ,69 ,69 ,65 ,38 ,48 ,37 ,68 ,62 ,62 ,67 ,47 ,100 ,66 ,37 ,53 ,
		84 ,50 ,65 ,63 ,68 ,65 ,71 ,73 ,69 ,43 ,85 ,72 ,39 ,68 ,44 ,53 ,69 ,63 ,88 ,65 ,68 ,71 ,86 ,45 ,72 ,79 ,67 ,93 ,72 ,66 ,64 ,81 ,
		};

	@Test
	@DisplayName("Test Height map version 1.12 size 16")
	public void size16() {
		randomChunkGen(VERSION, 112120023123L, DIMENSION, 16, 21382138983289132L, size16);
	}

	@Test
	@DisplayName("Test Height version 1.12 map size 32")
	public void size32() {
		randomChunkGen(VERSION, 112120023123L, DIMENSION, 32, 21382138983289132L, size32);
	}

	@Test
	@DisplayName("Test Height version 1.12 map size 128")
	public void size128() {
		randomHashGen(VERSION, 213232132139149124L, DIMENSION, 128, 21382138983289132L, 7969545620266398398L);
	}


	public static void getProgram() {
		System.out.println(" public static HashMap<Integer, ChunkPrimer> hashMap = new HashMap<>();\n" +
			"\n" +
			"    public static int processChunk(int x, int z, IChunkGenerator chunkGenerator,IBlockState blockState) {\n" +
			"        int cx = x >> 4;\n" +
			"        int cz = z >> 4;\n" +
			"        ChunkPrimer chunk = hashMap.computeIfAbsent(((cx & 0xffff) << 16) | (cz & 0xffff), e -> {\n" +
			"            ChunkPrimer chunkPrimer=new ChunkPrimer();\n" +
			"            chunkGenerator.setBlocksInChunk(cx, cz, chunkPrimer);\n" +
			"            return chunkPrimer;\n" +
			"        });\n" +
			"        return chunk.findGroundBlockIdx(x&0xf,z&0xf,block-> block==blockState);\n" +
			"    }\n" +
			"\n" +
			"    public static void main(String[] args)\n" +
			"    {\n" +
			"        Bootstrap.register();\n" +
			"        long seed=213232132139149124L;\n" +
			"        World world = new WorldClient(null,\n" +
			"                new WorldSettings(seed, GameType.NOT_SET, true, false, WorldType.DEFAULT),\n" +
			"                DimensionType.OVERWORLD.getId(), EnumDifficulty.EASY, null);\n" +
			"        ChunkGeneratorOverworld chunkGeneratorOverworld=new ChunkGeneratorOverworld(world,seed,true,\"\");\n" +
			"\n" +
			"\n" +
			"        world = new WorldClient(null,\n" +
			"                new WorldSettings(seed, GameType.NOT_SET, true, false, WorldType.DEFAULT),\n" +
			"                DimensionType.NETHER.getId(), EnumDifficulty.EASY, null);\n" +
			"        ChunkGeneratorHell chunkGeneratorHell=new ChunkGeneratorHell(world,true,seed);\n" +
			"\n" +
			"        world = new WorldClient(null,\n" +
			"                new WorldSettings(seed, GameType.NOT_SET, true, false, WorldType.DEFAULT),\n" +
			"                DimensionType.THE_END.getId(), EnumDifficulty.EASY, null);\n" +
			"        ChunkGeneratorEnd chunkGeneratorEnd=new ChunkGeneratorEnd(world,true,seed,new BlockPos(0,0,0));\n" +
			"\n" +
			"        IChunkGenerator chunkGenerator=chunkGeneratorOverworld;\n" +
			"        IBlockState state= Blocks.STONE.getDefaultState();\n" +
			"\n" +
			"        int size = 128;\n" +
			"        Random r = new Random(21382138983289132L);\n" +
			"        boolean PRINT = false;\n" +
			"        if (PRINT) System.out.println(\"{\");\n" +
			"        long hash = 0;\n" +
			"\n" +
			"        for (int i = 0; i < size; i++) {\n" +
			"            for (int j = 0; j < size; j++) {\n" +
			"                int x = r.nextInt(512000) - 25600;\n" +
			"                int z = r.nextInt(512000) - 25600;\n" +
			"                int y = processChunk(x, z, chunkGenerator,state);\n" +
			"                hash = hash * 0xFF51AFD7ED558CCDL + 0xC4CEB9FE1A85EC53L | y;\n" +
			"                if (PRINT) System.out.printf(\"%d ,\", y);\n" +
			"            }\n" +
			"            if (PRINT) System.out.println();\n" +
			"        }\n" +
			"        if (PRINT) System.out.print(\"};\");\n" +
			"        if (PRINT) System.out.println();\n" +
			"        if (!PRINT) System.out.println(hash + \"L\");\n" +
			"\n" +
			"       // Main.main(concat(new String[] {\"--version\", \"mcp\", \"--accessToken\", \"0\", \"--assetsDir\", \"assets\", \"--assetIndex\", \"1.8\", \"--userProperties\", \"{}\"}, args));\n" +
			"    }");
	}
}
