package fridgefoodtask.Components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Card {
  WebDriver driver;
  WebElement cardElement;

  public Card(WebDriver driver, WebElement card) {
    this.driver = driver;
    cardElement = card;
  }

  public String getCardName() {
    String cardName = cardElement.findElement(By.cssSelector("div[class='line-item-body']>a")).getText();
    return cardName;
  }

  public String getCardLink() {
    String cardLink = cardElement.findElement(By.cssSelector("div[class='line-item-image-container']>a"))
        .getAttribute("href");
    return cardLink;
  }

  public String getCardDetails() {
    String cardDetails = cardElement.findElement(By.cssSelector("div[class='line-item-details']>p")).getText()
        .replaceFirst("Category: ", "");
    return cardDetails;
  }

  public String getCardImgSrc() {
    String cardImgSrc = cardElement.findElement(By.cssSelector("div[class='line-item-image-container']>a>img"))
        .getAttribute("src").replace(" ", "%20");
    return cardImgSrc;
  }

  public String getRecipeCardCookingTime() {
    String recipeCardCookingTime = cardElement.findElement(By.cssSelector("div[class='line-item-details']")).getText()
        .replaceFirst("Cooking Time: ", "");
    return recipeCardCookingTime;
  }

  public String getRecipeCardIngredients() {
    String recipeCardIngredients = cardElement
        .findElement(By.cssSelector("div[class='missing-ingred-container']>span"))
        .getText();
    String recipeCardIngredientsValue = "None";
    if (recipeCardIngredients.equals("Missing Ingredients")) {
      recipeCardIngredientsValue = "";
      List<WebElement> IngredientsList = cardElement
          .findElements(By.cssSelector("div[class='flex-row']>span[class='AddIngredientName']"));
      for (WebElement ingredient : IngredientsList) {
        recipeCardIngredientsValue += ingredient.getText() + ", ";
      }
      recipeCardIngredientsValue = recipeCardIngredientsValue.substring(0, recipeCardIngredientsValue.length() - 2);
    }
    return recipeCardIngredientsValue;
  }

  public String getDeciderCardName() {
    String recipeCardName = cardElement.findElement(By.cssSelector("div[class='line-item-body']>div>a")).getText();
    return recipeCardName;
  }

  public String getDeciderCardDetails() {
    String recipeCardCategory = cardElement.findElement(By.cssSelector("div[class='line-item-details']>p")).getText()
        .replace(": \n", ": ");
    return recipeCardCategory;
  }

  public void clickCardBookmarksBtn() {
    WebElement bookmarksBtn = cardElement
        .findElement(By.cssSelector("div[class='recipe-results-bookmark']>span"));
    bookmarksBtn.click();
  }
}
