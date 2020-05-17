package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import structures.*;

public class Country {
	
	private String name;
	private String countryIn;
	private String countryOut;
	private static AdjacencyList<City> graphCity;
	private static ArrayList<City> cities;
	
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
	
	public ArrayList<City> load(String path) {
		cities = new ArrayList<>();
		BufferedReader br = null;
		FileReader fr = null;
		try {
			fr = new FileReader(path);
			br = new BufferedReader(fr);

			String sCurrentLine;
			int c = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] pieces = sCurrentLine.split(",");
				City p = new City(pieces[0],pieces[1] , c);
				cities.add(p);
				c++;
			}
		} catch (IOException e) {
			// e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		addVertex(cities, name);
		return cities;
	}

	public void addVertex(ArrayList<City> cities, String nameCountry) {
		graphCity = new AdjacencyList<>(false);
		for (int i = 0; i < cities.size(); i++) {
			graphCity.addVertex(cities.get(i));
		}
		String all = "";
		if(nameCountry.equals("Colombia")) {
			all = "";
		}else if(nameCountry.equals("Argentina")) {
			all = "";
		}else if(nameCountry.equals("Chile")) {
			all = "";
		}else if(nameCountry.equals("Peru")) {
			all = "";
		}else if(nameCountry.equals("Brasil")) {
			all = "";
		}else if(nameCountry.equals("Uruguay")) {
			all = "";
		}
		
		String[] relations = all.split(",");
		for (int i = 0; i < relations.length; i++) {
			String[] divide = relations[i].split("-");
			int one = getIdCities(divide[0]);
			int two = getIdCities(divide[1]);
			graphCity.addEdge(cities.get(one), cities.get(two));
		}
	}

	public int getIdCities(String name) {
		int id = -1;
		for (int i = 0; i < cities.size(); i++) {
			if (cities.get(i).getName().equals(name))
				id = cities.get(i).getId();
		}
		return id;
	}
	
}
