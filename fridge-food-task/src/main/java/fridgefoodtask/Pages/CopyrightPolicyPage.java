package fridgefoodtask.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;
import fridgefoodtask.Core.Constants;

public class CopyrightPolicyPage extends Navbar {
  WebElement firstElement;
  List<WebElement> ElementsList;

  public CopyrightPolicyPage(WebDriver driver) {
    super(driver);
  }

  public String getFirstElement() {
    String firstElementText;
    try {
      firstElement = driver.findElement(By.cssSelector(Constants.CopyrightFirstElementCssSelector));
      firstElementText = firstElement.getText();
    } catch (Exception e) {
      System.out.println("CAN'T FIND FIRST ELEMENT");
      firstElementText = "NONE";
    }
    return firstElementText;
  }

  public List<String> getSecondElement() {
    List<String> elementList = new ArrayList<String>();
    try {
      ElementsList = driver.findElements(By.xpath(Constants.CopyrightSecondFourthElementXPath));
      for (int i = 0; i < 11; i++) {
        int index = 5 + (2 * i);
        elementList.add(ElementsList.get(index).getText());
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND SECOND ELEMENT");
    }
    return elementList;
  }

  public List<String> getThirdElement() {
    List<String> elementList = new ArrayList<String>();
    try {
      ElementsList = driver.findElements(By.xpath(Constants.CopyrightListXPath(1)));
      for (WebElement element : ElementsList) {
        elementList.add(element.getText());
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND THIRD ELEMENT");
    }
    return elementList;
  }

  public List<String> getFourthElement() {
    List<String> elementList = new ArrayList<String>();
    try {
      ElementsList = driver.findElements(By.xpath(Constants.CopyrightSecondFourthElementXPath));
      for (int i = 0; i < 2; i++) {
        int index = 28 + (2 * i);
        elementList.add(ElementsList.get(index).getText());
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND FOURTH ELEMENT");
    }
    return elementList;
  }

  public List<String> getFifthElement() {
    List<String> elementList = new ArrayList<String>();
    try {
      ElementsList = driver.findElements(By.xpath(Constants.CopyrightListXPath(2)));
      for (WebElement element : ElementsList) {
        elementList.add(element.getText());
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND FIFTH ELEMENT");
    }
    return elementList;
  }

  public List<String> getSixthElement() {
    List<String> elementList = new ArrayList<String>();
    try {
      ElementsList = driver.findElements(By.xpath(Constants.CopyrightSixthElementXPath));
      for (WebElement element : ElementsList) {
        elementList.add(element.getText());
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND SIXTH ELEMENT");
    }
    return elementList;
  }

  public List<String> getSeventhElement() {
    List<String> elementList = new ArrayList<String>();
    try {
      ElementsList = driver.findElements(By.xpath(Constants.CopyrightListXPath(3)));
      for (WebElement element : ElementsList) {
        elementList.add(element.getText());
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND SEVENTH ELEMENT");
    }
    return elementList;
  }
}
