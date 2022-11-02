package fridgefoodtask.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;

public class CopyrightPolicyPage extends Navbar {
  WebElement firstElement;
  List<WebElement> ElementsList;

  public CopyrightPolicyPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public String getFirstElement() {
    firstElement = driver.findElement(By.cssSelector("div[class='content-main']>div>span"));
    return firstElement.getText();
  }

  public List<String> getSecondElement() {
    ElementsList = driver.findElements(By.xpath("//*[@class='content-main']/div"));
    List<String> elementList = new ArrayList<String>();
    for (int i = 0; i < 11; i++) {
      int index = 6 + (2 * i);
      elementList.add(ElementsList.get(index).getText());
    }
    return elementList;
  }

  public List<String> getThirdElement() {
    ElementsList = driver.findElements(By.xpath("//*[@class='content-main']/ul[1]/li"));
    List<String> elementList = new ArrayList<String>();
    for (WebElement element : ElementsList) {
      elementList.add(element.getText());
    }
    return elementList;
  }

  public List<String> getFourthElement() {
    ElementsList = driver.findElements(By.xpath("//*[@class='content-main']/div"));
    List<String> elementList = new ArrayList<String>();
    for (int i = 0; i < 2; i++) {
      int index = 29 + (2 * i);
      elementList.add(ElementsList.get(index).getText());
    }
    return elementList;
  }

  public List<String> getFifthElement() {
    ElementsList = driver.findElements(By.xpath("//*[@class='content-main']/ul[2]/li"));
    List<String> elementList = new ArrayList<String>();
    for (WebElement element : ElementsList) {
      elementList.add(element.getText());
    }
    return elementList;
  }

  public List<String> getSixthElement() {
    ElementsList = driver.findElements(By.xpath("//*[@class='content-main']/p"));
    List<String> elementList = new ArrayList<String>();
    for (WebElement element : ElementsList) {
      elementList.add(element.getText());
    }
    return elementList;
  }

  public List<String> getSeventhElement() {
    ElementsList = driver.findElements(By.xpath("//*[@class='content-main']/ul[3]/li"));
    List<String> elementList = new ArrayList<String>();
    for (WebElement element : ElementsList) {
      elementList.add(element.getText());
    }
    return elementList;
  }
}
