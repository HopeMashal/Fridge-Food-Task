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
    String cardName;
    try {
      cardName = cardElement.findElement(By.cssSelector(Constants.CardNameCssSelector)).getText();
    } catch (Exception e) {
      System.out.println("CAN'T FIND CARD NAME");
      cardName = "NONE";
    }
    return cardName;
  }

  public String getCardLink() {
    String cardLink;
    try {
      cardLink = cardElement.findElement(By.cssSelector(Constants.CardLinkCssSelector))
          .getAttribute("href");
    } catch (Exception e) {
      System.out.println("CAN'T FIND CARD LINK");
      cardLink = "NONE";
    }
    return cardLink;
  }

  public String getCardDetails() {
    String cardDetails;
    try {
      cardDetails = cardElement.findElement(By.cssSelector(Constants.CardDetailsCssSelector)).getText()
          .replaceFirst("Category: ", "");
    } catch (Exception e) {
      System.out.println("CAN'T FIND CARD DETAILS");
      cardDetails = "NONE";
    }
    return cardDetails;
  }

  public String getCardImgSrc() {
    String cardImgSrc;
    try {
      cardImgSrc = cardElement.findElement(By.cssSelector(Constants.CardImgSrcCssSelector))
          .getAttribute("src").replace(" ", "%20");
    } catch (Exception e) {
      System.out.println("CAN'T FIND CARD IMAGE SOURCE");
      cardImgSrc = "NONE";
    }
    return cardImgSrc;
  }

  public String getRecipeCardCookingTime() {
    String recipeCardCookingTime;
    try {
      recipeCardCookingTime = cardElement.findElement(By.cssSelector(Constants.RecipeCardCookingTimeCssSelector))
          .getText()
          .replaceFirst("Cooking Time: ", "");
    } catch (Exception e) {
      System.out.println("CAN'T FIND CARD COOKING TIME");
      recipeCardCookingTime = "NONE";
    }
    return recipeCardCookingTime;
  }

  public String getRecipeCardIngredients() {
    String recipeCardIngredients;
    try {
      recipeCardIngredients = cardElement
          .findElement(By.cssSelector(Constants.MissingIngredientsCssSelector))
          .getText();
    } catch (Exception e) {
      System.out.println("CAN'T FIND CARD INGREDIENTS");
      recipeCardIngredients = "NONE";
    }
    String recipeCardIngredientsValue = "";
    if (recipeCardIngredients.equals("Missing Ingredients")) {
      recipeCardIngredientsValue = "";
      try {
        List<WebElement> IngredientsList = cardElement
            .findElements(By.cssSelector(Constants.IngredientNameCssSelector));
        for (WebElement ingredient : IngredientsList) {
          recipeCardIngredientsValue += ingredient.getText() + ", ";
        }
        recipeCardIngredientsValue = recipeCardIngredientsValue.substring(0, recipeCardIngredientsValue.length() - 2);
      } catch (Exception e) {
        System.out.println("CAN'T FIND CARD INGREDIENTS LIST");
      }
    }
    return recipeCardIngredientsValue;
  }

  public String getDeciderCardName() {
    String recipeCardName;
    try {
      recipeCardName = cardElement.findElement(By.cssSelector(Constants.DeciderCardNameCssSelector)).getText();
    } catch (Exception e) {
      System.out.println("CAN'T FIND CARD NAME");
      recipeCardName = "NONE";
    }
    return recipeCardName;
  }

  public String getDeciderCardDetails() {
    String recipeCardCategory;
    try {
      recipeCardCategory = cardElement.findElement(By.cssSelector(Constants.CardDetailsCssSelector)).getText()
          .replace(": \n", ": ");
    } catch (Exception e) {
      System.out.println("CAN'T FIND CARD DETAILS");
      recipeCardCategory = "NONE";
    }
    return recipeCardCategory;
  }

  public void clickCardBookmarksBtn() {
    try {
      WebElement bookmarksBtn = cardElement
          .findElement(By.cssSelector(Constants.CardBookmarksBtnCssSelector));
      bookmarksBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T CLICK BOOKMARK BUTTON");
    }
  }
}
