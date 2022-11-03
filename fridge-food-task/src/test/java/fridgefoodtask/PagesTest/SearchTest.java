package fridgefoodtask.PagesTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fridgefoodtask.Core.CSVFile;
import fridgefoodtask.Core.Constant;
import fridgefoodtask.Core.TaskBase;
import fridgefoodtask.Core.WordFile;
import fridgefoodtask.Pages.RecipePage;
import fridgefoodtask.Pages.SearchPage;
import io.qameta.allure.Allure;

public class SearchTest extends TaskBase {

  static List<String[]> OutputList = new ArrayList<String[]>();

  @DataProvider
  public static Object[][] getInputCSVData() throws Exception {
    String inputFile = Constant.getCSVFilesPath() + "searchInput.csv";
    List<String[]> lines = CSVFile.readAllLines(inputFile);
    lines.remove(0);
    Object[][] data = new Object[lines.size()][lines.get(0).length];
    int index = 0;
    for (String[] line : lines) {
      data[index] = line;
      index++;
    }
    return data;
  }

  @Test(dataProvider = "getInputCSVData")
  public void SearchTesting(String searchKeyWord) throws IOException, InvalidFormatException {
    Allure.step("Go to Search Page  (" + searchKeyWord + ")  Using Navbar Method");
    SearchPage searchPage = new SearchPage(driver);
    searchPage.searchMethod(searchKeyWord);

    Allure.step("Check URL & Title of Search Page (" + searchKeyWord + ") ");
    String[] searchHref = searchPage.searchHref(searchKeyWord);
    Assert.assertEquals(driver.getTitle(), searchHref[0], "Title of Search Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), searchHref[1], "URL of Search Page NOT MATCH");

    Allure.step("Scroll Down 350px to Show Recipe Results (" + searchKeyWord + ") ");
    JavascriptExecutor JavaScript = (JavascriptExecutor) driver;
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("Search Results Page (" + searchKeyWord + ") - Take Screen Shot");
    File searchResultsPage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "SearchTest/" + searchKeyWord + "SearchResultsPage.jpg");
    allureAttached.addImage(searchResultsPage);

    Allure.step("Write the " + searchKeyWord + " Search Page Output File");
    CSVFile.writeDataLineByLine(Constant.getCSVFilesPath() + searchKeyWord + "SearchPageOutput.csv",
        searchPage.getFirstPageResults(),
        new String[] { "Recipe Name", "Recipe Link", "Recipe Category", "Recipe Image Source" });

    Allure.step("Attach the " + searchKeyWord + " Search Page Output File");
    File searchPageFile = new File(Constant.getCSVFilesPath() + searchKeyWord + "SearchPageOutput.csv");
    allureAttached.addFile(searchPageFile, "csv");

    Allure.step("Click Bookmarks Button For Second Result (" + searchKeyWord + ") ");
    searchPage.clickSelectBookmarksBtn(1);

    Allure.step(
        "After Click Bookmarks Button For Second Result in Results Page (" + searchKeyWord + ") - Take Screen Shot");
    File clickBookmarksForSecondResult = takeScreenShot
        .takeScreenShot(
            Constant.getScreenShotsPath() + "SearchTest/" + searchKeyWord + "ClickBookmarksForSecondResult.jpg");
    allureAttached.addImage(clickBookmarksForSecondResult);

    Allure.step("Click First Result (" + searchKeyWord + ") ");
    searchPage.clickSelectResult(0);
    RecipePage recipePage = new RecipePage(driver);

    Allure.step("Scroll Down 350px to Show Recipe Page (" + searchKeyWord + ") ");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("Recipe Page For " + searchKeyWord + " - Take Screen Shot");
    File firstResultPage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "SearchTest/" + searchKeyWord + "RecipePage.jpg");
    allureAttached.addImage(firstResultPage);

    Allure.step("Write the " + searchKeyWord + " Recipe Page File");
    WordFile wordFile = new WordFile(Constant.getWordFilesPath() + searchKeyWord + "RecipePage.docx");
    wordFile.AddHeader(driver.getTitle());
    wordFile.AddFooter(driver.getCurrentUrl());
    wordFile.AddTitle(recipePage.getRecipeName());
    wordFile.AddTable(recipePage.getRecipeTable());
    wordFile.AddImage(recipePage.getRecipeImgPath());
    for (String[] el : recipePage.getRecipeInformation()) {
      wordFile.AddSubtitle(el[0]);
      wordFile.AddParagraph(el[1]);
    }
    wordFile.WriteWordFile();

    Allure.step("Attach the " + searchKeyWord + " Recipe Page File");
    File recipeFile = new File(Constant.getWordFilesPath() + searchKeyWord + "RecipePage.docx");
    allureAttached.addFile(recipeFile, "docx");

    Allure.step("Scroll Down 700px to Show Bookmarks Button in Recipe Page (" + searchKeyWord + ") ");
    JavaScript.executeScript("window.scrollTo(0,700)");

    Allure.step("Click Bookmarks Button From Recipe Page (" + searchKeyWord + ") ");
    recipePage.clickRecipeBookmarksBtn();

    Allure.step(
        "After Click Bookmarks Button From Recipe Page (" + searchKeyWord + ") - Take Screen Shot");
    File clickBookmarksFromRecipePage = takeScreenShot
        .takeScreenShot(
            Constant.getScreenShotsPath() + "SearchTest/" + searchKeyWord + "ClickBookmarksFromRecipePage.jpg");
    allureAttached.addImage(clickBookmarksFromRecipePage);
  }

}
