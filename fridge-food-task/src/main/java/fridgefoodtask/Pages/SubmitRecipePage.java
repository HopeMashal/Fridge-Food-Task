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
    // TODO Auto-generated constructor stub
  }

  public String getSubmitRecipeTitle() {
    submitRecipeTitle = driver.findElement(By.tagName("h1"));
    return submitRecipeTitle.getText();
  }

  public List<String> getSubmitRecipeList() {
    submitRecipeList = driver.findElements(By.cssSelector(Constants.SubmitRecipeListCssSelector));
    List<String> paragraphList = new ArrayList<String>();
    for (WebElement paragraph : submitRecipeList) {
      paragraphList.add(paragraph.getText());
    }
    return paragraphList;
  }

  public void fullSubmitRecipe(String name, String email, String recipeName, String recipeImgPath, String photoCredit,
      String briefDesc, String cookingTime, String servings, String ingredientsList, String direction) {
    nameBox = driver.findElement(By.className(Constants.NameBoxClassName));
    nameBox.sendKeys(name);
    emailBox = driver.findElement(By.className(Constants.EmailBoxID));
    emailBox.sendKeys(email);
    recipeNameBox = driver.findElement(By.className(Constants.RecipeNameBoxClassName));
    recipeNameBox.sendKeys(recipeName);
    recipeImgBox = driver.findElement(By.cssSelector(Constants.RecipeImgBoxCssSelector));
    File file = new File(recipeImgPath);
    recipeImgBox.sendKeys(file.getAbsolutePath());
    photoCreditBox = driver.findElement(By.className(Constants.PhotoCreditBoxClassName));
    photoCreditBox.sendKeys(photoCredit);
    briefDescriptionBox = driver.findElement(By.className(Constants.DescriptionBoxClassName));
    briefDescriptionBox.sendKeys(briefDesc);
    cookingTimeBtn = driver.findElement(By.className(Constants.CookingTimeBtnClassName));
    Select cookTime = new Select(cookingTimeBtn);
    cookTime.selectByValue(cookingTime);
    servingsBox = driver.findElement(By.className(Constants.ServingsBtnClassName));
    Select serving = new Select(servingsBox);
    serving.selectByValue(servings);
    ingredientsListBox = driver.findElement(By.className(Constants.IngredientsListBoxClassName));
    ingredientsListBox.sendKeys(ingredientsList);
    directionsBox = driver.findElement(By.className(Constants.DirectionBoxClassName));
    directionsBox.sendKeys(direction);
  }

  public void clickSubmitBtn() {
    submitRecipeBtn = driver.findElement(By.xpath(Constants.SubmitBtnXPath));
    submitRecipeBtn.click();
  }
}
