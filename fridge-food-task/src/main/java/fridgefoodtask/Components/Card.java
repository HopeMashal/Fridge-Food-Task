package fridgefoodtask.Components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Core.Constants;

public class Card {
  WebDriver driver;
  WebElement cardElement;

  public Card(WebDriver driver, WebElement card) {
    this.driver = driver;
    cardElement = card;
  }

  public String getCardName() {
    String cardName = cardElement.findElement(By.cssSelector(Constants.CardNameCssSelector)).getText();
    return cardName;
  }

  public String getCardLink() {
    String cardLink = cardElement.findElement(By.cssSelector(Constants.CardLinkCssSelector))
        .getAttribute("href");
    return cardLink;
  }

  public String getCardDetails() {
    String cardDetails = cardElement.findElement(By.cssSelector(Constants.CardDetailsCssSelector)).getText()
        .replaceFirst("Category: ", "");
    return cardDetails;
  }

  public String getCardImgSrc() {
    String cardImgSrc = cardElement.findElement(By.cssSelector(Constants.CardImgSrcCssSelector))
        .getAttribute("src").replace(" ", "%20");
    return cardImgSrc;
  }

  public String getRecipeCardCookingTime() {
    String recipeCardCookingTime = cardElement.findElement(By.cssSelector(Constants.RecipeCardCookingTimeCssSelector))
        .getText()
        .replaceFirst("Cooking Time: ", "");
    return recipeCardCookingTime;
  }

  public String getRecipeCardIngredients() {
    String recipeCardIngredients = cardElement
        .findElement(By.cssSelector(Constants.MissingIngredientsCssSelector))
        .getText();
    String recipeCardIngredientsValue = "";
    if (recipeCardIngredients.equals("Missing Ingredients")) {
      recipeCardIngredientsValue = "";
      List<WebElement> IngredientsList = cardElement
          .findElements(By.cssSelector(Constants.IngredientNameCssSelector));
      for (WebElement ingredient : IngredientsList) {
        recipeCardIngredientsValue += ingredient.getText() + ", ";
      }
      recipeCardIngredientsValue = recipeCardIngredientsValue.substring(0, recipeCardIngredientsValue.length() - 2);
    }
    return recipeCardIngredientsValue;
  }

  public String getDeciderCardName() {
    String recipeCardName = cardElement.findElement(By.cssSelector(Constants.DeciderCardNameCssSelector)).getText();
    return recipeCardName;
  }

  public String getDeciderCardDetails() {
    String recipeCardCategory = cardElement.findElement(By.cssSelector(Constants.CardDetailsCssSelector)).getText()
        .replace(": \n", ": ");
    return recipeCardCategory;
  }

  public void clickCardBookmarksBtn() {
    WebElement bookmarksBtn = cardElement
        .findElement(By.cssSelector(Constants.CardBookmarksBtnCssSelector));
    bookmarksBtn.click();
  }
}
