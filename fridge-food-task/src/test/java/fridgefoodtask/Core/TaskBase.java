package fridgefoodtask.Core;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import fridgefoodtask.Components.Navbar;
import io.qameta.allure.Allure;

public class TaskBase {
  public static WebDriver driver;
  public static TakeScreenShot takeScreenShot;
  public static AllureAttached allureAttached = new AllureAttached();
  public static JavascriptExecutor JavaScript;

  @BeforeSuite
  public void beforeSuite() throws IOException {
    Allure.step("Open Headless Chrome Browser");
    driver = OpenBrowser.openChromeWithOptions();
    takeScreenShot = new TakeScreenShot(driver);
    JavaScript = (JavascriptExecutor) driver;
    driver.manage().window().setSize(new Dimension(1280, 900));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

    Allure.step("Open MyFridgeFood.com");
    driver.get(Constants.URL);

    Allure.step("After Open MyFridgeFood.com - Take Screen Shot");
    File afterOpenMyFridgeFoodPage = takeScreenShot
        .takeScreenShot(Constants.ScreenShotsPath + "TaskBase/afterOpenMyFridgeFoodWebsite.jpg");
    allureAttached.addImage(afterOpenMyFridgeFoodPage);
  }

  @AfterSuite
  public void afterSuite() throws IOException {
    Allure.step("Click Log Out Button");
    Navbar navbar = new Navbar(driver);
    navbar.clickLogoutBtn();

    Allure.step("Close Headless Chrome Browser");
    driver.quit();
  }
}
