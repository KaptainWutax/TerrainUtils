package kaptainwutax.terrainutils.utils;

public enum Block {
    AIR(0),
    STONE(1),
    GRASS(2),
    DIRT(3),
    BEDROCK(7),
    WATER(9),
    LAVA(11),
    SAND(12),
    GRAVEL(13),
    ICE(79),
    NETHERRACK(87),
    END_STONE(121)
    ;

    private final int value;

    Block(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}