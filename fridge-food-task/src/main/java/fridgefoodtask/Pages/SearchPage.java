package fridgefoodtask.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends Navbar {
  List<WebElement> firstPageResults;
  List<WebElement> homeSearchFirstPageResults;

  public SearchPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public List<String[]> searchPageMethod() {
    List<String[]> results = new ArrayList<String[]>();
    firstPageResults = driver.findElements(By.className("recipe-tile recipe"));
    for (WebElement result : firstPageResults) {
      String resultLink = result.findElement(By.cssSelector("div[class='line-item-image-container']>a"))
          .getAttribute("href");
      String resultName = result.findElement(By.cssSelector("div[class='line-item-body']>a")).getText();
      String resultCategory = result.findElement(By.cssSelector("div[class='line-item-details']>p")).getText();
      String resultImgSrc = result.findElement(By.cssSelector("div[class='line-item-image-container']>a>img"))
          .getAttribute("src");
      String[] resultValues = new String[] { resultName, resultLink, resultCategory, resultImgSrc };
      results.add(resultValues);
    }
    return results;
  }

  public List<String[]> homeSearchPageMethod() {
    List<String[]> results = new ArrayList<String[]>();
    homeSearchFirstPageResults = driver.findElements(By.className("recipe-tile recipe"));
    return results;
  }

  public void clickFirstSearchResult() {

  }

  public void clickFirstHomeSearchResult() {

  }
}
