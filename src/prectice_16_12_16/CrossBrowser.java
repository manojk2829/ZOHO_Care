package prectice_16_12_16;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser extends BaseTest{
    public Properties pro= null;
	WebDriver dr;
	@Test
    @Parameters("browser")
    public void cross(String broName) throws Exception{
		
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
    	dr.findElement(By.name(pro.getProperty("userName_name"))).sendKeys("qqqq");
    	dr.findElement(By.name(pro.getProperty("userPassword_name"))).sendKeys("qqqq");
    	dr.findElement(By.name(pro.getProperty("Submit_name"))).click();
    	System.out.println(dr.getTitle());
    	
    	WebElement radio1 = dr.findElement(By.xpath(pro.getProperty("Way_xpath")));
    	if(!radio1.isSelected()){
    		radio1.click();
    	}
    	
    	Select listPass = new Select(dr.findElement(By.xpath(pro.getProperty("pass_xpath"))));
    	listPass.selectByVisibleText("3");
    	
    	Select AireLine = new Select(dr.findElement(By.xpath(pro.getProperty("AirLine_xpath"))));
    	AireLine.selectByVisibleText("Pangea Airlines");
    	
    	Thread.sleep(3000);
    	dr.quit();
    }
}
