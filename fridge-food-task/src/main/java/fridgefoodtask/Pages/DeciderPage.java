package fridgefoodtask.Pages;

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
    // TODO Auto-generated constructor stub
  }

  public void clickAnswerBtn(String answer) {
    answerBtn = driver.findElement(By.linkText(answer));
    JavaScript.executeScript("arguments[0].click();", answerBtn);
  }

  public void clickAllAnswersBtn(String[] answerList) throws InterruptedException {
    for (int i = 0; i < answerList.length; i++) {
      clickAnswerBtn(answerList[i]);
      Thread.sleep(3000);
    }
  }

  public void clickPickOneResultBtn() {
    pickOneResultBtn = driver
        .findElement(By.cssSelector(Constants.PickOneResultBtnCssSelector));
    pickOneResultBtn.click();
  }

  public void clickStartOverBtn() {
    startOverBtn = driver.findElement(By.linkText(Constants.StartOverBtnLinkText));
    startOverBtn.click();
  }

  @Override
  public void clickSelectResult(int index) {
    // TODO Auto-generated method stub
    selectResult = driver
        .findElements(By.cssSelector(Constants.DeciderCardNameCssSelector)).get(index);
    JavaScript.executeScript("arguments[0].click();", selectResult);
  }

  @Override
  public List<String[]> getFirstPageResults() {
    // TODO Auto-generated method stub
    List<String[]> results = new ArrayList<String[]>();
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
    return results;
  }

}
