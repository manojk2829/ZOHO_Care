package TestNGListner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testListner implements ITestListener {

	@Override
	public void onFinish(ITestContext result) {
		
	}

	@Override
	public void onStart(ITestContext result) {
		System.out.println("My Test is Start, Test Case Google URL open --- " + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("My Test has Faild ---, Test Case Failure URL not opened --- " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("My Test is Start to Executed, Test Case Google URL open --- " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("My Test is Success to Executed, Test Case Done --- " + result.getName());
	}
}
