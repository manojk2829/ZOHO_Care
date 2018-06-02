package CAREModule20Again;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class FR_creation_SingleRoom extends BaseTestDec25{
	
	@Test()
	  public void NewCare_DashBoard_Test() throws Exception{
		test = rep.startTest("FR_creation_SingleRoom");
		test.log(LogStatus.INFO, "Starting the test -- FR_creation_SingleRoom FR");
		initialization();
	  	openBrowser("chrome");
	  	navigate("CareURL");
	  	typeTextUser("userLoginID_xpath", "careadmin1");
	  	typeTextPass("userLoginPass_id", "bbcl@gr1");
	  	FR_WO_ScreenShot();
	  	click("UserSubmit_xpath");
	  	System.out.println(dr.getTitle());
	  	Thread.sleep(2000);
	  	switchFrameCareDashBoard("switchFrameCareDashBoard_xpath");
	  	dr.switchTo().frame(0);
	  	NewDashBoard_CustomerID_Search("Cust_Search_id", "212339410");
	  	NewDashBoard_CustomerID_Search_Icon_Click("Cust_Search_Icon_Click_id");
	  	Thread.sleep(2000);
	  	FR_WO_ScreenShot();
	  	dr.switchTo().defaultContent();
	  	switchMainframe("switchMainframe_xpath");
	  	Thread.sleep(2000);
	  	WebElement CloseBTN = dr.findElement(By.xpath("//a[@id='TB_closeWindowButton']"));
	  	if(CloseBTN.isDisplayed())	  		
	  	Close_Popup_Window_Click("Close_Popup_Window_Click_xpath");
	  	
	/**********************FR Work Order Creation ************************************/
    
	Thread.sleep(2000);
	
	System.out.println("Going to create FR WO");
	LogComplaint_link("LogComplaint_xpath");
	Thread.sleep(1000);
    dr.switchTo().defaultContent();
    switchFrameCareDashBoard("switchFrameCareDashBoard_xpath");
  	dr.switchTo().frame(0);
  	Search_RTN("Search_RTN_id", "6634567890");
    WebElement Complaint_copyCallerNumber = dr.findElement(By.id("txtRTN"));
	Actions act_caller_number = new Actions(dr);
	act_caller_number.moveToElement(Complaint_copyCallerNumber).doubleClick().build().perform();
	dr.findElement(By.id("txtRTN")).sendKeys(Keys.CONTROL, "c");
	dr.switchTo().defaultContent();
	switchMainframe("switchMainframe_xpath");
	dr.findElement(By.id("txtCallerNo")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
	Thread.sleep(2000);
	LogComplaint_CallerType("LogComplaint_Callertype_id");
	Thread.sleep(2000);
	LogComplaint_Category("LogComplaint_Category_id");
	Thread.sleep(1000);
	LogComplaint_Type("LogComplaint_Type_id");
	Thread.sleep(1000);
	LogComplaint_SubType("LogComplaint_SubType_id");
	Thread.sleep(1000);
	LogComplaint_SUB_SubType("LogComplaint_SUB_SubType_id");
	Thread.sleep(1000);
	ComplaintDesc_txt_Clear("ComplaintDesc_txt_id");
	Thread.sleep(1000);
	ComplaintDesc_txt("ComplaintDesc_txt_id", "For Testing Use Only ComplaintDesc txt FR WO Creation");
	FR_WO_ScreenShot();
	Assign_btn("Assign_id");
	Thread.sleep(5000);
	WebElement WorkOrder_RTN_Update_Window_Open = dr.findElement(By.id("btnProceedFromRTN"));
	if(WorkOrder_RTN_Update_Window_Open.isDisplayed()){
		FR_WO_ScreenShot();
		Thread.sleep(1000);
		Cancle_btnProceedFromRTN("Cancle_btnProceedFromRTN_id");
		Thread.sleep(4000);
		FR_Service_Selection("FR_Service_Selection_id");
		FR_WO_ScreenShot();
		Thread.sleep(2000);
		Proceed_btn("Proceed_btn_xpath");
		Thread.sleep(5000);
		FR_WO_ScreenShot();
		Success_message("Success_message_id");
		Thread.sleep(6000);
		Close_Popup_Window_Click("Close_Popup_Window_Click_xpath");
		Thread.sleep(20000);
		FR_WO_ScreenShot();
		dr.close();
	}
	else
	{
		WebElement AlreadyWorkOrder_Created = dr.findElement(By.id("jqi_state0_buttonOk"));
		 Thread.sleep(4000);
		 FR_WO_ScreenShot();
		 AlreadyWorkOrder_Created.click();
		 System.out.println("Work Orde already created Successfuuly.....");
		 Thread.sleep(20000);
		 FR_WO_ScreenShot();
		 dr.close();
	 }
		/********************** FR WO Creation Successfully****************************/
   }
	
	@AfterMethod
	public void teardown(){
		rep.endTest(test);
		rep.flush();
	   }
}
