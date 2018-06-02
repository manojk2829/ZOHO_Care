package careApp;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest_CareApp {
    public static ExtentReports ext; 
    public static ExtentTest test;
	public static Properties pro=null;
	public WebDriver dr;

	public void inicialization(){
		if(pro==null)
		  pro = new Properties();
		{
			try
			{
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//careApp//careConfig.properties");
				pro.load(fis);
			}
			catch(Exception ex){
			   System.out.println(ex.getMessage());
			   ex.printStackTrace();
			}
		}
	}
	public void openBrowser(String broName) {

		if(broName.equalsIgnoreCase("firefox"))
		{
			dr = new FirefoxDriver();
		}
		else if(broName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", pro.getProperty("Chrome_Browser"));
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-extention");
			dr = new ChromeDriver(op);
		}
		
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(pro.getProperty("Care_URL"));
	}
	
	public void naviget(String urlkey){
		dr.get(pro.getProperty("Care_URL"));
	}
	public void EnterTextUser(String locater, String data) {
		getElement(locater).sendKeys(data);
	}
	public void ClickSubmit(String locater) {
		getElement(locater).click();
	}
	
	public WebElement getElement(String locater)
	{
		WebElement el = null;
		try
		{			
			if(locater.equals("_xpath"))
				el=dr.findElement(By.xpath(pro.getProperty(locater)));
			else if(locater.equals("_id"))
				el=dr.findElement(By.id(pro.getProperty(locater)));
			else if(locater.equals("_name"))
				el=dr.findElement(By.name(pro.getProperty(locater)));
	    }
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return el;
	}
	
/*********************** Reporting ******************************/
	
	public void ScreenShot() {
		Date d = new Date();
		String dateText = d.toString().replace(" ", "_").replace(":", "_")+ "_Care_.jpg";
		File src = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try
		{
			FileHandler.copy(src, new File(System.getProperty("user.dir")+"//ScreenShot//"+dateText));
		}
		catch(Exception ex)
		{
		   System.out.println(ex.getMessage());
		   ex.printStackTrace();
		}
		test.log(LogStatus.INFO, "ScreenShot"+ test.addScreenCapture(System.getProperty("user.dir")+"//ScreenShot//"+dateText));
	}
}
