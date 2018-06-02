package modul_20_Jan_2017;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyPaste {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chrome\\chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--disable-extention");
		WebDriver dr = new ChromeDriver(op);
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.get("http://executeautomation.com/demosite/index.html");
		dr.findElement(By.name("FirstName")).sendKeys("7894561234");
		WebElement copyText = dr.findElement(By.name("FirstName"));
		Actions act = new Actions(dr);
		act.moveToElement(copyText).doubleClick().build().perform();
		dr.findElement(By.name("FirstName")).sendKeys(Keys.CONTROL, "c");
		dr.findElement(By.name("MiddleName")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
		
	}

}
