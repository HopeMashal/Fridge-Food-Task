package fridgefoodtask.Pages;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;
import fridgefoodtask.Core.Constant;
import fridgefoodtask.Core.DownloadFile;

public class TipPage extends Navbar {
  WebElement tipName;
  WebElement tipImg;
  WebElement tipDescription;
  WebElement tipParagraph;

  public TipPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public String getTipName() {
    tipName = driver.findElement(By.cssSelector("div[class='page-block']>h1"));
    return tipName.getText();
  }

  public String getTipImgPath() throws MalformedURLException, IOException {
    tipImg = driver.findElement(By.className("recipe-img"));
    String ImgUrl = tipImg.getAttribute("src").replace(" ", "%20");
    DownloadFile downloadFile = new DownloadFile();
    File image = downloadFile.DownloadFileMethod(ImgUrl,
        Constant.getDownloadsPath() + getTipName().replace(" ", "") + ".jpg");
    return image.getPath();
  }

  public String getTipDescription() {
    tipDescription = driver.findElement(By.cssSelector("div[class='page-block']>p"));
    return tipDescription.getText();
  }

  public String getTipParagraph() {
    tipParagraph = driver.findElement(By.cssSelector("div[class='page-block']>div>p"));
    return tipParagraph.getText();
  }
}
