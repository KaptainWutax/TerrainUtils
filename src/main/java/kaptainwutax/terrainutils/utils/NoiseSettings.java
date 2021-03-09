package kaptainwutax.terrainutils.utils;

public class NoiseSettings {
    public NoiseSamplingSettings samplingSettings;
    public NoiseSlideSettings topSlideSettings;
    public NoiseSlideSettings bottomSlideSettings;

    public NoiseSettings(NoiseSamplingSettings samplingSettings, NoiseSlideSettings topSlideSettings, NoiseSlideSettings bottomSlideSettings) {
        this.samplingSettings = samplingSettings;
        this.topSlideSettings = topSlideSettings;
        this.bottomSlideSettings = bottomSlideSettings;
    }

    public NoiseSettings(NoiseSamplingSettings samplingSettings) {
        this(samplingSettings,null,null);
    }

    public static NoiseSettings create(double xzScale, double yScale, double xzFactor, double yFactor) {
        return new NoiseSettings(new NoiseSamplingSettings(xzScale, yScale, xzFactor, yFactor));
    }

    public NoiseSettings addTopSlide(int target, int size, int offset) {
        topSlideSettings = new NoiseSlideSettings(target, size, offset);
        return this;
    }

    public NoiseSettings addBottomSlide(int target, int size, int offset) {
        bottomSlideSettings = new NoiseSlideSettings(target, size, offset);
        return this;
    }

    public static class NoiseSamplingSettings {
        public double xzScale;
        public double yScale;
        public double xzFactor;
        public double yFactor;

        public NoiseSamplingSettings(double xzScale, double yScale, double xzFactor, double yFactor) {
            this.xzScale = xzScale;
            this.yScale = yScale;
            this.xzFactor = xzFactor;
            this.yFactor = yFactor;
        }
    }

    public static class NoiseSlideSettings {
        public int target;
        public int size;
        public int offset;

        public NoiseSlideSettings(int target, int size, int offset) {
            this.target = target;
            this.size = size;
            this.offset = offset;
        }
    }
}
