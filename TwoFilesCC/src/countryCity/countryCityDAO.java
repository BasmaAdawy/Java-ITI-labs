package countryCity;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;

public interface countryCityDAO {
	public List<Country> readCountryFromCSV(String filename);
	public List<City> readCityFromCSV(String filename);
	public Country createCountry(String [] metadata);
	public City createCity(String [] metadata);
	

}
