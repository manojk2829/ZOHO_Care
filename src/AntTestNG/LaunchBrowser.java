package AntTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LaunchBrowser {
    static WebDriver dr= null;
    //static String browser = "chrome";
    
    @Test(dataProvider="getdata")
	public void LaunchingBrowser(String browser, String user) {
	
      	if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chrome//chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--diable-extensions");
			dr = new ChromeDriver(op);
		}
		else if(browser.equalsIgnoreCase("firefox")){
			dr = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//ie//IEDriverServer.exe");
			dr = new InternetExplorerDriver();
		}
		dr.get("http://google.com");
		dr.close();
	}

	@DataProvider
	public Object[][] getdata(){
		
		Object[][] data = new Object[2][2];
		data[0][0] = "firefox";
		data[0][1] = "user1";
		
		data[1][0] = "chrome";
		data[1][1] = "user2";
		
		return data;
	}
}
