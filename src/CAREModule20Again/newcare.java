package CAREModule20Again;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class newcare extends BaseTestDec25{
  @Test
  public void carecustSearch() throws Exception{
	  initialization();
	  openBrowser("chrome");
	  navigate("CareURL");
	  typeTextUser("userLoginID_xpath", "careteststh");
	  typeTextPass("userLoginPass_id", "irctc@116");
      click("UserSubmit_xpath");
	  System.out.println(dr.getTitle());
	  Thread.sleep(3000);
	  WebElement switchMainFrame = dr.findElement(By.xpath("//frame[@src='frmLeft.aspx']"));
      dr.switchTo().frame(switchMainFrame);
      dr.switchTo().frame(0);
	  dr.findElement(By.name("txtSearch")).sendKeys("11111");
	  Thread.sleep(5000);
	  dr.quit();
  }
}
