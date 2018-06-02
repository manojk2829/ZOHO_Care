package AntTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownList {

	public static void main(String[] args) {
		WebDriver dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.get("http://qtpselenium.com/");
		System.out.println(dr.getTitle());
		dr.findElement(By.xpath("//button[@class='btn btn-default contact_trainer']")).click();
		Select contry = new Select(dr.findElement(By.name("country_id")));
		contry.selectByVisibleText("India");
	}

}
