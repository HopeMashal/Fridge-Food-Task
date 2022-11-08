package fridgefoodtask.PagesTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fridgefoodtask.Core.CSVFile;
import fridgefoodtask.Core.Constants;
import fridgefoodtask.Core.TaskBase;
import fridgefoodtask.Core.WordFile;
import fridgefoodtask.Pages.RecipePage;
import fridgefoodtask.Pages.SearchPage;
import io.qameta.allure.Allure;

public class SearchTest extends TaskBase {

  @DataProvider
  public static Object[][] getInputCSVData() throws Exception {
    String inputFile = Constants.CSVFilesPath + "searchInput.csv";
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
    Allure.step("Get Data From searchInput.csv File Using Data Provider");

    Allure.step("Attach searchInput.csv File");
    File searchInputFile = new File(Constants.CSVFilesPath + "searchInput.csv");
    allureAttached.addFile(searchInputFile, "csv");

    Allure.step("Go to " + searchKeyWord + " Search Page Using searchMethod");
    SearchPage searchPage = new SearchPage(driver);
    searchPage.searchMethod(searchKeyWord);

    Allure.step("Check URL & Title of " + searchKeyWord + " Search Page");
    String[] searchHref = searchPage.searchHref(searchKeyWord);
    Assert.assertEquals(driver.getTitle(), searchHref[0], "Title of " + searchKeyWord + " Search Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), searchHref[1], "URL of " + searchKeyWord + " Search Page NOT MATCH");

    Allure.step("Scroll Down 350px to Show " + searchKeyWord + " Search Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("After Open " + searchKeyWord + "Search Page - Take Screen Shot");
    File searchResultsPage = takeScreenShot
        .takeScreenShot(Constants.ScreenShotsPath + "SearchTest/afterOpen" + searchKeyWord + "SearchPage.jpg");
    allureAttached.addImage(searchResultsPage);

    Allure.step("Write Output File of the " + searchKeyWord + " Search Page");
    File searchPageFile = new File(Constants.CSVFilesPath + "outputFileOf" + searchKeyWord + "SearchPage.csv");
    CSVFile.writeDataLineByLine(searchPageFile.getPath(),
        searchPage.getFirstPageResults(),
        new String[] { "Recipe Name", "Recipe Link", "Recipe Category", "Recipe Image Source" });

    Allure.step("Attach Output File of the " + searchKeyWord + " Search Page");
    allureAttached.addFile(searchPageFile, "csv");

    Allure.step("Click Bookmarks Button For Second Result in " + searchKeyWord + " Results Page");
    searchPage.clickSelectBookmarksBtn(1);

    Allure.step(
        "After Click Bookmarks Button For Second Result in " + searchKeyWord + " Results Page - Take Screen Shot");
    File clickBookmarksForSecondResult = takeScreenShot
        .takeScreenShot(
            Constants.ScreenShotsPath + "SearchTest/afterClickBookmarksBtnForSecondResultIn" + searchKeyWord
                + "ResultPage.jpg");
    allureAttached.addImage(clickBookmarksForSecondResult);

    Allure.step("Click First Result in " + searchKeyWord + " Results Page");
    searchPage.clickSelectResult(0);
    RecipePage recipePage = new RecipePage(driver);

    Allure.step("Scroll Down 350px to Show " + searchKeyWord + " Recipe Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("After Open " + searchKeyWord + "Recipe Page - Take Screen Shot");
    File firstResultPage = takeScreenShot
        .takeScreenShot(Constants.ScreenShotsPath + "SearchTest/afterOpen" + searchKeyWord + "RecipePage.jpg");
    allureAttached.addImage(firstResultPage);

    Allure.step("Write the " + searchKeyWord + " Recipe Page File");
    String wordFilePath = Constants.WordFilesPath + searchKeyWord + "RecipePageFile.docx";
    WordFile wordFile = new WordFile(wordFilePath);
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
    File recipeFile = new File(wordFilePath);
    allureAttached.addFile(recipeFile, "doc");

    Allure.step("Scroll Down 700px to Show Bookmarks Button in " + searchKeyWord + " Recipe Page");
    JavaScript.executeScript("window.scrollTo(0,700)");

    Allure.step("Click Bookmarks Button From " + searchKeyWord + " Recipe Page");
    recipePage.clickRecipeBookmarksBtn();

    Allure.step(
        "After Click Bookmarks Button From " + searchKeyWord + " Recipe Page - Take Screen Shot");
    File clickBookmarksFromRecipePage = takeScreenShot
        .takeScreenShot(
            Constants.ScreenShotsPath + "SearchTest/afterClickBookmarksBtnFrom" + searchKeyWord + "RecipePage.jpg");
    allureAttached.addImage(clickBookmarksFromRecipePage);
  }

}
