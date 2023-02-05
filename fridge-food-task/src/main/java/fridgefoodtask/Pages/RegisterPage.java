package fridgefoodtask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import fridgefoodtask.Components.Navbar;
import fridgefoodtask.Core.Constants;

public class RegisterPage extends Navbar {
  WebElement firstNameBox;
  WebElement lastNameBox;
  WebElement countryBox;
  WebElement stateBox;
  WebElement cityBox;
  WebElement emailBox;
  WebElement passwordBox;
  WebElement confirmPasswordBox;
  WebElement submitBtn;

  public RegisterPage(WebDriver driver) {
    super(driver);
  }

  public void registerMethod(String firstName, String lastName, String country, String state, String city, String email,
      String password) {
    try {
      firstNameBox = driver.findElement(By.id(Constants.FirstNameBoxID));
      firstNameBox.sendKeys(firstName);
    } catch (Exception e) {
      System.out.println("CAN'T FIND FIRST NAME BOX");
    }
    try {
      lastNameBox = driver.findElement(By.id(Constants.LastNameBoxID));
      lastNameBox.sendKeys(lastName);
    } catch (Exception e) {
      System.out.println("CAN'T FIND LAST NAME BOX");
    }
    try {
      countryBox = driver.findElement(By.id(Constants.CountryBoxID));
      Select countries = new Select(countryBox);
      countries.selectByValue(country);
    } catch (Exception e) {
      System.out.println("CAN'T FIND COUNTRY BOX");
    }
    try {
      if (driver.findElements(By.cssSelector(Constants.CheckStateCssSelector)).size() > 2) {
        stateBox = driver.findElement(By.id(Constants.StateSelectID));
        Select states = new Select(stateBox);
        states.selectByValue(state);
      } else {
        stateBox = driver.findElement(By.id(Constants.StateBoxID));
        stateBox.sendKeys(state);
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND STATE BOX");
    }
    try {
      cityBox = driver.findElement(By.id(Constants.CityBoxID));
      cityBox.sendKeys(city);
    } catch (Exception e) {
      System.out.println("CAN'T FIND CITY BOX");
    }
    try {
      emailBox = driver.findElement(By.id(Constants.EmailBoxID));
      emailBox.sendKeys(email);
    } catch (Exception e) {
      System.out.println("CAN'T FIND EMAIL BOX");
    }
    try {
      passwordBox = driver.findElement(By.id(Constants.PasswordBoxID));
      passwordBox.sendKeys(password);
    } catch (Exception e) {
      System.out.println("CAN'T FIND PASSWORD BOX");
    }
    try {
      confirmPasswordBox = driver.findElement(By.id(Constants.ConfirmPasswordBoxID));
      confirmPasswordBox.sendKeys(password);
    } catch (Exception e) {
      System.out.println("CAN'T FIND CONFIRM PASSWORD BOX");
    }
  }

  public void clickSubmitBtn() {
    try {
      submitBtn = driver.findElement(By.id(Constants.SubmitBtnID));
      submitBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND SUBMIT BUTTON");
    }
  }
}
