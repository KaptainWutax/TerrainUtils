package kaptainwutax.terrainutils;

import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.terrainutils.terrain.OverworldChunkGenerator;
import kaptainwutax.terrainutils.terrain.NetherChunkGenerator;
import kaptainwutax.terrainutils.terrain.EndChunkGenerator;
import kaptainwutax.seedutils.mc.Dimension;
import kaptainwutax.seedutils.mc.MCVersion;
import kaptainwutax.seedutils.util.UnsupportedVersion;

public abstract class ChunkGenerator {

	protected final boolean amplified;
	protected final BiomeSource biomeSource;
	protected final MCVersion version;

	public ChunkGenerator(BiomeSource biomeSource) {
		this.biomeSource = biomeSource;
		this.version = biomeSource.getVersion();
		this.amplified = false;
		if(this.version.isOlderThan(MCVersion.v1_14)) {
			throw new UnsupportedVersion(this.version, "chunk generator");
		}
		System.out.println("THIS IS STILL EXPERIMENTAL");
	}

	public static Factory factory(Dimension dimension,BiomeSource biomeSource) {
		if (dimension == Dimension.OVERWORLD) return OverworldChunkGenerator::new;
		else if (dimension == Dimension.NETHER) return NetherChunkGenerator::new;
		else if (dimension == Dimension.END) return EndChunkGenerator::new;
		return null;
	}

	public static ChunkGenerator of(Dimension dimension, BiomeSource biomeSource) {
		Factory factory = factory(dimension,biomeSource);
		return factory == null ? null : factory.create(biomeSource);
	}


	public int getSeaLevel() {
		return 63;
	}

	public int getHeightInGround(int x, int z) {
		return this.getHeightOnGround(x, z) - 1;
	}

	public abstract int getHeightOnGround(int x, int z);


	@FunctionalInterface
	public interface Factory {
		ChunkGenerator create(BiomeSource biomeSource);
	}

}