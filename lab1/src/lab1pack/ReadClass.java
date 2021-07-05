package lab1pack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class ReadClass {

	public static void main(String[] args) throws IOException {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		String data ="";
		FileWriter fw = new FileWriter("file.txt");
		BufferedWriter wr = new BufferedWriter(fw);
			while(!data.equals("stop")) {
				System.out.println("enter data: ");
				data = br.readLine();
				wr.write("enter data ");
				wr.write("\n");
				wr.write(data);
				wr.write("\n");
				System.out.println("data is :"+data);	
			}
		
		
		br.close();
r.close();
wr.close();

//PrintStream p = new PrintStream(new File("E:\\iti ai courses\\11th java & uml"));

	}

}
