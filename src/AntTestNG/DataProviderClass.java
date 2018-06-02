package AntTestNG;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	@DataProvider(name="RegisterDataProvider")
   public static Object[][] getDate(){
	   Object[][] obj = new Object[3][4];
	   obj[0][0] = "user1";
	   obj[0][1] = "P1";
	   obj[0][2] = "ID1";
	   obj[0][3] = "Email1";
	   
	   obj[1][0] = "user2";
	   obj[1][1] = "P2";
	   obj[1][2] = "ID2";
	   obj[1][3] = "Email2";
	   
	   obj[2][0] = "user3";
	   obj[2][1] = "P3";
	   obj[2][2] = "ID3";
	   obj[2][3] = "Email3";
	   
	   return obj;
   }
}
