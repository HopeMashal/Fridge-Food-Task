package fridgefoodtask.PagesTest;

import org.testng.annotations.Test;

import fridgefoodtask.Core.TaskBase;

public class NavbarTest extends TaskBase {
  @Test
  public void BeforeSignIn() {
    System.out.println("Navbar - Before Sign In");
  }

  @Test
  public void AfterSignIn() {
    System.out.println("Navbar - After Sign In");
  }
}
