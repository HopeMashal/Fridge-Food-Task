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
import fridgefoodtask.Core.Constants;
import fridgefoodtask.Core.DownloadFile;

public class ContestPage extends Navbar {
  WebElement contestTitle;
  List<WebElement> contestParagraphs;
  List<WebElement> contestList;
  WebElement contestImg;
  List<WebElement> archivedContest;

  public ContestPage(WebDriver driver) {
    super(driver);
  }

  public String getContestTitle() {
    String contestTitleText;
    try {
      contestTitle = driver.findElement(By.cssSelector(Constants.ContestTipTitleCssSelector));
      contestTitleText = contestTitle.getText();
    } catch (Exception e) {
      System.out.println("CAN'T FIND CONTEST TITLE");
      contestTitleText = "NONE";
    }
    return contestTitleText;
  }

  public List<String> getContestParagraphs() {
    List<String> paragraphsList = new ArrayList<String>();
    try {
      contestParagraphs = driver.findElements(By.cssSelector(Constants.ContestPTipDescCssSelector));
      for (WebElement paragraph : contestParagraphs) {
        if (!paragraph.getText().isEmpty())
          paragraphsList.add(paragraph.getText());
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND CONTEST PARAGRAPHS");
    }
    return paragraphsList;
  }

  public List<String> getContestList() {
    List<String> contestsList = new ArrayList<String>();
    try {
      contestList = driver.findElements(By.cssSelector(Constants.ContestListCssSelector));
      for (WebElement element : contestList) {
        contestsList.add(element.getText());
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND CONTEST LIST");
    }
    return contestsList;
  }

  public String getContestImgPath() throws MalformedURLException, IOException {
    String imgPath;
    try {
      contestImg = driver.findElement(By.cssSelector(Constants.ContestImgCssSelector));
      String ImgUrl = contestImg.getAttribute("src").replace(" ", "%20");
      DownloadFile downloadFile = new DownloadFile();
      File image = downloadFile.DownloadFileMethod(ImgUrl,
          Constants.DownloadsPath + getContestTitle().replace(" ", "") + ".jpg");
      imgPath = image.getPath();
    } catch (Exception e) {
      System.out.println("CAN'T FIND IMAGE PATH");
      imgPath = "NONE";
    }
    return imgPath;
  }

  public List<String[]> getArchivedContest() {
    List<String[]> archivedContestsList = new ArrayList<String[]>();
    try {
      archivedContest = driver.findElements(By.cssSelector(Constants.ContestArchivedListCssSelector));
      for (WebElement element : archivedContest) {
        String archivedTitle = element.findElement(By.tagName("a")).getText();
        String archivedDate = element.findElement(By.tagName("span")).getText();
        String archivedHref = element.findElement(By.tagName("a")).getAttribute("href");
        archivedContestsList.add(new String[] { archivedTitle, archivedDate, archivedHref });
      }
    } catch (Exception e) {
      System.out.println("CAN'T FIND ARCHIVED CONTESTS LIST");
    }
    return archivedContestsList;
  }
}
