package fridgefoodtask.PagesTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fridgefoodtask.Core.CSVFile;
import fridgefoodtask.Core.Constants;
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
    String homeInputFile = Constants.CSVFilesPath + "homeInput.csv";
    String deciderInputFile = Constants.CSVFilesPath + "deciderInput.csv";
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
    File homeInputFile = new File(Constants.CSVFilesPath + "homeInput.csv");
    allureAttached.addFile(homeInputFile, "csv");

    Allure.step("Attach deciderInput.csv File");
    File deciderInputFile = new File(Constants.CSVFilesPath + "deciderInput.csv");
    allureAttached.addFile(deciderInputFile, "csv");

    Allure.step("Go to Home Page Using clickHomeBtn Method");
    HomePage homePage = new HomePage(driver);
    homePage.clickHomeBtn();

    Allure.step("Check URL & Title of Home Page");
    String[] homeHref = homePage.homeHref();
    Assert.assertEquals(driver.getTitle(), homeHref[0], "Title of Home Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), homeHref[1], "URL of Home Page NOT MATCH");

    Allure.step("Scroll Down 550px to Show Home Page");
    JavaScript.executeScript("window.scrollTo(0,550)");

    Allure.step("Click Clear All Button in Home Page");
    homePage.clickClearAllBtn();

    Allure.step("Click Ingredients CheckBox in Home Page");
    homePage.clickSelectIngredientCheckBox(Integer.parseInt(Int_1));
    homePage.clickSelectIngredientCheckBox(Integer.parseInt(Int_2));
    homePage.clickSelectIngredientCheckBox(Integer.parseInt(Int_3));
    homePage.clickSelectIngredientCheckBox(Integer.parseInt(Int_4));

    Allure.step("After Click Ingredients CheckBox in Home Page - Take Screen Shot");
    File homePageImage = takeScreenShot
        .takeScreenShot(
            Constants.ScreenShotsPath + "HomeTest/afterClickIngredientsCheckboxForDataNo_" + index + ".jpg");
    allureAttached.addImage(homePageImage);

    Allure.step(
        "Click Find Recipes Button in Home Page, then the Search Page Will Open Using the Selection of Ingredients");
    homePage.clickFindRecipesBtn();
    SearchPage searchPage = new SearchPage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.RecipeContainerXPath)));

    Allure.step("Check URL & Title of Search Page Using the Selection of Ingredients");
    String[] searchHref = searchPage.searchIngredientsHref();
    Assert.assertEquals(driver.getTitle(), searchHref[0],
        "Title of Search Page Using the Selection of Ingredients NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), searchHref[1],
        "URL of Search Page Using the Selection of Ingredients NOT MATCH");

    Allure.step("Scroll Down 350px to Show Search Page Using the Selection of Ingredients");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("After Open Search Page Using the Selection of Ingredients - Take Screen Shot");
    File searchResultsPage = takeScreenShot
        .takeScreenShot(
            Constants.ScreenShotsPath + "HomeTest/afterOpenSearchPageUsingIngredientsForDataNo_" + index + ".jpg");
    allureAttached.addImage(searchResultsPage);

    Allure.step("Write Output File of the Search Page Using Selection of Ingredients");
    File searchPageFile = new File(
        Constants.CSVFilesPath + "outputFileOfSearchPageUsingIngredientsForDataNo_" + index + ".csv");
    CSVFile.writeDataLineByLine(searchPageFile.getPath(),
        searchPage.getHomeSearchFirstPageResults(),
        new String[] { "Recipe Name", "Recipe Link", "Recipe Cooking Time", "Recipe Image Source",
            "Missing Ingredients in the Recipe" });

    Allure.step("Attach Output File of the Search Page Using Selection of Ingredients");
    allureAttached.addFile(searchPageFile, "csv");

    Allure.step("Go to Decider Page Using clickDeciderBtn Method");
    DeciderPage deciderPage = new DeciderPage(driver);
    deciderPage.clickDeciderBtn();

    Allure.step("Check URL & Title of Decider Page");
    String[] deciderHref = deciderPage.deciderHref();
    Assert.assertEquals(driver.getTitle(), deciderHref[0], "Title of Decider Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), deciderHref[1], "URL of Decider Page NOT MATCH");

    Allure.step("Scroll Down 350px to Show Decider Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("After Open Decider Page - Take Screen Shot");
    File deciderPageImage = takeScreenShot
        .takeScreenShot(Constants.ScreenShotsPath + "HomeTest/afterOpenDeciderPageForDataNo_" + index + ".jpg");
    allureAttached.addImage(deciderPageImage);

    Allure.step("Answer the Questions on the Decider Page");
    deciderPage.clickAllAnswersBtn(new String[] { A_1, A_2, A_3, A_4 });

    Allure.step("Scroll Down 350px to Show Decider Results Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("After Open Decider Results Page - Take Screen Shot");
    File deciderResultsPageImage = takeScreenShot
        .takeScreenShot(
            Constants.ScreenShotsPath + "HomeTest/afterOpenDeciderResultsPageForDataNo_" + index + ".jpg");
    allureAttached.addImage(deciderResultsPageImage);

    Allure.step("Write Output File Of the Decider Results Page");
    File deciderResultPageFile = new File(
        Constants.CSVFilesPath + "outputFileOFDeciderResultsPageForDataNo_" + index + ".csv");
    CSVFile.writeDataLineByLine(deciderResultPageFile.getPath(),
        deciderPage.getFirstPageResults(),
        new String[] { "Recipe Name", "Recipe Link", "Recipe Details", "Recipe Image Source" });

    Allure.step("Attach Output File Of the Decider Results Page");
    allureAttached.addFile(deciderResultPageFile, "csv");

    Allure.step("Click (Just pick one I can make!) Button");
    deciderPage.clickPickOneResultBtn();
    RecipePage recipePage = new RecipePage(driver);

    Allure.step("Scroll Down 350px to Show Recipe Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("After Open Recipe Page - Take Screen Shot");
    File recipeResultPage = takeScreenShot
        .takeScreenShot(Constants.ScreenShotsPath + "HomeTest/afterOpenRecipePageForDataNo_" + index + ".jpg");
    allureAttached.addImage(recipeResultPage);

    Allure.step("Write the Recipe Page File");
    String wordFilePath = Constants.WordFilesPath + "RecipePageFileForDataNo_" + index + ".docx";
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

    index++;
  }
}
