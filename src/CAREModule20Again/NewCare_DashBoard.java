package CAREModule20Again;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NewCare_DashBoard extends BaseTestDec25{
	  @Test()
	  public void NewCare_DashBoard_Test() throws Exception{
		initialization();
	  	openBrowser("chrome");
	  	navigate("CareURL");
	  	typeTextUser("userLoginID_xpath", "careadmin1");
	  	typeTextPass("userLoginPass_id", "bbcl@gr1");
	  	NewCareDashBoard_ScreenShot();
	  	click("UserSubmit_xpath");
	  	System.out.println(dr.getTitle());
	  	Thread.sleep(2000);
	  	switchFrameCareDashBoard("switchFrameCareDashBoard_xpath");
	  	dr.switchTo().frame(0);
	  	NewDashBoard_CustomerID_Search("Cust_Search_id", "89835785");
	  	NewCareDashBoard_ScreenShot();
	  	NewDashBoard_CustomerID_Search_Icon_Click("Cust_Search_Icon_Click_id");
	  	Thread.sleep(2000);
	  	NewCareDashBoard_ScreenShot();
	  	dr.switchTo().defaultContent();
	  	switchMainframe("switchMainframe_xpath");
	  	NewCareDashBoard_ScreenShot();
	  	Thread.sleep(2000);
	  	//WebElement CloseBTN = dr.findElement(By.xpath("//a[@id='TB_closeWindowButton']"));
	  	//if(CloseBTN.isDisplayed()){
	  	Close_Popup_Window_Click("Close_Popup_Window_Click_xpath");
	  	Thread.sleep(2000);
	  	/*Email_survey_PopUp_window("Email_survey_PopUp_window_id");
	  	Thread.sleep(2000);
	  	Email_Update_success_message("Email_Update_success_message_id");
	  	NewCareDashBoard_ScreenShot();*/
        // Customer Profile ----- 
        
	  	/**********************RTN 1 and RTN 2 Update******************************/
	  	Thread.sleep(2000);
	    RTN_Update_Link_Click("RTN_Update_xpath");
	    Thread.sleep(2000);
	    RTN_Update_remove_Old("RTN_1_Update_id");
	    Thread.sleep(2000);
	    RTN_1_Update("RTN_1_Update_id", "5092045378");
	    
	    WebElement copyRTN_1_Text = dr.findElement(By.id("txtRTN1"));
		Actions act = new Actions(dr);
		act.moveToElement(copyRTN_1_Text).doubleClick().build().perform();
		dr.findElement(By.id("txtRTN1")).sendKeys(Keys.CONTROL, "c");
		dr.findElement(By.id("txtRTNCallerNo")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
		RTN_1_Callertype("RTN_Callertype_id");
		NewCareDashBoard_ScreenShot();
		RTN_update_btn_Click("RTN_update_btn_Click_id");
		Thread.sleep(2000);
		RTN_AlertMessage("RTN_AlertMessage_name");
		Thread.sleep(2000);
		NewCareDashBoard_ScreenShot();
		RTN_AlertMessage("RTN_AlertMessage_name");
	    System.out.println("RTN_One Updated Done Successfully");
	    Thread.sleep(3000);

	    RTN_Update_Link_Click_RTN2("RTN_Update_xpath");
	    Thread.sleep(1000);
	    RTN_2_Update_remove_Old_RTN("RTN_2_Update_id");
	    Thread.sleep(1000);
	    RTN_2_Update("RTN_2_Update_id", "2901201912");
	    WebElement copyRTN_2_Text = dr.findElement(By.id("txtRTN2"));
		Actions act1 = new Actions(dr);
		act1.moveToElement(copyRTN_2_Text).doubleClick().build().perform();
		dr.findElement(By.id("txtRTN2")).sendKeys(Keys.CONTROL, "c");
		dr.findElement(By.id("txtRTNCallerNo")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
		RTN_1_Callertype("RTN_Callertype_id");
		NewCareDashBoard_ScreenShot();
		Thread.sleep(3000);
		RTN_update_btn_Click("RTN_update_btn_Click_id");
		Thread.sleep(1000);
		NewCareDashBoard_ScreenShot();
		Thread.sleep(2000);
		RTN_AlertMessage("RTN_AlertMessage_name");
		Thread.sleep(1000);
		NewCareDashBoard_ScreenShot();
		RTN_AlertMessage("RTN_AlertMessage_name");
	    System.out.println("RTN_ 2 Updated Done Successfully");
	    NewCareDashBoard_ScreenShot();

	    /************************RTN Updated Successfully ***************************/
	    
	    /************************Email Updated ***************************/
	    Thread.sleep(2000);
	    Email_update_Link("Email_update_Link_xpath");
	    Email_update_Link_Old_Email_Remove("Email_update_Link_Old_Email_Remove_id");
	    Thread.sleep(1000);
	    Email_text("Email_text_id","manoj.uio@d2h.com");
	    Thread.sleep(1000);
	    Email_Update_btn_Click("Email_Update_btn_Click_id");
	    Thread.sleep(2000);
	    Email_alert_message("Email_alert_message_id");
	    Thread.sleep(2000);
	    Email_success_message("Email_success_message_id");
	    System.out.println("Email Update Done");
	    NewCareDashBoard_ScreenShot();

	    /********************Language Updated *******************/
	   
        Thread.sleep(3000);
	    language_update_Link_Click("language_update_xpath");
	    Thread.sleep(2000);
	    change_Language("change_Language_id");
	    
	    Thread.sleep(1000);
	    dr.switchTo().defaultContent();
	    switchFrameCareDashBoard("switchFrameCareDashBoard_xpath");
	  	dr.switchTo().frame(0);
	  	Search_RTN("Search_RTN_id", "1234567890");
	    WebElement Langague_copyCallerNumber = dr.findElement(By.id("txtRTN"));
		Actions act_caller_number = new Actions(dr);
		act_caller_number.moveToElement(Langague_copyCallerNumber).doubleClick().build().perform();
		dr.findElement(By.id("txtRTN")).sendKeys(Keys.CONTROL, "c");
		dr.switchTo().defaultContent();
		switchMainframe("switchMainframe_xpath");
		dr.findElement(By.id("txtCallerNumber")).sendKeys(Keys.chord(Keys.CONTROL, "v"));
		Thread.sleep(2000);
		langauge_Callertype("Langauge_Callertype_id");
		Langauge_update_btn_Click("Langauge_update_btn_Click_id");
		Thread.sleep(2000);
		langague_alert_message("Email_alert_message_id");
		Thread.sleep(2000);
		Email_success_message("Email_success_message_id");
		NewCareDashBoard_ScreenShot();
		
		/***********************New Care Address Update*****************************/
	  	Thread.sleep(5000);
	  	dr.findElement(By.xpath("html/body/form/div[3]/div[4]/div[16]/div/div[2]/table/tbody/tr[7]/td[1]/div/a")).click();
	  	Address_Update_Link("Address_Update_Link_xpath");
		Thread.sleep(1000);
		Pincode_Search_icon("Pincode_Search_icon_xpath");
     	Pincode_Link_Click("Pincode_Link_Click_xpath");
    	
		NewCareDashBoard_ScreenShot();
		Thread.sleep(1000);
		Address_Update_1_txt("Address_Update_1_txt_id", "Address_Update 1 txt id");
		Thread.sleep(1000);
		Address_LandMark("Address_LandMark_id", "Address LandMark clear id");
		Address_btn_UpdateAddress_Click("Address_btn_UpdateAddress_id");
		Thread.sleep(2000);
		NewCareDashBoard_ScreenShot();
		Sucess_message("Success_message_id");
		
		// Account Information ------
		/***********************Balance History ****************************/
		Thread.sleep(3000);
		Balance_History_Link("Balance_History_Link_xpath");
		NewCareDashBoard_ScreenShot();
		Thread.sleep(3000);
		Balance_Popup_window_Close("Balance_Popup_window_Close_xpath");
		
		//***********************YPWR History ****************************//		
		Thread.sleep(3000);
		YPWR_Link("YPWR_Link_xpath");
		NewCareDashBoard_ScreenShot();
		Thread.sleep(3000);
		YPWR_Alert_message_OKbtn("YPWR_Alert_message_OKbtn_id");
		NewCareDashBoard_ScreenShot();
		Success_message("Success_message_id");
		
		//***********************YPWR History End ****************************//
		
		
		//************************Send YPWR message *************************//
		Thread.sleep(3000);
		Send_YPWR_SMS_Link("Send_YPWR_SMS_xpath");
		NewCareDashBoard_ScreenShot();
		Select_RTN_YPWR_SMS("Select_RTN_YPWR_SMS_id");
		RTN_txt_OthersOption("RTN_txt_OthersOption_id", "9632587410");
		
		btn_SendSMSOption("btnSendSMSOption_id");
		Thread.sleep(2000);
		NewCareDashBoard_ScreenShot();
		Success_message("Success_message_id");
		
		//************************Send YPWR message *************************//
		Thread.sleep(3000);
		cpe_reversal_link("cpe_reversal_xpath");
		Thread.sleep(2000);
		NewCareDashBoard_ScreenShot();
		Success_CPE_message("Success_message_id");
		
		//************************DBR Info *************************//
		Thread.sleep(3000);
		DBR_link("DBR_link_xpath");
		Thread.sleep(6000);
		NewCareDashBoard_ScreenShot();
		
		//******************** Re-Auth ***********************//
		Thread.sleep(3000);
		Re_Authorization_link("Re_Authorization_link_xpath");
		Thread.sleep(3000);
		ReAuthorization_Alert_message_OK_btn("ReAuthorization_Alert_message_OK_btn_id");
		Thread.sleep(3000);
		NewCareDashBoard_ScreenShot();
		Success_message("Success_message_id");
		
		//**********************SMS Re-Auth****************************//
		Thread.sleep(3000);
		//SMS_reAuth_link("SMS_reAuth_xpath");
		//NewCareDashBoard_ScreenShot();
		Reconnect_link("Reconnect_xpath");
		Thread.sleep(3000);
		NewCareDashBoard_ScreenShot();
		ReConnect_Alert_message_OK_btn("ReAuthorization_Alert_message_OK_btn_id");
		Success_message("Success_message_id");

		/********************** Check Warranty ****************************/
	    Thread.sleep(3000);
		CheckWarranty_link("CheckWarranty_link_xpath");
		Thread.sleep(3000);
		NewCareDashBoard_ScreenShot();
		CheckWarranty_Popup_window_Close("Close_Popup_Window_Click_xpath");
    }
  }

