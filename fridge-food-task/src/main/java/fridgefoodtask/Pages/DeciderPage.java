package fridgefoodtask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;

public class DeciderPage extends Navbar {
  WebElement answerBtn;
  WebElement pickOneResultBtn;
  WebElement startOverBtn;

  public DeciderPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public void clickAnswerBtn(String answer) {
    answerBtn = driver.findElement(By.linkText(answer));
    answerBtn.click();
  }

  public void clickPickOneResultBtn() {
    pickOneResultBtn = driver.findElement(By.linkText("Just Pick One I Can Make!"));
    pickOneResultBtn.click();
  }

  public void clickStartOverBtn() {
    startOverBtn = driver.findElement(By.linkText("Start Over"));
    startOverBtn.click();
  }
}
