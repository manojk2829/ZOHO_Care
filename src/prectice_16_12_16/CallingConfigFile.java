package prectice_16_12_16;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class CallingConfigFile {

	public static void main(String[] args) {
		
		Properties pro = new Properties();
		File src = new File(System.getProperty("user.dir")+"\\src\\configFile\\config.properties");
		try{
			FileInputStream fis = new FileInputStream(src);
			pro.load(fis);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		System.out.println(pro.getProperty("name"));
		System.out.println(pro.getProperty("DOB"));
		System.out.println(pro.getProperty("BP"));
		
	}

}
