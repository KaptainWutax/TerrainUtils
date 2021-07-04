package kaptainwutax.terrainutils.utils;

import static kaptainwutax.noiseutils.utils.MathHelper.lerp;

public class MathHelper {

	public static double clampedLerp(double first, double second, double delta) {
		if(delta < 0.0D) {
			return first;
		} else {
			return delta > 1.0D ? second : lerp(delta, first, second);
		}
	}

	public static float sqrt(float f) {
		return (float)Math.sqrt(f);
	}

	public static double clamp(double value, double min, double max) {
		if(value < min) {
			return min;
		} else {
			return Math.min(value, max);
		}
	}
	public static double fastInvSqrt(double d) {
		double half = 0.5D * d;
		long bits = Double.doubleToRawLongBits(d);
		bits = 6910469410427058090L - (bits >> 1);
		d = Double.longBitsToDouble(bits);
		return d * (1.5D - half * d * d);
	}
}
