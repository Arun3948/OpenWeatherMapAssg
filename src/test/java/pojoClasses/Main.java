package pojoClasses;

public class Main {

	public double temp;
	public double feels_like;
	public double temp_min;
	public double temp_max;
	public int pressure;
	public int humidity;

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Main() {
	}

	/**
	 *
	 * @param feels_like
	 * @param tempMax
	 * @param temp
	 * @param humidity
	 * @param pressure
	 * @param tempMin
	 */
	public Main(Float temp, Float feels_like, Float tempMin, Float tempMax, Integer pressure, Integer humidity) {
		super();
		this.temp = temp;
		this.feels_like = feels_like;
		this.temp_min = tempMin;
		this.temp_max = tempMax;
		this.pressure = pressure;
		this.humidity = humidity;
	}

}
