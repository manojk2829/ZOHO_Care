package AntTestNG;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenerTestNG extends TestListenerAdapter {
   public void 	onTestFailure(ITestResult tr){
	 System.out.println("Fail");  
   }
   
   public void 	onTestSuccess(ITestResult tr){
	 System.out.println("Success"); 
   }
   
   public void 	onTestSkipped(ITestResult tr){
	   System.out.println("Skipped");
   }
}
