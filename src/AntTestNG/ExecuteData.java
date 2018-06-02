package AntTestNG;

import org.testng.annotations.Test;

public class ExecuteData {
  @Test(dataProviderClass=DataProviderClass.class,dataProvider="RegisterDataProvider")
  public void ExecutionOfCode(String user,String pass,String ID, String Email){
	  System.out.println(user + "|--" +pass + "|--" + ID + "| " + Email);
  }
  
  
  @Test(dataProviderClass=Data_Pro.class,dataProvider="RegisterData_Provider")
  public void ExecutionOfCode(String name,String Pass){
	  System.out.println(name + "  |  " +Pass);
  }
}
