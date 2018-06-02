package prectice_16_12_16;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionClass_Mukesh {
        public static Properties pro= null;
		public static void main(String[] args) throws Exception {
			
			pro= new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\prectice_16_12_16\\confi.properties");
			pro.load(fis);
					
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-extensions");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chrome//chromedriver.exe");
			WebDriver dr = new ChromeDriver(op);
			dr.manage().window().maximize();
	    	dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	dr.get(pro.getProperty("AppURL_Mukesh"));
	    	System.out.println(dr.getTitle());
    	
	    	Actions act = new Actions(dr);
	    	WebElement ele = dr.findElement(By.xpath(pro.getProperty("DropDown_xpath")));
	    	act.moveToElement(ele).build().perform();
	    	
	    	List <WebElement> linkBox = dr.findElements(By.xpath(pro.getProperty("LinkBox_xpath")));
	    	  	for(int i =0;i<linkBox.size();i++){
	    	  		System.out.println(linkBox.get(i).getText());
	    	  }
	    	  	Actions act2 = new Actions(dr);
	    	  	WebElement ele2 = dr.findElement(By.xpath(pro.getProperty("LinkBox2_xpath")));  	
	    	  	act2.moveToElement(ele2).click().build().perform();
	    	
	    	Thread.sleep(5000);
	    	dr.quit();

	}

}
