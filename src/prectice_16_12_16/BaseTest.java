package prectice_16_12_16;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
   public WebDriver dr;
   public Properties pro;
   
   public void openBrowser(String broName){
	   
	   if(pro==null){
		   pro=new Properties();
	  try{
	       FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\prectice_16_12_16\\confi.properties");
	       pro.load(fis);
		 }
	  catch(Exception ex){
		  System.out.println(ex.getMessage());
          ex.printStackTrace();
	  }
	   }
	   
	   if(broName.equalsIgnoreCase("Firefox"))
	   {
		   dr = new FirefoxDriver();
	   }
	   else if (broName.equalsIgnoreCase("chrome")){
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chrome//chromedriver.exe");
   		ChromeOptions op = new ChromeOptions();
   		op.addArguments("--disable-extensions");
   		dr = new ChromeDriver(op);
	   }
	   dr.get(pro.getProperty("CrossBrowserURL"));
	   dr.manage().window().maximize();
	   dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  }
   
  public void navigate(String URL){
	  dr.get(pro.getProperty("CrossBrowserURL"));
  }
}
