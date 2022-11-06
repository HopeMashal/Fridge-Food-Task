package fridgefoodtask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import fridgefoodtask.Components.Navbar;

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
    firstNameBox = driver.findElement(By.id("txtfname"));
    return firstNameBox.getAttribute("value");
  }

  public String getLastNameValue() {
    lastNameBox = driver.findElement(By.id("txtlname"));
    return lastNameBox.getAttribute("value");
  }

  public String getCountryValue() {
    countryBox = driver.findElement(By.id("ddcountry"));
    return countryBox.getAttribute("value");
  }

  public String getStateValue() {
    if (driver.findElements(By.cssSelector("select[id='ddstate']>option")).size() > 2) {
      stateBox = driver.findElement(By.id("ddstate"));
    } else {
      stateBox = driver.findElement(By.id("txtstate"));
    }
    return stateBox.getAttribute("value");
  }

  public String getCityValue() {
    cityBox = driver.findElement(By.id("txtCity"));
    return cityBox.getAttribute("value");
  }

  public void editProfile(String firstName, String lastName, String country, String state, String city){
    firstNameBox = driver.findElement(By.id("txtfname"));
    firstNameBox.clear();
    firstNameBox.sendKeys(firstName);
    lastNameBox = driver.findElement(By.id("txtlname"));
    lastNameBox.clear();
    lastNameBox.sendKeys(lastName);
    countryBox = driver.findElement(By.id("ddcountry"));
    Select countries = new Select(countryBox);
    countries.selectByValue(country);
    if (driver.findElements(By.cssSelector("select[id='ddstate']>option")).size() > 2) {
      stateBox = driver.findElement(By.id("ddstate"));
      Select states = new Select(stateBox);
      states.selectByValue(state);
    } else {
      stateBox = driver.findElement(By.id("txtstate"));
      stateBox.clear();
      stateBox.sendKeys(state);
    }
    cityBox = driver.findElement(By.id("txtCity"));
    cityBox.clear();
    cityBox.sendKeys(city);
  }

  public void clickSubmitBtn() {
    submitBtn = driver.findElement(By.id("getbutton"));
    submitBtn.click();
  }
}
