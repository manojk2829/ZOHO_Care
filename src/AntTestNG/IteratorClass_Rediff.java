package AntTestNG;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IteratorClass_Rediff {

	public static void main(String[] args) {
		WebDriver dr = new FirefoxDriver();
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//dr.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		
		Set<String> s = dr.getWindowHandles();
		System.out.println(s.size());
		Iterator<String> it = s.iterator();
		System.out.println(it.next());
	}

}
