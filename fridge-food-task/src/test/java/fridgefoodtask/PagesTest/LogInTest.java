package fridgefoodtask.PagesTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import fridgefoodtask.Core.Constant;
import fridgefoodtask.Core.PropertiesFile;
import fridgefoodtask.Core.TaskBase;
import fridgefoodtask.Pages.LogInPage;
import io.qameta.allure.Allure;

public class LogInTest extends TaskBase {
  @Test
  public void LogInTesting() throws IOException {
    Allure.step("Go to Login Page Using clickLoginBtn Method");
    LogInPage logInPage = new LogInPage(driver);
    logInPage.clickLoginBtn();

    Allure.step("Check URL & Title of Login Page");
    String[] loginHref = logInPage.loginHref();
    Assert.assertEquals(driver.getTitle(), loginHref[0], "Title of Login Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), loginHref[1], "URL of Login Page NOT MATCH");

    Allure.step("Get Data From props.properties File");
    String propFilePath = Constant.getPropertiesFilesPath() + "props.properties";
    String email = PropertiesFile.getProperty(propFilePath, "email");
    String password = PropertiesFile.getProperty(propFilePath, "password");

    Allure.step("Attach props.properties File");
    File propertiesFile = new File(propFilePath);
    allureAttached.addFile(propertiesFile, "txt");

    Allure.step("Fill Data in LogInMethod");
    logInPage.LogInMethod(email, password);

    Allure.step("Scroll Down 350px to Show Login Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("After Fill Data in Log In Page - Take Screen Shot");
    File afterFillDataInLogInPage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "LogInTest/afterFillDataInLogInPage.jpg");
    Allure.addAttachment(
        afterFillDataInLogInPage.getName(),
        FileUtils.openInputStream(afterFillDataInLogInPage));

    Allure.step("Click Submit Button in Log In Page");
    logInPage.clickSubmitBtn();

    Allure.step("Accept Alert - Login Message");
    try {
      Thread.sleep(5000);
      driver.switchTo().alert().accept();
    } catch (Exception e) {
      Assert.fail("Login Failed");
    }

    Allure.step("After Log In - Take Screen Shot");
    File afterLogIn = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "LogInTest/afterLogIn.jpg");
    Allure.addAttachment(
        afterLogIn.getName(),
        FileUtils.openInputStream(afterLogIn));
  }

}
