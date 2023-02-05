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
  }

  public String getFirstNameValue() {
    String firstName;
    try {
      firstNameBox = driver.findElement(By.id(Constants.FirstNameBoxID));
      firstName = firstNameBox.getAttribute("value");
    } catch (Exception e) {
      System.out.println("CAN'T FIND FIRST NAME BOX");
      firstName = "NONE";
    }
    return firstName;
  }

  public String getLastNameValue() {
    String lastName;
    try {
      lastNameBox = driver.findElement(By.id(Constants.LastNameBoxID));
      lastName = lastNameBox.getAttribute("value");
    } catch (Exception e) {
      System.out.println("CAN'T FIND LAST NAME BOX");
      lastName = "NONE";
    }
    return lastName;
  }

  public String getCountryValue() {
    String country;
    try {
      countryBox = driver.findElement(By.id(Constants.CountryBoxID));
      country = countryBox.getAttribute("value");
    } catch (Exception e) {
      System.out.println("CAN'T FIND COUNTRY BOX");
      country = "NONE";
    }
    return country;
  }

  public String getStateValue() {
    String state;
    try {
      if (driver.findElements(By.cssSelector(Constants.CheckStateCssSelector)).size() > 2) {
        stateBox = driver.findElement(By.id(Constants.StateSelectID));
      } else {
        stateBox = driver.findElement(By.id(Constants.StateBoxID));
      }
      state = stateBox.getAttribute("value");
    } catch (Exception e) {
      System.out.println("CAN'T FIND STATE BOX");
      state = "NONE";
    }
    return state;
  }

  public String getCityValue() {
    String city;
    try {
      cityBox = driver.findElement(By.id(Constants.CityBoxID));
      city = cityBox.getAttribute("value");
    } catch (Exception e) {
      System.out.println("CAN'T FIND CITY BOX");
      city = "NONE";
    }
    return city;
  }

  public void editProfile(String firstName, String lastName, String country, String state, String city) {
    try {
      firstNameBox = driver.findElement(By.id(Constants.FirstNameBoxID));
      firstNameBox.clear();
      firstNameBox.sendKeys(firstName);
    } catch (Exception e) {
      System.out.println("CAN'T FIND FIRST NAME BOX");
    }
    try {
      lastNameBox = driver.findElement(By.id(Constants.LastNameBoxID));
      lastNameBox.clear();
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
        stateBox.clear();
        stateBox.sendKeys(state);
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND STATE BOX");
    }
    try {
      cityBox = driver.findElement(By.id(Constants.CityBoxID));
      cityBox.clear();
      cityBox.sendKeys(city);
    } catch (Exception e) {
      System.out.println("CAN'T FIND CITY BOX");
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
