package kaptainwutax.terrainutils;

import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.mcutils.block.Block;
import kaptainwutax.mcutils.block.Blocks;
import kaptainwutax.mcutils.state.Dimension;
import kaptainwutax.mcutils.version.MCVersion;
import kaptainwutax.mcutils.version.UnsupportedVersion;
import kaptainwutax.terrainutils.terrain.EndTerrainGenerator;
import kaptainwutax.terrainutils.terrain.NetherTerrainGenerator;
import kaptainwutax.terrainutils.terrain.OverworldTerrainGenerator;

import java.util.function.Predicate;

public abstract class TerrainGenerator {

	protected boolean amplified;
	protected final BiomeSource biomeSource;
	protected final MCVersion version;
	// only 5 blocks are registered here END_STONE, AIR, LAVA, WATER, NETHERRACK, STONE
	public static Predicate<Block> WORLD_SURFACE_WG = b -> b.getId() != Blocks.AIR.getId();
	// only fluid have no colliders
	public static Predicate<Block> OCEAN_FLOOR_WG = b -> b.getId() != Blocks.AIR.getId() && b.getId() != Blocks.WATER.getId() && b.getId() != Blocks.LAVA.getId();
	// there is more predicate but terrainutils is not ready yet

	public TerrainGenerator(BiomeSource biomeSource) {
		this.biomeSource = biomeSource;
		this.version = biomeSource.getVersion();
		this.amplified = false;
		if(this.version.isOlderThan(MCVersion.v1_8)) {
			throw new UnsupportedVersion(this.version, "chunk generator");
		}
		if(this.version.isOlderThan(MCVersion.v1_12)) {
			System.err.println("WARNING THIS VERSION IS UNTESTED YET");
		}
	}

	public TerrainGenerator setAmplified(boolean amplified){
		this.amplified=amplified;
		return this;
	}

	public static void main(String[] args) {
		BiomeSource bs = BiomeSource.of(Dimension.NETHER, MCVersion.v1_13_2, 1232903292041L);
		TerrainGenerator cg = TerrainGenerator.of(Dimension.NETHER, bs);
		cg.sampleNoiseColumnOld(null,50688,288,0,0);
	}

	public static Factory factory(Dimension dimension) {
		if(dimension == Dimension.OVERWORLD) return OverworldTerrainGenerator::new;
		else if(dimension == Dimension.NETHER) return NetherTerrainGenerator::new;
		else if(dimension == Dimension.END) return EndTerrainGenerator::new;
		return null;
	}

	public static TerrainGenerator of(Dimension dimension, BiomeSource biomeSource) {
		Factory factory = factory(dimension);
		return factory == null ? null : factory.create(biomeSource);
	}

	public static TerrainGenerator of(BiomeSource biomeSource) {
		Factory factory = factory(biomeSource.getDimension());
		return factory == null ? null : factory.create(biomeSource);
	}

	public abstract Dimension getDimension();

	public BiomeSource getBiomeSource() {
		return biomeSource;
	}

	public MCVersion getVersion() {
		return version;
	}

	public long getWorldSeed() {
		return biomeSource.getWorldSeed();
	}

	public int getSeaLevel() {
		return 63;
	}

	public int getMinWorldHeight() {
		return 0;
	}

	public int getMaxWorldHeight() {
		return getWorldHeight() - getMinWorldHeight();
	}

	public abstract int getWorldHeight();

	public abstract Block getDefaultBlock();

	public abstract Block getDefaultFluid();

	protected abstract void sampleNoiseColumnOld(double[] buffer, int x, int z, double depth, double scale);

	/**
	 * Returns the lowest non fluid block (this means not water nor air) y value - 1 to accommodate its position
	 */
	public int getHeightInGround(int x, int z) {
		return this.getHeightOnGround(x, z) - 1;
	}

	/**
	 * Returns the lowest non fluid block (this means not water nor air) y value
	 */
	public abstract int getHeightOnGround(int x, int z);

	/**
	 * Returns the first y value that match a given predicate
	 */
	public abstract int getFirstHeightInColumn(int x, int z, Predicate<Block> predicate);

	/**
	 * Returns the block column at x,z of length: worldHeight, this column has 3 blocks tops, default block, default fluid and air
	 */
	public abstract Block[] getColumnAt(int x, int z);

	/**
	 * Returns the block at x,y,z, this block can be 3 blocks tops, default block, default fluid and air
	 */
	public abstract Block getBlockAt(int x, int y, int z);

	@FunctionalInterface
	public interface Factory {
		TerrainGenerator create(BiomeSource biomeSource);
	}

}
