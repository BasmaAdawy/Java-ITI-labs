package lab2pyramids;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PyramidCSVDAO implements PyramidDao{
	public PyramidCSVDAO() {
		
	}


	public List<Pyramid> readPyramidsFromCSV(String filename) {
		List<Pyramid> pyramid_list = new ArrayList<Pyramid>();
		FileReader fr;
		try {
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line ;
			br.readLine();
			do {

				//String metadata[]=null;
				line = br.readLine();
					//System.out.println(line);
				if(line!=null) {
						
					String [] metadata =line.split(",");
					Pyramid pyrma = createPyramid(metadata);
					pyramid_list.add(pyrma);
					
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
		
		//pyramid_list.sort(Comparator.comparingDouble(Pyramid::)
          //      .reversed());

		//pyramid_list.forEach(System.out::println);

		return pyramid_list;
		
	}
	
	public Pyramid createPyramid(String [] metadata) {
		//System.out.println(metadata[7]);
	    String heig = metadata[7];
		if (heig.equals("")|| heig==null) {
			heig="0.0";
		}
		Pyramid prm = new Pyramid( metadata[0], metadata[2], metadata[4],Double.parseDouble(heig));
		
		return prm;
	}
	


}
