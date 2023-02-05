package fridgefoodtask.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;
import fridgefoodtask.Core.Constants;

public class HomePage extends Navbar {
  WebElement clearBtn;
  WebElement findRecipesBtn;
  List<WebElement> ingredientCheckBoxes;
  WebElement selectIngredientCheckBox;

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public void clickClearAllBtn() {
    try {
      if (!driver.findElements(By.cssSelector(Constants.CheckClearBtnCssSelector))
          .isEmpty()) {
        clearBtn = driver.findElement(By.cssSelector(Constants.ClearBtnCssSelector));
        clearBtn.click();
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND CLEAR ALL BUTTON");
    }
  }

  public void clickFindRecipesBtn() {
    try {
      findRecipesBtn = driver.findElement(By.cssSelector(Constants.FindRecipesBtnCssSelector));
      findRecipesBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND - FIND RECIPES BUTTON");
    }
  }

  public void clickSelectIngredientCheckBox(int index) {
    try {
      ingredientCheckBoxes = driver.findElements(By.cssSelector(
          Constants.IngredientCheckBoxCssSelector));
      selectIngredientCheckBox = ingredientCheckBoxes.get(index);
      selectIngredientCheckBox.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND INGREDIENT CHECKBOX");
    }
  }
}
