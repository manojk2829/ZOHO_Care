package CAREModule20Again;

import org.testng.annotations.Test;

public class AgencyDashBoard_NI_Activation extends BaseTestDec25 {
    @Test
	public void agencyDashBoard() throws Exception {
    	initialization();
    	openBrowser("chrome");
    	navigate("CareURL");
    	typeTextUser("userLoginID_xpath", "careteststh");
    	typeTextPass("userLoginPass_id", "irctc@116");
    	AgencyDashBoard_ScreenShot();
    	click("UserSubmit_xpath");
    	System.out.println(dr.getTitle());
    	switchFrameWFM("switchFrameWFM_Tab_xpath");
    	switchWFM_Tab_Click("swithWFM_Tab_Link_xpath");
    	AgencyDashBoard_ScreenShot();
    	AgencyDashBoard_Click("AgencyDashBoard_xpath");
    	Thread.sleep(2000);
    	AgencyDashBoard_ScreenShot();
    	
    	dr.switchTo().defaultContent();
	    switchMainframe("switchMainframe_xpath");
	    
	    AgecnyCustomerSearchIcon("AgecnyCustomerSearchIcon_xpath");
	    Thread.sleep(3000);
	    AgencyDashBoard_ScreenShot();
	    dr.switchTo().frame(0);
	    Agency_customerID_search("customerID_search_id", "2022321");
	    Agency_cust_search_btn("cust_search_btn_id");

	    Thread.sleep(2000);
	    AgencyDashBoard_ScreenShot();
	    
	    WorkOrderLink_Click("WorkOrderLink_xpath");
	    Thread.sleep(2000);
	    AgencyDashBoard_ScreenShot();
	    dr.switchTo().frame(0);
    
	    // ---------  NI Work Order activation ---------- //
	    visitRemark_Yes("visit_Yes_Remark_id");
	    Visit_Yes_txtRemark("visit_Yes_txt_id", "Visit Yes Done");
	    NatureOfWork("NatureOfWork_id");
	    ResolutionCode("ResolutionCode_id");
	    ActionTaken("ActionTaken_id", "Action Taken Done");
	    Thread.sleep(4000);
	    AgencyDashBoard_ScreenShot();
	    Activate_NI("Activate_id");
	    Activation_alert_message("Activation_Alert_Message_message_id");
	    Thread.sleep(4000);
	    AgencyDashBoard_ScreenShot();
	    Activation_Success_Message_message("Activation_Success_Message_message_id");
	}
}
