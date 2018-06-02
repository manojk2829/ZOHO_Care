package CAREModule20Again;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTestDec25 {
	WebDriver dr;
	public Properties pro=null;
	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;

	public void initialization(){
		if(pro==null)
			pro = new Properties();
		try{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\CAREModule20Again\\decConfig.properties");
			pro.load(fis);
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void openBrowser(String broName){
		if(broName.equalsIgnoreCase("firefox")){
			dr = new FirefoxDriver();
		}
		else if(broName.equalsIgnoreCase("chrome"))
		{
			// pro.getProperty("Chrome_Browser")
			System.setProperty("webdriver.chrome.driver", pro.getProperty("Chrome_Browser")); //System.getProperty("user.dir")+"//chrome//chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--disable-extention");
			dr = new ChromeDriver(op);
		}
		dr.manage().window().maximize();
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println(pro.getProperty("Chrome_Browser"));
		System.out.println(pro.getProperty("CareURL"));
	}

	public void navigate(String URL){
		dr.get(pro.getProperty(URL));
	}

	public void typeTextUser(String LocaterKey, String Data){
		getElement(LocaterKey).sendKeys(Data);
	}
	public void typeTextPass(String LocaterKey, String Data){
		getElement(LocaterKey).sendKeys(Data);
	}

	public void click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void reportFail(String LocaterKey){

	}
	
	public void WaitUntil_PageLoaded(){
		   JavascriptExecutor js = (JavascriptExecutor)dr;
		   String state = (String)js.executeScript("return document.readyState");
		   while(!state.equals("complete")){
			   Wait_Unti_ElementPresent(1);
			   state = (String)js.executeScript("return document.readyState");
		   }
	   }
	
	
	public void Wait_Unti_ElementPresent(int TimeInSec){
				try {
					Thread.sleep(TimeInSec * 1000);
				   } catch (InterruptedException e) {
					e.printStackTrace();
				}
		   }

	/********************** Switch Frame ************************/

	public void SwitchFrame_CustomerIDSearch(String LocaterKey){
		WebElement frameCustomerIDSearch = getElement(LocaterKey);
		dr.switchTo().frame(frameCustomerIDSearch);
	}

	public void switchFrameCustomerCapture(String LocaterKey){
		WebElement frameCustomerCapature = getElement(LocaterKey);
		dr.switchTo().frame(frameCustomerCapature);
	}

	public void switchCustomerCaptureIcone(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Add_Customer_Link(String LocaterKey){
		getElement(LocaterKey).click();
	}

	/*******************WFM tab switch Frame****************************/
	public void switchFrameWFM(String LocaterKey){
		WebElement frameWFM = getElement(LocaterKey);
		dr.switchTo().frame(frameWFM);
	}

	public void switchWFM_Tab_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void AgencyDashBoard_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void AgecnyCustomerSearchIcon(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Agency_customerID_search(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void Agency_cust_search_btn(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void radio_ByWorkOrder(String LocaterKey){
		WebElement radio_ByWorkOrder_Radio = getElement(LocaterKey);
		if(!radio_ByWorkOrder_Radio.isSelected()){
			radio_ByWorkOrder_Radio.click();
		}
	}
	public void WO_ID_search(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void SearchByWo_Click_btn(String LocaterKey){
		getElement(LocaterKey).click();
	} 

	public void WorkOrderLink_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}   

	public void visitRemark_Yes(String LocaterKey){
		WebElement Visit_Yes_Radio = getElement(LocaterKey);
		if(!Visit_Yes_Radio.isSelected()){
			Visit_Yes_Radio.click();
		}
	}

	public void visitRemark_No(String LocaterKey){
		WebElement Visit_No_Radio = getElement(LocaterKey);
		if(!Visit_No_Radio.isSelected()){
			Visit_No_Radio.click();
		}
	}

	public void Visit_Yes_txtRemark(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void Visit_No_txtRemark(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void NatureOfWork(String LocaterKey){
		Select WO_nature_Category= new Select(getElement(LocaterKey));
		WO_nature_Category.selectByVisibleText("Installation");
	}
	public void ResolutionCode(String LocaterKey){
		Select WO_ResolutionCode= new Select(getElement(LocaterKey));
		WO_ResolutionCode.selectByVisibleText("Installation - Normal / LCD Table Top Complete");
	}


	public void FR_NatureOfWork(String LocaterKey){
		Select FR_WO_nature_Category= new Select(getElement(LocaterKey));
		FR_WO_nature_Category.selectByVisibleText("Education");
	}
	
	public void FR_issue_observation(String LocaterKey){
		Select FR_WO_nature_Category= new Select(getElement(LocaterKey));
		FR_WO_nature_Category.selectByVisibleText("Remote Key not working - resolved by Battery re-fitted/ replaced");
	}
	
	
	public void FR_ResolutionCode(String LocaterKey){
		Select FR_WO_ResolutionCode= new Select(getElement(LocaterKey));
		FR_WO_ResolutionCode.selectByVisibleText("Automatically Resolved - No Visit Required");
	}

	public void ActionTaken(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void Activate_NI(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Complete_FR_WO(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Activation_alert_message(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Activation_Success_Message_message(String LocaterKey){
		getElement(LocaterKey).click();
	}
	
	public void Complete_FR_Success_Message(String LocaterKey){
		getElement(LocaterKey).click();
	}


	/*******************Agency Dash Board End ****************************/

	/*************************Inner Form Add Customer ****************************/

	public void switchMainframe(String LocaterKey){
		WebElement formAddCustomer = getElement(LocaterKey);
		dr.switchTo().frame(formAddCustomer);
	}

	public void CustomerDetails_Search_button(String LocaterKey){
		getElement(LocaterKey).click();
	}

	/************************Select Title**************************/

	public void selectTitle(String LocaterKey){

		Select title= new Select(getElement(LocaterKey));
		title.selectByVisibleText("MR.");
	}

	public void selectDevice_Model(String LocaterKey){
		Select modelCategory= new Select(getElement(LocaterKey));
		modelCategory.selectByVisibleText("SD");
	}

	public void firstName(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);

	}

	public void LastName(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);

	}

	public void Address1(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void LandMark(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void PinCode(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void PinCodeSearchIcon(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void selectPincode(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void RTN_1(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void RTN_1_CheckBox(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void DOB(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void DOB_Customer_Select(String LocaterKey){
		Select DOB_Select= new Select(getElement(LocaterKey));
		DOB_Select.selectByVisibleText("1990");
	}

	public void DealerName(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void DealerPhone(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void ClickNext(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void STBEnter(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	} 

	public void SmartCardEnter(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void SmartCardSearch_Icon_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Skip_button_click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Add_Select(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Add_Special_Addon(String LocaterKey){
		getElement(LocaterKey).click();
	}


	public void GetOffer(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Save_Customer_Offer(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void WorkOrderDescription(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void CallerNumber(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void Callertype(String LocaterKey){
		Select callerttype = new Select(getElement(LocaterKey));
		callerttype.selectByVisibleText("Customer");
	}

	public void Prceed_Button_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}



	/**********************Add_Product_Link***************************/

	public void Add_Product_Link(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void CustomerDetails_field(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void CustomerDetails_Search_btn(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Add_Product_button(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Email_survey_PopUp_window(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Email_Update_success_message(String LocaterKey){
		getElement(LocaterKey).click();
	}

	/**********************Element Found***************************/

	public WebElement getElement(String LocaterKey){
		WebElement e =null;
		if(LocaterKey.endsWith("_xpath"))
			e=dr.findElement(By.xpath(pro.getProperty(LocaterKey)));
		else if(LocaterKey.endsWith("_id"))
			e=dr.findElement(By.id(pro.getProperty(LocaterKey)));
		else if(LocaterKey.endsWith("_name"))
			e=dr.findElement(By.name(pro.getProperty(LocaterKey)));
		return e;
	}

	/********************* Reporting *******************************/
	
	public void Add_Customer_screenShot(){
		Date d = new Date();
		String FileName= d.toString().replace(" ", "_").replace(":", "_")+"_New_NI_Screen_.jpg";

		File screenSrc = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(screenSrc, new File(System.getProperty("user.dir")+"//Add_Customer_screenShot//"+FileName));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Add Screen Shot --> " + test.addScreenCapture(System.getProperty("user.dir")+"//Add_Customer_screenShot//"+FileName));
	}

	public void NIWO_Created_Successfully_ScreenShot(){
		Date d = new Date();
		String FileName= d.toString().replace(" ", "_").replace(":", "_")+"_NIWO_.jpg";

		File screenSrc = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(screenSrc, new File(System.getProperty("user.dir")+"//NIWO_Created_Successfully_ScreenShot//"+FileName));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Add Screen Shot --> " + test.addScreenCapture(System.getProperty("user.dir")+"//NIWO_Created_Successfully_ScreenShot//"+FileName));
	}

	public void Add_Product_ScreenShot(){
		Date d = new Date();
		String FileName= d.toString().replace(" ", "_").replace(":", "_")+"_Add_Product_.jpg";

		File screenSrc = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(screenSrc, new File(System.getProperty("user.dir")+"//Add_Product_ScreenShot//"+FileName));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Add Screen Shot --> " + test.addScreenCapture(System.getProperty("user.dir")+"//Add_Product_ScreenShot//"+FileName));
	}

	public void GLK_Customer_ScreenShot(){
		Date d = new Date();
		String FileName= d.toString().replace(" ", "_").replace(":", "_")+"_GLK_.jpg";

		File screenSrc = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(screenSrc, new File(System.getProperty("user.dir")+"//GLK_Customer_ScreenShot//"+FileName));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		//test.log(LogStatus.INFO, "Add Screen Shot --> " + test.addScreenCapture(System.getProperty("user.dir")+"//GLK_Customer_ScreenShot//"+FileName));
	}

	public void NewCareDashBoard_ScreenShot(){
		Date d = new Date();
		String FileName= d.toString().replace(" ", "_").replace(":", "_")+"_NewCareDashBorad_.jpg";

		File screenSrc = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(screenSrc, new File(System.getProperty("user.dir")+"//NewCare_DashBoard//"+FileName));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Add Screen Shot --> " + test.addScreenCapture(System.getProperty("user.dir")+"//NewCare_DashBoard//"+FileName));
	}

	public void AgencyDashBoard_ScreenShot(){
		Date d = new Date();
		String FileName= d.toString().replace(" ", "_").replace(":", "_")+"_AgencyDashBoard_.jpg";

		File screenSrc = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(screenSrc, new File(System.getProperty("user.dir")+"//AgencyDashBoard_ScreenShot//"+FileName));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		test.log(LogStatus.INFO, "Add Screen Shot --> " + test.addScreenCapture(System.getProperty("user.dir")+"//AgencyDashBoard_ScreenShot//"+FileName));
	}

	public void AgencyDashBoard_FR_WO_ScreenShot(){
		Date d = new Date();
		String FileName= d.toString().replace(" ", "_").replace(":", "_")+"_FR_WO_.jpg";

		File screenSrc = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(screenSrc, new File(System.getProperty("user.dir")+"//FR_WO_Complete_ScreenShot//"+FileName));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		test.log(LogStatus.INFO, "Add Screen Shot --> " + test.addScreenCapture(System.getProperty("user.dir")+"//FR_WO_Complete_ScreenShot//"+FileName));
	}

	public void FR_WO_ScreenShot(){
		Date d = new Date();
		String FileName= d.toString().replace(" ", "_").replace(":", "_")+"_FR_WO_.jpg";

		File screenSrc = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(screenSrc, new File(System.getProperty("user.dir")+"//FR_WO_ScreenShot//"+FileName));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Add Screen Shot --> " + test.addScreenCapture(System.getProperty("user.dir")+"//FR_WO_ScreenShot//"+FileName));
	}
	
	public void FTR_And_NFTR_SR_ScreenShot(){
		Date d = new Date();
		String FileName= d.toString().replace(" ", "_").replace(":", "_")+"_FTR_NFTR_SR_.jpg";

		File screenSrc = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(screenSrc, new File(System.getProperty("user.dir")+"//FTR_And_NFTR_SR_ScreenShot//"+FileName));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Add Screen Shot --> " + test.addScreenCapture(System.getProperty("user.dir")+"//FTR_And_NFTR_SR_ScreenShot//"+FileName));
	}
	
	public void FTR_NFTR_SR_Multi_Room_ScreenShot(){
		Date d = new Date();
		String FileName= d.toString().replace(" ", "_").replace(":", "_")+"_Multiroom_SR_.jpg";

		File screenSrc = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(screenSrc, new File(System.getProperty("user.dir")+"//FTR_NFTR_SR_Multi_Room_ScreenShot//"+FileName));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Add Screen Shot --> " + test.addScreenCapture(System.getProperty("user.dir")+"//FTR_NFTR_SR_Multi_Room_ScreenShot//"+FileName));
	}
	
	public void FR_WO_Multi_Room_ScreenShot(){
		Date d = new Date();
		String FileName= d.toString().replace(" ", "_").replace(":", "_")+"_FR_.jpg";

		File screenSrc = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		try{
			FileHandler.copy(screenSrc, new File(System.getProperty("user.dir")+"//FR_WO_Multi_Room_ScreenShot//"+FileName));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		test.log(LogStatus.INFO, "Add Screen Shot --> " + test.addScreenCapture(System.getProperty("user.dir")+"//FR_WO_Multi_Room_ScreenShot//"+FileName));
	}
	
	/**********************GLK CUstomer Creation Base Test***************************/ 

	public void glk_voucherRadio_btn_rediDirectSale(String LocaterKey){
		WebElement GLKRadio_btn = getElement(LocaterKey);
		if(!GLKRadio_btn.isSelected()){
			GLKRadio_btn.click();
		}
	}
	public void txtVoucher_PIN_number(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void txtVoucher_Serial_number(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void GLK_validation_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Select_D2H_package(String LocaterKey){
		Select cust_package= new Select(getElement(LocaterKey));
		cust_package.selectByVisibleText("NEW GOLD SPORTS");
	}

	public void GLK_OfferConfiguration_id(String LocaterKey){
		WebElement GLKRadio_Offer = getElement(LocaterKey);
		if(!GLKRadio_Offer.isSelected()){
			GLKRadio_Offer.click();
		}
	}

	public void Save_GLK_Customer_Offer(String LocaterKey){
		getElement(LocaterKey).click();
	}


	/**********************New Care DashBoard***************************/ 

	public void switchFrameCareDashBoard(String LocaterKey){
		WebElement frameCustomerSearch = getElement(LocaterKey);
		dr.switchTo().frame(frameCustomerSearch);
	}

	public void NewDashBoard_CustomerID_Search(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void NewDashBoard_CustomerID_Search_Icon_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void switchHeaderFrameCare(String LocaterKey){
		WebElement formCareHeader = getElement(LocaterKey);
		dr.switchTo().frame(formCareHeader);
	}

	public void Close_Popup_Window_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void RTN_Update_Link_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void RTN_Update_remove_Old(String LocaterKey){
		getElement(LocaterKey).clear();
	}

	public void RTN_1_Update(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void RTN_1_Callertype(String LocaterKey){
		Select CallerType_Cust_RTN_1= new Select(getElement(LocaterKey));
		CallerType_Cust_RTN_1.selectByVisibleText("Customer");
	}

	public void RTN_update_btn_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void RTN_AlertMessage(String LocaterKey){
		getElement(LocaterKey).click();
	}


	public void RTN_Update_Link_Click_RTN2(String LocaterKey){
		getElement(LocaterKey).click();
	}


	public void RTN_2_Update_remove_Old_RTN(String LocaterKey){
		getElement(LocaterKey).clear();
	}
	public void RTN_2_Update(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	/**** Email Updated Feature ********/

	public void Email_update_Link(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Email_update_Link_Old_Email_Remove(String LocaterKey){
		getElement(LocaterKey).clear();
	}

	public void Email_text(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void Email_Update_btn_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Email_alert_message(String LocaterKey){
		getElement(LocaterKey).click();
	} 

	public void Email_success_message(String LocaterKey){
		getElement(LocaterKey).click();
	}  

	/********************** Language Update *************************/

	public void language_update_Link_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void change_Language(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByVisibleText("Telugu");
	}

	public void langauge_Callertype(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByVisibleText("Customer");
	}

	public void langague_alert_message(String LocaterKey){
		getElement(LocaterKey).click();
	} 

	public void Search_RTN(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void Langauge_update_btn_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	/********************** Address Update *************************/
	public void Address_Update_Link(String LocaterKey){
		getElement(LocaterKey).click();
	} 

	public void Pincode_Search_icon(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Pincode_Link_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Address_Update_1_clear(String LocaterKey){
		getElement(LocaterKey).clear();
	}

	public void Address_Update_1_txt(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}
	public void Address_LandMark_clear(String LocaterKey){
		getElement(LocaterKey).clear();
	}

	public void Address_LandMark(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void Address_btn_UpdateAddress_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Sucess_message(String LocaterKey){
		getElement(LocaterKey).click();
	} 
	/********************** Balance History Update **********************/

	public void Balance_History_Link(String LocaterKey)
	{
		getElement(LocaterKey).click();
	}
	public void Balance_Popup_window_Close(String LocaterKey){
		getElement(LocaterKey).click();
	}

	/********************** YPWR request **********************/

	public void YPWR_Link(String LocaterKey){
		getElement(LocaterKey).click();
	}
	public void YPWR_Alert_message_OKbtn(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Success_message(String LocaterKey){
		getElement(LocaterKey).click();
	}

	/**********************Send YPWR SMS ******************/

	public void Send_YPWR_SMS_Link(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Select_RTN_YPWR_SMS(String LocaterKey){
		Select CallerType_Cust_RTN_1= new Select(getElement(LocaterKey));
		CallerType_Cust_RTN_1.selectByVisibleText("Others");
	}

	public void RTN_txt_OthersOption(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void btn_SendSMSOption(String LocaterKey){
		getElement(LocaterKey).click();
	}

	/**********************Send YPWR SMS END******************/


	public void cpe_reversal_link(String LocaterKey){
		getElement(LocaterKey).click();
	}  

	public void Success_CPE_message(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void DBR_link(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Re_Authorization_link(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void ReAuthorization_Alert_message_OK_btn(String LocaterKey){
		getElement(LocaterKey).click();
	}
	/*************************SMS Re-Authorization *******************************/
	public void SMS_reAuth_link(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Reconnect_link(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void ReConnect_Alert_message_OK_btn(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void CheckWarranty_link(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void CheckWarranty_Popup_window_Close(String LocaterKey){
		getElement(LocaterKey).click();
	}

	/************************Log Complaint FR Creation********************************/

	public void LogComplaint_link(String LocaterKey){
		getElement(LocaterKey).click();
	}

	public void Select_Device(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByIndex(1);
	}

	public void Select_Device_MultiRoom(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByIndex(1);
	} 
	
	public void Select_Device_MultiRoom_2(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByIndex(2);
	} 

	public void LogComplaint_CallerType(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByVisibleText("Customer");
	}    
	public void LogComplaint_Category(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByVisibleText("Complaint");
	}

	public void LogComplaint_Type(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByVisibleText("Service Related");
	}

	public void LogComplaint_SubType(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByVisibleText("Audio Problem");
	}

	public void LogComplaint_SUB_SubType(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByVisibleText("Volume Issues");
	}

	public void ComplaintDesc_txt_Clear(String LocaterKey){
		getElement(LocaterKey).clear();
	}
	
	public void ComplaintDesc_txt(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}

	public void Assign_btn(String LocaterKey){
		getElement(LocaterKey).click();
	}


	public void Cancle_btnProceedFromRTN(String LocaterKey){
		getElement(LocaterKey).click();
	}  

	public void FR_Service_Selection(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByIndex(1);
	}

	public void Proceed_btn(String LocaterKey){
		getElement(LocaterKey).click();
	}
	
	//  Multi Room FR WO creation Device select //
	
	public void Devce_Selection_MultiRoom_FR_WO_1(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByIndex(1);
	}

	public void Devce_Selection_MultiRoom_FR_WO_2(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByIndex(2);
	}
	
	public void Devce_Selection_MultiRoom_FR_WO_3(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByIndex(3);
	}
	
	public void Devce_Selection_MultiRoom_FR_WO_4(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByIndex(4);
	}
	
	public void ResolutionCode_1(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByIndex(1);
	}

	public void txtClosureRemarks(String LocaterKey, String data){
		getElement(LocaterKey).sendKeys(data);
	}  

	public void Resolve_btn_Click(String LocaterKey){
		getElement(LocaterKey).click();
	}  

	// NFTR --
	
	public void LogComplaint_NFTR_Type(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByVisibleText("Billing Related");
	}

	public void LogComplaint_NFTR_SubType(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByVisibleText("Balance deduction");
	}

	public void LogComplaint_NFTR_SUB_SubType(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByVisibleText("Balance Deduction under EDI Scheme");
	}

	public void LogComplaint_NFTR_New_SubType(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByVisibleText("Recharge Related");
	}

	public void LogComplaint_NFTR_New_SUB_SubType(String LocaterKey){
		Select select_Language= new Select(getElement(LocaterKey));
		select_Language.selectByVisibleText("Reversal-Credit Card/Net Bank Double Deduction");
	}

	/**********************End New Care DashBoard***************************/ 
	@AfterMethod
	public void teardown(){
		rep.endTest(test);
		rep.flush();
	   }
}
