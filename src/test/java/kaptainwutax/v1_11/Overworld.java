package kaptainwutax.v1_11;

import kaptainwutax.TestFramework;
import kaptainwutax.mcutils.state.Dimension;
import kaptainwutax.mcutils.version.MCVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static kaptainwutax.TestFramework.randomChunkGen;
import static kaptainwutax.TestFramework.randomHashGen;

@DisplayName("Minecraft v1.11 Overworld")
@Tag("v1.11")
@TestFramework.Overworld
public class Overworld {
	public static final MCVersion VERSION = MCVersion.v1_11;
	public static final Dimension DIMENSION = Dimension.OVERWORLD;
	private static final int[] size16 = {
		52 ,80 ,68 ,48 ,61 ,64 ,123 ,78 ,66 ,77 ,67 ,43 ,77 ,63 ,31 ,65 ,
		79 ,71 ,31 ,66 ,71 ,68 ,69 ,32 ,69 ,48 ,38 ,71 ,39 ,41 ,69 ,59 ,
		87 ,48 ,78 ,57 ,34 ,52 ,46 ,76 ,50 ,42 ,63 ,72 ,63 ,38 ,71 ,41 ,
		64 ,66 ,69 ,78 ,64 ,31 ,39 ,66 ,65 ,35 ,78 ,38 ,71 ,34 ,40 ,68 ,
		69 ,66 ,47 ,80 ,32 ,69 ,32 ,54 ,65 ,68 ,72 ,71 ,62 ,101 ,36 ,57 ,
		74 ,68 ,31 ,85 ,73 ,64 ,38 ,47 ,60 ,40 ,62 ,67 ,33 ,62 ,47 ,81 ,
		62 ,72 ,43 ,81 ,68 ,69 ,37 ,106 ,64 ,66 ,66 ,67 ,63 ,118 ,40 ,66 ,
		50 ,44 ,64 ,64 ,94 ,69 ,70 ,64 ,71 ,46 ,73 ,64 ,77 ,48 ,64 ,56 ,
		63 ,47 ,71 ,64 ,32 ,37 ,61 ,30 ,37 ,69 ,62 ,72 ,61 ,35 ,64 ,69 ,
		60 ,52 ,66 ,66 ,37 ,80 ,49 ,64 ,63 ,83 ,52 ,69 ,66 ,46 ,60 ,84 ,
		67 ,63 ,69 ,64 ,77 ,47 ,70 ,32 ,59 ,61 ,58 ,62 ,67 ,69 ,68 ,62 ,
		48 ,46 ,31 ,38 ,60 ,54 ,90 ,32 ,39 ,71 ,70 ,63 ,46 ,32 ,46 ,70 ,
		86 ,64 ,58 ,37 ,64 ,105 ,72 ,72 ,70 ,72 ,46 ,59 ,40 ,71 ,79 ,80 ,
		72 ,64 ,64 ,73 ,56 ,62 ,65 ,76 ,70 ,72 ,38 ,30 ,64 ,72 ,63 ,35 ,
		70 ,29 ,69 ,48 ,69 ,76 ,74 ,70 ,70 ,48 ,37 ,69 ,31 ,60 ,72 ,68 ,
		71 ,32 ,103 ,64 ,42 ,48 ,47 ,64 ,56 ,66 ,69 ,70 ,47 ,66 ,69 ,74 ,
		};


	private static final int[] size32 = {
		52 ,80 ,68 ,48 ,61 ,64 ,123 ,78 ,66 ,77 ,67 ,43 ,77 ,63 ,31 ,65 ,79 ,71 ,31 ,66 ,71 ,68 ,69 ,32 ,69 ,48 ,38 ,71 ,39 ,41 ,69 ,59 ,
		87 ,48 ,78 ,57 ,34 ,52 ,46 ,76 ,50 ,42 ,63 ,72 ,63 ,38 ,71 ,41 ,64 ,66 ,69 ,78 ,64 ,31 ,39 ,66 ,65 ,35 ,78 ,38 ,71 ,34 ,40 ,68 ,
		69 ,66 ,47 ,80 ,32 ,69 ,32 ,54 ,65 ,68 ,72 ,71 ,62 ,101 ,36 ,57 ,74 ,68 ,31 ,85 ,73 ,64 ,38 ,47 ,60 ,40 ,62 ,67 ,33 ,62 ,47 ,81 ,
		62 ,72 ,43 ,81 ,68 ,69 ,37 ,106 ,64 ,66 ,66 ,67 ,63 ,118 ,40 ,66 ,50 ,44 ,64 ,64 ,94 ,69 ,70 ,64 ,71 ,46 ,73 ,64 ,77 ,48 ,64 ,56 ,
		63 ,47 ,71 ,64 ,32 ,37 ,61 ,30 ,37 ,69 ,62 ,72 ,61 ,35 ,64 ,69 ,60 ,52 ,66 ,66 ,37 ,80 ,49 ,64 ,63 ,83 ,52 ,69 ,66 ,46 ,60 ,84 ,
		67 ,63 ,69 ,64 ,77 ,47 ,70 ,32 ,59 ,61 ,58 ,62 ,67 ,69 ,68 ,62 ,48 ,46 ,31 ,38 ,60 ,54 ,90 ,32 ,39 ,71 ,70 ,63 ,46 ,32 ,46 ,70 ,
		86 ,64 ,58 ,37 ,64 ,105 ,72 ,72 ,70 ,72 ,46 ,59 ,40 ,71 ,79 ,80 ,72 ,64 ,64 ,73 ,56 ,62 ,65 ,76 ,70 ,72 ,38 ,30 ,64 ,72 ,63 ,35 ,
		70 ,29 ,69 ,48 ,69 ,76 ,74 ,70 ,70 ,48 ,37 ,69 ,31 ,60 ,72 ,68 ,71 ,32 ,103 ,64 ,42 ,48 ,47 ,64 ,56 ,66 ,69 ,70 ,47 ,66 ,69 ,74 ,
		72 ,67 ,74 ,68 ,37 ,67 ,63 ,72 ,62 ,30 ,83 ,40 ,67 ,53 ,42 ,34 ,60 ,47 ,48 ,42 ,37 ,81 ,33 ,62 ,56 ,64 ,32 ,69 ,32 ,62 ,59 ,66 ,
		47 ,62 ,87 ,60 ,56 ,66 ,64 ,75 ,75 ,50 ,56 ,68 ,40 ,62 ,71 ,81 ,57 ,52 ,45 ,34 ,64 ,47 ,39 ,40 ,64 ,37 ,35 ,63 ,56 ,32 ,72 ,32 ,
		123 ,39 ,71 ,30 ,69 ,33 ,69 ,48 ,64 ,84 ,69 ,64 ,64 ,47 ,75 ,70 ,80 ,73 ,70 ,60 ,83 ,42 ,64 ,38 ,58 ,50 ,90 ,50 ,32 ,63 ,71 ,97 ,
		117 ,77 ,40 ,35 ,75 ,46 ,63 ,71 ,43 ,47 ,58 ,48 ,73 ,67 ,71 ,69 ,67 ,67 ,33 ,64 ,41 ,32 ,66 ,62 ,53 ,63 ,64 ,46 ,35 ,63 ,70 ,64 ,
		61 ,77 ,65 ,79 ,48 ,64 ,52 ,71 ,71 ,60 ,62 ,49 ,78 ,35 ,84 ,68 ,63 ,34 ,71 ,53 ,73 ,73 ,76 ,71 ,48 ,44 ,67 ,32 ,44 ,35 ,61 ,92 ,
		76 ,61 ,69 ,71 ,38 ,45 ,40 ,32 ,66 ,60 ,88 ,55 ,73 ,51 ,62 ,70 ,32 ,70 ,57 ,67 ,64 ,63 ,32 ,64 ,67 ,71 ,79 ,66 ,64 ,46 ,68 ,67 ,
		46 ,68 ,39 ,47 ,36 ,64 ,97 ,62 ,47 ,62 ,31 ,77 ,64 ,65 ,64 ,48 ,91 ,33 ,66 ,73 ,58 ,66 ,68 ,70 ,93 ,63 ,61 ,72 ,61 ,79 ,64 ,32 ,
		76 ,48 ,67 ,30 ,76 ,62 ,68 ,56 ,47 ,63 ,96 ,37 ,64 ,70 ,79 ,32 ,69 ,80 ,69 ,68 ,62 ,64 ,53 ,62 ,40 ,78 ,63 ,63 ,35 ,105 ,66 ,40 ,
		39 ,62 ,34 ,64 ,32 ,79 ,61 ,66 ,61 ,64 ,63 ,64 ,45 ,66 ,66 ,35 ,66 ,37 ,47 ,39 ,71 ,37 ,33 ,72 ,47 ,68 ,80 ,32 ,32 ,95 ,69 ,68 ,
		71 ,87 ,80 ,76 ,60 ,64 ,116 ,32 ,67 ,63 ,68 ,70 ,67 ,83 ,63 ,63 ,64 ,45 ,39 ,61 ,32 ,64 ,69 ,40 ,70 ,44 ,90 ,77 ,79 ,37 ,47 ,38 ,
		36 ,61 ,32 ,48 ,68 ,103 ,56 ,62 ,68 ,63 ,71 ,32 ,66 ,77 ,71 ,88 ,69 ,48 ,45 ,71 ,75 ,62 ,67 ,62 ,40 ,57 ,69 ,38 ,61 ,73 ,99 ,77 ,
		68 ,71 ,63 ,69 ,63 ,64 ,71 ,48 ,31 ,70 ,63 ,34 ,63 ,32 ,70 ,35 ,93 ,50 ,73 ,64 ,69 ,60 ,68 ,79 ,32 ,68 ,33 ,47 ,51 ,81 ,64 ,32 ,
		75 ,56 ,52 ,32 ,70 ,32 ,35 ,61 ,79 ,69 ,69 ,48 ,48 ,61 ,66 ,62 ,74 ,32 ,36 ,60 ,82 ,78 ,38 ,34 ,75 ,55 ,64 ,88 ,68 ,66 ,67 ,62 ,
		40 ,79 ,68 ,64 ,79 ,37 ,63 ,49 ,58 ,72 ,32 ,71 ,70 ,74 ,66 ,39 ,37 ,67 ,85 ,48 ,72 ,42 ,70 ,48 ,75 ,38 ,64 ,66 ,32 ,72 ,50 ,64 ,
		40 ,39 ,60 ,72 ,80 ,34 ,60 ,45 ,48 ,32 ,33 ,84 ,95 ,62 ,31 ,37 ,62 ,32 ,32 ,71 ,50 ,71 ,69 ,31 ,34 ,63 ,68 ,41 ,83 ,63 ,47 ,35 ,
		38 ,61 ,67 ,64 ,63 ,64 ,72 ,42 ,62 ,47 ,38 ,64 ,42 ,62 ,65 ,33 ,48 ,69 ,78 ,61 ,32 ,67 ,69 ,65 ,45 ,50 ,61 ,71 ,67 ,70 ,80 ,70 ,
		70 ,72 ,67 ,58 ,64 ,72 ,67 ,37 ,69 ,38 ,43 ,47 ,66 ,63 ,64 ,39 ,69 ,32 ,62 ,31 ,35 ,72 ,72 ,63 ,66 ,32 ,64 ,70 ,102 ,68 ,49 ,62 ,
		102 ,51 ,64 ,63 ,33 ,64 ,69 ,76 ,67 ,70 ,61 ,39 ,61 ,48 ,32 ,77 ,45 ,69 ,46 ,47 ,72 ,78 ,68 ,43 ,67 ,32 ,66 ,64 ,73 ,32 ,66 ,32 ,
		70 ,71 ,70 ,37 ,65 ,77 ,64 ,62 ,54 ,67 ,68 ,78 ,30 ,64 ,69 ,61 ,60 ,67 ,92 ,98 ,43 ,72 ,72 ,61 ,78 ,76 ,66 ,48 ,33 ,84 ,86 ,68 ,
		94 ,36 ,61 ,63 ,63 ,69 ,63 ,53 ,65 ,39 ,63 ,67 ,49 ,106 ,44 ,47 ,63 ,56 ,36 ,61 ,63 ,63 ,62 ,35 ,75 ,37 ,64 ,38 ,48 ,69 ,79 ,55 ,
		69 ,41 ,49 ,69 ,63 ,64 ,70 ,53 ,40 ,68 ,32 ,32 ,30 ,32 ,55 ,72 ,72 ,48 ,66 ,64 ,37 ,68 ,63 ,72 ,30 ,76 ,66 ,81 ,83 ,88 ,68 ,58 ,
		73 ,39 ,81 ,47 ,56 ,64 ,53 ,65 ,63 ,76 ,65 ,73 ,80 ,62 ,60 ,59 ,46 ,67 ,66 ,55 ,80 ,72 ,76 ,70 ,48 ,51 ,64 ,70 ,42 ,71 ,69 ,64 ,
		56 ,70 ,69 ,55 ,37 ,76 ,75 ,42 ,47 ,47 ,104 ,63 ,71 ,64 ,39 ,68 ,71 ,66 ,61 ,47 ,59 ,48 ,31 ,94 ,32 ,72 ,47 ,48 ,51 ,77 ,74 ,63 ,
		64 ,44 ,75 ,39 ,65 ,63 ,75 ,71 ,69 ,65 ,62 ,43 ,73 ,72 ,40 ,68 ,48 ,69 ,71 ,46 ,78 ,48 ,71 ,65 ,58 ,62 ,87 ,73 ,65 ,37 ,43 ,40 ,
		};


	@Test
	@DisplayName("Test Height map version 1.11 size 16")
	public void size16() {
		randomChunkGen(VERSION, 3123285319240812381L, DIMENSION, 16, 21382138983289132L, size16);
	}

	@Test
	@DisplayName("Test Height version 1.11 map size 32")
	public void size32() {
		randomChunkGen(VERSION, 3123285319240812381L, DIMENSION, 32, 21382138983289132L, size32);
	}

	@Test
	@DisplayName("Test Height version 1.11 map size 128")
	public void size128() {
		randomHashGen(VERSION, 3123285319240812381L, DIMENSION, 128, 21382138983289132L, 9111972824862961247L);
	}


	//	public static HashMap<Integer, ChunkPrimer> hashMap = new HashMap<>();
	//
	//  public static int processChunk(int x, int z, IChunkGenerator chunkGenerator, IBlockState blockState) {
	//		int cx = x >> 4;
	//		int cz = z >> 4;
	//		ChunkPrimer chunk = hashMap.computeIfAbsent(((cx & 0xffff) << 16) | (cz & 0xffff), e -> {
	//			ChunkPrimer chunkPrimer = new ChunkPrimer();
	//			chunkGenerator.setBlocksInChunk(cx, cz, chunkPrimer);
	//			return chunkPrimer;
	//		});
	//		return chunk.findGroundBlockIdx(x & 0xf, z & 0xf, block -> block == blockState);
	//	}
	//
	//	public static void testTerrain() {
	//		Bootstrap.register();
	//		long seed = 3123285319240812381L;
	//		World world = new WorldClient(null,
	//				new WorldSettings(seed, GameType.NOT_SET, true, false, WorldType.DEFAULT),
	//				DimensionType.OVERWORLD.getId(), EnumDifficulty.EASY, null);
	//        ChunkProviderOverworld chunkGeneratorOverworld = new ChunkProviderOverworld(world, seed, true, "");
	//
	//
	//		world = new WorldClient(null,
	//				new WorldSettings(seed, GameType.NOT_SET, true, false, WorldType.DEFAULT),
	//				DimensionType.NETHER.getId(), EnumDifficulty.EASY, null);
	//        ChunkProviderHell chunkGeneratorHell = new ChunkProviderHell(world, true, seed);
	//
	//		world = new WorldClient(null,
	//				new WorldSettings(seed, GameType.NOT_SET, true, false, WorldType.DEFAULT),
	//				DimensionType.THE_END.getId(), EnumDifficulty.EASY, null);
	//        ChunkProviderEnd chunkGeneratorEnd = new ChunkProviderEnd(world, true, seed, new BlockPos(0, 0, 0));
	//
	//		IChunkGenerator chunkGenerator = chunkGeneratorOverworld;
	//		IBlockState state = Blocks.STONE.getDefaultState();
	//
	//		int size = 32;
	//		Random r = new Random(21382138983289132L);
	//		boolean PRINT = true;
	//		if (PRINT) System.out.println("{");
	//		long hash = 0;
	//
	//		for (int i = 0; i < size; i++) {
	//			for (int j = 0; j < size; j++) {
	//				int x = r.nextInt(512000) - 25600;
	//				int z = r.nextInt(512000) - 25600;
	//				int y = processChunk(x, z, chunkGenerator, state);
	//				hash = hash * 0xFF51AFD7ED558CCDL + 0xC4CEB9FE1A85EC53L | y;
	//				if (PRINT) System.out.printf("%d ,", y);
	//			}
	//			if (PRINT) System.out.println();
	//		}
	//		if (PRINT) System.out.print("};");
	//		if (PRINT) System.out.println();
	//		if (!PRINT) System.out.println(hash + "L");
	//
	//	}
}
