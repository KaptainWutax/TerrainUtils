package kaptainwutax.terrainutils;

import kaptainwutax.biomeutils.source.BiomeSource;
import kaptainwutax.seedutils.mc.Dimension;
import kaptainwutax.seedutils.mc.MCVersion;
import kaptainwutax.seedutils.util.UnsupportedVersion;
import kaptainwutax.terrainutils.terrain.EndChunkGenerator;
import kaptainwutax.terrainutils.terrain.NetherChunkGenerator;
import kaptainwutax.terrainutils.terrain.OverworldChunkGenerator;
import kaptainwutax.terrainutils.utils.Block;

public abstract class ChunkGenerator {

    protected final boolean amplified;
    protected final BiomeSource biomeSource;
    protected final MCVersion version;

    public ChunkGenerator(BiomeSource biomeSource) {
        this.biomeSource = biomeSource;
        this.version = biomeSource.getVersion();
        this.amplified = false;
        if (this.version.isOlderThan(MCVersion.v1_14)) {
            throw new UnsupportedVersion(this.version, "chunk generator");
        }
        if (this.version.isOlderThan(MCVersion.v1_16)){
            System.out.println("WARNING THIS VERSION IS UNTESTED YET");
        }
    }

    public static Factory factory(Dimension dimension, BiomeSource biomeSource) {
        if (dimension == Dimension.OVERWORLD) return OverworldChunkGenerator::new;
        else if (dimension == Dimension.NETHER) return NetherChunkGenerator::new;
        else if (dimension == Dimension.END) return EndChunkGenerator::new;
        return null;
    }

    public static ChunkGenerator of(Dimension dimension, BiomeSource biomeSource) {
        Factory factory = factory(dimension, biomeSource);
        return factory == null ? null : factory.create(biomeSource);
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
     * Returns the block column at x,z of length: worldHeight, this column has 3 blocks tops, default block, default fluid and air
     */
    public abstract Block[] getColumnAt(int x, int z);

    /**
     * Returns the block at x,y,z, this block can be 3 blocks tops, default block, default fluid and air
     */
    public abstract Block getBlockAt(int x, int y, int z);

    @FunctionalInterface
    public interface Factory {
        ChunkGenerator create(BiomeSource biomeSource);
    }

}