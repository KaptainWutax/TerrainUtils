package kaptainwutax.v1_12;

import kaptainwutax.TestFramework;
import kaptainwutax.mcutils.state.Dimension;
import kaptainwutax.mcutils.version.MCVersion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static kaptainwutax.TestFramework.randomChunkGen;
import static kaptainwutax.TestFramework.randomHashGen;

@DisplayName("Minecraft v1.12 End")
@Tag("v1.12")
@TestFramework.End
public class End {
	public static final MCVersion VERSION = MCVersion.v1_12;
	public static final Dimension DIMENSION = Dimension.END;
	private static final int[] size16 = {
		0 ,0 ,57 ,56 ,59 ,61 ,59 ,60 ,0 ,0 ,0 ,59 ,61 ,58 ,0 ,0 ,
		0 ,0 ,0 ,0 ,0 ,60 ,0 ,0 ,0 ,57 ,0 ,0 ,0 ,60 ,0 ,55 ,
		0 ,0 ,57 ,0 ,60 ,0 ,0 ,0 ,60 ,62 ,0 ,58 ,0 ,49 ,0 ,0 ,
		0 ,57 ,0 ,57 ,0 ,0 ,0 ,0 ,59 ,0 ,64 ,59 ,57 ,58 ,0 ,0 ,
		0 ,0 ,0 ,0 ,54 ,0 ,57 ,0 ,0 ,57 ,0 ,0 ,61 ,0 ,0 ,61 ,
		0 ,0 ,0 ,0 ,61 ,59 ,0 ,0 ,0 ,62 ,0 ,0 ,0 ,0 ,63 ,0 ,
		61 ,0 ,0 ,60 ,0 ,61 ,0 ,0 ,57 ,0 ,62 ,58 ,39 ,63 ,59 ,0 ,
		0 ,61 ,63 ,57 ,62 ,0 ,0 ,60 ,60 ,0 ,57 ,0 ,58 ,0 ,0 ,0 ,
		57 ,0 ,0 ,60 ,0 ,60 ,57 ,0 ,0 ,57 ,59 ,0 ,0 ,55 ,59 ,0 ,
		57 ,0 ,62 ,55 ,55 ,0 ,0 ,0 ,0 ,0 ,47 ,0 ,0 ,58 ,0 ,0 ,
		60 ,0 ,0 ,0 ,61 ,38 ,0 ,63 ,0 ,0 ,0 ,59 ,59 ,58 ,60 ,58 ,
		62 ,59 ,60 ,0 ,0 ,61 ,0 ,55 ,58 ,0 ,0 ,34 ,0 ,0 ,40 ,52 ,
		61 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,57 ,0 ,60 ,59 ,0 ,0 ,0 ,57 ,
		57 ,58 ,0 ,61 ,0 ,0 ,0 ,0 ,0 ,60 ,61 ,0 ,0 ,0 ,61 ,61 ,
		57 ,0 ,0 ,57 ,0 ,57 ,0 ,0 ,0 ,63 ,57 ,0 ,0 ,58 ,0 ,57 ,
		0 ,0 ,0 ,58 ,0 ,0 ,60 ,0 ,0 ,0 ,62 ,0 ,0 ,0 ,51 ,0 ,
		};


	private static final int[] size32 = {
		59 ,56 ,60 ,60 ,0 ,0 ,0 ,0 ,0 ,0 ,59 ,0 ,62 ,58 ,0 ,57 ,61 ,0 ,58 ,0 ,62 ,0 ,0 ,62 ,0 ,0 ,63 ,0 ,44 ,0 ,0 ,57 ,
		57 ,0 ,0 ,0 ,0 ,0 ,58 ,0 ,0 ,0 ,61 ,59 ,55 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,61 ,0 ,58 ,58 ,0 ,60 ,43 ,40 ,60 ,62 ,67 ,62 ,
		0 ,0 ,0 ,60 ,0 ,0 ,59 ,61 ,0 ,0 ,62 ,61 ,0 ,0 ,63 ,57 ,0 ,0 ,0 ,0 ,0 ,62 ,62 ,58 ,62 ,0 ,59 ,62 ,57 ,58 ,59 ,61 ,
		65 ,58 ,61 ,0 ,60 ,52 ,0 ,58 ,0 ,33 ,0 ,0 ,0 ,0 ,61 ,0 ,57 ,34 ,58 ,61 ,58 ,62 ,0 ,0 ,0 ,63 ,0 ,0 ,0 ,0 ,0 ,0 ,
		0 ,0 ,0 ,0 ,60 ,0 ,58 ,0 ,0 ,57 ,0 ,0 ,0 ,0 ,0 ,57 ,38 ,0 ,45 ,58 ,0 ,0 ,0 ,64 ,57 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,
		0 ,0 ,59 ,0 ,0 ,0 ,60 ,0 ,0 ,0 ,0 ,58 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,59 ,59 ,0 ,0 ,0 ,0 ,0 ,58 ,
		0 ,0 ,0 ,0 ,0 ,0 ,0 ,59 ,59 ,0 ,63 ,0 ,61 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,58 ,0 ,0 ,
		0 ,57 ,0 ,0 ,59 ,0 ,0 ,57 ,0 ,0 ,64 ,0 ,58 ,58 ,57 ,0 ,58 ,43 ,57 ,0 ,34 ,58 ,46 ,0 ,61 ,61 ,0 ,0 ,57 ,0 ,0 ,0 ,
		0 ,58 ,0 ,0 ,0 ,59 ,0 ,0 ,0 ,44 ,0 ,0 ,0 ,0 ,0 ,58 ,0 ,0 ,0 ,0 ,61 ,0 ,58 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,62 ,
		0 ,0 ,0 ,59 ,57 ,58 ,0 ,62 ,0 ,0 ,0 ,59 ,61 ,59 ,57 ,59 ,0 ,64 ,64 ,0 ,0 ,0 ,67 ,58 ,60 ,60 ,58 ,63 ,0 ,58 ,57 ,60 ,
		0 ,0 ,47 ,57 ,62 ,61 ,57 ,59 ,57 ,63 ,65 ,50 ,0 ,57 ,0 ,0 ,57 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,59 ,0 ,0 ,57 ,0 ,38 ,0 ,59 ,
		0 ,59 ,60 ,0 ,64 ,0 ,59 ,0 ,60 ,0 ,44 ,0 ,59 ,0 ,0 ,0 ,67 ,0 ,58 ,59 ,0 ,60 ,0 ,0 ,60 ,62 ,54 ,0 ,62 ,0 ,0 ,0 ,
		0 ,0 ,35 ,0 ,60 ,0 ,34 ,0 ,0 ,0 ,59 ,60 ,58 ,57 ,0 ,0 ,0 ,57 ,43 ,0 ,57 ,0 ,33 ,61 ,59 ,0 ,63 ,0 ,0 ,0 ,0 ,0 ,
		0 ,0 ,0 ,58 ,0 ,0 ,57 ,0 ,0 ,0 ,0 ,63 ,0 ,63 ,61 ,0 ,57 ,0 ,0 ,58 ,61 ,59 ,45 ,57 ,58 ,0 ,30 ,58 ,0 ,0 ,61 ,63 ,
		0 ,60 ,53 ,53 ,0 ,0 ,0 ,58 ,61 ,0 ,42 ,57 ,0 ,0 ,0 ,59 ,58 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,58 ,57 ,0 ,0 ,62 ,
		60 ,59 ,0 ,0 ,62 ,60 ,60 ,0 ,0 ,58 ,60 ,60 ,58 ,57 ,58 ,0 ,0 ,57 ,0 ,0 ,59 ,64 ,63 ,0 ,0 ,59 ,57 ,0 ,0 ,0 ,0 ,0 ,
		0 ,63 ,58 ,0 ,0 ,0 ,0 ,0 ,64 ,0 ,56 ,0 ,63 ,58 ,62 ,0 ,0 ,0 ,60 ,57 ,59 ,0 ,59 ,0 ,0 ,59 ,0 ,0 ,0 ,63 ,61 ,61 ,
		0 ,0 ,0 ,0 ,0 ,36 ,0 ,57 ,63 ,38 ,62 ,55 ,59 ,57 ,58 ,0 ,59 ,0 ,57 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,57 ,0 ,64 ,0 ,0 ,58 ,
		0 ,0 ,64 ,59 ,0 ,0 ,0 ,49 ,0 ,0 ,41 ,36 ,0 ,58 ,63 ,0 ,57 ,63 ,0 ,33 ,57 ,0 ,0 ,62 ,0 ,0 ,65 ,0 ,0 ,29 ,59 ,65 ,
		55 ,0 ,0 ,0 ,60 ,60 ,58 ,0 ,0 ,63 ,0 ,60 ,61 ,60 ,61 ,0 ,0 ,0 ,64 ,0 ,58 ,58 ,0 ,0 ,59 ,0 ,0 ,0 ,0 ,0 ,65 ,61 ,
		0 ,64 ,62 ,0 ,0 ,0 ,0 ,0 ,66 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,64 ,0 ,0 ,0 ,0 ,0 ,60 ,57 ,61 ,0 ,62 ,0 ,0 ,
		0 ,62 ,38 ,0 ,59 ,61 ,57 ,0 ,61 ,0 ,59 ,58 ,61 ,0 ,0 ,0 ,0 ,0 ,61 ,0 ,46 ,63 ,0 ,0 ,0 ,0 ,62 ,63 ,0 ,58 ,61 ,64 ,
		0 ,63 ,0 ,57 ,0 ,0 ,0 ,57 ,0 ,0 ,0 ,57 ,59 ,58 ,62 ,0 ,62 ,0 ,0 ,57 ,0 ,0 ,0 ,0 ,56 ,57 ,58 ,59 ,59 ,61 ,57 ,49 ,
		57 ,61 ,0 ,0 ,45 ,59 ,0 ,60 ,0 ,59 ,61 ,41 ,0 ,59 ,0 ,58 ,0 ,55 ,0 ,0 ,0 ,64 ,58 ,64 ,0 ,0 ,64 ,0 ,63 ,0 ,58 ,0 ,
		57 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,46 ,57 ,0 ,55 ,62 ,0 ,64 ,60 ,0 ,59 ,57 ,61 ,0 ,0 ,64 ,0 ,0 ,0 ,61 ,59 ,0 ,
		62 ,60 ,60 ,60 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,58 ,0 ,0 ,0 ,57 ,57 ,61 ,0 ,0 ,0 ,57 ,0 ,0 ,57 ,30 ,0 ,36 ,59 ,0 ,0 ,0 ,
		0 ,0 ,0 ,0 ,0 ,58 ,0 ,52 ,0 ,0 ,0 ,0 ,58 ,37 ,58 ,0 ,64 ,57 ,34 ,0 ,0 ,0 ,0 ,61 ,0 ,57 ,0 ,0 ,0 ,0 ,0 ,66 ,
		0 ,0 ,0 ,0 ,58 ,0 ,62 ,0 ,63 ,0 ,58 ,0 ,0 ,0 ,0 ,60 ,59 ,61 ,0 ,61 ,38 ,65 ,0 ,58 ,0 ,62 ,0 ,31 ,60 ,63 ,0 ,0 ,
		59 ,0 ,57 ,0 ,0 ,51 ,64 ,0 ,0 ,57 ,0 ,0 ,0 ,56 ,0 ,0 ,0 ,0 ,0 ,61 ,62 ,54 ,64 ,0 ,61 ,61 ,0 ,0 ,0 ,0 ,0 ,0 ,
		60 ,0 ,61 ,0 ,58 ,59 ,58 ,0 ,0 ,62 ,0 ,0 ,0 ,0 ,0 ,0 ,53 ,0 ,0 ,61 ,0 ,57 ,57 ,0 ,61 ,0 ,0 ,32 ,0 ,57 ,43 ,0 ,
		0 ,57 ,32 ,0 ,0 ,0 ,0 ,0 ,58 ,58 ,0 ,61 ,0 ,0 ,67 ,36 ,59 ,0 ,63 ,58 ,62 ,0 ,60 ,0 ,0 ,39 ,58 ,62 ,0 ,0 ,51 ,0 ,
		60 ,0 ,60 ,57 ,0 ,0 ,0 ,0 ,0 ,60 ,53 ,0 ,61 ,0 ,0 ,57 ,0 ,59 ,0 ,0 ,0 ,59 ,64 ,36 ,0 ,0 ,61 ,0 ,59 ,62 ,61 ,0 ,
		};

	@Test
	@DisplayName("Test Height map version 1.12 size 16")
	public void size16() {
		randomChunkGen(VERSION, 123909012342109241L, DIMENSION, 16, 21382138983289132L, size16);
	}

	@Test
	@DisplayName("Test Height version 1.12 map size 32")
	public void size32() {
		randomChunkGen(VERSION, 981293281392132132L, DIMENSION, 32, 21382138983289132L, size32);
	}

	@Test
	@DisplayName("Test Height version 1.12 map size 128")
	public void size128() {
		randomHashGen(VERSION, 929123281392132132L, DIMENSION, 128, 21382138983289132L, 2298905152885145662L);
	}

	//  public static HashMap<Integer, ChunkPrimer> hashMap = new HashMap<>();
	//
	//    public static int processChunk(int x, int z, IChunkGenerator chunkGenerator,IBlockState blockState) {
	//        int cx = x >> 4;
	//        int cz = z >> 4;
	//        ChunkPrimer chunk = hashMap.computeIfAbsent(((cx & 0xffff) << 16) | (cz & 0xffff), e -> {
	//            ChunkPrimer chunkPrimer=new ChunkPrimer();
	//            chunkGenerator.setBlocksInChunk(cx, cz, chunkPrimer);
	//            return chunkPrimer;
	//        });
	//        return chunk.findGroundBlockIdx(x&0xf,z&0xf,block-> block==blockState);
	//    }
	//
	//    public static void main(String[] args)
	//    {
	//        Bootstrap.register();
	//        long seed=929123281392132132L;
	//        World world = new WorldClient(null,
	//                new WorldSettings(seed, GameType.NOT_SET, true, false, WorldType.DEFAULT),
	//                DimensionType.OVERWORLD.getId(), EnumDifficulty.EASY, null);
	//        ChunkGeneratorOverworld chunkGeneratorOverworld=new ChunkGeneratorOverworld(world,seed,true,"");
	//
	//
	//        world = new WorldClient(null,
	//                new WorldSettings(seed, GameType.NOT_SET, true, false, WorldType.DEFAULT),
	//                DimensionType.NETHER.getId(), EnumDifficulty.EASY, null);
	//        ChunkGeneratorHell chunkGeneratorHell=new ChunkGeneratorHell(world,true,seed);
	//
	//        world = new WorldClient(null,
	//                new WorldSettings(seed, GameType.NOT_SET, true, false, WorldType.DEFAULT),
	//                DimensionType.THE_END.getId(), EnumDifficulty.EASY, null);
	//        ChunkGeneratorEnd chunkGeneratorEnd=new ChunkGeneratorEnd(world,true,seed,new BlockPos(0,0,0));
	//
	//        IChunkGenerator chunkGenerator=chunkGeneratorEnd;
	//        IBlockState state= Blocks.END_STONE.getDefaultState();
	//
	//        int size = 128;
	//        Random r = new Random(21382138983289132L);
	//        boolean PRINT = false;
	//        if (PRINT) System.out.println("{");
	//        long hash = 0;
	//
	//        for (int i = 0; i < size; i++) {
	//            for (int j = 0; j < size; j++) {
	//                int x = r.nextInt(512000) - 25600;
	//                int z = r.nextInt(512000) - 25600;
	//                int y = processChunk(x, z, chunkGenerator,state);
	//                hash = hash * 0xFF51AFD7ED558CCDL + 0xC4CEB9FE1A85EC53L | y;
	//                if (PRINT) System.out.printf("%d ,", y);
	//            }
	//            if (PRINT) System.out.println();
	//        }
	//        if (PRINT) System.out.print("};");
	//        if (PRINT) System.out.println();
	//        if (!PRINT) System.out.println(hash + "L");
	//
	//       // Main.main(concat(new String[] {"--version", "mcp", "--accessToken", "0", "--assetsDir", "assets", "--assetIndex", "1.8", "--userProperties", "{}"}, args));
	//    }
}
