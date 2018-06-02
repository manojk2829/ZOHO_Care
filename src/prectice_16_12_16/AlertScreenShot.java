package prectice_16_12_16;

import java.io.File;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

public class AlertScreenShot {
        static WebDriver dr;
	public static void main(String[] args) throws Exception {
		ChromeOptions op = new ChromeOptions();
	      op.addArguments("--disable-extensions");
	      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chrome//chromedriver.exe");
	      dr = new ChromeDriver(op);
	      
	      dr.get("http://executeautomation.com/demosite/index.html");
	  	  System.out.println(dr.getTitle());
	  	  
		  File scr = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(scr, new File("C:\\Users\\ti01045\\Desktop\\ScreenShot\\Alert.jpg"));
	  	  
	  	  dr.findElement(By.name("generate")).click();
	  	  Thread.sleep(2000);
  	 
	  	  String TextAlert =  dr.switchTo().alert().getText();
	  	  System.out.println(TextAlert);
	  	  Alert act = dr.switchTo().alert();
	  	  String Text = "You generated a Javascript alert";
	  	  Assert.assertEquals(TextAlert, Text);
	  	  act.accept();
	  	  System.out.println("Passsssssss");
	  	  String TextAlert1 =  dr.switchTo().alert().getText();
	  	  System.out.println(TextAlert1);
	  	  Thread.sleep(2000);
	  	  Alert act1 = dr.switchTo().alert();
	  	  act1.accept();
	  	  Thread.sleep(2000);
	  	  dr.quit();
	  	  
	}
}
