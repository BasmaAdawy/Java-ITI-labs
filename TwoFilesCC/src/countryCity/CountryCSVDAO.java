package countryCity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


public class CountryCSVDAO  implements countryCityDAO{
	
	static List<Country> country_list = new ArrayList<Country>();
	List<City> city_list = new ArrayList<City>();
	ArrayList<String> cntryCode = new ArrayList<String>();
	
	public List<Country> readCountryFromCSV(String filename) {
		//List<Country> country_list = new ArrayList<Country>();
		FileReader fr;
		try {
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line ;
	
			do {
				line = br.readLine();
				if(line!=null) {
						
					String [] metadata =line.split(",");
					Country coun = createCountry(metadata);
					country_list.add(coun);
					
					//for(String part : metadata) {
				      //   System.out.println(part);
					//}
					
					}
			}while (line != null);
			
			}catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		//System.out.println(pyramid_list);

		return country_list;
		
	}

	
	public List<City> readCityFromCSV(String filename) {
		//List<City> city_list = new ArrayList<City>();
		FileReader fr;
		try {
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line ;
			
			do {
				line = br.readLine();
				if(line!=null) {
						
					String [] metadata =line.split(",");
					City cit = createCity(metadata);
					city_list.add(cit);
					
					//for(String part : metadata) {
				      //   System.out.println(part);
					//}
					
					}
			}while (line != null);
			
			}catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		//System.out.println(pyramid_list);

		return city_list;
		
	}
	

	public Country createCountry(String [] metadata) {
		String surArea = metadata[3];
	    String pop = metadata[4];
	    String gn = metadata[5];
	    String cap = metadata[6];
		Country cou = new Country( metadata[0], metadata[1], 
				metadata[2],Double.parseDouble(surArea),
				Double.parseDouble(pop),Double.parseDouble(gn),
				Integer.parseInt(cap));
		
		return cou;
	}
	
	
	public City createCity(String [] metadata) {
		    String i = metadata[0];
		    String ca = metadata[2];
			City ci = new City( Integer.parseInt(i),metadata[1], Integer.parseInt(ca), metadata[3]);
			
			return ci;
		}
	

	 
	 public static  Map<String, List<City>> countryCodeCities(List<Country> countries, List<City> cities){
	        Map<String, List<City>> cntryMap = cities.stream()
	                .collect(Collectors.groupingBy(City::getCountryCode, Collectors.toList()));
	        cntryMap.forEach((k, v) -> System.out.println(k + " = " + v));
	        
	       return cntryMap;
	    }
	 
	 
	 public static List<City> sortCitiesPop(String countryCode, Map<String, List<City>> cntryMap){
	        return cntryMap.get(countryCode).stream()
	                .sorted(Comparator.comparingInt(City::getPopulation)).collect(Collectors.toList());
	    }
	 
	 
	 
	 public static void countriesPop(List<Country> countries) {
	        countries.forEach(cp -> System.out.println(cp.getName()+" : "+(long) cp.getPopulation()));
	    }
	 
	 
	 public static  OptionalDouble avgPopulation() {
         OptionalDouble average = country_list.stream().mapToDouble(Country::getPopulation).average();
         
        return average;
	}
	 
	
	 public static OptionalDouble maxPopulation(List<Country> countries) {
		 OptionalDouble maxpop = country_list.stream().mapToDouble(Country::getPopulation).max();
		 return maxpop;
	 }
	 

	 public static void highestPopCity(List<Country> countries, List<City> cities) {
		 countries.forEach(c -> { City higCity = cities.stream()
	        		.filter(h -> h.getCountryCode().equals(c.getCode())).max(Comparator.comparingInt(City::getPopulation)).get();
		 System.out.println(c.getName() + higCity.getName());});
	    }
	
	 

	 
	 public static void maxCapitalPop(List<Country> countries, List<City> cities) {
	        Map<Country, City> capMap = new HashMap<>();
	        for(Country cntry : countries)
	        	capMap.put(cntry, cities.get((int) cntry.getCapital()));
	        System.out.println(capMap.entrySet().stream().max(Map.Entry.comparingByValue(Comparator
	        		.comparingInt(City::getPopulation))).get());
	}
	 
	 
}

