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
    // TODO Auto-generated constructor stub
  }

  public void clickClearAllBtn() {
    if (!driver.findElements(By.cssSelector(Constants.CheckClearBtnCssSelector))
        .isEmpty()) {
      clearBtn = driver.findElement(By.cssSelector(Constants.ClearBtnCssSelector));
      clearBtn.click();
    }
  }

  public void clickFindRecipesBtn() {
    findRecipesBtn = driver.findElement(By.cssSelector(Constants.FindRecipesBtnCssSelector));
    findRecipesBtn.click();
  }

  public void clickSelectIngredientCheckBox(int index) {
    ingredientCheckBoxes = driver.findElements(By.cssSelector(
        Constants.IngredientCheckBoxCssSelector));
    selectIngredientCheckBox = ingredientCheckBoxes.get(index);
    selectIngredientCheckBox.click();
  }
}
