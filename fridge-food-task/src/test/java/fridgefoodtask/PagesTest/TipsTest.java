package fridgefoodtask.PagesTest;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.Test;

import fridgefoodtask.Core.CSVFile;
import fridgefoodtask.Core.Constant;
import fridgefoodtask.Core.TaskBase;
import fridgefoodtask.Core.WordFile;
import fridgefoodtask.Pages.TipPage;
import fridgefoodtask.Pages.TipsPage;
import io.qameta.allure.Allure;

public class TipsTest extends TaskBase {
  @Test
  public void TipsTesting() throws IOException, InvalidFormatException {
    Allure.step("Go to Tips Page Using Navbar Method");
    TipsPage tipsPage = new TipsPage(driver);
    tipsPage.clickTipsBtn();

    Allure.step("Check URL & Title of Tips Page");
    String[] tipsHref = tipsPage.tipsHref();
    Assert.assertEquals(driver.getTitle(), tipsHref[0], "Title of Tips Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), tipsHref[1], "URL of Tips Page NOT MATCH");

    Allure.step("Scroll Down 350px to Show Tips Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("Tips Page - Take Screen Shot");
    File tipsPageImage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "TipsTest/" + "TipsPage.jpg");
    allureAttached.addImage(tipsPageImage);

    Allure.step("Write the Tips Page Output File");
    File tipsFile = new File(Constant.getCSVFilesPath() + "TipsPageOutput.csv");
    CSVFile.writeDataLineByLine(tipsFile.getPath(),
        tipsPage.getFirstPageResults(),
        new String[] { "Tip Name", "Tip Link", "Tip Details", "Tip Image Source" });

    Allure.step("Attach the Tips Page Output File");
    allureAttached.addFile(tipsFile, "csv");

    Allure.step("Click First Tip Result");
    tipsPage.clickSelectResult(0);
    TipPage tipPage = new TipPage(driver);

    Allure.step("Scroll Down 350px to Show Tip Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("Tip Page - Take Screen Shot");
    File firstResultPage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "TipsTest/" + "TipPage.jpg");
    allureAttached.addImage(firstResultPage);

    Allure.step("Write the Tip Page File");
    String wordFilePath = Constant.getWordFilesPath() + "TipPage.docx";
    WordFile wordFile = new WordFile(wordFilePath);
    wordFile.AddHeader(driver.getTitle());
    wordFile.AddFooter(driver.getCurrentUrl());
    wordFile.AddTitle(tipPage.getTipName());
    wordFile.AddSubtitle(tipPage.getTipDescription());
    wordFile.AddParagraph(tipPage.getTipParagraph());
    wordFile.AddImage(tipPage.getTipImgPath());
    wordFile.WriteWordFile();

    Allure.step("Attach the Tip Page File");
    File tipFile = new File(wordFilePath);
    allureAttached.addFile(tipFile, "doc");
  }
}
