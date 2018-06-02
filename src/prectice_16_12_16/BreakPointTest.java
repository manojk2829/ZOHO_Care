package prectice_16_12_16;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class BreakPointTest {
	static WebDriver dr;
	public static void main(String[] args) throws Exception {
		
		dr = new FirefoxDriver();
		dr.get("http://www.google.com");
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		ScreenShotNew();
		System.out.println("First Line Execution.....");
		System.out.println("Second Line Execution.....");
		System.out.println("Thired Line Execution.....");
		
		System.out.print("Fourth Line Execution.....");
		System.out.println("Five Line Execution.....");
		
		addTwoNumber();
		MulTwoNumber();
		dr.quit();
		
	}	
	public static void addTwoNumber(){
		int sum;
		int a=9,b=10;
		
		sum = a+b;
		System.out.println(sum);
		
	}

	public static void MulTwoNumber(){
		int Mul;
		int a=9,b=10;
		
		Mul = a*b;
		System.out.println(Mul);
		
	}
	
	public static void ScreenShotNew() throws Exception{
		File src = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\ti01045\\Desktop\\BRD-2016\\A.jpg"));
	}
}
