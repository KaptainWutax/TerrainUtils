package kaptainwutax.v1_13;

import kaptainwutax.TestFramework;
import kaptainwutax.mcutils.state.Dimension;
import kaptainwutax.mcutils.version.MCVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static kaptainwutax.TestFramework.randomChunkGen;
import static kaptainwutax.TestFramework.randomHashGen;
import static kaptainwutax.TestFramework.testSinglePoint;

@DisplayName("Minecraft v1.13 Overworld")
@Tag("v1.13")
@TestFramework.Overworld
public class Overworld {
	public static final MCVersion VERSION = MCVersion.v1_13;
	public static final Dimension DIMENSION = Dimension.OVERWORLD;
	private static final int[] size16 = {
		65 ,67 ,62 ,50 ,74 ,36 ,48 ,66 ,31 ,35 ,47 ,69 ,61 ,67 ,90 ,69 ,
		65 ,71 ,65 ,78 ,85 ,34 ,42 ,64 ,54 ,45 ,58 ,68 ,34 ,74 ,32 ,77 ,
		62 ,64 ,132 ,32 ,45 ,66 ,51 ,76 ,35 ,63 ,63 ,62 ,75 ,71 ,69 ,70 ,
		68 ,56 ,38 ,32 ,60 ,42 ,53 ,41 ,68 ,64 ,67 ,41 ,62 ,64 ,66 ,62 ,
		35 ,66 ,55 ,111 ,68 ,66 ,65 ,52 ,66 ,79 ,72 ,34 ,77 ,57 ,64 ,68 ,
		82 ,63 ,64 ,69 ,69 ,48 ,67 ,84 ,70 ,64 ,64 ,64 ,65 ,67 ,69 ,71 ,
		43 ,32 ,47 ,74 ,50 ,61 ,65 ,49 ,40 ,65 ,66 ,47 ,75 ,62 ,32 ,52 ,
		29 ,62 ,41 ,73 ,71 ,48 ,76 ,63 ,33 ,78 ,64 ,39 ,78 ,69 ,76 ,63 ,
		68 ,47 ,48 ,46 ,76 ,64 ,66 ,64 ,65 ,63 ,59 ,118 ,64 ,83 ,64 ,64 ,
		48 ,40 ,67 ,39 ,59 ,62 ,69 ,65 ,102 ,61 ,71 ,32 ,36 ,84 ,68 ,72 ,
		70 ,77 ,80 ,64 ,69 ,52 ,31 ,38 ,72 ,51 ,71 ,62 ,54 ,48 ,61 ,79 ,
		69 ,66 ,47 ,61 ,46 ,79 ,64 ,66 ,61 ,37 ,32 ,71 ,70 ,82 ,52 ,32 ,
		66 ,70 ,63 ,87 ,67 ,39 ,31 ,76 ,64 ,46 ,73 ,89 ,64 ,84 ,48 ,36 ,
		48 ,84 ,63 ,67 ,70 ,63 ,88 ,68 ,47 ,67 ,76 ,48 ,69 ,67 ,49 ,71 ,
		64 ,85 ,72 ,32 ,71 ,72 ,69 ,32 ,78 ,70 ,51 ,63 ,66 ,67 ,74 ,39 ,
		36 ,56 ,68 ,52 ,48 ,74 ,70 ,115 ,75 ,63 ,68 ,71 ,87 ,33 ,62 ,70 ,
		};


	private static final int[] size32 = {
		65 ,67 ,62 ,50 ,74 ,36 ,48 ,66 ,31 ,35 ,47 ,69 ,61 ,67 ,90 ,69 ,65 ,71 ,65 ,78 ,85 ,34 ,42 ,64 ,54 ,45 ,58 ,68 ,34 ,74 ,32 ,77 ,
		62 ,64 ,132 ,32 ,45 ,66 ,51 ,76 ,35 ,63 ,63 ,62 ,75 ,71 ,69 ,70 ,68 ,56 ,38 ,32 ,60 ,42 ,53 ,41 ,68 ,64 ,67 ,41 ,62 ,64 ,66 ,62 ,
		35 ,66 ,55 ,111 ,68 ,66 ,65 ,52 ,66 ,79 ,72 ,34 ,77 ,57 ,64 ,68 ,82 ,63 ,64 ,69 ,69 ,48 ,67 ,84 ,70 ,64 ,64 ,64 ,65 ,67 ,69 ,71 ,
		43 ,32 ,47 ,74 ,50 ,61 ,65 ,49 ,40 ,65 ,66 ,47 ,75 ,62 ,32 ,52 ,29 ,62 ,41 ,73 ,71 ,48 ,76 ,63 ,33 ,78 ,64 ,39 ,78 ,69 ,76 ,63 ,
		68 ,47 ,48 ,46 ,76 ,64 ,66 ,64 ,65 ,63 ,59 ,118 ,64 ,83 ,64 ,64 ,48 ,40 ,67 ,39 ,59 ,62 ,69 ,65 ,102 ,61 ,71 ,32 ,36 ,84 ,68 ,72 ,
		70 ,77 ,80 ,64 ,69 ,52 ,31 ,38 ,72 ,51 ,71 ,62 ,54 ,48 ,61 ,79 ,69 ,66 ,47 ,61 ,46 ,79 ,64 ,66 ,61 ,37 ,32 ,71 ,70 ,82 ,52 ,32 ,
		66 ,70 ,63 ,87 ,67 ,39 ,31 ,76 ,64 ,46 ,73 ,89 ,64 ,84 ,48 ,36 ,48 ,84 ,63 ,67 ,70 ,63 ,88 ,68 ,47 ,67 ,76 ,48 ,69 ,67 ,49 ,71 ,
		64 ,85 ,72 ,32 ,71 ,72 ,69 ,32 ,78 ,70 ,51 ,63 ,66 ,67 ,74 ,39 ,36 ,56 ,68 ,52 ,48 ,74 ,70 ,115 ,75 ,63 ,68 ,71 ,87 ,33 ,62 ,70 ,
		65 ,97 ,46 ,70 ,63 ,80 ,55 ,77 ,32 ,42 ,68 ,44 ,64 ,141 ,40 ,43 ,100 ,69 ,74 ,32 ,67 ,41 ,64 ,64 ,74 ,56 ,29 ,59 ,43 ,78 ,70 ,70 ,
		54 ,70 ,33 ,66 ,57 ,37 ,64 ,74 ,96 ,123 ,65 ,71 ,85 ,31 ,47 ,51 ,87 ,72 ,33 ,50 ,67 ,68 ,64 ,72 ,64 ,48 ,39 ,64 ,71 ,60 ,69 ,32 ,
		69 ,64 ,77 ,74 ,45 ,68 ,63 ,51 ,96 ,48 ,72 ,63 ,71 ,59 ,76 ,64 ,32 ,44 ,54 ,63 ,69 ,31 ,94 ,66 ,69 ,55 ,63 ,46 ,35 ,85 ,80 ,72 ,
		46 ,72 ,49 ,70 ,64 ,66 ,67 ,64 ,73 ,69 ,62 ,35 ,79 ,69 ,51 ,34 ,72 ,62 ,40 ,34 ,48 ,86 ,49 ,67 ,34 ,46 ,68 ,59 ,63 ,65 ,75 ,70 ,
		63 ,63 ,44 ,73 ,57 ,46 ,45 ,66 ,78 ,32 ,106 ,71 ,55 ,32 ,72 ,33 ,47 ,60 ,62 ,71 ,71 ,68 ,63 ,66 ,32 ,48 ,36 ,60 ,64 ,74 ,65 ,33 ,
		67 ,32 ,68 ,47 ,63 ,69 ,47 ,102 ,49 ,64 ,36 ,69 ,41 ,32 ,33 ,44 ,34 ,90 ,60 ,72 ,72 ,85 ,92 ,38 ,64 ,62 ,79 ,62 ,68 ,69 ,64 ,77 ,
		51 ,44 ,62 ,64 ,41 ,64 ,39 ,88 ,65 ,69 ,68 ,67 ,36 ,72 ,64 ,62 ,48 ,78 ,55 ,66 ,64 ,58 ,56 ,72 ,106 ,82 ,47 ,70 ,71 ,48 ,35 ,63 ,
		41 ,50 ,37 ,67 ,62 ,64 ,47 ,63 ,66 ,68 ,64 ,31 ,69 ,70 ,55 ,77 ,34 ,47 ,69 ,48 ,69 ,48 ,65 ,69 ,68 ,83 ,63 ,33 ,48 ,49 ,73 ,67 ,
		60 ,98 ,64 ,69 ,67 ,68 ,63 ,56 ,49 ,64 ,70 ,66 ,69 ,57 ,37 ,64 ,64 ,69 ,33 ,81 ,63 ,62 ,68 ,49 ,64 ,63 ,37 ,48 ,48 ,66 ,32 ,88 ,
		49 ,83 ,83 ,68 ,64 ,32 ,63 ,117 ,69 ,67 ,63 ,48 ,68 ,69 ,39 ,107 ,77 ,64 ,36 ,35 ,72 ,74 ,70 ,48 ,50 ,89 ,70 ,65 ,85 ,77 ,62 ,67 ,
		64 ,32 ,57 ,68 ,38 ,47 ,66 ,62 ,70 ,68 ,36 ,33 ,48 ,38 ,71 ,63 ,74 ,71 ,71 ,64 ,64 ,62 ,53 ,66 ,66 ,31 ,37 ,64 ,43 ,81 ,77 ,94 ,
		75 ,66 ,71 ,47 ,63 ,72 ,66 ,70 ,68 ,76 ,54 ,66 ,39 ,94 ,39 ,61 ,74 ,61 ,87 ,34 ,63 ,68 ,32 ,87 ,70 ,65 ,65 ,70 ,48 ,36 ,64 ,68 ,
		64 ,31 ,83 ,69 ,33 ,72 ,70 ,57 ,47 ,48 ,46 ,47 ,96 ,78 ,57 ,57 ,60 ,62 ,56 ,64 ,90 ,64 ,67 ,33 ,34 ,64 ,65 ,65 ,78 ,84 ,71 ,62 ,
		83 ,68 ,70 ,48 ,63 ,68 ,66 ,31 ,71 ,77 ,79 ,71 ,95 ,63 ,64 ,47 ,64 ,32 ,33 ,68 ,60 ,98 ,67 ,64 ,31 ,64 ,30 ,58 ,68 ,79 ,76 ,50 ,
		64 ,40 ,62 ,78 ,66 ,63 ,78 ,79 ,64 ,30 ,80 ,70 ,64 ,72 ,68 ,48 ,59 ,36 ,38 ,44 ,70 ,49 ,67 ,57 ,43 ,71 ,33 ,72 ,65 ,47 ,44 ,85 ,
		70 ,44 ,68 ,32 ,62 ,85 ,31 ,39 ,65 ,61 ,63 ,61 ,63 ,66 ,31 ,64 ,64 ,42 ,34 ,33 ,69 ,86 ,68 ,90 ,74 ,46 ,52 ,70 ,63 ,55 ,108 ,65 ,
		68 ,54 ,57 ,45 ,64 ,49 ,70 ,74 ,55 ,67 ,78 ,62 ,48 ,68 ,47 ,48 ,71 ,69 ,34 ,72 ,72 ,70 ,53 ,65 ,63 ,37 ,70 ,66 ,78 ,54 ,67 ,77 ,
		64 ,64 ,72 ,86 ,74 ,75 ,65 ,32 ,72 ,73 ,49 ,50 ,49 ,71 ,46 ,80 ,68 ,38 ,68 ,98 ,45 ,69 ,49 ,64 ,80 ,72 ,97 ,56 ,37 ,74 ,92 ,31 ,
		66 ,82 ,47 ,65 ,71 ,36 ,94 ,71 ,64 ,64 ,47 ,52 ,68 ,38 ,66 ,65 ,36 ,48 ,45 ,39 ,68 ,77 ,74 ,66 ,62 ,52 ,69 ,56 ,68 ,54 ,60 ,63 ,
		80 ,46 ,39 ,68 ,64 ,56 ,34 ,76 ,47 ,83 ,66 ,63 ,88 ,32 ,46 ,45 ,63 ,64 ,66 ,62 ,45 ,33 ,75 ,62 ,70 ,64 ,64 ,72 ,65 ,64 ,40 ,71 ,
		79 ,48 ,51 ,31 ,88 ,92 ,74 ,47 ,67 ,54 ,56 ,47 ,73 ,48 ,68 ,65 ,112 ,31 ,57 ,44 ,43 ,48 ,65 ,69 ,64 ,65 ,62 ,71 ,47 ,40 ,78 ,71 ,
		68 ,72 ,59 ,94 ,66 ,63 ,65 ,72 ,112 ,103 ,36 ,68 ,70 ,62 ,71 ,68 ,69 ,64 ,36 ,67 ,51 ,55 ,80 ,31 ,63 ,69 ,67 ,45 ,66 ,68 ,54 ,55 ,
		65 ,55 ,59 ,51 ,31 ,57 ,71 ,63 ,32 ,63 ,64 ,68 ,73 ,64 ,69 ,73 ,31 ,69 ,64 ,96 ,63 ,67 ,49 ,70 ,66 ,62 ,72 ,69 ,45 ,47 ,32 ,41 ,
		66 ,64 ,70 ,64 ,94 ,31 ,45 ,64 ,43 ,77 ,69 ,47 ,76 ,51 ,74 ,72 ,40 ,62 ,68 ,72 ,63 ,63 ,78 ,58 ,68 ,42 ,34 ,75 ,70 ,36 ,67 ,85 ,
		};

	@Test
	@DisplayName("Test Height map version 1.13 size 16")
	public void size16() {
		randomChunkGen(VERSION, 1232903292041L, DIMENSION, 16, 21382138983289132L, size16);
	}

	@Test
	@DisplayName("Test Height version 1.13 map size 32")
	public void size32() {
		randomChunkGen(VERSION, 1232903292041L, DIMENSION, 32, 21382138983289132L, size32);
	}

	@Test
	@DisplayName("Test Height version 1.13 map size 128")
	public void size128() {
		randomHashGen(VERSION, 1232903292041L, DIMENSION, 128, 21382138983289132L, 1018152795219244607L);
	}


	//	public static HashMap<Integer, BlockState[][][]> hashMap = new HashMap<>();
	//
	//	public static int processChunk(int x, int z, AbstractChunkGenerator<?> chunkGenerator) {
	//		int cx = x >> 4;
	//		int cz = z >> 4;
	//		BlockState[][][] chunk = hashMap.computeIfAbsent(((cx & 0xffff) << 16) | (cz & 0xffff), e -> {
	//			BlockState[][][] blockStates = new BlockState[16][chunkGenerator.getMaxHeight()][16];
	//			chunkGenerator.setBlocksInChunk(cx, cz, blockStates);
	//			return blockStates;
	//		});
	//		BlockState[][] xPart = chunk[x & 0xf];
	//		List<BlockState> column = Arrays.stream(xPart).map(e -> e[z & 0xf]).collect(Collectors.toList());
	//		Predicate<BlockState> predicate = blockState -> blockState == chunkGenerator.getDefaultBlock();
	//		int y;
	//		for (y = column.size() - 1; y >= 0; y--) {
	//			if (predicate.test(column.get(y))) break; ;
	//		}
	//		// onground
	//		return y + 1;
	//	}
	//
	//	public static void main(String[] args) {
	//		Bootstrap.register();
	//		long seed = 1232903292041L;
	//
	//		World world = new WorldClient(null,
	//				new WorldSettings(seed, GameType.NOT_SET, true, false, WorldType.DEFAULT),
	//				DimensionType.OVERWORLD, EnumDifficulty.EASY, null);
	//		OverworldDimension overworldDimension = new OverworldDimension();
	//		overworldDimension.setWorld(world);
	//		ChunkGeneratorOverworld chunkGeneratorOverworld = (ChunkGeneratorOverworld) overworldDimension.createChunkGenerator();
	//
	//		world = new WorldClient(null,
	//				new WorldSettings(seed, GameType.NOT_SET, true, false, WorldType.DEFAULT),
	//				DimensionType.THE_END, EnumDifficulty.EASY, null);
	//		EndDimension endDimension = new EndDimension();
	//		endDimension.setWorld(world);
	//		ChunkGeneratorEnd chunkGeneratorEnd = (ChunkGeneratorEnd) endDimension.createChunkGenerator();
	//
	//		world = new WorldClient(null,
	//				new WorldSettings(seed, GameType.NOT_SET, true, false, WorldType.DEFAULT),
	//				DimensionType.NETHER, EnumDifficulty.EASY, null);
	//		NetherDimension netherDimension = new NetherDimension();
	//		netherDimension.setWorld(world);
	//		ChunkGeneratorNether chunkGeneratorNether = (ChunkGeneratorNether) netherDimension.createChunkGenerator();
	//
	//		AbstractChunkGenerator<?> chunkGenerator = chunkGeneratorOverworld;
	//		int yy=processChunk(369016,101544,chunkGenerator);
	//		int size = 128;
	//		Random r = new Random(21382138983289132L);
	//		boolean PRINT = false;
	//		if (PRINT) System.out.println("{");
	//		long hash = 0;
	//
	//		for (int i = 0; i < size; i++) {
	//			for (int j = 0; j < size; j++) {
	//				int x = r.nextInt(512000) - 25600;
	//				int z = r.nextInt(512000) - 25600;
	//				int y = processChunk(x, z, chunkGenerator);
	//				hash = hash * 0xFF51AFD7ED558CCDL + 0xC4CEB9FE1A85EC53L | y;
	//				if (PRINT) System.out.printf("%d ,", y);
	//			}
	//			if (PRINT) System.out.println();
	//		}
	//		if (PRINT) System.out.print("};");
	//		if (PRINT) System.out.println();
	//		if (!PRINT) System.out.println(hash + "L");
}
