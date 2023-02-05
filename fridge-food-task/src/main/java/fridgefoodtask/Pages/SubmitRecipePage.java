package fridgefoodtask.Pages;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import fridgefoodtask.Components.Navbar;
import fridgefoodtask.Core.Constants;

public class SubmitRecipePage extends Navbar {
  WebElement submitRecipeTitle;
  List<WebElement> submitRecipeList;
  WebElement nameBox;
  WebElement emailBox;
  WebElement recipeNameBox;
  WebElement recipeImgBox;
  WebElement photoCreditBox;
  WebElement briefDescriptionBox;
  WebElement cookingTimeBtn;
  WebElement servingsBox;
  WebElement ingredientsListBox;
  WebElement directionsBox;
  WebElement submitRecipeBtn;

  public SubmitRecipePage(WebDriver driver) {
    super(driver);
  }

  public String getSubmitRecipeTitle() {
    String submitRecipeTitleText;
    try {
      submitRecipeTitle = driver.findElement(By.tagName("h1"));
      submitRecipeTitleText = submitRecipeTitle.getText();
    } catch (Exception e) {
      System.out.println("CAN'T FIND SUBMIT RECIPE TITLE");
      submitRecipeTitleText = "NONE";
    }
    return submitRecipeTitleText;
  }

  public List<String> getSubmitRecipeList() {
    List<String> paragraphList = new ArrayList<String>();
    try {
      submitRecipeList = driver.findElements(By.cssSelector(Constants.SubmitRecipeListCssSelector));
      for (WebElement paragraph : submitRecipeList) {
        paragraphList.add(paragraph.getText());
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND SUBMIT RECIPE LIST");
    }
    return paragraphList;
  }

  public void fullSubmitRecipe(String name, String email, String recipeName, String recipeImgPath, String photoCredit,
      String briefDesc, String cookingTime, String servings, String ingredientsList, String direction) {
    try {
      nameBox = driver.findElement(By.className(Constants.NameBoxClassName));
      nameBox.sendKeys(name);
    } catch (Exception e) {
      System.out.println("CAN'T FIND NAME BOX");
    }
    try {
      emailBox = driver.findElement(By.className(Constants.EmailBoxID));
      emailBox.sendKeys(email);
    } catch (Exception e) {
      System.out.println("CAN'T FIND EMAIL BOX");
    }
    try {
      recipeNameBox = driver.findElement(By.className(Constants.RecipeNameBoxClassName));
      recipeNameBox.sendKeys(recipeName);
    } catch (Exception e) {
      System.out.println("CAN'T FIND RECIPE NAME BOX");
    }
    try {
      recipeImgBox = driver.findElement(By.cssSelector(Constants.RecipeImgBoxCssSelector));
      File file = new File(recipeImgPath);
      recipeImgBox.sendKeys(file.getAbsolutePath());
    } catch (Exception e) {
      System.out.println("CAN'T FIND RECIPE IMAGE BOX");
    }
    try {
      photoCreditBox = driver.findElement(By.className(Constants.PhotoCreditBoxClassName));
      photoCreditBox.sendKeys(photoCredit);
    } catch (Exception e) {
      System.out.println("CAN'T FIND PHOTO CREDIT BOX");
    }
    try {
      briefDescriptionBox = driver.findElement(By.className(Constants.DescriptionBoxClassName));
      briefDescriptionBox.sendKeys(briefDesc);
    } catch (Exception e) {
      System.out.println("CAN'T FIND BRIEF DESCRIPTION BOX");
    }
    try {
      cookingTimeBtn = driver.findElement(By.className(Constants.CookingTimeBtnClassName));
      Select cookTime = new Select(cookingTimeBtn);
      cookTime.selectByValue(cookingTime);
    } catch (Exception e) {
      System.out.println("CAN'T FIND COOKING TIME BOX");
    }
    try {
      servingsBox = driver.findElement(By.className(Constants.ServingsBtnClassName));
      Select serving = new Select(servingsBox);
      serving.selectByValue(servings);
    } catch (Exception e) {
      System.out.println("CAN'T FIND SERVINGS BOX");
    }
    try {
      ingredientsListBox = driver.findElement(By.className(Constants.IngredientsListBoxClassName));
      ingredientsListBox.sendKeys(ingredientsList);
    } catch (Exception e) {
      System.out.println("CAN'T FIND INGREDIENTS LIST BOX");
    }
    try {
      directionsBox = driver.findElement(By.className(Constants.DirectionBoxClassName));
      directionsBox.sendKeys(direction);
    } catch (Exception e) {
      System.out.println("CAN'T FIND DIRECTION BOX");
    }
  }

  public void clickSubmitBtn() {
    try {
      submitRecipeBtn = driver.findElement(By.xpath(Constants.SubmitBtnXPath));
      submitRecipeBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND SUBMIT BUTTON");
    }
  }
}
