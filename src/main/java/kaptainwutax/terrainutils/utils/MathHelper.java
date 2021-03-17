package kaptainwutax.terrainutils.utils;

import static kaptainwutax.noiseutils.utils.MathHelper.lerp;

public class MathHelper {

    public static double clampedLerp(double first, double second, double delta) {
        if (delta < 0.0D) {
            return first;
        } else {
            return delta > 1.0D ? second : lerp(delta, first, second);
        }
    }

    public static float sqrt(float f) {
        return (float) Math.sqrt(f);
    }

    public static double clamp(double value, double min, double max) {
        if (value < min) {
            return min;
        } else {
            return Math.min(value, max);
        }
    }
}
