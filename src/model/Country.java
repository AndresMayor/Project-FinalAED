package model;

public class Country {
	
	private String name;
	private String countryIn;
	private String countryOut;
	
	public Country(String name, String countryIn, String countryOut) {
		this.name = name;
		this.countryIn = countryIn;
		this.countryOut = countryOut;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the countryIn
	 */
	public String getCountryIn() {
		return countryIn;
	}

	/**
	 * @param countryIn the countryIn to set
	 */
	public void setCountryIn(String countryIn) {
		this.countryIn = countryIn;
	}

	/**
	 * @return the countryOut
	 */
	public String getCountryOut() {
		return countryOut;
	}

	/**
	 * @param countryOut the countryOut to set
	 */
	public void setCountryOut(String countryOut) {
		this.countryOut = countryOut;
	}

	@Override
	public String toString() {
		return "Name: "+name+", Incoming countries: "+countryIn+", Outcoming countries: "+countryOut;
	}
	
	

}
