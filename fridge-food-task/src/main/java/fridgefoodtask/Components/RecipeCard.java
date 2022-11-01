package fridgefoodtask.Components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RecipeCard {
  WebDriver driver;
  WebElement recipeElement;

  public RecipeCard(WebDriver driver, WebElement recipe) {
    this.driver = driver;
    recipeElement = recipe;
  }

  public String getRecipeCardName() {
    String recipeCardName = recipeElement.findElement(By.cssSelector("div[class='line-item-body']>a")).getText();
    return recipeCardName;
  }

  public String getRecipeCardLink() {
    String recipeCardLink = recipeElement.findElement(By.cssSelector("div[class='line-item-image-container']>a"))
        .getAttribute("href");
    return recipeCardLink;
  }

  public String getRecipeCardCategory() {
    String recipeCardCategory = recipeElement.findElement(By.cssSelector("div[class='line-item-details']>p")).getText()
        .replaceFirst("Category: ", "");
    return recipeCardCategory;
  }

  public String getRecipeCardImgSrc() {
    String recipeCardImgSrc = recipeElement.findElement(By.cssSelector("div[class='line-item-image-container']>a>img"))
        .getAttribute("src");
    return recipeCardImgSrc;
  }

  public String getRecipeCardCookingTime() {
    String recipeCardCookingTime = recipeElement.findElement(By.cssSelector("div[class='line-item-details']")).getText()
        .replaceFirst("Cooking Time: ", "");
    return recipeCardCookingTime;
  }

  public String getRecipeCardIngredients() {
    String recipeCardIngredients = recipeElement
        .findElement(By.cssSelector("div[class='missing-ingred-container']>span"))
        .getText();
    String recipeCardIngredientsValue = "None";
    if (recipeCardIngredients.equals("Missing Ingredients")) {
      recipeCardIngredientsValue = "";
      List<WebElement> IngredientsList = recipeElement
          .findElements(By.cssSelector("div[class='flex-row']>span[class='AddIngredientName']"));
      for (WebElement ingredient : IngredientsList) {
        recipeCardIngredientsValue += ingredient.getText() + ", ";
      }
      recipeCardIngredientsValue = recipeCardIngredientsValue.substring(0, recipeCardIngredientsValue.length() - 2);
    }
    return recipeCardIngredientsValue;
  }

  public void clickBookmarksBtn() {
    WebElement bookmarksBtn = recipeElement
        .findElement(By.xpath("//div[contains(@class,'recipe-results-bookmark')]/span"));
    bookmarksBtn.click();
  }
}
