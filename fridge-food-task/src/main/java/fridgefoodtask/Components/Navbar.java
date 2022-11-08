package fridgefoodtask.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Core.Constants;

public class Navbar {
  public WebDriver driver;
  WebElement homeBtn;
  WebElement bookmarksBtn;
  WebElement contestsBtn;
  WebElement tipsBtn;
  WebElement submitRecipeBtn;
  WebElement deciderBtn;
  WebElement copyrightPolicyBtn;
  WebElement myProfileBtn;
  WebElement searchBox;
  WebElement loginBtn;
  WebElement logoutBtn;

  public Navbar(WebDriver driver) {
    this.driver = driver;
  }

  public void clickLoginBtn() {
    loginBtn = driver.findElement(By.xpath(Constants.LoginBtnXPath));
    loginBtn.click();
  }

  public void clickLogoutBtn() {
    logoutBtn = driver.findElement(By.xpath(Constants.LogoutBtnXPath));
    logoutBtn.click();
  }

  public void clickHomeBtn() {
    homeBtn = driver.findElement(By.xpath(Constants.HomeBtnXPath));
    homeBtn.click();
  }

  public void clickBookmarksBtn() {
    bookmarksBtn = driver.findElement(By.xpath(Constants.BookmarksBtnXPath));
    bookmarksBtn.click();
  }

  public void clickContestsBtn() {
    contestsBtn = driver.findElement(By.xpath(Constants.ContestsBtnXPath));
    contestsBtn.click();
  }

  public void clickTipsBtn() {
    tipsBtn = driver.findElement(By.xpath(Constants.TipsBtnXPath));
    tipsBtn.click();
  }

  public void clickSubmitRecipeBtn() {
    submitRecipeBtn = driver.findElement(By.xpath(Constants.SubmitRecipeBtnXPath));
    submitRecipeBtn.click();
  }

  public void clickDeciderBtn() {
    deciderBtn = driver.findElement(By.xpath(Constants.DeciderBtnXPath));
    deciderBtn.click();
  }

  public void clickCopyrightPolicyBtn() {
    copyrightPolicyBtn = driver.findElement(By.xpath(Constants.CopyrightPolicyBtnXPath));
    copyrightPolicyBtn.click();
  }

  public void clickMyProfileBtn() {
    myProfileBtn = driver.findElement(By.xpath(Constants.MyProfileBtnXPath));
    myProfileBtn.click();
  }

  public String[] homeHref() {
    homeBtn = driver.findElement(By.xpath(Constants.HomeBtnXPath));
    String homeHrefValue = homeBtn.getAttribute("href");
    String[] homeList = new String[] { "MyFridgeFood - Home", homeHrefValue };
    return homeList;
  }

  public String[] bookmarksHref() {
    bookmarksBtn = driver.findElement(By.xpath(Constants.BookmarksBtnXPath));
    String bookmarksHrefValue = bookmarksBtn.getAttribute("href");
    String[] bookmarksList = new String[] { "MyFridgeFood - Bookmarks", bookmarksHrefValue };
    return bookmarksList;
  }

  public String[] contestsHref() {
    contestsBtn = driver.findElement(By.xpath(Constants.ContestsBtnXPath));
    String contestsHrefValue = contestsBtn.getAttribute("href");
    String[] contestsList = new String[] { "MyFridgeFood - Contests", contestsHrefValue };
    return contestsList;
  }

  public String[] tipsHref() {
    tipsBtn = driver.findElement(By.xpath(Constants.TipsBtnXPath));
    String tipsHrefValue = tipsBtn.getAttribute("href");
    String[] tipsList = new String[] { "MyFridgeFood - Tips", tipsHrefValue };
    return tipsList;
  }

  public String[] submitRecipeHref() {
    submitRecipeBtn = driver.findElement(By.xpath(Constants.SubmitRecipeBtnXPath));
    String submitRecipeHrefValue = submitRecipeBtn.getAttribute("href");
    String[] submitRecipeList = new String[] { "MyFridgeFood - Submit a Recipe", submitRecipeHrefValue };
    return submitRecipeList;
  }

  public String[] deciderHref() {
    deciderBtn = driver.findElement(By.xpath(Constants.DeciderBtnXPath));
    String deciderHrefValue = deciderBtn.getAttribute("href");
    String[] deciderList = new String[] { "MyFridgeFood - The Decider", deciderHrefValue };
    return deciderList;
  }

  public String[] copyrightPolicyHref() {
    copyrightPolicyBtn = driver.findElement(By.xpath(Constants.CopyrightPolicyBtnXPath));
    String copyrightPolicyHrefValue = copyrightPolicyBtn.getAttribute("href");
    String[] copyrightPolicyList = new String[] { "MyFridgeFood - Copyright Policy", copyrightPolicyHrefValue };
    return copyrightPolicyList;
  }

  public String[] myProfileHref() {
    myProfileBtn = driver.findElement(By.xpath(Constants.MyProfileBtnXPath));
    String myProfileHrefValue = myProfileBtn.getAttribute("href");
    String[] myProfileList = new String[] { "MyFridgeFood - MyProfile", myProfileHrefValue };
    return myProfileList;
  }

  public String[] searchHref(String search) {
    String searchHrefValue = Constants.URL + "/Search?q=" + search.replace(" ", "%20");
    String[] searchList = new String[] { "MyFridgeFood - Search", searchHrefValue };
    return searchList;
  }

  public String[] searchIngredientsHref() {
    String searchHrefValue = Constants.URL + "/search-by-ingredients";
    String[] searchList = new String[] { "MyFridgeFood - Search By Ingredients", searchHrefValue };
    return searchList;
  }

  public String[] loginHref() {
    String loginHrefValue = Constants.URL + "/login";
    String[] loginList = new String[] { "MyFridgeFood - login", loginHrefValue };
    return loginList;
  }

  public String[] registerHref() {
    String registerHrefValue = Constants.URL + "/register";
    String[] registerList = new String[] { "MyFridgeFood - Register", registerHrefValue };
    return registerList;
  }

  public void searchMethod(String search) {
    searchBox = driver.findElement(By.id(Constants.SearchBoxID));
    searchBox.sendKeys(search);
    searchBox.sendKeys(Keys.ENTER);
  }
}
