package fridgefoodtask.PagesTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fridgefoodtask.Core.CSVFile;
import fridgefoodtask.Core.Constant;
import fridgefoodtask.Core.TaskBase;
import fridgefoodtask.Core.WordFile;
import fridgefoodtask.Pages.DeciderPage;
import fridgefoodtask.Pages.HomePage;
import fridgefoodtask.Pages.RecipePage;
import fridgefoodtask.Pages.SearchPage;
import io.qameta.allure.Allure;

public class HomeTest extends TaskBase {
  static int index = 1;

  @DataProvider
  public static Object[][] getInputCSVData() throws Exception {
    String homeInputFile = Constant.getCSVFilesPath() + "homeInput.csv";
    String deciderInputFile = Constant.getCSVFilesPath() + "deciderInput.csv";
    List<String[]> homeLines = CSVFile.readAllLines(homeInputFile);
    homeLines.remove(0);
    List<String[]> deciderLines = CSVFile.readAllLines(deciderInputFile);
    deciderLines.remove(0);
    int colSize = homeLines.get(0).length + deciderLines.get(0).length;
    Object[][] data = new Object[homeLines.size()][colSize];
    for (int i = 0; i < data.length; i++) {
      for (int j = 0; j < homeLines.get(0).length; j++) {
        data[i][j] = homeLines.get(i)[j];
      }
      for (int j = 0; j < deciderLines.get(0).length; j++) {
        int Index = j + deciderLines.get(0).length;
        data[i][Index] = deciderLines.get(i)[j];
      }
    }
    return data;
  }

  @Test(dataProvider = "getInputCSVData")
  public void HomeTesting(String Int_1, String Int_2, String Int_3, String Int_4, String A_1, String A_2, String A_3,
      String A_4) throws IOException, InterruptedException, InvalidFormatException {
    Allure.step("Get Data From homeInput.csv & deciderInput.csv Files Using Data Provider");

    Allure.step("Attach homeInput.csv File");
    File homeInputFile = new File(Constant.getCSVFilesPath() + "homeInput.csv");
    allureAttached.addFile(homeInputFile, "csv");

    Allure.step("Attach deciderInput.csv File");
    File deciderInputFile = new File(Constant.getCSVFilesPath() + "deciderInput.csv");
    allureAttached.addFile(deciderInputFile, "csv");

    Allure.step("Go to Home Page Using Navbar Method");
    HomePage homePage = new HomePage(driver);
    homePage.clickHomeBtn();

    Allure.step("Check URL & Title of Home Page");
    String[] homeHref = homePage.homeHref();
    Assert.assertEquals(driver.getTitle(), homeHref[0], "Title of Home Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), homeHref[1], "URL of Home Page NOT MATCH");

    Allure.step("Scroll Down 550px to Show Home Page");
    JavaScript.executeScript("window.scrollTo(0,550)");

    Allure.step("Click Clear All in Home Page");
    homePage.clickClearAllBtn();

    Allure.step("Click Ingredients CheckBox");
    homePage.clickSelectIngredientCheckBox(Integer.parseInt(Int_1));
    homePage.clickSelectIngredientCheckBox(Integer.parseInt(Int_2));
    homePage.clickSelectIngredientCheckBox(Integer.parseInt(Int_3));
    homePage.clickSelectIngredientCheckBox(Integer.parseInt(Int_4));

    Allure.step("After Click Ingredients CheckBox - Take Screen Shot");
    File homePageImage = takeScreenShot
        .takeScreenShot(
            Constant.getScreenShotsPath() + "HomeTest/" + "HomePageAfterClickIngredientsCheckbox_" + index + ".jpg");
    allureAttached.addImage(homePageImage);

    Allure.step("Click Find Recipes Button - Go To Search Page Using Ingredients CheckBox");
    homePage.clickFindRecipesBtn();
    SearchPage searchPage = new SearchPage(driver);
    Thread.sleep(3000);

    Allure.step("Check URL & Title of Search Page Using Ingredients CheckBox");
    String[] searchHref = searchPage.searchIngredientsHref();
    Assert.assertEquals(driver.getTitle(), searchHref[0], "Title of Search Page Using Ingredients CheckBox NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), searchHref[1],
        "URL of Search Page Using Ingredients CheckBox NOT MATCH");

    Allure.step("Scroll Down 350px to Show Search Results Using Ingredients");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("Search Results Page Using Ingredients - Take Screen Shot");
    File searchResultsPage = takeScreenShot
        .takeScreenShot(
            Constant.getScreenShotsPath() + "HomeTest/" + "SearchResultsPageUsingIngredients_" + index + ".jpg");
    allureAttached.addImage(searchResultsPage);

    Allure.step("Write the Search Page Using Ingredients Output File");
    File searchPageFile = new File(Constant.getCSVFilesPath() + "SearchPageUsingIngredients_" + index + "_Output.csv");
    CSVFile.writeDataLineByLine(searchPageFile.getPath(),
        searchPage.getHomeSearchFirstPageResults(),
        new String[] { "Recipe Name", "Recipe Link", "Recipe Cooking Time", "Recipe Image Source",
            "Missing Ingredients in the Recipe" });

    Allure.step("Attach the Search Page Using Ingredients Output File");
    allureAttached.addFile(searchPageFile, "csv");

    Allure.step("Go to Decider Page Using Navbar Method");
    DeciderPage deciderPage = new DeciderPage(driver);
    deciderPage.clickDeciderBtn();

    Allure.step("Check URL & Title of Decider Page");
    String[] deciderHref = deciderPage.deciderHref();
    Assert.assertEquals(driver.getTitle(), deciderHref[0], "Title of Decider Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), deciderHref[1], "URL of Decider Page NOT MATCH");

    Allure.step("Scroll Down 350px to Show Decider Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("Decider Page - Take Screen Shot");
    File deciderPageImage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "HomeTest/" + "DeciderPage_" + index + ".jpg");
    allureAttached.addImage(deciderPageImage);

    Allure.step("Select Answer in Decider Page");
    deciderPage.clickAllAnswersBtn(new String[] { A_1, A_2, A_3, A_4 });

    Allure.step("Scroll Down 350px to Show Decider Results Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("Decider Results Page - Take Screen Shot");
    File deciderResultsPageImage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "HomeTest/" + "DeciderResultsPage_" + index + ".jpg");
    allureAttached.addImage(deciderResultsPageImage);

    Allure.step("Write the Decider Results Page Output File");
    File deciderResultPageFile = new File(Constant.getCSVFilesPath() + "DeciderResultsPage_" + index + "_Output.csv");
    CSVFile.writeDataLineByLine(deciderResultPageFile.getPath(),
        deciderPage.getFirstPageResults(),
        new String[] { "Recipe Name", "Recipe Link", "Recipe Details", "Recipe Image Source" });

    Allure.step("Attach the Decider Results Page Output File");
    allureAttached.addFile(deciderResultPageFile, "csv");

    Allure.step("Click (Just pick one I can make!) Button");
    deciderPage.clickPickOneResultBtn();
    RecipePage recipePage = new RecipePage(driver);

    Allure.step("Scroll Down 350px to Show Recipe Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("Recipe Page - Take Screen Shot");
    File recipeResultPage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "HomeTest/" + "RecipePage_" + index + ".jpg");
    allureAttached.addImage(recipeResultPage);

    Allure.step("Write the Recipe Page File");
    String wordFilePath = Constant.getWordFilesPath() + "RecipePage_" + index + ".docx";
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

    Allure.step("Attach the Recipe Page File");
    File recipeFile = new File(wordFilePath);
    allureAttached.addFile(recipeFile, "doc");

    Allure.step("Scroll Down 700px to Show Bookmarks Button in Recipe Page");
    JavaScript.executeScript("window.scrollTo(0,700)");

    Allure.step("Click Bookmarks Button From Recipe Page");
    recipePage.clickRecipeBookmarksBtn();

    Allure.step(
        "After Click Bookmarks Button From Recipe Page - Take Screen Shot");
    File clickBookmarksFromRecipePage = takeScreenShot
        .takeScreenShot(
            Constant.getScreenShotsPath() + "HomeTest/" + "ClickBookmarksFromRecipePage_" + index + ".jpg");
    allureAttached.addImage(clickBookmarksFromRecipePage);

    // Allure.step("Go to Home Page Using Navbar Method");
    // recipePage.clickHomeBtn();

    // Allure.step("Click Clear All in Home Page");
    // homePage.clickClearAllBtn();

    index++;
  }
}
