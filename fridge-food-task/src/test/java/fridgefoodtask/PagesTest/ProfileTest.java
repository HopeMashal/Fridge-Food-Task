package fridgefoodtask.PagesTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import fridgefoodtask.Core.Constant;
import fridgefoodtask.Core.PropertiesFile;
import fridgefoodtask.Core.TaskBase;
import fridgefoodtask.Pages.ProfilePage;
import io.qameta.allure.Allure;

public class ProfileTest extends TaskBase {
  @Test
  public void ProfileTesting() throws IOException, InterruptedException {
    Allure.step("Go to Profile Page Using clickMyProfileBtn Method");
    ProfilePage profilePage = new ProfilePage(driver);
    profilePage.clickMyProfileBtn();

    Allure.step("Check URL & Title of Profile Page");
    String[] profileHref = profilePage.myProfileHref();
    Assert.assertEquals(driver.getTitle(), profileHref[0], "Title of Profile Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), profileHref[1], "URL of Profile Page NOT MATCH");

    Allure.step("Get Data From props.properties File");
    String propFilePath = Constant.getPropertiesFilesPath() + "props.properties";
    String firstName = PropertiesFile.getProperty(propFilePath, "firstName");
    String lastName = PropertiesFile.getProperty(propFilePath, "lastName");
    String country = PropertiesFile.getProperty(propFilePath, "country");
    String state = PropertiesFile.getProperty(propFilePath, "state");
    String city = PropertiesFile.getProperty(propFilePath, "city");

    Allure.step("Attach props.properties File");
    File propertiesFile = new File(propFilePath);
    allureAttached.addFile(propertiesFile, "txt");

    Allure.step("Scroll Down 350px to Show Profile Page");
    JavaScript.executeScript("window.scrollTo(0,350)");
    Thread.sleep(3000);

    Allure.step("After Open Profile Page - Take Screen Shot");
    File myProfilePage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "ProfileTest/afterOpenProfilePage.jpg");
    Allure.addAttachment(
        myProfilePage.getName(),
        FileUtils.openInputStream(myProfilePage));

    Allure.step("Compare Data From My Profile Page with Registration Data");
    Assert.assertEquals(profilePage.getFirstNameValue(), firstName, "First Name NOT MATCH");
    Assert.assertEquals(profilePage.getLastNameValue(), lastName, "Last Name NOT MATCH");
    Assert.assertEquals(profilePage.getCountryValue(), country, "Country NOT MATCH");
    Assert.assertEquals(profilePage.getStateValue(), state, "State NOT MATCH");
    Assert.assertEquals(profilePage.getCityValue(), city, "City NOT MATCH");
  }
}
