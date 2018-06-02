package AntTestNG;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GmailTest {
    @BeforeTest
    public void OpenBrowser(){
    	System.out.println("Open Browser");
    }
    
    @Test(priority=1, dataProviderClass=Data_Pro.class,dataProvider="RegisterData_Provider")
    public void LoginPage(String name,String Pass, String Email){
    	System.out.println("Open Login Page");
    	System.out.println(name + "|--" +Pass + "|--" + Email);
    }
    
    @Test(priority=2, dependsOnMethods={"LoginPage"})
    public void UserID(){
    	System.out.println("Enter Login user ID");
    }
    
    @Test(priority=3, dependsOnMethods={"LoginPage", "UserID"})
    public void Password(){
    	System.out.println("Enter Password user ID");
    	//Assert.assertTrue(3>12, "3 is not greater than 12...");
    }
    
    @AfterTest
    public void TestDown(){
    	System.out.println("Window CLose");
    }
}
