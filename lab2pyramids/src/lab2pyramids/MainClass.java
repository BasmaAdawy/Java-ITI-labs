package lab2pyramids;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {

	public MainClass() {
		// TODO Auto-generated constructor stub
	}
	
	public static void pyramidsInSites(ArrayList<String> list)
	{
	    //hash map to store the frequency of element
	    Map<String, Integer> hm = new HashMap<String, Integer>();

	    for (String l : list) {
	    	Integer n = hm.get(l);
	        hm.put(l, (n == null) ? 1 : n + 1);
	    }

	    // displaying the occurrence of elements in the array list
	    for (Map.Entry<String, Integer> val : hm.entrySet()) {
	        System.out.println(val.getKey() + " = " + val.getValue() );}}

	
	
	public static void main(String[] args) {
		PyramidCSVDAO pDAO = new PyramidCSVDAO();
		List<Pyramid> pyramids = pDAO.readPyramidsFromCSV("E:\\iti ai courses\\11th java & uml\\pyramids.csv");
		ArrayList<String> siteList = new ArrayList<String>();
		
		//System.out.println(pyramids);
		int i =0;
		for(Pyramid p: pyramids) {       //original pyramids list
			System.out.println("#"+(i++)+p);
		}
		System.out.println("--------------------##################-------------------");
		System.out.println("'pyramids sorted by height'");
		
		Collections.sort(pyramids , new heightSort());
		int j =0;
		for(Pyramid h: pyramids)    //sorted pyramids list by height
			System.out.println("#"+(j++)+h);
		
		
		for(Pyramid s: pyramids)      //put sites in site list
			siteList.add(s.getSite());
		
		
		System.out.println("--------------------##################-------------------");
		System.out.println("'number of pyramids in site'");
		
		pyramidsInSites(siteList);

		
	}
}

