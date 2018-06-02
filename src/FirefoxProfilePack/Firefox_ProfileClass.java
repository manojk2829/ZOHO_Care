package FirefoxProfilePack;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;


public class Firefox_ProfileClass {
    static WebDriver driver = null;
	public static void main(String[] args) throws Exception {
		//ProfilesIni allPro = new ProfilesIni();
		//FirefoxProfile profileFirefox = allPro.getProfile("default_Manoj");
		System.setProperty("webdriver.gecko.driver", "D://Browser_exe_FF//geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		//driver.get("https://google.com");
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
	    // now copy the  screenshot to desired location using copyFile //method
		FileHandler.copy(src, new File("C:/Users/ti01045/Desktop/BRD-2016/googleScreenShot.jpg"));
		}
		catch (Exception e)
		 {
		  System.out.println(e.getMessage());
		 }
		System.out.println(driver.getTitle());
	}
}
