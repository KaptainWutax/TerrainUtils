package kaptainwutax.v1_13;

import kaptainwutax.TestFramework;
import kaptainwutax.mcutils.state.Dimension;
import kaptainwutax.mcutils.version.MCVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static kaptainwutax.TestFramework.randomChunkGen;
import static kaptainwutax.TestFramework.randomHashGen;

@DisplayName("Minecraft v1.13 End")
@Tag("v1.13")
@TestFramework.End
public class End {
	public static final MCVersion VERSION = MCVersion.v1_13;
	public static final Dimension DIMENSION = Dimension.END;
	private static final int[] size16 = {
		60 ,0 ,0 ,0 ,0 ,0 ,0 ,59 ,0 ,58 ,0 ,0 ,60 ,58 ,0 ,42 ,
		58 ,62 ,0 ,0 ,61 ,0 ,60 ,63 ,0 ,0 ,0 ,0 ,41 ,66 ,0 ,0 ,
		0 ,0 ,0 ,0 ,0 ,0 ,47 ,0 ,62 ,0 ,0 ,0 ,60 ,58 ,0 ,0 ,
		0 ,58 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,64 ,63 ,0 ,0 ,0 ,58 ,
		0 ,0 ,57 ,63 ,63 ,0 ,0 ,63 ,0 ,47 ,0 ,0 ,63 ,0 ,60 ,57 ,
		57 ,0 ,55 ,59 ,58 ,57 ,0 ,65 ,59 ,43 ,50 ,0 ,0 ,0 ,63 ,58 ,
		59 ,0 ,0 ,0 ,57 ,58 ,0 ,0 ,61 ,57 ,0 ,0 ,57 ,62 ,45 ,57 ,
		40 ,0 ,0 ,0 ,57 ,0 ,57 ,0 ,61 ,0 ,59 ,0 ,61 ,0 ,61 ,0 ,
		0 ,59 ,57 ,0 ,0 ,63 ,60 ,0 ,0 ,42 ,0 ,63 ,0 ,58 ,0 ,0 ,
		0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,64 ,0 ,60 ,0 ,0 ,0 ,0 ,0 ,
		58 ,0 ,63 ,58 ,0 ,59 ,0 ,58 ,0 ,57 ,63 ,57 ,50 ,58 ,58 ,46 ,
		0 ,0 ,54 ,0 ,0 ,0 ,0 ,0 ,57 ,0 ,0 ,65 ,0 ,61 ,0 ,57 ,
		62 ,61 ,0 ,58 ,0 ,0 ,58 ,66 ,0 ,59 ,62 ,0 ,0 ,58 ,57 ,57 ,
		59 ,54 ,0 ,0 ,60 ,0 ,0 ,66 ,57 ,0 ,0 ,25 ,0 ,58 ,0 ,45 ,
		59 ,0 ,60 ,62 ,0 ,58 ,59 ,0 ,64 ,59 ,57 ,0 ,0 ,0 ,0 ,57 ,
		59 ,62 ,0 ,58 ,0 ,57 ,62 ,0 ,0 ,57 ,0 ,0 ,0 ,57 ,0 ,0 ,
		};


	private static final int[] size32 = {
		60 ,0 ,0 ,0 ,0 ,0 ,0 ,59 ,0 ,58 ,0 ,0 ,60 ,58 ,0 ,42 ,58 ,62 ,0 ,0 ,61 ,0 ,60 ,63 ,0 ,0 ,0 ,0 ,41 ,66 ,0 ,0 ,
		0 ,0 ,0 ,0 ,0 ,0 ,47 ,0 ,62 ,0 ,0 ,0 ,60 ,58 ,0 ,0 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,64 ,63 ,0 ,0 ,0 ,58 ,
		0 ,0 ,57 ,63 ,63 ,0 ,0 ,63 ,0 ,47 ,0 ,0 ,63 ,0 ,60 ,57 ,57 ,0 ,55 ,59 ,58 ,57 ,0 ,65 ,59 ,43 ,50 ,0 ,0 ,0 ,63 ,58 ,
		59 ,0 ,0 ,0 ,57 ,58 ,0 ,0 ,61 ,57 ,0 ,0 ,57 ,62 ,45 ,57 ,40 ,0 ,0 ,0 ,57 ,0 ,57 ,0 ,61 ,0 ,59 ,0 ,61 ,0 ,61 ,0 ,
		0 ,59 ,57 ,0 ,0 ,63 ,60 ,0 ,0 ,42 ,0 ,63 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,64 ,0 ,60 ,0 ,0 ,0 ,0 ,0 ,
		58 ,0 ,63 ,58 ,0 ,59 ,0 ,58 ,0 ,57 ,63 ,57 ,50 ,58 ,58 ,46 ,0 ,0 ,54 ,0 ,0 ,0 ,0 ,0 ,57 ,0 ,0 ,65 ,0 ,61 ,0 ,57 ,
		62 ,61 ,0 ,58 ,0 ,0 ,58 ,66 ,0 ,59 ,62 ,0 ,0 ,58 ,57 ,57 ,59 ,54 ,0 ,0 ,60 ,0 ,0 ,66 ,57 ,0 ,0 ,25 ,0 ,58 ,0 ,45 ,
		59 ,0 ,60 ,62 ,0 ,58 ,59 ,0 ,64 ,59 ,57 ,0 ,0 ,0 ,0 ,57 ,59 ,62 ,0 ,58 ,0 ,57 ,62 ,0 ,0 ,57 ,0 ,0 ,0 ,57 ,0 ,0 ,
		41 ,64 ,0 ,42 ,57 ,0 ,0 ,62 ,0 ,0 ,0 ,0 ,46 ,59 ,55 ,0 ,0 ,0 ,61 ,59 ,47 ,0 ,0 ,0 ,0 ,0 ,58 ,62 ,0 ,58 ,0 ,0 ,
		0 ,61 ,53 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,53 ,59 ,0 ,60 ,0 ,63 ,53 ,0 ,57 ,0 ,0 ,0 ,60 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,59 ,
		0 ,0 ,0 ,0 ,0 ,0 ,60 ,58 ,0 ,61 ,0 ,0 ,46 ,61 ,60 ,62 ,0 ,57 ,0 ,57 ,0 ,62 ,61 ,44 ,0 ,59 ,0 ,0 ,58 ,0 ,0 ,0 ,
		0 ,64 ,58 ,59 ,0 ,0 ,0 ,46 ,48 ,0 ,0 ,0 ,58 ,58 ,0 ,58 ,0 ,0 ,0 ,0 ,53 ,0 ,0 ,35 ,0 ,0 ,60 ,0 ,0 ,0 ,60 ,59 ,
		57 ,0 ,0 ,58 ,36 ,0 ,0 ,0 ,0 ,48 ,63 ,62 ,0 ,40 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,44 ,63 ,59 ,0 ,0 ,0 ,0 ,
		45 ,0 ,0 ,0 ,0 ,0 ,61 ,0 ,0 ,0 ,0 ,60 ,58 ,0 ,57 ,42 ,0 ,59 ,57 ,0 ,63 ,60 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,57 ,59 ,
		0 ,61 ,0 ,0 ,0 ,58 ,0 ,65 ,63 ,0 ,62 ,0 ,59 ,0 ,0 ,0 ,0 ,57 ,0 ,0 ,60 ,0 ,0 ,0 ,66 ,0 ,59 ,60 ,0 ,0 ,38 ,0 ,
		67 ,60 ,0 ,0 ,60 ,0 ,57 ,0 ,58 ,0 ,0 ,57 ,58 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,58 ,0 ,0 ,0 ,60 ,0 ,0 ,60 ,62 ,58 ,61 ,0 ,
		0 ,0 ,0 ,0 ,0 ,0 ,0 ,61 ,61 ,0 ,61 ,0 ,62 ,0 ,65 ,57 ,0 ,58 ,0 ,0 ,0 ,60 ,0 ,0 ,0 ,60 ,62 ,0 ,0 ,0 ,60 ,46 ,
		59 ,43 ,60 ,0 ,0 ,0 ,59 ,59 ,0 ,0 ,55 ,0 ,60 ,57 ,0 ,63 ,0 ,65 ,0 ,0 ,0 ,65 ,63 ,62 ,58 ,61 ,63 ,48 ,61 ,58 ,0 ,59 ,
		0 ,36 ,58 ,61 ,57 ,0 ,62 ,0 ,0 ,57 ,67 ,0 ,61 ,0 ,62 ,0 ,0 ,0 ,58 ,43 ,58 ,59 ,0 ,59 ,0 ,51 ,57 ,0 ,45 ,0 ,0 ,0 ,
		0 ,0 ,63 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,58 ,0 ,57 ,59 ,0 ,0 ,0 ,0 ,57 ,61 ,0 ,62 ,58 ,0 ,59 ,0 ,0 ,0 ,0 ,59 ,62 ,0 ,
		57 ,0 ,63 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,49 ,0 ,63 ,57 ,0 ,0 ,0 ,43 ,43 ,0 ,60 ,60 ,0 ,58 ,0 ,0 ,60 ,0 ,0 ,
		0 ,0 ,0 ,48 ,0 ,0 ,0 ,0 ,59 ,57 ,53 ,63 ,46 ,0 ,0 ,57 ,63 ,0 ,59 ,0 ,0 ,61 ,0 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,59 ,0 ,
		0 ,61 ,57 ,60 ,57 ,0 ,0 ,62 ,0 ,58 ,58 ,0 ,62 ,60 ,0 ,57 ,0 ,35 ,58 ,0 ,59 ,46 ,0 ,0 ,59 ,61 ,0 ,0 ,0 ,0 ,0 ,57 ,
		0 ,0 ,0 ,0 ,58 ,0 ,61 ,58 ,0 ,0 ,0 ,0 ,57 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,64 ,0 ,0 ,0 ,59 ,0 ,65 ,58 ,0 ,0 ,0 ,61 ,
		61 ,62 ,61 ,0 ,58 ,55 ,0 ,0 ,43 ,60 ,35 ,0 ,61 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,60 ,0 ,57 ,0 ,0 ,57 ,0 ,0 ,0 ,62 ,0 ,0 ,
		0 ,0 ,61 ,59 ,0 ,61 ,0 ,0 ,58 ,58 ,0 ,0 ,63 ,57 ,0 ,0 ,0 ,58 ,0 ,61 ,0 ,59 ,63 ,58 ,0 ,0 ,58 ,58 ,61 ,0 ,0 ,0 ,
		0 ,0 ,58 ,61 ,60 ,60 ,0 ,0 ,62 ,0 ,58 ,59 ,60 ,0 ,0 ,0 ,61 ,61 ,0 ,58 ,0 ,61 ,0 ,61 ,0 ,0 ,0 ,0 ,0 ,48 ,0 ,0 ,
		60 ,0 ,61 ,58 ,0 ,61 ,59 ,0 ,60 ,57 ,0 ,60 ,0 ,0 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,58 ,0 ,0 ,0 ,0 ,61 ,57 ,53 ,0 ,0 ,0 ,
		58 ,63 ,0 ,0 ,59 ,0 ,0 ,0 ,54 ,59 ,59 ,0 ,0 ,57 ,0 ,0 ,0 ,63 ,0 ,0 ,61 ,0 ,62 ,63 ,0 ,58 ,0 ,59 ,0 ,62 ,57 ,0 ,
		58 ,0 ,58 ,59 ,0 ,60 ,63 ,61 ,62 ,57 ,0 ,0 ,0 ,0 ,61 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,63 ,63 ,0 ,0 ,61 ,0 ,0 ,59 ,
		61 ,61 ,45 ,59 ,0 ,0 ,0 ,0 ,61 ,0 ,0 ,61 ,0 ,57 ,63 ,59 ,0 ,58 ,0 ,0 ,0 ,0 ,60 ,50 ,0 ,0 ,64 ,0 ,0 ,59 ,58 ,0 ,
		58 ,57 ,60 ,57 ,0 ,0 ,0 ,58 ,58 ,0 ,58 ,58 ,0 ,63 ,0 ,58 ,58 ,0 ,0 ,60 ,0 ,60 ,58 ,0 ,0 ,0 ,60 ,0 ,0 ,34 ,0 ,0 ,
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
		randomHashGen(VERSION, 1232903292041L, DIMENSION, 128, 21382138983289132L, 6801224251659587710L);
	}


	//  public static HashMap<Integer, BlockState[][][]> hashMap = new HashMap<>();
	//
	//	public static int processChunk(int x, int z, AbstractChunkGenerator<?> chunkGenerator) {
	//		int cx = x >> 4;
	//		int cz = z >> 4;
	//		BlockState[][][] chunk = hashMap.computeIfAbsent(((cx & 0xffff) << 16) | (cz & 0xffff), e -> {
	//			BlockState[][][] blockStates = new BlockState[16][chunkGenerator.getMaxHeight()][16];
	//			chunkGenerator.setBlocksInChunk(cx, cz, blockStates);
	//			return blockStates;
	//		});
	//		hashMap.clear();
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
	//	public static List<BlockState> getColumn(int x, int z, AbstractChunkGenerator<?> chunkGenerator) {
	//		int cx = x >> 4;
	//		int cz = z >> 4;
	//		BlockState[][][] chunk = hashMap.computeIfAbsent(((cx & 0xffff) << 16) | (cz & 0xffff), e -> {
	//			BlockState[][][] blockStates = new BlockState[16][chunkGenerator.getMaxHeight()][16];
	//			chunkGenerator.setBlocksInChunk(cx, cz, blockStates);
	//			return blockStates;
	//		});
	//		BlockState[][] xPart = chunk[x & 0xf];
	//		return Arrays.stream(xPart).map(e -> e[z & 0xf]).collect(Collectors.toList());
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
	//		AbstractChunkGenerator<?> chunkGenerator = chunkGeneratorEnd;
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
	//
	//		}
	//		if (PRINT) System.out.print("};");
	//		if (PRINT) System.out.println();
	//		if (!PRINT) System.out.println(hash + "L");
	//
	//
	//		String assets = System.getenv().containsKey("assetDirectory") ? System.getenv("assetDirectory") : "assets";
	//		//Main.main(concat(new String[] {"--version", "mcp", "--accessToken", "0", "--assetsDir", assets, "--assetIndex", "1.13", "--userProperties", "{}", "--gameDir", "run"}, args));
	//	}
}
