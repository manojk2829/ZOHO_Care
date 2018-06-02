package CAREModule20Again;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FTR_NFTR_Single_Room_SR extends BaseTestDec25{
	@Test()
	  public void FTR_And_NFTR() throws Exception{
		initialization();
	  	openBrowser("chrome");
	  	navigate("CareURL");
	  	typeTextUser("userLoginID_xpath", "careteststh");
	  	typeTextPass("userLoginPass_id", "irctc@116");
	  	FTR_And_NFTR_SR_ScreenShot();
	  	click("UserSubmit_xpath");
	  	System.out.println(dr.getTitle());
	  	Thread.sleep(2000);
	  	switchFrameCareDashBoard("switchFrameCareDashBoard_xpath");
	  	dr.switchTo().frame(0);
	  	NewDashBoard_CustomerID_Search("Cust_Search_id", "2004865");
	  	NewDashBoard_CustomerID_Search_Icon_Click("Cust_Search_Icon_Click_id");
	  	Thread.sleep(2000);
	  	dr.switchTo().defaultContent();
	  	switchMainframe("switchMainframe_xpath");
	  	NewCareDashBoard_ScreenShot();
	  	Thread.sleep(2000);
	  	WebElement CloseBTN = dr.findElement(By.xpath("//a[@id='TB_closeWindowButton']"));
	  	if(CloseBTN.isDisplayed())	  		
	  	Close_Popup_Window_Click("Close_Popup_Window_Click_xpath");
	  	System.out.println("Going to Create FTR and NFTR SR from New care Dash Borad page.");
	  	FTR_And_NFTR_SR_ScreenShot();
	  	
     	/********************** FTR Complaint Creation FTR (First Time Resolved) ****************************/
	  	Thread.sleep(3000);
		LogComplaint_link("LogComplaint_xpath");
		Thread.sleep(1000);
	    dr.switchTo().defaultContent();
	    switchFrameCareDashBoard("switchFrameCareDashBoard_xpath");
	  	dr.switchTo().frame(0);
	  	Search_RTN("Search_RTN_id", "6634567890");
	    WebElement Complaint_FTR_copyCallerNumber = dr.findElement(By.id("txtRTN"));
		Actions act_caller_FTR_number = new Actions(dr);
		act_caller_FTR_number.moveToElement(Complaint_FTR_copyCallerNumber).doubleClick().build().perform();
		dr.findElement(By.id("txtRTN")).sendKeys(Keys.CONTROL, "c");
		dr.switchTo().defaultContent();
		switchMainframe("switchMainframe_xpath");
		dr.findElement(By.id("txtCallerNo")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
		Thread.sleep(2000);
		LogComplaint_CallerType("LogComplaint_Callertype_id");
		LogComplaint_Category("LogComplaint_Category_id");
		Thread.sleep(2000);
		LogComplaint_Type("LogComplaint_Type_id");
		Thread.sleep(2000);
		LogComplaint_SubType("LogComplaint_SubType_id");
		Thread.sleep(2000);
		LogComplaint_SUB_SubType("LogComplaint_SUB_SubType_id");
		Thread.sleep(2000);
		ResolutionCode_1("ResolutionCode_id");
		Thread.sleep(5000);
		txtClosureRemarks("txtClosureRemarks_id", "txt Closure Remarks");
		Thread.sleep(2000);
		Resolve_btn_Click("btnResolve_id");
		Thread.sleep(5000);
		FTR_And_NFTR_SR_ScreenShot();
		Success_message("Success_message_id");
		Thread.sleep(2000);
		Close_Popup_Window_Click("Close_Popup_Window_Click_xpath");
		System.out.println("FTR SR created Successfully.......");

		/************************ NFTR SR Creation ****************************/

		Thread.sleep(3000);
		LogComplaint_link("LogComplaint_xpath");
		Thread.sleep(1000);
	    dr.switchTo().defaultContent();
	    switchFrameCareDashBoard("switchFrameCareDashBoard_xpath");
	  	dr.switchTo().frame(0);
	  	Search_RTN("Search_RTN_id", "6634567890");
	    WebElement Complaint_NFTR_copyCallerNumber = dr.findElement(By.id("txtRTN"));
		Actions act_caller_NFTR_number = new Actions(dr);
		act_caller_NFTR_number.moveToElement(Complaint_NFTR_copyCallerNumber).doubleClick().build().perform();
		dr.findElement(By.id("txtRTN")).sendKeys(Keys.CONTROL, "c");
		dr.switchTo().defaultContent();
		switchMainframe("switchMainframe_xpath");
		dr.findElement(By.id("txtCallerNo")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
		Thread.sleep(2000);
		LogComplaint_CallerType("LogComplaint_Callertype_id");
		LogComplaint_Category("LogComplaint_Category_id");
		Thread.sleep(2000);
		LogComplaint_NFTR_Type("LogComplaint_Type_id");
		Thread.sleep(1000);
		LogComplaint_NFTR_SubType("LogComplaint_SubType_id");
		Thread.sleep(1000);
		LogComplaint_NFTR_SUB_SubType("LogComplaint_SUB_SubType_id");
		Thread.sleep(2000);
		FTR_And_NFTR_SR_ScreenShot();
		Assign_btn("Assign_id");
		Thread.sleep(3000);

		WebElement NFTR_Created_Alert_OR_Successfull_Message = dr.findElement(By.id("jqi_state0_buttonOk"));
		String Actual_alert_Message = "This SubSubType of open complaint within SLA is already exist";
		String Expected_alert_Message = dr.findElement(By.xpath("//div[@class='jqimessage']")).getText();
	    boolean test=Actual_alert_Message.equalsIgnoreCase(Expected_alert_Message);
	
		if(test){
			System.out.println("Actual Alert message is equal to Expected message match"); 
			Thread.sleep(2000);
			FTR_And_NFTR_SR_ScreenShot();
			NFTR_Created_Alert_OR_Successfull_Message.click();
			Thread.sleep(2000);
		    dr.switchTo().defaultContent();
		    switchFrameCareDashBoard("switchFrameCareDashBoard_xpath");
		  	dr.switchTo().frame(0);
		  	Search_RTN("Search_RTN_id", "6634567890");
		    Complaint_NFTR_copyCallerNumber = dr.findElement(By.id("txtRTN"));
			act_caller_NFTR_number = new Actions(dr);
			act_caller_NFTR_number.moveToElement(Complaint_NFTR_copyCallerNumber).doubleClick().build().perform();
			dr.findElement(By.id("txtRTN")).sendKeys(Keys.CONTROL, "c");
			dr.switchTo().defaultContent();
			switchMainframe("switchMainframe_xpath");
			dr.findElement(By.id("txtCallerNo")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
			Thread.sleep(2000);
			LogComplaint_CallerType("LogComplaint_Callertype_id");
			LogComplaint_Category("LogComplaint_Category_id");
			Thread.sleep(2000);
			LogComplaint_NFTR_Type("LogComplaint_Type_id");
			Thread.sleep(2000);
			LogComplaint_NFTR_New_SubType("LogComplaint_SubType_id");
			Thread.sleep(2000);
			LogComplaint_NFTR_New_SUB_SubType("LogComplaint_SUB_SubType_id");
			FTR_And_NFTR_SR_ScreenShot();
			Thread.sleep(2000);
			Assign_btn("Assign_id");
			Thread.sleep(3000);

			WebElement NFTR_Another_Time_Created_Alert_OR_Successfull_Message = dr.findElement(By.id("jqi_state0_buttonOk"));
			if(test=Actual_alert_Message.equalsIgnoreCase(Expected_alert_Message)){
				Thread.sleep(2000);
				FTR_And_NFTR_SR_ScreenShot();
				System.out.println("Another time actual Alert message is match to Expected message");
				NFTR_Another_Time_Created_Alert_OR_Successfull_Message.click();
				System.out.println("NFTR SR is not getting created.......");
				
			}
			else
			{   
				Thread.sleep(2000);
				Success_message("Success_message_id");
				System.out.println("NFTR SR created successfully....."); 
				Thread.sleep(2000);
				FTR_And_NFTR_SR_ScreenShot();
				Close_Popup_Window_Click("Close_Popup_Window_Click_xpath");
				Thread.sleep(20000);
				dr.close();
			}
		}
		else
		{   
			Thread.sleep(2000);
			FTR_And_NFTR_SR_ScreenShot();
			Success_message("Success_message_id");
			
			System.out.println("NFTR SR created successfully....."); 
			Thread.sleep(2000);
			FTR_And_NFTR_SR_ScreenShot();
			Close_Popup_Window_Click("Close_Popup_Window_Click_xpath");
			Thread.sleep(20000);
			dr.close();
		}
		//NFTR End -----
    }
  }
