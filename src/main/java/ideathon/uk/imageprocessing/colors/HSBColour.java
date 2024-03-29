package ideathon.uk.imageprocessing.colors;

import java.util.Objects;

/**
 * Holds hue, saturation and brightness values, on a scale of 0.0 to 1.0.
 * <p>
 * To read hue as a degrees value, simply multiply it by 360.
 */
public class HSBColour {

	private static final float EQUALS_FLOAT_VARIANCE = 0.00001f;

	private final float hue;
	private final float saturation;
	private final float brightness;

	public HSBColour(float hue, float saturation, float brightness) {
		this.hue = hue;
		this.saturation = saturation;
		this.brightness = brightness;
	}

	public HSBColour(float[] hsb) {
		this(hsb[0], hsb[1], hsb[2]);
	}

	public float hue() {
		return hue;
	}

	public float saturation() {
		return saturation;
	}

	public float brightness() {
		return brightness;
	}

	public float[] hsb() {
		return new float[] { hue, saturation, brightness };
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		HSBColour colour = (HSBColour)o;
		return Math.abs(hue - colour.hue) < EQUALS_FLOAT_VARIANCE
			   && Math.abs(saturation - colour.saturation) < EQUALS_FLOAT_VARIANCE
			   && Math.abs(brightness - colour.brightness) < EQUALS_FLOAT_VARIANCE;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hue, saturation, brightness);
	}

	@Override
	public String toString() {
		return String.format("HSBColour [hue=%f, saturation=%f, brightness=%f]",
							 hue, saturation, brightness);
	}
}
