package fridgefoodtask.Components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Core.Constants;

public class Result extends Navbar {
  public JavascriptExecutor JavaScript;
  List<WebElement> firstPageResults;
  WebElement selectResult;

  public Result(WebDriver driver) {
    super(driver);
    JavaScript = (JavascriptExecutor) driver;
  }

  public List<String[]> getFirstPageResults() {
    List<String[]> results = new ArrayList<String[]>();
    try {
      firstPageResults = driver.findElements(By.cssSelector(Constants.FirstPageResultsCssSelector));
      if (!firstPageResults.isEmpty()) {
        for (WebElement result : firstPageResults) {
          Card recipeCard = new Card(driver, result);
          String resultLink = recipeCard.getCardLink();
          String resultName = recipeCard.getCardName();
          String resultCategory = recipeCard.getCardDetails();
          String resultImgSrc = recipeCard.getCardImgSrc();
          String[] resultValues = new String[] { resultName, resultLink, resultCategory, resultImgSrc };
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

  public void clickSelectResult(int index) {
    try {
      selectResult = driver
          .findElements(By.cssSelector(Constants.CardNameCssSelector)).get(index);
      JavaScript.executeScript("arguments[0].click();", selectResult);
    } catch (Exception e) {
      System.out.println("CAN'T CLICK SPECIFIC RESULT");
    }
  }

  public void clickSelectBookmarksBtn(int index) {
    try {
      selectResult = driver.findElements(By.cssSelector(Constants.FirstPageResultsCssSelector)).get(index);
      Card recipeCard = new Card(driver, selectResult);
      recipeCard.clickCardBookmarksBtn();
    } catch (Exception e) {
      System.out.println(" CAN'T CLICK SPECIFIC BOOKMARKS BUTTON");
    }
  }

}
