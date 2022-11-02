package fridgefoodtask.Pages;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;
import fridgefoodtask.Core.Constant;
import fridgefoodtask.Core.DownloadFile;

public class ContestPage extends Navbar {
  WebElement contestTitle;
  List<WebElement> contestParagraphs;
  List<WebElement> contestList;
  WebElement contestImg;
  List<WebElement> archivedContest;

  public ContestPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public String getContestTitle() {
    contestTitle = driver.findElement(By.cssSelector("div[class='page-block']>h1"));
    return contestTitle.getText();
  }

  public List<String> getContestParagraphs() {
    contestParagraphs = driver.findElements(By.cssSelector("div[class='page-block']>p"));
    List<String> paragraphsList = new ArrayList<String>();
    for (WebElement paragraph : contestParagraphs) {
      if (!paragraph.getText().isEmpty())
        paragraphsList.add(paragraph.getText());
    }
    return paragraphsList;
  }

  public List<String> getContestList() {
    contestList = driver.findElements(By.cssSelector("div[class='page-block']>ul>li"));
    List<String> contestsList = new ArrayList<String>();
    for (WebElement element : contestList) {
      contestsList.add(element.getText());
    }
    return contestsList;
  }

  public String getContestImgPath() throws MalformedURLException, IOException {
    contestImg = driver.findElement(By.cssSelector("div[class='page-block']>p>img"));
    String ImgUrl = contestImg.getAttribute("src").replace(" ", "%20");
    DownloadFile downloadFile = new DownloadFile();
    File image = downloadFile.DownloadFileMethod(ImgUrl,
        Constant.getDownloadsPath() + getContestTitle().replace(" ", "") + ".jpg");
    return image.getPath();
  }

  public List<String[]> getArchivedContest() {
    archivedContest = driver.findElements(By.cssSelector("div[class='archived-contests']>ul>li"));
    List<String[]> archivedContestsList = new ArrayList<String[]>();
    for (WebElement element : archivedContest) {
      String archivedTitle = element.findElement(By.tagName("a")).getText();
      String archivedDate = element.findElement(By.tagName("span")).getText();
      archivedContestsList.add(new String[] { archivedTitle, archivedDate });
    }
    return archivedContestsList;
  }
}
