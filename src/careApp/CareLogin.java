package careApp;

import org.testng.annotations.Test;

public class CareLogin extends BaseTest_CareApp {
   @Test
    public void CareLoginTest(){
    	inicialization();
    	openBrowser("chrome");
    	naviget("urlkey");
    	EnterTextUser("UserName_name", "careteststh");
    	EnterTextUser("UserPassword_id", "irctc@116");
    	ClickSubmit("CareLogin_xpath");
    }
    
}
