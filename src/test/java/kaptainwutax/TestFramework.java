package kaptainwutax;

import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.mcutils.block.Block;
import kaptainwutax.mcutils.state.Dimension;
import kaptainwutax.mcutils.version.MCVersion;
import kaptainwutax.terrainutils.TerrainGenerator;
import org.junit.jupiter.api.Tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFramework {
	public static boolean DEBUG = false;

	public static void randomChunkGen(MCVersion version, long seed, Dimension dimension, int size, long randomSeed, int[] heightMap) {
		BiomeSource bs = BiomeSource.of(dimension, version, seed);
		TerrainGenerator cg = TerrainGenerator.of(dimension, bs);
		assert cg != null;
		Random r = new Random(randomSeed);
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				int x = r.nextInt(512000) - 25600;
				int z = r.nextInt(512000) - 25600;
				int y = cg.getHeightOnGround(x, z);
				if(DEBUG) System.out.println(x + " " + z);
				assertEquals(heightMap[i * size + j], y,
					String.format("Height wrong at (%s,%s) got y=%d instead of %d", x, z, y, heightMap[i * size + j]));
			}
		}
	}

	public static void randomChunkColumn(MCVersion version, long seed, Dimension dimension, int size, long randomSeed, Block[][] heightMap) {
		BiomeSource bs = BiomeSource.of(dimension, version, seed);
		TerrainGenerator cg = TerrainGenerator.of(dimension, bs);
		assert cg != null;
		Random r = new Random(randomSeed);
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				int x = r.nextInt(512000) - 25600;
				int z = r.nextInt(512000) - 25600;
				Block[] column = cg.getColumnAt(x, z);
				for(int y = 0; y < cg.getMaxWorldHeight(); y++) {
					Block toMatch = heightMap[i * size + j][y];
					Block current = column[y];
					assertEquals(toMatch, current, String.format("Block was wrong at (x,y,z):(%d,%d,%d) got %s instead of %s", x, y, z, current, toMatch));
				}
			}
		}
	}

	public static void randomHashColumn(MCVersion version, long seed, Dimension dimension, int size, long randomSeed, long matchHash) {
		BiomeSource bs = BiomeSource.of(dimension, version, seed);
		TerrainGenerator cg = TerrainGenerator.of(dimension, bs);
		assert cg != null;
		Random r = new Random(randomSeed);
		long hash = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				int x = r.nextInt(512000) - 25600;
				int z = r.nextInt(512000) - 25600;
				Block[] column = cg.getColumnAt(x, z);
				for(int y = 0; y < cg.getMaxWorldHeight(); y++) {
					Block current = column[y];
					hash = hash * 0xFF51AFD7ED558CCDL + 0xC4CEB9FE1A85EC53L | (long)current.getName().toUpperCase().hashCode() * y;
				}
			}
		}
		assertEquals(matchHash, hash, "Hash are not identical, something is wrong");
	}

	public static void randomHashGen(MCVersion version, long seed, Dimension dimension, int size, long randomSeed, long matchHash) {
		BiomeSource bs = BiomeSource.of(dimension, version, seed);
		TerrainGenerator cg = TerrainGenerator.of(dimension, bs);
		assert cg != null;
		Random r = new Random(randomSeed);
		long hash = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				int x = r.nextInt(512000) - 25600;
				int z = r.nextInt(512000) - 25600;
				int y = cg.getHeightOnGround(x, z);
				hash = hash * 0xFF51AFD7ED558CCDL + 0xC4CEB9FE1A85EC53L | y;
				if (DEBUG)System.out.println(hash+" "+y+" "+x+" "+z);
			}
		}
		assertEquals(matchHash, hash, "Hash are not identical, something is wrong");
	}

	public static void testSinglePoint(MCVersion version, long seed, Dimension dimension, int x, int z, int expectedY) {
		BiomeSource bs = BiomeSource.of(dimension, version, seed);
		TerrainGenerator cg = TerrainGenerator.of(dimension, bs);
		assert cg != null;
		assertEquals(expectedY,cg.getHeightOnGround(x, z));
	}

	@Target({ElementType.TYPE, ElementType.METHOD})
	@Retention(RetentionPolicy.RUNTIME)
	@Tag("OVERWORLD")
	public @interface Overworld {}

	@Target({ElementType.TYPE, ElementType.METHOD})
	@Retention(RetentionPolicy.RUNTIME)
	@Tag("NETHER")
	public @interface Nether {}

	@Target({ElementType.TYPE, ElementType.METHOD})
	@Retention(RetentionPolicy.RUNTIME)
	@Tag("END")
	public @interface End {}
}
