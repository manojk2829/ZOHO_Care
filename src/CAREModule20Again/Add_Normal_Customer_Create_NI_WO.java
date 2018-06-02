package CAREModule20Again;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Add_Normal_Customer_Create_NI_WO extends BaseTestDec25{

	@Test
    public void Add_Customer_NI_WorkOrder() throws Exception{
		test = rep.startTest("Add_Normal_Customer_Create_NI_WO");
		test.log(LogStatus.INFO, "Starting the test -- Create Normal customer");
    	initialization();
    	openBrowser("chrome");
    	test.log(LogStatus.INFO, "Chrome Browser Open");
    	navigate("CareURL");
    	typeTextUser("userLoginID_xpath", "careteststh");
    	typeTextPass("userLoginPass_id", "irctc@116");
    	Add_Customer_screenShot();
    	click("UserSubmit_xpath");
    	test.log(LogStatus.INFO, "Care login successfully");
    	System.out.println(dr.getTitle());
    	Add_Customer_screenShot();
    	switchFrameCustomerCapture("switchFrameCustomerCapture_xpath");
    	switchCustomerCaptureIcone("Customer_Capture_xpath");
    	Add_Customer_Link("Add_Customer_Link_xpath");
    	dr.switchTo().defaultContent();
    	
    	switchMainframe("switchMainframe_xpath");

    	// -------- Fill the Form Add Customer -------
    	
    	Add_Customer_screenShot();
    	selectTitle("select_Title_id");
    	firstName("UserFirstName_id", "Testing");
    	LastName("Userlastname_id", "Care");
    	
    	Address1("Address1_id", "Address 1");
    	LandMark("landMark_id", "Land Mark");
    	PinCode("Pincode_id", "201301");
    	Thread.sleep(1000);
    	PinCodeSearchIcon("PinCode_SearchIcon_id");
    	Thread.sleep(1000);
    	
    	selectPincode("SelectPincode_xpath");
    	Thread.sleep(1000);
    	
    	RTN_1("RTN1_id","6290340094");
    	
    	RTN_1_CheckBox("RTN_1_CheckBox_id");
    	Thread.sleep(1000);
    	
    	Select langauge = new Select(dr.findElement(By.xpath("//Select[@id='ddllanguage']")));
    	langauge.selectByValue("H");
    	
    	DOB("DOB_xpath");
    	DOB_Customer_Select("select_DOB_xpath");
    	//Select CustDOB = new Select(dr.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td/center/table[1]/tbody/tr/td[3]/select")));
    	//CustDOB.selectByVisibleText("1990");
    	
    	dr.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td/center/table[2]/tbody/tr[3]/td[5]/a")).click();
    	
    	DealerName("DealerName_id", "Dealer_Name");
    	DealerPhone("DealerPhone_id", "87896541230");
    	Thread.sleep(1000);
    	Add_Customer_screenShot();
    	
    	ClickNext("Next_id");
    	dr.switchTo().alert().accept();
    	Add_Customer_screenShot();
    	
    	test.log(LogStatus.PASS, "Customer Created Successfully.....");
    	test.log(LogStatus.FAIL, "Screen Shot capture after " + test.addScreenCapture(""));
    	
    	STBEnter("STB_id", "410414780151012435");
    	SmartCardEnter("SmartCard_id","10123610171");
    	SmartCardSearch_Icon_Click("SmartCard_SearchICon_id");
   	
    	// Select Package -------
    	
    	Select D2H_package = new Select(dr.findElement(By.xpath("//select[@id='ddlPackage']")));
    	D2H_package.selectByVisibleText("NEW GOLD SPORTS");
    	
    	// Package Configuration Radio button selection ------
    	
    	WebElement Offer = dr.findElement(By.xpath("//input[@id='rdblOfferConfiguration_0']"));
    	if(!Offer.isSelected()){
    		Offer.click();
    	}
    	Thread.sleep(2000);
    	Add_Customer_screenShot();
    	
    	Skip_button_click("SkipButton_id");
    	Thread.sleep(2000);
    	Add_Customer_screenShot();
    	System.out.println("Add Product Page has been opened successfully.....");
    	Add_Select("Add_Select_id");
    	Add_Special_Addon("SpecialAddon_id");
    	dr.switchTo().alert().accept();
    	GetOffer("GetOffer_id");
    	Add_Customer_screenShot();
    	Save_Customer_Offer("Save_Customer_Offer_id");
    	Add_Customer_screenShot();
    	
    	//------ Pop-up Work Order Description --------
    	
    	WorkOrderDescription("WorkOrderDescription_id", "23456789023");
    	WebElement copyText = dr.findElement(By.id("txtDescription"));
		Actions act = new Actions(dr);
		act.moveToElement(copyText).doubleClick().build().perform();
		dr.findElement(By.id("txtDescription")).sendKeys(Keys.CONTROL, "c");
		dr.findElement(By.id("txtCallerNo")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
		Callertype("Callertype_id");
    	Prceed_Button_Click("Prceed_id");
    	dr.switchTo().alert().accept();
    	NIWO_Created_Successfully_ScreenShot();
    	System.out.println("NIWO_Created_Successfully_ScreenShot");
    }
	
	
	@AfterMethod
	public void tearDown(){
		rep.endTest(test);
		rep.close();
		rep.flush();
	}
}
