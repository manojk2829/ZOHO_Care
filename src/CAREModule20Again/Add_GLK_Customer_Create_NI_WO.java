package CAREModule20Again;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Add_GLK_Customer_Create_NI_WO extends BaseTestDec25 {
	@Test
    public void Add_GLK_Customer_NI_WorkOrder() throws Exception{
    	initialization();
    	openBrowser("chrome");
    	navigate("CareURL");
    	typeTextUser("userLoginID_xpath", "careteststh");
    	typeTextPass("userLoginPass_id", "irctc@116");
    	GLK_Customer_ScreenShot();
    	click("UserSubmit_xpath");
    	System.out.println(dr.getTitle());
    	GLK_Customer_ScreenShot();
    	switchFrameCustomerCapture("switchFrameCustomerCapture_xpath");
    	switchCustomerCaptureIcone("Customer_Capture_xpath");
    	Add_Customer_Link("Add_Customer_Link_xpath");
	
    	dr.switchTo().defaultContent();
   	    	
    	switchMainframe("switchMainframe_xpath");

    	// -------- Fill the Form Add Customer -------
    	
    	GLK_Customer_ScreenShot();
    	
    	selectTitle("select_Title_id");
   	
    	glk_voucherRadio_btn_rediDirectSale("rediDirectSale_id");
    	
    	txtVoucher_PIN_number("txtVoucher_id", "198364660481");
    	
    	txtVoucher_Serial_number("txtSerial_id", "1457");
    	
    	GLK_validation_Click("ValidateVoucher_id");
    	
    	firstName("UserFirstName_id", "Testing");
    	LastName("Userlastname_id", "Care");
    	
    	Address1("Address1_id", "Address 1");
    	LandMark("landMark_id", "Land Mark");
    	
    	PinCode("Pincode_id", "678622");
   	
    	Thread.sleep(1000);
    	
    	PinCodeSearchIcon("PinCode_SearchIcon_id");
    	Thread.sleep(1000);
    	
    	selectPincode("SelectPincode_xpath");
    	Thread.sleep(1000);
    	
    	RTN_1("RTN1_id","7994140934");
    	
    	RTN_1_CheckBox("RTN_1_CheckBox_id");
    	Thread.sleep(1000);
    	
    	Select langauge = new Select(dr.findElement(By.xpath("//Select[@id='ddllanguage']")));
    	langauge.selectByValue("H");
    	
    	DOB("DOB_xpath");
    	
    	Select CustDOB = new Select(dr.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td/center/table[1]/tbody/tr/td[3]/select")));
    	CustDOB.selectByVisibleText("1990");
    	
    	dr.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td/center/table[2]/tbody/tr[3]/td[5]/a")).click();
    	
    	DealerName("DealerName_id", "Dealer_Name");
    	DealerPhone("DealerPhone_id", "87896541230");
    	GLK_Customer_ScreenShot();
    	ClickNext("Next_id");
    	dr.switchTo().alert().accept();
    	GLK_Customer_ScreenShot();
  	
    	// Select Package -------
    	selectDevice_Model("ModelCategory_id");
    	Select_D2H_package("D2H_package_id");
  	
    	// Package Configuration Radio button selection ------
    	GLK_OfferConfiguration_id("GLK_OfferConfiguration_id");
    	Thread.sleep(2000);
    	GLK_Customer_ScreenShot();
    	
    	Skip_button_click("SkipButton_id");
    	Thread.sleep(2000);
    	GLK_Customer_ScreenShot();
    	System.out.println("Add Product Page has been done successfully.....");
    	GetOffer("GetOffer_id");
    	GLK_Customer_ScreenShot();
    	//dr.findElement(By.id("btnRecharege")).click();
    	Save_GLK_Customer_Offer("Save_GLK_Customer_Offer_id");
    	GLK_Customer_ScreenShot();
    	
    	//------ Pop-up Work Order Description --------
    	
    	WorkOrderDescription("WorkOrderDescription_id", "23456789023");
    	WebElement copyText = dr.findElement(By.id("txtDescription"));
    	Actions act = new Actions(dr);
    	act.moveToElement(copyText).doubleClick().build().perform();
    	dr.findElement(By.id("txtDescription")).sendKeys(Keys.CONTROL, "c");
    	dr.findElement(By.id("txtCallerNo")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
    	Callertype("Callertype_id");
        Thread.sleep(2000);
        GLK_Customer_ScreenShot();
    	System.out.println("NI Work Order Created Successfully.....");
    	Thread.sleep(2000);
    	dr.quit();
    }
}
