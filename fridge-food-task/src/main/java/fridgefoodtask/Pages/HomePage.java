package fridgefoodtask.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;

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
    clearBtn = driver.findElement(By.cssSelector("div[class='Clear']>div[class='remove']"));
    clearBtn.click();
  }

  public void clickFindRecipesBtn() {
    findRecipesBtn = driver.findElement(By.cssSelector("div[class='button submit']"));
    findRecipesBtn.click();
  }

  public void clickSelectIngredientCheckBox(int index) {
    ingredientCheckBoxes = driver.findElements(By.cssSelector(
        "div[class='tile ingredient tiles-item']>span[class='check-box']>span[class='ingredient-checkbox']"));
    // ingredientCheckBoxes=driver.findElements(By.cssSelector("div[class='tile
    // ingredient tiles-item']>span[class='check-box']>input"));
    selectIngredientCheckBox = ingredientCheckBoxes.get(index);
    selectIngredientCheckBox.click();
  }
}
