package prectice_16_12_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenOne {
	 WebDriver driver; 
     @Test(dataProvider= "data")
     public void DataDriven(String user, String pass){
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chrome\\chromedriver.exe");
    	ChromeOptions op = new ChromeOptions();
    	op.addArguments("--disable-extensions");
 		driver = new ChromeDriver(op);
 		driver.manage().window().maximize();
 		driver.get("http://demosite.center/wordpress/wp-login.php");
 		driver.findElement(By.id("user_login")).sendKeys(user);
 		driver.findElement(By.id("user_pass")).sendKeys(pass);
 		driver.findElement(By.id("wp-submit")).click();
 		System.out.println(driver.getTitle());
 		Assert.assertTrue(driver.getTitle().contains("Dashboard"),"User is not able to Login....");
 		System.out.println("User able to Login... ");
 				
     }
     
    /* @AfterMethod
     public void lastquite(){
    	 driver.quit();
     }
     */
     @DataProvider
     public Object[][] data(){
    	 Object[][] data = new Object[4][2];
    	 data[0][0] = "admin";
    	 data[0][1] = "demo";
    	 
    	 data[1][0] = "admin1";
    	 data[1][1] = "demo123";
    	 
      	 data[2][0] = "admin";
    	 data[2][1] = "demo123";
    	 
    	 data[3][0] = "admin123";
    	 data[3][1] = "demo123";
    	 
    	 return data;
     }
}
