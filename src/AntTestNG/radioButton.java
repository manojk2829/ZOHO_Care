package AntTestNG;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class radioButton {

	public static void main(String[] args) {
		WebDriver dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.get("http://www.echoecho.com/htmlforms10.htm");
		System.out.println(dr.getTitle());
		List<WebElement> radiobtn = dr.findElements(By.name("group1"));
		System.out.println(radiobtn.size());
		for(int i=0;i<radiobtn.size();i++)
		{
		   System.out.println(radiobtn.get(i).getAttribute("checked"));
		}
		radiobtn = dr.findElements(By.name("group2"));
		for(int i=0;i<radiobtn.size();i++){
			System.out.println(radiobtn.get(i).getAttribute("checked"));
		}
		
		File srcShot = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			 FileHandler.copy(srcShot, new File("D://report//sssss.jpg"));
		   }
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
