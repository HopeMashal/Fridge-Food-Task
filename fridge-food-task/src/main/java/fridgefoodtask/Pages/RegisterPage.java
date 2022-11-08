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
    // TODO Auto-generated constructor stub
  }

  public void registerMethod(String firstName, String lastName, String country, String state, String city, String email,
      String password) {
    firstNameBox = driver.findElement(By.id(Constants.FirstNameBoxID));
    firstNameBox.sendKeys(firstName);
    lastNameBox = driver.findElement(By.id(Constants.LastNameBoxID));
    lastNameBox.sendKeys(lastName);
    countryBox = driver.findElement(By.id(Constants.CountryBoxID));
    Select countries = new Select(countryBox);
    countries.selectByValue(country);
    if (driver.findElements(By.cssSelector(Constants.CheckStateCssSelector)).size() > 2) {
      stateBox = driver.findElement(By.id(Constants.StateSelectID));
      Select states = new Select(stateBox);
      states.selectByValue(state);
    } else {
      stateBox = driver.findElement(By.id(Constants.StateBoxID));
      stateBox.sendKeys(state);
    }
    cityBox = driver.findElement(By.id(Constants.CityBoxID));
    cityBox.sendKeys(city);
    emailBox = driver.findElement(By.id(Constants.EmailBoxID));
    emailBox.sendKeys(email);
    passwordBox = driver.findElement(By.id(Constants.PasswordBoxID));
    passwordBox.sendKeys(password);
    confirmPasswordBox = driver.findElement(By.id(Constants.ConfirmPasswordBoxID));
    confirmPasswordBox.sendKeys(password);
  }

  public void clickSubmitBtn() {
    submitBtn = driver.findElement(By.id(Constants.SubmitBtnID));
    submitBtn.click();
  }
}
