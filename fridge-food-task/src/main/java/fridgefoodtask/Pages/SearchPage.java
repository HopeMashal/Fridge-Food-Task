package fridgefoodtask.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Card;
import fridgefoodtask.Components.Result;
import fridgefoodtask.Core.Constants;

public class SearchPage extends Result {
  List<WebElement> firstPageResults;

  public SearchPage(WebDriver driver) {
    super(driver);
  }

  public List<String[]> getHomeSearchFirstPageResults() {
    List<String[]> results = new ArrayList<String[]>();
    try {
      firstPageResults = driver.findElements(By.cssSelector(Constants.FirstPageResultsCssSelector));
      if (!firstPageResults.isEmpty()) {
        for (WebElement result : firstPageResults) {
          Card recipeCard = new Card(driver, result);
          String resultLink = recipeCard.getCardLink();
          String resultName = recipeCard.getCardName();
          String resultCookingTime = recipeCard.getRecipeCardCookingTime();
          String resultImgSrc = recipeCard.getCardImgSrc();
          String resultIngredients = recipeCard.getRecipeCardIngredients();
          String[] resultValues = new String[] { resultName, resultLink, resultCookingTime, resultImgSrc,
              resultIngredients };
          results.add(resultValues);
        }
      } else {
        String[] resultValues = new String[] { "", "", "", "", "" };
        results.add(resultValues);
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND RESULT");
    }
    return results;
  }

}
