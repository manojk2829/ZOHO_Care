package log4jFile;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4j_Base_Class {
	public static final Logger log=Logger.getLogger(Log4j_Base_Class.class.getName());	
	public Log4j_Base_Class(){
		logged4j();
	}
	public void logged4j(){
		String log4gConfigPath = "C:\\Selenium\\WorkBookNew\\ZOHO\\src\\CAREModule20Again\\log4j.properties";
		PropertyConfigurator.configure(log4gConfigPath);
	}
	

}
