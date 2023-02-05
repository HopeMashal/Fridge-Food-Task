package fridgefoodtask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import fridgefoodtask.Components.Result;
import fridgefoodtask.Core.Constants;

public class BookmarksPage extends Result {

  public BookmarksPage(WebDriver driver) {
    super(driver);
  }

  public int getBookmarksNumbers() {
    int bookmarksNumbers;
    try {
      bookmarksNumbers = driver.findElements(By.cssSelector(Constants.FirstPageResultsCssSelector)).size();
    } catch (Exception e) {
      System.out.println("CAN'T FIND BOOKMARKS");
      bookmarksNumbers = 0;
    }
    return bookmarksNumbers;
  }

  public void deleteAllBookmarksResult() {
    int size = getBookmarksNumbers();
    for (int i = 0; i < size; i++) {
      int index = size - 1 - i;
      super.clickSelectBookmarksBtn(index);
    }
  }
}
