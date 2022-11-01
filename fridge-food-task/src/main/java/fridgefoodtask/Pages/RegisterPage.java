package fridgefoodtask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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
    firstNameBox = driver.findElement(By.id("txtfname"));
    firstNameBox.sendKeys(firstName);
    lastNameBox = driver.findElement(By.id("txtlname"));
    lastNameBox.sendKeys(lastName);
    countryBox = driver.findElement(By.id("ddcountry"));
    Select countries = new Select(countryBox);
    countries.selectByValue(country);
    if (!driver.findElements(By.id("ddstate")).isEmpty()) {
      stateBox = driver.findElement(By.id("ddstate"));
      Select states = new Select(stateBox);
      states.selectByValue(state);
    } else {
      stateBox = driver.findElement(By.id("txtstate"));
      stateBox.sendKeys(state);
    }
    cityBox = driver.findElement(By.id("txtCity"));
    cityBox.sendKeys(city);
    emailBox = driver.findElement(By.id("txtEmail"));
    emailBox.sendKeys(email);
    passwordBox = driver.findElement(By.id("txtPassword"));
    passwordBox.sendKeys(password);
    confirmPasswordBox = driver.findElement(By.id("txtconfirmpassword"));
    confirmPasswordBox.sendKeys(password);
    submitBtn = driver.findElement(By.id("getbutton"));
    submitBtn.click();
  }
}
