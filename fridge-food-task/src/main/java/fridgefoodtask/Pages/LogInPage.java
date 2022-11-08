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
    // TODO Auto-generated constructor stub
  }

  public void LogInMethod(String email, String password) {
    emailBox = driver.findElement(By.id(Constants.EmailBoxID));
    emailBox.sendKeys(email);
    passwordBox = driver.findElement(By.id(Constants.PasswordBoxID));
    passwordBox.sendKeys(password);
  }

  public void clickSubmitBtn() {
    loginBtn = driver.findElement(By.id(Constants.SubmitBtnID));
    loginBtn.click();
  }

  public void clickRegisterBtn() {
    registerBtn = driver.findElement(By.id(Constants.RegistrationBtnID));
    registerBtn.click();
  }
}
