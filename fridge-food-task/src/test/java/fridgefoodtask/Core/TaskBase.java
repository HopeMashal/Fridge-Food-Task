package fridgefoodtask.Core;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TaskBase {
  @BeforeSuite
  public void beforeSuite() {
    System.out.println("Before Suite");
  }

  @BeforeTest
  public void beforeTest(){
    System.out.println("Before Test");
  }

  @AfterSuite
  public void afterSuite() {
    System.out.println("After Suite");
  }
}
