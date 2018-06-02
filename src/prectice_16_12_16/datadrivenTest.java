package prectice_16_12_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class datadrivenTest {
	WebDriver dr;
	@BeforeTest
    public void inisialization(){
		dr = new FirefoxDriver();
    }
   @Test(dataProvider="getdata")
   public void login(String user,String password) throws Exception
	{	   
	   dr.manage().window().maximize();
	   dr.get("http://care.d2h.com/cms/");
	   dr.findElement(By.id("txtUserName")).sendKeys(user);
	   dr.findElement(By.id("txtPassword")).sendKeys(password);
	   dr.findElement(By.xpath("//a[@id='btnLogin']")).click();
	   String actual = dr.getTitle();
	   Thread.sleep(3000);
	   Assert.assertEquals(actual, dr.getTitle());
	   System.out.println("Care title match.");

   }
	
	@DataProvider
	public Object[][] getdata(){
		Object[][] data = new Object[3][2];
		data[0][0] = "careadmin1";
		data[0][1] = "smx@bbcl";
		data[1][0] = "careadmin1";
		data[1][1] = "smx";
		data[2][0] = "careadmin1";
		data[2][1] = "bbcl@gr1";
		return data;
	}
	
}
