package fridgefoodtask.Pages;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;
import fridgefoodtask.Core.Constants;
import fridgefoodtask.Core.DownloadFile;

public class RecipePage extends Navbar {
  JavascriptExecutor JavaScript;
  WebElement recipeName;
  List<WebElement> recipeTable;
  WebElement recipeImg;
  WebElement bookmarksBtn;
  List<WebElement> recipeInformation;

  public RecipePage(WebDriver driver) {
    super(driver);
    JavaScript = (JavascriptExecutor) driver;
    // TODO Auto-generated constructor stub
  }

  public String getRecipeName() {
    recipeName = driver.findElement(By.cssSelector(Constants.RecipeNameCssSelector));
    return recipeName.getText();
  }

  public List<String[]> getRecipeTable() {
    recipeTable = driver.findElements(By.className(Constants.RecipeTableClassName));
    List<String[]> tableData = new ArrayList<String[]>();
    for (WebElement tableElement : recipeTable) {
      List<WebElement> elements = tableElement.findElements(By.tagName("div"));
      String[] elementList = new String[elements.size()];
      for (int i = 0; i < elementList.length; i++) {
        elementList[i] = elements.get(i).getText();
      }
      tableData.add(elementList);
    }
    return tableData;
  }

  public String getRecipeImgPath() throws MalformedURLException, IOException {
    recipeImg = driver.findElement(By.className(Constants.RecipeImgClassName));
    String ImgUrl = recipeImg.getAttribute("src").replace(" ", "%20");
    DownloadFile downloadFile = new DownloadFile();
    File image = downloadFile.DownloadFileMethod(ImgUrl,
        Constants.DownloadsPath + getRecipeName().replace(" ", "") + ".jpg");
    return image.getPath();
  }

  public void clickRecipeBookmarksBtn() {
    bookmarksBtn = driver.findElement(By.cssSelector(Constants.RecipeBookmarksBtnCssSelector));
    JavaScript.executeScript("arguments[0].click();", bookmarksBtn);
  }

  public List<String[]> getRecipeInformation() {
    recipeInformation = driver.findElements(By.cssSelector(Constants.RecipeInformationCssSelector));
    List<String[]> infoList = new ArrayList<String[]>();
    for (WebElement info : recipeInformation) {
      String infoTitle = info.findElement(By.tagName("h3")).getText();
      String infoText = info.getText().replaceFirst(infoTitle + "\n", "");
      String[] information = new String[] { infoTitle, infoText };
      infoList.add(information);
    }
    return infoList;
  }

}
