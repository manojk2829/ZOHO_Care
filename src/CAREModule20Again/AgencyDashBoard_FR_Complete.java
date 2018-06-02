package CAREModule20Again;

import org.testng.annotations.Test;

public class AgencyDashBoard_FR_Complete extends BaseTestDec25 {
	@Test
	public void agencyDashBoardFR_Complete() throws Exception {
    	initialization();
    	openBrowser("chrome");
    	navigate("CareURL");
    	typeTextUser("userLoginID_xpath", "careteststh");
    	typeTextPass("userLoginPass_id", "irctc@116");
    	AgencyDashBoard_FR_WO_ScreenShot();
    	click("UserSubmit_xpath");
    	System.out.println(dr.getTitle());
    	switchFrameWFM("switchFrameWFM_Tab_xpath");
    	switchWFM_Tab_Click("swithWFM_Tab_Link_xpath");
    	AgencyDashBoard_FR_WO_ScreenShot();
    	AgencyDashBoard_Click("AgencyDashBoard_xpath");
    	Thread.sleep(2000);
    	AgencyDashBoard_FR_WO_ScreenShot();
    	
    	dr.switchTo().defaultContent();
	    switchMainframe("switchMainframe_xpath");
	    
	    AgecnyCustomerSearchIcon("AgecnyCustomerSearchIcon_xpath");
	    Thread.sleep(4000);
	    AgencyDashBoard_FR_WO_ScreenShot();
	    dr.switchTo().frame(0);
	    radio_ByWorkOrder("radio_ByWorkOrder_id");
	    WO_ID_search("WorkOrderID_search_id", "215451");
	    SearchByWo_Click_btn("Search_ByWo_id");
	    Thread.sleep(4000);
	    AgencyDashBoard_FR_WO_ScreenShot();
	    
	    WorkOrderLink_Click("WorkOrderLink_xpath");
	    Thread.sleep(1000);
	    AgencyDashBoard_FR_WO_ScreenShot();
	    dr.switchTo().frame(0);
	    // ---------  FR Work Order Complete ---------- //
	    visitRemark_No("visit_No_Remark_id");
	    Visit_No_txtRemark("Visit_No_txtRemark_Tele_id", "Tele remark Done");
	    FR_NatureOfWork("NatureOfWork_id");
	    FR_issue_observation("IssueObserved_id");
	    FR_ResolutionCode("ResolutionCode_id");
	    Thread.sleep(1000);
	    ActionTaken("ActionTaken_id", "Action Taken Done");
	    Complete_FR_WO("Complete_WO_id");
	    Thread.sleep(2000);
	    Complete_FR_Success_Message("Activation_Success_Message_message_id");
	    System.out.println("FR completed successfully");
	    Thread.sleep(2000);
	    AgencyDashBoard_FR_WO_ScreenShot();
	    Thread.sleep(10000);
	    dr.close();
	}
}
