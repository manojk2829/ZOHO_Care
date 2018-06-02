package CAREModule20Again;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

public class loginCare extends BaseClass {
	@Test
	public void login() throws Exception
	{
		test = rep.startTest("login");
		test.log(LogStatus.INFO, "Starting the test -- Create login");
		initialization();
		openBrowser("chrome");
		navigate("GOOGLE");
		screeShot();
		Thread.sleep(3000);
		dr.close();
	}

	@AfterMethod
	public void teardown(){
		rep.endTest(test);
		rep.flush();
		rep.close();

	}
}
