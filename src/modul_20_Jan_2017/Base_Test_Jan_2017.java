package modul_20_Jan_2017;

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
import org.openqa.selenium.support.ui.Select;

public class Base_Test_Jan_2017 {
	public Properties pro;
	WebDriver dr;
    public void openBrowser(String bName){
     if(pro ==null)
    	pro = new Properties();
    	{
    	  try{
    		  FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\modul_20_Jan_2017\\OR.properties");	
    	      pro.load(fis);
    	     }
    	  catch(Exception ex){
    		  System.out.println(ex.getMessage());
    	  }
    	}
    	if(bName.equalsIgnoreCase("firefox")){
    		dr = new FirefoxDriver();
    	}
    	else if (bName.equalsIgnoreCase("chrome")){
    		System.setProperty("webdriver.chrome.driver", pro.getProperty("Browser"));
    		ChromeOptions op = new ChromeOptions();
    		op.addArguments("--disable-extentions");
    		dr = new ChromeDriver(op);
    	}
    	dr.manage().window().maximize();
    	dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    
    public void navigate(String URL){
    	dr.get(pro.getProperty("APPURL"));
    }
    
    public void selectTitle(String locterKey){
    	Select title_user = new Select(getElement(locterKey));
    	title_user.selectByVisibleText("Ms.");
    }
    public void typeText_Initial(String locterKey, String data){
    	getElement(locterKey).sendKeys(data);
    }
    
    public void typeText_First(String locterKey, String data){
    	getElement(locterKey).sendKeys(data);
    }
    
    public void gender_Radio(String locterKey){
    	WebElement radio_gender = getElement(locterKey);
    	if(!radio_gender.isSelected()){
    		radio_gender.click();
    	}
    }
    public void Languages(String locterKey){
    	getElement(locterKey).click();
    }
    
    public void Click(){
    	
    }
    
    public WebElement getElement(String locterKey){
    	WebElement e = null;
    	if(locterKey.endsWith("_id"))
    	  e = dr.findElement(By.id(pro.getProperty(locterKey)));
    	  else if(locterKey.endsWith("_name"))
    		  e = dr.findElement(By.name(pro.getProperty(locterKey))); 
    	  else if(locterKey.endsWith("_xpath"))
    		  e = dr.findElement(By.xpath(pro.getProperty(locterKey)));
    	return e; 
    	
    }
    /********************Validation Function**********************/
    
    public boolean validation(){
    	return false;
    }
    public boolean isElementPresent(){
    	
    	return false;
    }
    public boolean verfyTest(){
    	return false;
    }
    
    /********************Reporting**********************/
    
    public void ScreenShot_Process(){
    	Date d = new Date();
    	String FileName = d.toString().replace(" ", "_").replace(":", "_")+"_screenLogin.jpg";
    	File src = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
    	try{
    		FileHandler.copy(src, new File(System.getProperty("user.dir")+"//report//"+ FileName));
    	}
    	catch(Exception ex){
    		System.out.println(ex.getMessage());
    	}
    }
   

}
