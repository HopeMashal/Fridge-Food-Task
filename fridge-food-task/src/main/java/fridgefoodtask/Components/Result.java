package fridgefoodtask.Components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Result extends Navbar {
  JavascriptExecutor JavaScript;
  List<WebElement> firstPageResults;
  WebElement selectResult;

  public Result(WebDriver driver) {
    super(driver);
    JavaScript = (JavascriptExecutor) driver;
    // TODO Auto-generated constructor stub
  }

  public List<String[]> getFirstPageResults() {
    List<String[]> results = new ArrayList<String[]>();
    firstPageResults = driver.findElements(By.cssSelector("div[class='recipe-tile recipe']"));
    if (!firstPageResults.isEmpty()) {
      for (WebElement result : firstPageResults) {
        Card recipeCard = new Card(driver, result);
        String resultLink = recipeCard.getRecipeCardLink();
        String resultName = recipeCard.getRecipeCardName();
        String resultCategory = recipeCard.getRecipeCardCategory();
        String resultImgSrc = recipeCard.getRecipeCardImgSrc();
        String[] resultValues = new String[] { resultName, resultLink, resultCategory, resultImgSrc };
        results.add(resultValues);
      }
    } else {
      String[] resultValues = new String[] { "NO RESULT", "NO RESULT", "NO RESULT", "NO RESULT" };
      results.add(resultValues);
    }
    return results;
  }

  public void clickSelectResult(int index) {
    selectResult = driver
        .findElements(By.cssSelector("div[class='line-item-body']>a")).get(index);
    JavaScript.executeScript("arguments[0].click();", selectResult);
  }

  public void clickSelectBookmarksBtn(int index) {
    selectResult = driver.findElements(By.cssSelector("div[class='recipe-tile recipe']")).get(index);
    Card recipeCard = new Card(driver, selectResult);
    recipeCard.clickCardBookmarksBtn();
  }

  public JavascriptExecutor getJavaScript() {
    return JavaScript;
  }

}
