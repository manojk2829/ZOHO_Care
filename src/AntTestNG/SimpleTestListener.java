package AntTestNG;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class SimpleTestListener {
  @Test
  public void test1(){
	  System.out.println("Open Browser");
  }
  
  @Test
  public void test2(){
	  System.out.println("Skipped....");
	  throw new SkipException("Skip my this Test....");
  }

  @Test
  public void test3(){
	  System.out.println("Fail....");
      Assert.assertEquals("A", "B");
  }
}
