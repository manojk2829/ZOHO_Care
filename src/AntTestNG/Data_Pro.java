package AntTestNG;

import org.testng.annotations.DataProvider;

public class Data_Pro {
   @DataProvider(name="RegisterData_Provider")
   public static Object[][] getdata(){
	   Object[][] oo = new Object[2][2];
	   oo[0][0] = "U1";
	   oo[0][1] = "P1";

	   oo[1][0] = "U2";
	   oo[1][1] = "P2";

	   return oo;
   }
}
