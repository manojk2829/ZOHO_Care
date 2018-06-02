package CAREModule20Again;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class BaseClass {
	public Properties pro = null;	
	public WebDriver dr;
	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;
	public void initialization(){
	if(pro==null)
		pro = new Properties();
try{
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\CAREModule20Again\\decConfig.properties");
    pro.load(fis);
}
catch(Exception e){
	System.out.println(e.getMessage());
	e.printStackTrace();
 }
}
	public void openBrowser(String broName){
		if(broName.equalsIgnoreCase("firefox"))
			dr = new FirefoxDriver();
	else if(broName.equalsIgnoreCase("chrome"))
	   {
			System.setProperty("webdriver.chrome.driver", pro.getProperty("Chrome_Browser"));
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-extention");
			dr = new ChromeDriver(op);
			dr.manage().window().maximize();
			dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}
	
	public void navigate(String URL){
		dr.get(pro.getProperty(URL));
	}
	/******************* Reporting ******************/
	
	public void screeShot(){
		Date d = new Date();
		String ScreenShotFileName = d.toString().replace(":", "_").replace(" ", "_")+"_.jpg";
		File src = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	  try{
		  FileHandler.copy(src, new File(System.getProperty("user.dir")+"//report//"+ ScreenShotFileName));
	  }
	  catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
	  }
	  test.log(LogStatus.INFO, "Add Screen Shot --> " + test.addScreenCapture(System.getProperty("user.dir")+"//report//"+ ScreenShotFileName));
	}
	
	
	public void WaitUntil_PageLoaded(){
		   JavascriptExecutor js = (JavascriptExecutor)dr;
		   String state = (String)js.executeScript("return document.readyState");
		   while(!state.equals("complete")){
			   try {
				Thread.sleep(2000);
				state = (String)js.executeScript("return document.readyState");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
	   }
	
}
