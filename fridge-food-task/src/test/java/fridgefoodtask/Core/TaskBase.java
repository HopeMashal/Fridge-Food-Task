package fridgefoodtask.Core;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TaskBase {
  @BeforeSuite
  public void beforeSuite() {
    System.out.println("Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
    System.out.println("After Suite");
  }
}
