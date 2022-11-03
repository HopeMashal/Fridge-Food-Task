package fridgefoodtask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;

public class SignInPage extends Navbar {
  WebElement emailBox;
  WebElement passwordBox;
  WebElement loginBtn;
  WebElement registerBtn;

  public SignInPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public void signInMethod(String email, String password) {
    emailBox = driver.findElement(By.id("txtEmail"));
    emailBox.sendKeys(email);
    passwordBox = driver.findElement(By.id("txtpassword"));
    passwordBox.sendKeys(password);
  }

  public void clickSubmitBtn() {
    loginBtn = driver.findElement(By.id("getbutton"));
    loginBtn.click();
  }

  public void clickRegisterBtn() {
    registerBtn = driver.findElement(By.id("registration"));
    registerBtn.click();
  }
}
