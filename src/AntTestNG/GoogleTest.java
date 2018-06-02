package AntTestNG;

import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTest {
	    @BeforeTest
	    public void OpenBrowser(){
	        System.out.println("Open Browser");
	    }
	    
	    @Test(priority=1)
	    public void SearchText(){
	    	System.out.println("Search Text data Login Page");
	    }
	    
	    @Test(priority=2)
	    public void UserID(){
	    	System.out.println("Enter Login user ID");
	    	throw new SkipException("Skip my Code -----");
	    }
	    
	    @Test(priority=3)
	    public void Password(){
	    	System.out.println("Enter Password user ID");
	    }
	    
	    @AfterTest
	    public void TestDown(){
	    	System.out.println("Window CLose");
	    }
}
