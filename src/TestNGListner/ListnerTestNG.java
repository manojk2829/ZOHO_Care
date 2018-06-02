package TestNGListner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
  @Listeners(TestNGListner.testListner.class)
public class ListnerTestNG {
	WebDriver dr;
    @Test
    public void googleTest() throws Exception{
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chrome\\chromedriver.exe");
    	ChromeOptions op = new ChromeOptions();
    	op.addArguments("--disable-extensions");
    	dr = new ChromeDriver(op);
    	dr.manage().window().maximize();
    	dr.get("http://google.com");
    	System.out.println(dr.getTitle());
    	String actual = dr.getTitle();
    	String Expected = "Google";
    	Assert.assertEquals(actual, Expected);
    	System.out.println("Expected value is equale to Actual");
    	Assert.assertTrue(false);
    	Thread.sleep(3000);
    	dr.quit();
    }
}
