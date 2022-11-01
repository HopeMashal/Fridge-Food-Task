package fridgefoodtask.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;
import fridgefoodtask.Components.RecipeCard;

public class SearchPage extends Navbar {
  List<WebElement> firstPageResults;
  WebElement firstResult;

  public SearchPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public List<String[]> getFirstPageResults() {
    List<String[]> results = new ArrayList<String[]>();
    firstPageResults = driver.findElements(By.className("recipe-tile recipe"));
    for (WebElement result : firstPageResults) {
      RecipeCard recipeCard = new RecipeCard(driver, result);
      String resultLink = recipeCard.getRecipeCardLink();
      String resultName = recipeCard.getRecipeCardName();
      String resultCategory = recipeCard.getRecipeCardCategory();
      String resultImgSrc = recipeCard.getRecipeCardImgSrc();
      String[] resultValues = new String[] { resultName, resultLink, resultCategory, resultImgSrc };
      results.add(resultValues);
    }
    return results;
  }

  public List<String[]> getHomeSearchFirstPageResults() {
    List<String[]> results = new ArrayList<String[]>();
    firstPageResults = driver.findElements(By.className("recipe-tile recipe"));
    for (WebElement result : firstPageResults) {
      RecipeCard recipeCard = new RecipeCard(driver, result);
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

  public void clickFirstResult() {
    firstResult = driver
        .findElement(By.cssSelector("div[class='line-item-image-container']>a"));
    firstResult.click();
  }

  public void clickBookmarksBtn(int index) {
    firstPageResults = driver.findElements(By.className("recipe-tile recipe"));
    WebElement recipeResult = firstPageResults.get(index);
    RecipeCard recipeCard = new RecipeCard(driver, recipeResult);
    recipeCard.clickBookmarksBtn();
  }
}
