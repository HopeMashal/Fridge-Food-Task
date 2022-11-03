package fridgefoodtask.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Navbar;

public class BookmarksPage extends Navbar {
  List<WebElement> bookmarksResults;

  public BookmarksPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public List<String[]> getBookmarksResults() {
    SearchPage bookmarksPage = new SearchPage(driver);
    List<String[]> bookmarkResults = bookmarksPage.getFirstPageResults();
    return bookmarkResults;
  }

  public void deleteSelectBookmarks(int index) {
    SearchPage bookmarksPage = new SearchPage(driver);
    bookmarksPage.clickSelectBookmarksBtn(index);
  }

  public void clickSelectBookmarksResult(int index) {
    SearchPage bookmarksPage = new SearchPage(driver);
    bookmarksPage.clickSelectResult(index);
  }

  public int getBookmarksNumbers() {
    int bookmarksNumbers = driver.findElements(By.cssSelector("div[class='recipe-tile recipe']")).size();
    return bookmarksNumbers;
  }

  public void deleteAllBookmarksResult() {
    int size = getBookmarksNumbers();
    for (int i = 0; i < size; i++) {
      int index = size - 1 - i;
      deleteSelectBookmarks(index);
    }
  }
}
