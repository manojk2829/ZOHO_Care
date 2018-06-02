package AntTestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TotalNoOfLinkOnPage {

	public static void main(String[] args) {
		WebDriver dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.get("https://in.yahoo.com/");
		System.out.println(dr.getTitle());
		/*List<WebElement> NoOfLink = dr.findElements(By.tagName("a"));
		System.out.println("No Of Link --> " + NoOfLink.size());
		for(int i=0;i<NoOfLink.size();i++){
			System.out.println(NoOfLink.get(i).getText() + "  ------- >  "+ NoOfLink.get(i).isDisplayed() );
		}*/
		
		WebElement Mainbox = dr.findElement(By.xpath("//*[@id='applet_p_32209491']"));
		List<WebElement> link = Mainbox.findElements(By.tagName("a"));
		System.out.println("----- > " +link.size());
		
		for(int j=0;j<link.size();j++){
			System.out.println(link.get(j).getText() +"       ---- > " + link.get(j).isDisplayed());
			link.get(j).click();
			System.out.println(dr.getTitle());
			dr.navigate().back();
			Mainbox = dr.findElement(By.xpath("//*[@id='applet_p_32209491']"));
			link = Mainbox.findElements(By.tagName("a"));
		}

	}

}
