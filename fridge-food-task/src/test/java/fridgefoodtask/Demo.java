package fridgefoodtask;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import fridgefoodtask.Core.Constants;
import fridgefoodtask.Core.OpenBrowser;
import fridgefoodtask.Core.PropertiesFile;
import fridgefoodtask.Pages.BookmarksPage;
import fridgefoodtask.Pages.DeciderPage;
import fridgefoodtask.Pages.HomePage;
import fridgefoodtask.Pages.LogInPage;
import fridgefoodtask.Pages.RecipePage;
import fridgefoodtask.Pages.SearchPage;

public class Demo {
  WebDriver driver;
  JavascriptExecutor JavaScript;
  String searchKeyWord = "Cake";

  @Test
  public void testingForDemo() throws Exception {
    driver = OpenBrowser.openChromeWithOptions();
    JavaScript = (JavascriptExecutor) driver;
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

    driver.get(Constants.URL);

    LogInPage logInPage = new LogInPage(driver);
    logInPage.clickLoginBtn();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Constants.EmailBoxID)));
    String[] loginHref = logInPage.loginHref();
    Assert.assertEquals(driver.getTitle(), loginHref[0], "Title of Login Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), loginHref[1], "URL of Login Page NOT MATCH");

    String propFilePath = Constants.PropertiesFilesPath + "props.properties";
    String email = PropertiesFile.getProperty(propFilePath, "email");
    String password = PropertiesFile.getProperty(propFilePath, "password");

    logInPage.LogInMethod(email, password);

    JavaScript.executeScript("window.scrollTo(0,350)");

    logInPage.clickSubmitBtn();

    try {
      wait.until(ExpectedConditions.alertIsPresent());
      driver.switchTo().alert().accept();
    } catch (Exception e) {
      Assert.fail("Login Failed");
    }

    SearchPage searchPage = new SearchPage(driver);
    searchPage.searchMethod(searchKeyWord);

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.RecipeContainerXPath)));
    String[] searchHref = searchPage.searchHref(searchKeyWord);
    Assert.assertEquals(driver.getTitle(), searchHref[0], "Title of " + searchKeyWord + " Search Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), searchHref[1], "URL of " + searchKeyWord + " Search Page NOT MATCH");

    JavaScript.executeScript("window.scrollTo(0,350)");

    searchPage.clickSelectBookmarksBtn(1);
    Thread.sleep(2000);

    searchPage.clickSelectResult(0);
    RecipePage recipePage = new RecipePage(driver);

    JavaScript.executeScript("window.scrollTo(0,350)");

    JavaScript.executeScript("window.scrollTo(0,700)");
    Thread.sleep(2000);

    recipePage.clickRecipeBookmarksBtn();
    Thread.sleep(2000);

    HomePage homePage = new HomePage(driver);
    homePage.clickHomeBtn();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Constants.FindRecipesBtnCssSelector)));
    String[] homeHref = homePage.homeHref();
    Assert.assertEquals(driver.getTitle(), homeHref[0], "Title of Home Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), homeHref[1], "URL of Home Page NOT MATCH");

    JavaScript.executeScript("window.scrollTo(0,650)");

    Thread.sleep(1000);
    homePage.clickSelectIngredientCheckBox(Integer.parseInt("9"));
    Thread.sleep(1000);
    homePage.clickSelectIngredientCheckBox(Integer.parseInt("12"));
    Thread.sleep(1000);
    homePage.clickSelectIngredientCheckBox(Integer.parseInt("6"));
    Thread.sleep(1000);
    homePage.clickSelectIngredientCheckBox(Integer.parseInt("10"));

    homePage.clickFindRecipesBtn();
    SearchPage homeSearchPage = new SearchPage(driver);

    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Constants.RecipeContainerXPath)));
    String[] homeSearchHref = homeSearchPage.searchIngredientsHref();
    Assert.assertEquals(driver.getTitle(), homeSearchHref[0],
        "Title of Search Page Using the Selection of Ingredients NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), homeSearchHref[1],
        "URL of Search Page Using the Selection of Ingredients NOT MATCH");

    JavaScript.executeScript("window.scrollTo(0,350)");

    DeciderPage deciderPage = new DeciderPage(driver);
    deciderPage.clickDeciderBtn();

    String[] deciderHref = deciderPage.deciderHref();
    Assert.assertEquals(driver.getTitle(), deciderHref[0], "Title of Decider Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), deciderHref[1], "URL of Decider Page NOT MATCH");

    JavaScript.executeScript("window.scrollTo(0,350)");

    deciderPage.clickAllAnswersBtn(new String[] { "Yes", "No", "Yes", "No" });

    JavaScript.executeScript("window.scrollTo(0,550)");

    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Constants.PickOneResultBtnCssSelector)));
    deciderPage.clickPickOneResultBtn();

    JavaScript.executeScript("window.scrollTo(0,450)");
    Thread.sleep(2000);

    BookmarksPage bookmarksPage = new BookmarksPage(driver);
    bookmarksPage.clickBookmarksBtn();
    Thread.sleep(1000);

    String[] bookmarksHref = bookmarksPage.bookmarksHref();
    Assert.assertEquals(driver.getTitle(), bookmarksHref[0], "Title of Bookmarks Page NOT MATCH");
    Assert.assertEquals(driver.getCurrentUrl(), bookmarksHref[1], "URL of Bookmarks Page NOT MATCH");

    JavaScript.executeScript("window.scrollTo(0,350)");
    Thread.sleep(2000);

    bookmarksPage.clickSelectBookmarksBtn(1);
    Thread.sleep(2000);
    
    bookmarksPage.deleteAllBookmarksResult();
    Thread.sleep(2000);

    bookmarksPage.clickLogoutBtn();
    Thread.sleep(2000);

    driver.quit();
  }
}
