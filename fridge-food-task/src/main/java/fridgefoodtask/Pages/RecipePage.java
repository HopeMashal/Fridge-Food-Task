package fridgefoodtask.Pages;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Core.Constant;
import fridgefoodtask.Core.DownloadFile;

public class RecipePage extends Navbar {
  WebElement recipeName;
  List<WebElement> recipeTable;
  WebElement recipeImg;
  WebElement bookmarksBtn;
  List<WebElement> recipeInformation;

  public RecipePage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public String getRecipeName() {
    recipeName = driver.findElement(By.cssSelector("div[class='recipe-title']>h1"));
    return recipeName.getText();
  }

  public List<String[]> getRecipeTable() {
    recipeTable = driver.findElements(By.className("recipe-stats"));
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
    recipeImg = driver.findElement(By.className("recipe-image"));
    String ImgUrl = recipeImg.getAttribute("src");
    DownloadFile downloadFile = new DownloadFile();
    File image = downloadFile.DownloadFileMethod(ImgUrl,
        Constant.getDownloadsPath() + getRecipeName().replace(" ", "") + ".jpg");
    return image.getPath();
  }

  public void clickBookmarksBtn() {
    bookmarksBtn = driver.findElement(By.id("bookmark-it"));
    bookmarksBtn.click();
  }

  public List<String[]> getRecipeInformation() {
    recipeInformation = driver.findElements(By.cssSelector("div[class='recipe-text']>div"));
    List<String[]> infoList = new ArrayList<String[]>();
    for (WebElement info : recipeInformation) {
      String infoTitle = info.findElement(By.tagName("h3")).getText();
      String infoText = info.getText().replaceFirst(infoTitle, "");
      String[] information = new String[] { infoTitle, infoText };
      infoList.add(information);
    }
    return infoList;
  }
}
