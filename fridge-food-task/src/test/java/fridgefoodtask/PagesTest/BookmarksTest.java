package fridgefoodtask.PagesTest;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import fridgefoodtask.Core.CSVFile;
import fridgefoodtask.Core.Constant;
import fridgefoodtask.Core.TaskBase;
import fridgefoodtask.Pages.BookmarksPage;
import io.qameta.allure.Allure;

public class BookmarksTest extends TaskBase {

  @Test
  public void BookmarksTesting() throws IOException, InterruptedException {
    Allure.step("Go to Bookmarks Page Using Navbar Method");
    BookmarksPage bookmarksPage = new BookmarksPage(driver);
    bookmarksPage.clickBookmarksBtn();

    Allure.step("Check URL & Title of Bookmarks Page");
    String[] bookmarksHref = bookmarksPage.bookmarksHref();
    Assert.assertEquals(driver.getTitle(), bookmarksHref[0], "Title of Bookmarks Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), bookmarksHref[1], "URL of Bookmarks Page NOT MATCH");

    Allure.step("Scroll Down 350px to Show Bookmarks Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("Bookmarks Page - Take Screen Shot");
    File bookmarksResultPage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "BookmarksTest/" + "BookmarksResultPage.jpg");
    allureAttached.addImage(bookmarksResultPage);

    Allure.step("Write the Bookmarks Page Output File");
    File bookmarksPageFile = new File(Constant.getCSVFilesPath() + "BookmarksPageOutput.csv");
    CSVFile.writeDataLineByLine(bookmarksPageFile.getPath(),
        bookmarksPage.getFirstPageResults(),
        new String[] { "Recipe Name", "Recipe Link", "Recipe Category", "Recipe Image Source" });

    Allure.step("Attach the Bookmarks Page Output File");
    allureAttached.addFile(bookmarksPageFile, "csv");

    Allure.step("Click Delete Bookmarks Button For Third Element");
    bookmarksPage.clickSelectBookmarksBtn(2);
    Thread.sleep(2000);

    Allure.step("After Click Delete Bookmarks Button For Third Element - Take Screen Shot");
    File bookmarksPageAfterDelete = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "BookmarksTest/" + "BookmarksPageAfterDelete.jpg");
    allureAttached.addImage(bookmarksPageAfterDelete);

    Allure.step("Delete All Bookmarks");
    bookmarksPage.deleteAllBookmarksResult();
    Thread.sleep(2000);

    Allure.step("After Delete All Bookmarks - Take Screen Shot");
    File bookmarksPageAfterDeleteAll = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "BookmarksTest/" + "BookmarksPageAfterDeleteAll.jpg");
    allureAttached.addImage(bookmarksPageAfterDeleteAll);
  }
}
