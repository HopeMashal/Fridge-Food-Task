package fridgefoodtask.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Card;
import fridgefoodtask.Components.Result;
import fridgefoodtask.Core.Constants;

public class DeciderPage extends Result {
  WebElement answerBtn;
  WebElement pickOneResultBtn;
  WebElement startOverBtn;
  List<WebElement> firstPageResults;
  WebElement selectResult;

  public DeciderPage(WebDriver driver) {
    super(driver);
  }

  public void clickAnswerBtn(String answer) {
    try {
      answerBtn = driver.findElement(By.linkText(answer));
      JavaScript.executeScript("arguments[0].click();", answerBtn);
    } catch (Exception e) {
      System.out.println("CAN'T FIND ANSWER BUTTON");
    }
  }

  public void clickAllAnswersBtn(String[] answerList) throws InterruptedException {
    for (int i = 0; i < answerList.length; i++) {
      clickAnswerBtn(answerList[i]);
      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(12));
    }
  }

  public void clickPickOneResultBtn() {
    try {
      pickOneResultBtn = driver
          .findElement(By.cssSelector(Constants.PickOneResultBtnCssSelector));
      pickOneResultBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND PICK ONE RESULT BUTTON");
    }
  }

  public void clickStartOverBtn() {
    try {
      startOverBtn = driver.findElement(By.linkText(Constants.StartOverBtnLinkText));
      startOverBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND START OVER BUTTON");
    }
  }

  @Override
  public void clickSelectResult(int index) {
    try {
      selectResult = driver
          .findElements(By.cssSelector(Constants.DeciderCardNameCssSelector)).get(index);
      JavaScript.executeScript("arguments[0].click();", selectResult);
    } catch (Exception e) {
      System.out.println("CAN'T FIND SPECIFIC CARD");
    }
  }

  @Override
  public List<String[]> getFirstPageResults() {
    List<String[]> results = new ArrayList<String[]>();
    try {
      firstPageResults = driver.findElements(By.cssSelector(Constants.FirstPageResultsCssSelector));
      if (!firstPageResults.isEmpty()) {
        for (WebElement result : firstPageResults) {
          Card deciderCard = new Card(driver, result);
          String resultLink = deciderCard.getCardLink();
          String resultName = deciderCard.getDeciderCardName();
          String resultDetails = deciderCard.getDeciderCardDetails();
          String resultImgSrc = deciderCard.getCardImgSrc();
          String[] resultValues = new String[] { resultName, resultLink, resultDetails, resultImgSrc };
          results.add(resultValues);
        }
      } else {
        String[] resultValues = new String[] { "", "", "", "" };
        results.add(resultValues);
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND RESULTS");
    }
    return results;
  }

}
