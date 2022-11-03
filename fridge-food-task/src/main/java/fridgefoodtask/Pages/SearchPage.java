package fridgefoodtask.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Card;
import fridgefoodtask.Components.Result;

public class SearchPage extends Result {
  List<WebElement> firstPageResults;

  public SearchPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public List<String[]> getHomeSearchFirstPageResults() {
    List<String[]> results = new ArrayList<String[]>();
    firstPageResults = driver.findElements(By.cssSelector("div[class='recipe-tile recipe']"));
    for (WebElement result : firstPageResults) {
      Card recipeCard = new Card(driver, result);
      String resultLink = recipeCard.getRecipeCardLink();
      String resultName = recipeCard.getRecipeCardName();
      String resultCookingTime = recipeCard.getRecipeCardCookingTime();
      String resultImgSrc = recipeCard.getRecipeCardImgSrc();
      String resultIngredients = recipeCard.getRecipeCardIngredients();
      String[] resultValues = new String[] { resultName, resultLink, resultCookingTime, resultImgSrc,
          resultIngredients };
      results.add(resultValues);
    }
    return results;
  }

}
