package fridgefoodtask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;
import fridgefoodtask.Core.Constants;

public class LogInPage extends Navbar {
  WebElement emailBox;
  WebElement passwordBox;
  WebElement loginBtn;
  WebElement registerBtn;

  public LogInPage(WebDriver driver) {
    super(driver);
  }

  public void LogInMethod(String email, String password) {
    try {
      emailBox = driver.findElement(By.id(Constants.EmailBoxID));
      emailBox.sendKeys(email);
      passwordBox = driver.findElement(By.id(Constants.PasswordBoxID));
      passwordBox.sendKeys(password);
    } catch (Exception e) {
      System.out.println("CAN'T FILL LOGIN INPUTS");
    }
  }

  public void clickSubmitBtn() {
    try {
      loginBtn = driver.findElement(By.id(Constants.SubmitBtnID));
      loginBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND SUBMIT BUTTON");
    }
  }

  public void clickRegisterBtn() {
    try {
      registerBtn = driver.findElement(By.id(Constants.RegistrationBtnID));
      registerBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND REGISTER BUTTON");
    }
  }
}
