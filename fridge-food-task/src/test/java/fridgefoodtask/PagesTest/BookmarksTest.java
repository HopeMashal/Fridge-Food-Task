package fridgefoodtask.PagesTest;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import fridgefoodtask.Core.CSVFile;
import fridgefoodtask.Core.Constants;
import fridgefoodtask.Core.TaskBase;
import fridgefoodtask.Pages.BookmarksPage;
import io.qameta.allure.Allure;

public class BookmarksTest extends TaskBase {

  @Test
  public void BookmarksTesting() throws IOException, InterruptedException {
    Allure.step("Go to Bookmarks Page Using clickBookmarksBtn Method");
    BookmarksPage bookmarksPage = new BookmarksPage(driver);
    bookmarksPage.clickBookmarksBtn();

    Allure.step("Check URL & Title of Bookmarks Page");
    String[] bookmarksHref = bookmarksPage.bookmarksHref();
    Assert.assertEquals(driver.getTitle(), bookmarksHref[0], "Title of Bookmarks Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), bookmarksHref[1], "URL of Bookmarks Page NOT MATCH");

    Allure.step("Scroll Down 350px to Show Bookmarks Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("After Open Bookmarks Page - Take Screen Shot");
    File bookmarksResultPage = takeScreenShot
        .takeScreenShot(Constants.ScreenShotsPath + "BookmarksTest/afterOpenBookmarksPage.jpg");
    allureAttached.addImage(bookmarksResultPage);

    Allure.step("Write Output File of the Bookmarks Page");
    File bookmarksPageFile = new File(Constants.CSVFilesPath + "outputFileOfBookmarksPage.csv");
    CSVFile.writeDataLineByLine(bookmarksPageFile.getPath(),
        bookmarksPage.getFirstPageResults(),
        new String[] { "Recipe Name", "Recipe Link", "Recipe Category", "Recipe Image Source" });

    Allure.step("Attach Output File of the Bookmarks Page");
    allureAttached.addFile(bookmarksPageFile, "csv");

    Allure.step("Delete the Third Item from Bookmarks");
    bookmarksPage.clickSelectBookmarksBtn(2);
    Thread.sleep(500); // Just For ScreenShot

    Allure.step("After Delete the Third Item from Bookmarks - Take Screen Shot");
    File bookmarksPageAfterDelete = takeScreenShot
        .takeScreenShot(Constants.ScreenShotsPath + "BookmarksTest/afterDeleteThirdItemFromBookmarks.jpg");
    allureAttached.addImage(bookmarksPageAfterDelete);

    Allure.step("Delete All Items from Bookmarks");
    bookmarksPage.deleteAllBookmarksResult();
    Thread.sleep(500); // Just For ScreenShot

    Allure.step("After Delete All Items from Bookmarks - Take Screen Shot");
    File bookmarksPageAfterDeleteAll = takeScreenShot
        .takeScreenShot(Constants.ScreenShotsPath + "BookmarksTest/afterDeleteAllItemsFromBookmarks.jpg");
    allureAttached.addImage(bookmarksPageAfterDeleteAll);
  }
}
