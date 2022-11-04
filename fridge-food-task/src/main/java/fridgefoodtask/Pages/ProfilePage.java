package fridgefoodtask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;

public class ProfilePage extends Navbar {
  WebElement firstNameBox;
  WebElement lastNameBox;
  WebElement countryBox;
  WebElement stateBox;
  WebElement cityBox;

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
}
