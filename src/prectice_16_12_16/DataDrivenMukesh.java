package prectice_16_12_16;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataDrivenMukesh {
	WebDriver dr;
	@BeforeTest
	@Parameters("browser")
	public void execute(String broName){
		if(broName.equalsIgnoreCase("firefox")){
			dr = new FirefoxDriver();
		}
		else if(broName.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chrome//chromedriver.exe");
  		ChromeOptions op = new ChromeOptions();
  		op.addArguments("--disable-extensions");
  		dr = new ChromeDriver(op);
	    dr.manage().window().maximize();
	    dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
}
	
   @Test(dataProvider="getData")
   public void wordPressLogin(String userName,String Password){
    
	    dr.get("http://demosite.center/wordpress/wp-login.php"); 
	    System.out.println(dr.getTitle());
	    dr.findElement(By.id("user_login")).sendKeys(userName);
	    dr.findElement(By.id("user_pass")).sendKeys(Password);
	    dr.findElement(By.id("wp-submit")).click();
	    System.out.println(dr.getTitle());
	    takeScreenShot();
	    
}

   @DataProvider
   public Object[][] getData(){
	   
	   Object[][] data= new Object[3][2];
	   data[0][0] = "admin1";
	   data[0][1] = "demo1";
	   
	   data[1][0] = "admin";
	   data[1][1] = "demo123";
	   
	   data[2][0] = "admin";
	   data[2][1] = "demo123";
	   
	   return data;
	   
   }
   
   
   public void takeScreenShot(){
		Date d=new Date();
		String fileScreenShot=d.toString().replace(":", "_").replace(" ", "_")+".jpg";
		File srcFile=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try
		{
			FileHandler.copy(srcFile,new File(System.getProperty("user.dir")+"//ScreenShot//"+fileScreenShot)); 
		}
		catch(IOException exp){
			exp.printStackTrace();
		}
		//test.log(LogStatus.INFO, "Screen Shot -- > " + test.addScreenCapture(System.getProperty("user.dir")+"//repoerScreenShot//"+fileScreenShot));
	}
}
