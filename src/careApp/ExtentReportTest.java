package careApp;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportTest {
	ExtentReports rep;
	ExtentTest test;
	
  @BeforeTest
  public void startReporting()
  {
	  rep = new ExtentReports(System.getProperty("user.dir")+"//chrome//report.html",true);
      rep.addSystemInfo("HostName", "Manoj Kushwaha").addSystemInfo("Environment","QA")
      .addSystemInfo("User_name", "ManojKushwaha");
      rep.loadConfig(new File(System.getProperty("user.dir")+"/reportNew.xml"));
  }
	
	@Test(priority=1)
    public void loginTest() throws Exception{
	  test = rep.startTest("ExtentReportTest");
      WebDriver dr = new FirefoxDriver();
	  dr.manage().window().maximize();
	  dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  dr.get("http://newtours.demoaut.com/");
	  test.log(LogStatus.INFO, "URL uploaded successfully....");
	  System.out.println(dr.getTitle());
	  test.log(LogStatus.PASS, "Assert Test Pass.....");
	  
	  Thread.sleep(3000);
	  dr.quit();
  }
	
	@Test(priority=2)
	public void testfail()
	{
		test = rep.startTest("testfail");
		Assert.assertTrue(false);
		test.log(LogStatus.FAIL, "Faile Test case.. Executed");
	}
	
	@Test(priority=3)
	public void testSkip()
	{
		test = rep.startTest("testSkip");
		test.log(LogStatus.SKIP, "My TestCase Skiped");
		throw new SkipException("Skip test for Some Resone...");
		
	}
	
	@Test(priority=4)
	public void skipingTest(){
		test = rep.startTest("skipingTest");
		test.log(LogStatus.SKIP, "My TestCase Skiped");
		System.out.println("This test has been skipped successfully.....");
		throw new SkipException("Skip test for Some Resone...");
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE){
			test.log(LogStatus.FAIL, result.getThrowable());
		}
		rep.endTest(test);
	}
	
	@AfterTest
	public void endMyTest(){
		rep.endTest(test);
		rep.flush();
		rep.close();
	}
}
