package prectice_16_12_16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HighLightElement  {
	public static void main(String[] args) throws Exception {
		WebDriver dr = new FirefoxDriver();   
		dr.manage().window().maximize();
		dr.get("http://care.d2h.com/cms/");
		WebElement  userName = dr.findElement(By.id("txtUserName"));
		highLightElement(dr,userName);
		userName.sendKeys("careadin1");
		
		WebElement password = dr.findElement(By.id("txtPassword"));
		highLightElement(dr,password);
		password.sendKeys("bbcl@gr1");
		dr.findElement(By.xpath("//a[@id='btnLogin']")).click();
		Thread.sleep(3000);
		dr.quit();
	}
	
	
	public static void highLightElement(WebDriver driver, WebElement element)
		{
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		 
		try 
		{
		   Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
		 
		System.out.println(e.getMessage());
		} 
		 
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
		 
		}
	}

