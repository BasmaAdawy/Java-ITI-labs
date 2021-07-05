package jupai.dataprep;


import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.columns.Column;


import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.IntColumn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TableSawExample {

	public static void main(String[] args) {

		 try {
			 Table titanicData = Table.read().csv("src/main/resources/data/titanic.csv")
					 .retainColumns("pclass","survived","name","age","sex","fare","embarked");
	            List<Integer> newValues = new ArrayList<> ();
	            Column values = titanicData.column("sex");
	            for (Object obj : values) {
	                if (obj instanceof String) {
	                    String str = (String) obj;
	                    if (str.equals ("female"))
	                        newValues.add (1);
	                    else
	                        newValues.add (0);
	                }

	            }
	            
	            System.out.println(titanicData.first(5));
	     
	            Integer[] gndr = new Integer[newValues.size()];
	            gndr = newValues.toArray(gndr);
	            titanicData.addColumns(IntColumn.create("gender",gndr));
	           
	            System.out.println(titanicData.first(5));
	            System.out.println(titanicData.summary());
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	   }
	   
			 }
	}

