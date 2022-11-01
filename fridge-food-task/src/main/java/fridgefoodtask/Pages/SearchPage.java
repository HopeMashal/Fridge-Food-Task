package fridgefoodtask.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends Navbar {
  List<WebElement> firstPageResults;
  List<WebElement> firstPageResultsLink;
  List<WebElement> firstPageResultsImgSrc;
  List<WebElement> firstPageResultsName;
  List<WebElement> firstPageResultsCategory;
  List<WebElement> firstPageResultsBookmarksBtn;

  List<WebElement> homeSearchFirstPageResults;
  List<WebElement> homeSearchFirstPageResultsLink;
  List<WebElement> homeSearchFirstPageResultsImgSrc;
  List<WebElement> homeSearchFirstPageResultsName;
  List<WebElement> homeSearchFirstPageResultsCookingTime;
  List<WebElement> homeSearchFirstPageResultsAddIngredientName;
  List<WebElement> homeSearchFirstPageResultsBookmarksBtn;

  public SearchPage(WebDriver driver) {
    super(driver);
    //TODO Auto-generated constructor stub
  }
  
}
