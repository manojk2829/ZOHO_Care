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

public class ActionAndDragAndDropClass {
	public static Properties pro=null;
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
    	dr.get(pro.getProperty("AppURL"));
    	System.out.println(dr.getTitle());
    	
    	
    	WebElement ele = dr.findElement(By.xpath(pro.getProperty("Header_xpath")));
    	Actions act = new Actions(dr);
    	act.moveToElement(ele).build().perform();
    	
    	List<WebElement> link = dr.findElements(By.xpath(pro.getProperty("Header_xpath")));
    	for(int i=0;i<link.size();i++){
    		System.out.println(link.get(i).getText());
    	}
    	
    	WebElement eleNext = dr.findElement(By.xpath(pro.getProperty("DropList_xpath")));
    	Actions act1 = new Actions(dr);
    	act1.moveToElement(eleNext).build().perform();
    	
    	List<WebElement> linkT = dr.findElements(By.xpath(pro.getProperty("SideList_xpath")));
    	for(int j=0;j<linkT.size();j++){
    		System.out.println(linkT.get(j).getText());
    	}
    	
    	Thread.sleep(3000);
    	Actions act2 = new Actions(dr);
    	WebElement LinkClick = dr.findElement(By.xpath(pro.getProperty("SideLinkClick_xpath")));
    	act2.moveToElement(LinkClick).build().perform();
    	
    	Thread.sleep(3000);
    	//Drag and Drop ----
    	
    	dr.findElement(By.xpath(pro.getProperty("Drag_xpath"))).click();    	
    	
    	Actions drag = new Actions(dr);
    	WebElement source = dr.findElement(By.xpath(pro.getProperty("Item1_xpath")));
    	WebElement target = dr.findElement(By.xpath(pro.getProperty("Item4_xpath")));
    	drag.dragAndDrop(source, target).build().perform();;
    	
    	Thread.sleep(5000);
    	dr.quit();
   }
}
