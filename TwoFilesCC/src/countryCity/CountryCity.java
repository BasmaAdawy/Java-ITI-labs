package countryCity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CountryCity {
	
	public static void main(String[] args) throws IOException {
		CountryCSVDAO coDAO = new CountryCSVDAO();
		List<Country> countries = coDAO.readCountryFromCSV("Countries.csv");
		List<City> cities = coDAO.readCityFromCSV("Cities.csv");

//		int i =0;                                     //print country
//		for(Country c: countries) {       
//			System.out.println(""+(i++)+c);
//		}
		
//		int j =0;                               //print city
//		for(City f: cities) {       
//			System.out.println(""+(j++) +f);
//		}
		

		
	//map that uses the country code as keys and a list of cities as the value for  each country.
	   System.out.println("-----------map that uses the country code as keys and"
	    		+ " a list of cities as the value for  each country---------");
	   System.out.println();
	   
	   Map<String, List<City>> cntrycode = CountryCSVDAO.countryCodeCities(countries,cities);
		   System.out.println();
	   
		
	// For a given country code (from Console) sort the cities according to the population put space before country code
	   InputStreamReader r = new InputStreamReader(System.in);
       BufferedReader br = new BufferedReader(r);
       System.out.println("Enter Country Code you want to sort with :");
       String givenCC = br.readLine();

       List<City> srtCties = CountryCSVDAO.sortCitiesPop(givenCC, cntrycode);
       //System.out.println(givenCC);
       srtCties.forEach(System.out::println);
      
		   
		//list of countries population   
	   System.out.println("list of countries pop is ");
       CountryCSVDAO.countriesPop(countries);
       System.out.println();
       
       //average population
       System.out.println("average countries population is :");
       System.out.println(CountryCSVDAO.avgPopulation());
       System.out.println();
		 
       //max population
       System.out.println("max population is :");
       System.out.println(CountryCSVDAO.maxPopulation(countries));
       System.out.println();
       
       
       //highest population city
       System.out.println("highest population city is :");
       CountryCSVDAO.highestPopCity(countries,cities);
       
       
       
     //max capital population
       System.out.println("max capital population is :");
       CountryCSVDAO.maxCapitalPop(countries, cities);
       System.out.println();
      
}


	
}

