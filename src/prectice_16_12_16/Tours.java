package prectice_16_12_16;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Tours {
    WebDriver dr;
	@Test
  public void loginTours() throws InterruptedException, IOException
	{
/*	  dr = new FirefoxDriver();
	  dr.manage().window().maximize();
	  dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  dr.get("http://newtours.demoaut.com/");
	  String Title_Text = dr.getTitle();
	  System.out.println(Title_Text);
	  
	  dr.findElement(By.name("userName")).sendKeys("qqqq");
	  dr.findElement(By.name("password")).sendKeys("qqqq");
	  dr.findElement(By.name("login")).click();
	  
	  System.out.println(dr.getTitle());
	  
	  String HeaderName = dr.findElement(By.xpath("//form[@name='findflight']/table/tbody/tr[1]")).getText();
	  System.out.println(HeaderName);
	  
	  List<WebElement> linkName = dr.findElements(By.tagName("a"));
	  for(int i=0;i<linkName.size();i++){
		 System.out.println(linkName.get(i).getText()); 
	  }
	  System.out.println(linkName.size());

	  
      WebElement radio = dr.findElement(By.xpath("//input[@value='oneway']"));
	  if(!radio.isSelected()){
		  radio.click();
	  }
	  
	  Select ListFromPort= new Select(dr.findElement(By.xpath("//select[@name='fromPort']")));
	  ListFromPort.selectByVisibleText("London");
	  
	  Select FromMonth= new Select(dr.findElement(By.xpath("//select[@name='fromMonth']")));
	  FromMonth.selectByVisibleText("April");
	  
	  Select FromDay= new Select(dr.findElement(By.xpath("//select[@name='fromDay']")));
	  FromDay.selectByVisibleText("27");
	  
	  WebElement radioClass = dr.findElement(By.xpath("//input[@value='First']"));
	  if(!radioClass.isSelected()){
		  radioClass.click();
	  }
	  
	  Select air_line= new Select(dr.findElement(By.xpath("//select[@name='airline']")));
	  air_line.selectByVisibleText("Pangea Airlines");
	  
	  
	  Select pass_Count= new Select(dr.findElement(By.xpath("//select[@name='passCount']")));
	  pass_Count.selectByVisibleText("4");
	  
	  String text_Footer = dr.findElement(By.xpath("//div[@class='footer']")).getText();
	  
	  Assert.assertEquals(text_Footer.equals(text_Footer), true);
	  
	  System.out.println("Footer found Succesfully");
	  
	  
	  // Find the Link Name from Box.
	  List<WebElement> BoxLink = dr.findElements(By.xpath("html/body/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table"));
	  for(int j=0;j<BoxLink.size();j++){
		 System.out.println(BoxLink.get(j).getText()); 
		 System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		 BoxLink.get(j).click();
		 System.out.println(dr.getTitle());
		 BoxLink = dr.findElements(By.xpath("html/body/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table"));
	  }*/
	  
      ChromeOptions op = new ChromeOptions();
      op.addArguments("--disable-extensions");
      System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chrome//chromedriver.exe");
      dr = new ChromeDriver(op);
      
      dr.get("http://executeautomation.com/demosite/index.html");
  	  System.out.println(dr.getTitle());
  	  
	  WebElement event = dr.findElement(By.xpath("html/body/div[1]/ul/li[2]/a")); 
	  Actions act = new Actions(dr);
      act.moveToElement(event).perform();
      Thread.sleep(2000);
      dr.quit();    	
}
      
      
	/*  dr.navigate().to("http://executeautomation.com/demosite/index.html");
	  dr.manage().window().maximize();
	  dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  
	  //Select  List box...
	  
	  Select title = new Select(dr.findElement(By.name("TitleId")));
	  title.selectByVisibleText("Mr.");
	  
	  //Radio button...
  
	  WebElement radio  = dr.findElement(By.name("Female"));
	  if(!radio.isSelected()){
		  radio.click();
	  }
	  
	  //Check Box.....
	  dr.findElement(By.name("Hindi")).click();
	  Thread.sleep(2000);
	  
	  //Check Box Unchecked.....
	  dr.findElement(By.name("english")).click();
	  
	  
	  //Click On Link....
	  dr.findElement(By.linkText("HtmlPopup ")).click();
	  Thread.sleep(2000);
	  System.out.println("Popup Window Open successfully......");
	  
	  //Screen Shot Capture......
	  File src = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	  
	  try{
		  
		  FileUtils.copyFile(src, new File("C:/Users/ti01045/Desktop/ScreenShot/A.jpg"));
	  }
	  catch(Exception ex){
		  System.out.println(ex.getMessage());
	  }
	  
	  // PopUp Window handle....
	  for(String popupWindow: dr.getWindowHandles()){
		  dr.switchTo().window(popupWindow);
	  }
	  dr.findElement(By.name("FirstName")).sendKeys("First Name");
	  Select Country = new Select(dr.findElement(By.name("Country")));
	  Country.selectByVisibleText("USA");
	  
	  File src1 = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
	  try{
		  FileUtils.copyFile(src1, new File("C:/Users/ti01045/Desktop/ScreenShot/A2.jpg"));
		  }
	  catch(Exception e){
		 System.out.println(e.getMessage()); 
	     e.printStackTrace();
	  }
	  Thread.sleep(3000);
      dr.close();
      
      for(String mainWindow : dr.getWindowHandles()){
    	  dr.switchTo().window(mainWindow);
      }
     // dr.findElement(By.name("generate")).click();
      // Alert Handle ----
     // dr.switchTo().alert().accept();
      //Thread.sleep(3000);
	  //Check Box Unchecked.....
      
	  dr.findElement(By.name("english")).click();	  
	  Thread.sleep(2000);


      
      
      WebElement Actionevent1 = dr.findElement(By.xpath("html/body/div[1]/ul/li[2]/ul")); 
      Actions act1 = new Actions(dr);
      act.moveToElement(Actionevent1).perform();
      
      List <WebElement> allLink = dr.findElements(By.xpath("html/body/div[1]/ul/li[2]/ul/li[2]/ul"));
      for(int j=0;j<allLink.size();j++){
    	  System.out.println(allLink.get(j).getText());
      }

   } */
  }	
