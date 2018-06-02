package configFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class rw {
	    WebDriver dr;
		@Test(priority=1)
		public void login(){
			System.out.println("Login 1");
		}
		@Test(priority=4)
		public void Password(){
			System.out.println("Password 1");
		}
		@Test(priority=3)
		public void UserLogin(){
			System.out.println("UserLogin 1");
		}
		
		@Test(priority=2)
		public void AdminLogin(){
			System.out.println("AdminLogin 1");
		}
		
		@BeforeTest
		public void OpenBrowser() throws Exception{
			dr = new FirefoxDriver();
			dr.navigate().to("http://google.com/");
			System.out.println(dr.getTitle());
			
			File src = new File("D://report//tempNew.txt");
			FileWriter fw = new FileWriter(src);

			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Manoj Kushwaha");
			bw.newLine();
			bw.write("Neeraj Kumar");
			bw.newLine();
			bw.write("Vinod Ji");
			bw.newLine();
			bw.write("Vivek Kumar");
			bw.newLine();
			bw.flush();
			
			FileReader fr = new FileReader(src);
			BufferedReader br = new BufferedReader(fr);
			//System.out.println(br.readLine());
			String x = "";
			while((x=br.readLine()) != null){
				System.out.println(x);
			}
		}
	
		@AfterTest
		public void After(){
			dr.close();
			System.out.println("After Method Executed");
		}

}
