package AntTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class ElementLocationOnPage {
   
	public static void main(String[] args) throws Exception {
		ProfilesIni allPro = new ProfilesIni();
		FirefoxProfile pro = allPro.getProfile("default_Manoj");		
		FirefoxDriver dr = new FirefoxDriver((Capabilities) pro);
	    dr.get("http://gmail.com");
	    String BannerText = dr.findElement(By.xpath("//div[@class='banner']/h1")).getText();
	    System.out.println(BannerText);
	    
	    String AllPage_Text = dr.findElement(By.xpath("//*")).getText();
	    System.out.println(AllPage_Text);
	    Thread.sleep(3000);
	    dr.close();	
	    
	    /* 
	    WebElement ele = dr.findElement(By.id("lst-ib"));
	    ele.sendKeys("Manoj");
	    Thread.sleep(3000);
	    ele.clear();
	    
	    int x = ele.getLocation().x;
	    int y = ele.getLocation().y;
	    System.out.println(x + "-----" + y);
	    */
   
	       
	}

}
