package fridgefoodtask.PagesTest;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import fridgefoodtask.Core.Constant;
import fridgefoodtask.Core.TaskBase;
import fridgefoodtask.Core.WordFile;
import fridgefoodtask.Pages.CopyrightPolicyPage;
import io.qameta.allure.Allure;

public class CopyrightPolicyTest extends TaskBase {
  @Test
  public void CopyrightPolicyTesting() throws IOException {
    Allure.step("Go to Copyright Policy Page Using Navbar Method");
    CopyrightPolicyPage copyrightPolicyPage = new CopyrightPolicyPage(driver);
    copyrightPolicyPage.clickCopyrightPolicyBtn();

    Allure.step("Check URL & Title of Copyright Policy Page");
    String[] copyrightHref = copyrightPolicyPage.copyrightPolicyHref();
    Assert.assertEquals(driver.getTitle(), copyrightHref[0], "Title of Copyright Policy Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), copyrightHref[1], "URL of Copyright Policy Page NOT MATCH");

    Allure.step("Scroll Down 350px to Show Copyright Policy Page");
    JavaScript.executeScript("window.scrollTo(0,350)");

    Allure.step("Copyright Policy Page - Take Screen Shot");
    File copyrightPage = takeScreenShot
        .takeScreenShot(Constant.getScreenShotsPath() + "CopyrightPolicyTest/" + "CopyrightPolicyPage.jpg");
    allureAttached.addImage(copyrightPage);

    Allure.step("Write Copyright Policy Page File");
    String wordFilePath = Constant.getWordFilesPath() + "CopyrightPolicyPage.docx";
    WordFile wordFile = new WordFile(wordFilePath);
    wordFile.AddHeader(driver.getTitle());
    wordFile.AddFooter(driver.getCurrentUrl());
    wordFile.AddParagraph(copyrightPolicyPage.getFirstElement());
    for (String el : copyrightPolicyPage.getSecondElement()) {
      wordFile.AddParagraph(el);
    }
    wordFile.AddLists(copyrightPolicyPage.getThirdElement());
    for (String el : copyrightPolicyPage.getFourthElement()) {
      wordFile.AddParagraph(el);
    }
    wordFile.AddLists(copyrightPolicyPage.getFifthElement());
    for (String el : copyrightPolicyPage.getSixthElement()) {
      wordFile.AddParagraph(el);
    }
    wordFile.AddLists(copyrightPolicyPage.getSeventhElement());
    wordFile.WriteWordFile();

    Allure.step("Attach Copyright Policy Page File");
    File contestFile = new File(wordFilePath);
    allureAttached.addFile(contestFile, "doc");
  }
}
