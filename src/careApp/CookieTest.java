package careApp;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

	public class CookieTest {
	    WebDriver dr;
	 
	    @Test
	    public void login_state_should_be_restored() {
	        dr = new FirefoxDriver();
	 
	        dr.get("http://demosite.center/wordpress/wp-login.php");
			dr.findElement(By.id("user_login")).sendKeys("admin");
			dr.findElement(By.id("user_pass")).sendKeys("demo123");
			dr.findElement(By.id("wp-submit")).click();
			String actualTitlle = dr.getTitle();
	 
	        Assert.assertEquals(actualTitlle, "Dashboard ‹ WordPress Demo Install — WordPress");
	 
	        //Before closing the browser, read the cookies
	        Set<Cookie> allCookies = dr.manage().getCookies();
	 
	        //dr.close();
	 
	        //open a new browser window
	        dr = new FirefoxDriver();
	 
	        //restore all cookies from previous session
	        for(Cookie cookie : allCookies) {
	            dr.manage().addCookie(cookie);
	        }
	 
	        dr.get("http://demosite.center/wordpress/wp-login.php");
	        
	        //Login page should not be disaplyed
	        Assert.assertEquals(actualTitlle, "Dashboard ‹ WordPress Demo Install — WordPress");
	        
	        dr.close();
	    }
	}
