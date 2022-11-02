package fridgefoodtask.PagesTest;

import java.io.IOException;

import org.testng.annotations.Test;

import fridgefoodtask.Core.TaskBase;

public class NavbarTest extends TaskBase {
  @Test
  public void BeforeSignIn() throws IOException {
    System.out.println("Navbar - Before Sign In");
  }

  @Test
  public void AfterSignIn() {
    System.out.println("Navbar - After Sign In");
  }
}
