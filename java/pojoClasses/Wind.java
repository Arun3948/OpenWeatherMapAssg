package pojoClasses;

public class Wind {

	public Float speed;
	public Integer deg;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Wind() {
	}

	/**
	 *
	 * @param deg
	 * @param speed
	 */
	public Wind(Float speed, Integer deg) {
		super();
		this.speed = speed;
		this.deg = deg;
	}

}
