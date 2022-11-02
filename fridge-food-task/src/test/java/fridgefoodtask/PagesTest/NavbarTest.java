package fridgefoodtask.PagesTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import fridgefoodtask.Core.CSVFile;
import fridgefoodtask.Core.Constant;
import fridgefoodtask.Core.TaskBase;
import fridgefoodtask.Core.WordFile;
import fridgefoodtask.Pages.RecipePage;
import fridgefoodtask.Pages.SearchPage;

public class NavbarTest extends TaskBase {
  @Test
  public void BeforeSignIn() throws IOException {
    System.out.println("Navbar - Before Sign In");
    driver.get("https://www.myfridgefood.com/Search?q=cake");
    SearchPage searchPage = new SearchPage(driver);
    CSVFile.writeDataLineByLine(Constant.getCSVFilesPath() + "test1.csv", searchPage.getFirstPageResults(),
        new String[] { "Recipe Name", "Recipe Link", "Recipe Category", "Recipe Image Source" });
    searchPage.clickSelectResult(0);
    RecipePage recipePage = new RecipePage(driver);
    CSVFile.writeDataLineByLine(Constant.getCSVFilesPath() + "test2.csv", recipePage.getRecipeInformation(),
        new String[] { "Desc", "Desc Value" });
    System.out.println(driver.findElement(By.cssSelector("div[class='recipe-text']>div")).getText());
    System.out.println("*********************");
    System.out.println(driver.findElement(By.xpath("//*[@id='recipe-page-block']/div[1]/div[2]/div[1]")).getText());
    System.out.println("-------------------------");
    WordFile wfile = new WordFile(Constant.getWordFilesPath() + "test.docx");
    wfile.AddTable(recipePage.getRecipeTable());
    wfile.WriteWordFile();
  }

  @Test
  public void AfterSignIn() {
    System.out.println("Navbar - After Sign In");
  }
}
