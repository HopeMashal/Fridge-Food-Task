package fridgefoodtask.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;

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

  public SubmitRecipePage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public String getSubmitRecipeTitle() {
    submitRecipeTitle = driver.findElement(By.tagName("h1"));
    return submitRecipeTitle.getText();
  }

  public List<String> getSubmitRecipeList() {
    submitRecipeList = driver.findElements(By.cssSelector("p+ul>li"));
    List<String> paragraphList = new ArrayList<String>();
    for (WebElement paragraph : submitRecipeList) {
      paragraphList.add(paragraph.getText());
    }
    return paragraphList;
  }

  public void fullSubmitRecipe(){
    
  }
}
