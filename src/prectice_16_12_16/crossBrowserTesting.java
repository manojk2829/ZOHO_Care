package prectice_16_12_16;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class crossBrowserTesting {
  WebDriver dr;
  @Test
  @Parameters("browser")
  public void cross(String broName){
	  if(broName.equalsIgnoreCase("firefox")){
		dr = new FirefoxDriver();  
	  }
	  else if(broName.equalsIgnoreCase("chrome")){
		  ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-extensions");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chrome//chromedriver.exe");
			dr = new ChromeDriver(op);
			
	  }
	  	dr.manage().window().maximize();
  		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  		dr.get("http://google.com");
  		dr.quit();
  }
}
