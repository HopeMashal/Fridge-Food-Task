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
import fridgefoodtask.Pages.ContestPage;
import io.qameta.allure.Allure;

public class ContestTest extends TaskBase {
  @Test
  public void ContestTesting() throws IOException, InvalidFormatException {
    Allure.step("Go to Contests Page Using Navbar Method");
    ContestPage contestsPage = new ContestPage(driver);
    contestsPage.clickContestsBtn();

    Allure.step("Check URL & Title of Contests Page");
    String[] contestsHref = contestsPage.contestsHref();
    Assert.assertEquals(driver.getTitle(), contestsHref[0], "Title of Contests Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), contestsHref[1], "URL of Contests Page NOT MATCH");

    Allure.step("Scroll Down 350px to Show Contests Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("Contests Page - Take Screen Shot");
    File contestPage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "ContestsTest/" + "ContestsPage.jpg");
    allureAttached.addImage(contestPage);

    Allure.step("Write Contests Page File");
    String wordFilePath = Constant.getWordFilesPath() + "ContestsPage.docx";
    WordFile wordFile = new WordFile(wordFilePath);
    wordFile.AddHeader(driver.getTitle());
    wordFile.AddFooter(driver.getCurrentUrl());
    wordFile.AddTitle(contestsPage.getContestTitle());
    for (String el : contestsPage.getContestParagraphs()) {
      wordFile.AddParagraph(el);
    }
    wordFile.AddLists(contestsPage.getContestList());
    wordFile.AddImage(contestsPage.getContestImgPath());
    wordFile.WriteWordFile();

    Allure.step("Attach Contests Page File");
    File contestFile = new File(wordFilePath);
    allureAttached.addFile(contestFile, "doc");

    Allure.step("Write the Contests Archived Output File");
    File contestArchivedFile = new File(Constant.getCSVFilesPath() + "ContestsArchivedOutput.csv");
    CSVFile.writeDataLineByLine(contestArchivedFile.getPath(),
        contestsPage.getArchivedContest(),
        new String[] { "Archived Title", "Archived Date" });

    Allure.step("Attach the Contests Archived Output File");
    allureAttached.addFile(contestArchivedFile, "csv");
  }
}
