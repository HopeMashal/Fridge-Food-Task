package fridgefoodtask.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends Navbar {
  List<WebElement> firstPageResults;
  List<WebElement> homeSearchFirstPageResults;
  WebElement firstResult;
  WebElement homeSearchFirstResult;

  public SearchPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public List<String[]> getFirstPageResults() {
    List<String[]> results = new ArrayList<String[]>();
    firstPageResults = driver.findElements(By.className("recipe-tile recipe"));
    for (WebElement result : firstPageResults) {
      String resultLink = result.findElement(By.cssSelector("div[class='line-item-image-container']>a"))
          .getAttribute("href");
      String resultName = result.findElement(By.cssSelector("div[class='line-item-body']>a")).getText();
      String resultCategory = result.findElement(By.cssSelector("div[class='line-item-details']>p")).getText();
      String resultImgSrc = result.findElement(By.cssSelector("div[class='line-item-image-container']>a>img"))
          .getAttribute("src");
      String[] resultValues = new String[] { resultName, resultLink, resultCategory, resultImgSrc };
      results.add(resultValues);
    }
    return results;
  }

  public List<String[]> getHomeSearchFirstPageResults() {
    List<String[]> results = new ArrayList<String[]>();
    homeSearchFirstPageResults = driver.findElements(By.className("recipe-tile recipe"));
    for (WebElement result : firstPageResults) {
      String resultLink = result.findElement(By.cssSelector("div[class='line-item-image-container']>a"))
          .getAttribute("href");
      String resultName = result.findElement(By.cssSelector("div[class='line-item-body']>a")).getText();
      String resultCookingTime = result.findElement(By.cssSelector("div[class='line-item-details']")).getText();
      String resultImgSrc = result.findElement(By.cssSelector("div[class='line-item-image-container']>a>img"))
          .getAttribute("src");
      String resultIngredients = result.findElement(By.cssSelector("div[class='missing-ingred-container']>span"))
          .getText();
      String resultIngredientsValue = "None";
      if (resultIngredients.equals("Missing Ingredients")) {
        resultIngredientsValue = "";
        List<WebElement> IngredientsList = result
            .findElements(By.cssSelector("div[class='flex-row']>span[class='AddIngredientName']"));
        for (WebElement ingredient : IngredientsList) {
          resultIngredientsValue += ingredient.getText() + ", ";
        }
        resultIngredientsValue = resultIngredientsValue.substring(0, resultIngredientsValue.length() - 2);
      }
      String[] resultValues = new String[] { resultName, resultLink, resultCookingTime, resultImgSrc,
          resultIngredientsValue };
      results.add(resultValues);
    }
    return results;
  }

  public void clickFirstResult() {
    firstResult = driver
        .findElement(By.cssSelector("div[class='line-item-image-container']>a"));
    firstResult.click();
  }

  public void clickHomeSearchFirstResult() {
    homeSearchFirstResult = driver
        .findElement(By.cssSelector("div[class='line-item-image-container']>a"));
    homeSearchFirstResult.click();
  }
}
