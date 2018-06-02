package modul_20_Jan_2017;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Main_Test extends Base_Test_Jan_2017{
 WebDriver dr;
	@Test
 public void LoginTest() throws Exception{
	openBrowser("chrome");
	navigate("URL");
	selectTitle("title_xpath");
	typeText_Initial("initial_id", "5");
	gender_Radio("Gender_name");
	Languages("Languages_name");
	Thread.sleep(3000);
	ScreenShot_Process();
	dr.quit();
  }
}
