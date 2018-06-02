package prectice_16_12_16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReadAndWriteTextFile {

	public static void main(String[] args) throws IOException {
		File f = new File("D://report//temp1.txt");
		FileWriter fw = new FileWriter(f);
	    BufferedWriter bw = new BufferedWriter(fw);
	    bw.write("1");
	    bw.newLine();
	    bw.write("Kushwaha 1");
	    bw.newLine();
	    bw.write("Kushwaha 2");
	    bw.newLine();
	    bw.write("Kushwaha 3");
	    bw.newLine();
	    bw.write("Kushwaha 4");
	    bw.flush();
		
		System.out.println("***************************");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		System.out.println(br.readLine());
		String x = "";
		while((x=br.readLine())!=null){
			System.out.println(x);
		}
		
		
	}

}
