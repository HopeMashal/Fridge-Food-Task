package fridgefoodtask.Pages;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;
import fridgefoodtask.Core.Constants;
import fridgefoodtask.Core.DownloadFile;

public class TipPage extends Navbar {
  WebElement tipName;
  WebElement tipImg;
  WebElement tipDescription;
  WebElement tipParagraph;

  public TipPage(WebDriver driver) {
    super(driver);
  }

  public String getTipName() {
    String tipNameText;
    try {
      tipName = driver.findElement(By.cssSelector(Constants.ContestTipTitleCssSelector));
      tipNameText = tipName.getText();
    } catch (Exception e) {
      System.out.println("CAN'T FIND TIP NAME");
      tipNameText = "NONE";
    }
    return tipNameText;
  }

  public String getTipImgPath() throws MalformedURLException, IOException {
    String tipImgPath;
    try {
      tipImg = driver.findElement(By.className(Constants.TipImgClassName));
      String ImgUrl = tipImg.getAttribute("src").replace(" ", "%20");
      DownloadFile downloadFile = new DownloadFile();
      File image = downloadFile.DownloadFileMethod(ImgUrl,
          Constants.DownloadsPath + getTipName().replace(" ", "") + ".jpg");
      tipImgPath = image.getPath();
    } catch (Exception e) {
      System.out.println("CAN'T FIND TIP IMAGE PATH");
      tipImgPath = "NONE";
    }
    return tipImgPath;
  }

  public String getTipDescription() {
    String tipDesc;
    try {
      tipDescription = driver.findElement(By.cssSelector(Constants.ContestPTipDescCssSelector));
      tipDesc = tipDescription.getText();
    } catch (Exception e) {
      System.out.println("CAN'T FIND TIP DESCRIPTION");
      tipDesc = "NONE";
    }
    return tipDesc;
  }

  public String getTipParagraph() {
    String tipP;
    try {
      tipParagraph = driver.findElement(By.cssSelector(Constants.TipParagraphCssSelector));
      tipP = tipParagraph.getText();
    } catch (Exception e) {
      System.out.println("CAN'T FIND TIP PARAGRAPH");
      tipP = "NONE";
    }
    return tipP;
  }
}
