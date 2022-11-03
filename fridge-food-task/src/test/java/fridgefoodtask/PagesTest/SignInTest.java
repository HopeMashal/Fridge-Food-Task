package fridgefoodtask.PagesTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import fridgefoodtask.Core.Constant;
import fridgefoodtask.Core.PropertiesFile;
import fridgefoodtask.Core.TaskBase;
import fridgefoodtask.Pages.SignInPage;
import io.qameta.allure.Allure;

public class SignInTest extends TaskBase {
  @Test
  public void SignInTesting() throws IOException {
    Allure.step("Go to Login Page Using Navbar Method");
    SignInPage signInPage = new SignInPage(driver);
    signInPage.clickLoginBtn();

    Allure.step("Check URL & Title of Login Page");
    String[] loginHref = signInPage.loginHref();
    Assert.assertEquals(driver.getTitle(), loginHref[0], "Title of Login Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), loginHref[1], "URL of Login Page NOT MATCH");

    Allure.step("Get Data From props.properties File");
    String email = PropertiesFile.getProperty(Constant.getPropertiesFilesPath() + "props.properties", "email");
    String password = PropertiesFile.getProperty(Constant.getPropertiesFilesPath() + "props.properties", "password");

    Allure.step("Attach props.properties File");
    File propertiesFile = new File(Constant.getPropertiesFilesPath() + "props.properties");
    allureAttached.addFile(propertiesFile, "txt");

    Allure.step("Fill Data For Sign In Method");
    signInPage.signInMethod(email, password);

    Allure.step("After Fill Data in Log In Page - Take Screen Shot");
    File afterFillDataInLogInPage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "SignInTest/afterFillDataInLogInPage.jpg");
    Allure.addAttachment(
        afterFillDataInLogInPage.getName(),
        FileUtils.openInputStream(afterFillDataInLogInPage));

    Allure.step("Click Submit Button in Log In Page");
    signInPage.clickSubmitBtn();

    Allure.step("Accept Alert - Login Message");
    try {
      Thread.sleep(5000);
      driver.switchTo().alert().accept();
    } catch (Exception e) {
      Assert.fail("Login Failed");
    }

    Allure.step("After Sign In - Take Screen Shot");
    File afterSignIn = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "SignInTest/afterSignIn.jpg");
    Allure.addAttachment(
        afterSignIn.getName(),
        FileUtils.openInputStream(afterSignIn));
  }

}
