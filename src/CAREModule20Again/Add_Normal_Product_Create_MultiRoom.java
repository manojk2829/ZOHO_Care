package CAREModule20Again;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Add_Normal_Product_Create_MultiRoom extends BaseTestDec25{
  
  @Test()
  public void Create_MultiRoom_Customer() throws Exception{
	initialization();
  	openBrowser("chrome");
  	navigate("CareURL");
  	typeTextUser("userLoginID_xpath", "careteststh");
  	typeTextPass("userLoginPass_id", "irctc@116");
  	Add_Product_ScreenShot();
  	click("UserSubmit_xpath");
  	System.out.println(dr.getTitle());
  	Add_Product_ScreenShot();
  	switchFrameCustomerCapture("switchFrameCustomerCapture_xpath");
  	switchCustomerCaptureIcone("Customer_Capture_xpath");
  	Add_Product_Link("Add_Product_Link_xpath");
  	
	dr.switchTo().defaultContent();
   	
	switchMainframe("switchMainframe_xpath");
 
  	CustomerDetails_field("CustomerDetails_txtCust_id","2018640");
  	CustomerDetails_Search_btn("CustomerDetails_Search_id");
  	
  	/*----- Normal Customer creation ------ */
  	
  	Add_Product_ScreenShot();
  	
  	Add_Product_button("Add_Product_button_id");
  	Add_Product_ScreenShot();
  	
  	STBEnter("STB_id", "410414780151013444");
	SmartCardEnter("SmartCard_id","10123618331");
	SmartCardSearch_Icon_Click("SmartCard_SearchICon_id");
	
	// Select Package -------
	
	Select D2H_package = new Select(dr.findElement(By.xpath("//select[@id='ddlPackage']")));
	D2H_package.selectByValue("185");
	
	// Package Configuration Radio button selection ------
	
	WebElement Offer = dr.findElement(By.xpath("//input[@id='rdblOfferConfiguration_0']"));
	if(!Offer.isSelected()){
		Offer.click();
	}
	Thread.sleep(2000);
	Add_Product_ScreenShot();
	
	Skip_button_click("SkipButton_id");
	Thread.sleep(2000);
	Add_Product_ScreenShot();
	System.out.println("Add Product Page has been opened successfully.....");
	GetOffer("GetOffer_id");
	Add_Product_ScreenShot();
	Save_Customer_Offer("Save_Customer_Offer_id");
	Add_Product_ScreenShot();
	
	//------ Pop-up Work Order Description --------
	
	WorkOrderDescription("WorkOrderDescription_id", "23456789023");
	WebElement copyText = dr.findElement(By.id("txtDescription"));
	Actions act = new Actions(dr);
	act.moveToElement(copyText).doubleClick().build().perform();
	dr.findElement(By.id("txtDescription")).sendKeys(Keys.CONTROL, "c");
	dr.findElement(By.id("txtCallerNo")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
	Callertype("Callertype_id");
    Thread.sleep(2000);
    Add_Product_ScreenShot();
	System.out.println("NI Work Order Created Successfully.....");
	Thread.sleep(2000);
	dr.quit();
  }
}
