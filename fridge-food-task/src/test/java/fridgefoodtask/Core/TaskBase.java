package fridgefoodtask.Core;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import fridgefoodtask.Components.Navbar;
import io.qameta.allure.Allure;

public class TaskBase {
  public static WebDriver driver;
  public static TakeScreenShot takeScreenShot;

  @BeforeSuite
  public void beforeSuite() throws IOException {
    Allure.step("Open Headless Chrome Browser");
    driver = OpenBrowser.openChromeWithOptions();
    takeScreenShot = new TakeScreenShot(driver);
    driver.manage().window().setSize(new Dimension(1280, 900));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

    Allure.step("Open MyFridgeFood.com");
    driver.get(Constant.getURL());

    Allure.step("After Open MyFridgeFood.com - Take Screen Shot");
    File afterOpenMyFridgeFoodPage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "TaskBase/afterOpenMyFridgeFoodPage.jpg");
    Allure.addAttachment(
        afterOpenMyFridgeFoodPage.getName(),
        FileUtils.openInputStream(afterOpenMyFridgeFoodPage));
  }

  @BeforeTest
  public void beforeTest() {
    Allure.step("Go to Home Page Using Navbar Method");
    Navbar navbar = new Navbar(driver);
    navbar.clickHomeBtn();

    Allure.step("Check URL & Title of Home Page");
    String[] homeHref = navbar.homeHref();
    Assert.assertEquals(driver.getTitle(), homeHref[0], "Title of Home Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), homeHref[1], "URL of Home Page NOT MATCH");
  }

  @AfterTest
  public void afterTest() {

  }

  @AfterSuite
  public void afterSuite() throws IOException {
    Allure.step("Click Log Out Button");
    Navbar navbar = new Navbar(driver);
    navbar.clickLogoutBtn();

    Allure.step("After Log Out - Check URL & Title of Home Page");
    String[] homeHref = navbar.logoutHref();
    Assert.assertEquals(driver.getTitle(), homeHref[0], "Title of Home Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), homeHref[1], "URL of Home Page NOT MATCH");

    Allure.step("After Click Log Out Button - Take Screen Shot");
    File afterClickLogOutBtn = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "TaskBase/afterClickLogOutBtn.jpg");
    Allure.addAttachment(
        afterClickLogOutBtn.getName(),
        FileUtils.openInputStream(afterClickLogOutBtn));

    Allure.step("Close Headless Chrome Browser");
    driver.quit();
  }
}
