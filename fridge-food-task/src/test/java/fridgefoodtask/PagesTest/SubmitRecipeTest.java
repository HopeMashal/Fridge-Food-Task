package fridgefoodtask.PagesTest;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import fridgefoodtask.Core.Constant;
import fridgefoodtask.Core.TaskBase;
import fridgefoodtask.Core.WordFile;
import fridgefoodtask.Pages.SubmitRecipePage;
import io.qameta.allure.Allure;

public class SubmitRecipeTest extends TaskBase {
  @Test
  public void SubmitRecipeTesting() throws IOException {
    Allure.step("Go to Submit a Recipe Page Using Navbar Method");
    SubmitRecipePage submitRecipePage = new SubmitRecipePage(driver);
    submitRecipePage.clickSubmitRecipeBtn();

    Allure.step("Check URL & Title of Submit a Recipe Page");
    String[] submitRecipeHref = submitRecipePage.submitRecipeHref();
    Assert.assertEquals(driver.getTitle(), submitRecipeHref[0], "Title of Submit a Recipe Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), submitRecipeHref[1], "URL of Submit a Recipe Page NOT MATCH");

    Allure.step("Scroll Down 350px to Show Submit a Recipe Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("Submit a Recipe Page - Take Screen Shot");
    File submitPage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "SubmitRecipeTest/" + "SubmitRecipePage.jpg");
    allureAttached.addImage(submitPage);

    Allure.step("Write Submit a Recipe Page File");
    String wordFilePath = Constant.getWordFilesPath() + "SubmitRecipePage.docx";
    WordFile wordFile = new WordFile(wordFilePath);
    wordFile.AddHeader(driver.getTitle());
    wordFile.AddFooter(driver.getCurrentUrl());
    wordFile.AddTitle(submitRecipePage.getSubmitRecipeTitle());
    wordFile.AddLists(submitRecipePage.getSubmitRecipeList());
    wordFile.WriteWordFile();

    Allure.step("Attach Submit a Recipe Page File");
    File contestFile = new File(wordFilePath);
    allureAttached.addFile(contestFile, "doc");
  }
}
