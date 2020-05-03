package model;

public class City {
	
	private String name;
	private String countryName;
	
	public City(String name, String countryName) {
		this.name = name;
		this.countryName = countryName;
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
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public String toString() {
		return "City: "+name+", from: "+countryName;
	}
	
	

}
