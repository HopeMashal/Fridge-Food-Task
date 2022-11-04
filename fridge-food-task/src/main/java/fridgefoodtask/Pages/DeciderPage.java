package fridgefoodtask.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Card;
import fridgefoodtask.Components.Result;

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

  @Override
  public void clickSelectResult(int index) {
    // TODO Auto-generated method stub
    selectResult = driver
        .findElements(By.cssSelector("div[class='line-item-body']>div>a")).get(index);
    getJavaScript().executeScript("arguments[0].click();", selectResult);
  }

  @Override
  public List<String[]> getFirstPageResults() {
    // TODO Auto-generated method stub
    List<String[]> results = new ArrayList<String[]>();
    firstPageResults = driver.findElements(By.cssSelector("div[class='recipe-tile recipe']"));
    if (!firstPageResults.isEmpty()) {
      for (WebElement result : firstPageResults) {
        Card deciderCard = new Card(driver, result);
        String resultLink = deciderCard.getRecipeCardLink();
        String resultName = deciderCard.getDeciderCardName();
        String resultDetails = deciderCard.getDeciderCardDetails();
        String resultImgSrc = deciderCard.getRecipeCardImgSrc();
        String[] resultValues = new String[] { resultName, resultLink, resultDetails, resultImgSrc };
        results.add(resultValues);
      }
    } else {
      String[] resultValues = new String[] { "NO RESULT", "NO RESULT", "NO RESULT", "NO RESULT" };
      results.add(resultValues);
    }
    return results;
  }

}
