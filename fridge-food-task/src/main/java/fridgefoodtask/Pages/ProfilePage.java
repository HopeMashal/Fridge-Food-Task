package fridgefoodtask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import fridgefoodtask.Components.Navbar;
import fridgefoodtask.Core.Constants;

public class ProfilePage extends Navbar {
  WebElement firstNameBox;
  WebElement lastNameBox;
  WebElement countryBox;
  WebElement stateBox;
  WebElement cityBox;
  WebElement submitBtn;

  public ProfilePage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public String getFirstNameValue() {
    firstNameBox = driver.findElement(By.id(Constants.FirstNameBoxID));
    return firstNameBox.getAttribute("value");
  }

  public String getLastNameValue() {
    lastNameBox = driver.findElement(By.id(Constants.LastNameBoxID));
    return lastNameBox.getAttribute("value");
  }

  public String getCountryValue() {
    countryBox = driver.findElement(By.id(Constants.CountryBoxID));
    return countryBox.getAttribute("value");
  }

  public String getStateValue() {
    if (driver.findElements(By.cssSelector(Constants.CheckStateCssSelector)).size() > 2) {
      stateBox = driver.findElement(By.id(Constants.StateSelectID));
    } else {
      stateBox = driver.findElement(By.id(Constants.StateBoxID));
    }
    return stateBox.getAttribute("value");
  }

  public String getCityValue() {
    cityBox = driver.findElement(By.id(Constants.CityBoxID));
    return cityBox.getAttribute("value");
  }

  public void editProfile(String firstName, String lastName, String country, String state, String city) {
    firstNameBox = driver.findElement(By.id(Constants.FirstNameBoxID));
    firstNameBox.clear();
    firstNameBox.sendKeys(firstName);
    lastNameBox = driver.findElement(By.id(Constants.LastNameBoxID));
    lastNameBox.clear();
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
      stateBox.clear();
      stateBox.sendKeys(state);
    }
    cityBox = driver.findElement(By.id(Constants.CityBoxID));
    cityBox.clear();
    cityBox.sendKeys(city);
  }

  public void clickSubmitBtn() {
    submitBtn = driver.findElement(By.id(Constants.SubmitBtnID));
    submitBtn.click();
  }
}
