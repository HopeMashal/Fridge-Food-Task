package fridgefoodtask.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Components.Result;

public class BookmarksPage extends Result {
  List<WebElement> bookmarksResults;

  public BookmarksPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public int getBookmarksNumbers() {
    int bookmarksNumbers = driver.findElements(By.cssSelector("div[class='recipe-tile recipe']")).size();
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
