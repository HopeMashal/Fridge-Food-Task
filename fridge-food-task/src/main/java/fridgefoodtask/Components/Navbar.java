package fridgefoodtask.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fridgefoodtask.Core.Constant;

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
    loginBtn = driver.findElement(By.xpath("//div/a[@href='/login']"));
    loginBtn.click();
  }

  public void clickLogoutBtn() {
    logoutBtn = driver.findElement(By.xpath("//div[contains(@class,'header-right-links')]/a[@href='#']"));
    logoutBtn.click();
  }

  public void clickHomeBtn() {
    homeBtn = driver.findElement(By.xpath("//a[@href='/']"));
    homeBtn.click();
  }

  public void clickBookmarksBtn() {
    bookmarksBtn = driver.findElement(By.xpath("//li[@class='header-left-links']/a[@href='/bookmarks/']"));
    bookmarksBtn.click();
  }

  public void clickContestsBtn() {
    contestsBtn = driver.findElement(By.xpath("//li[@class='header-left-links']/a[@href='/contests/']"));
    contestsBtn.click();
  }

  public void clickTipsBtn() {
    tipsBtn = driver.findElement(By.xpath("//li[@class='header-left-links']/a[@href='/tips/']"));
    tipsBtn.click();
  }

  public void clickSubmitRecipeBtn() {
    submitRecipeBtn = driver.findElement(By.xpath("//li[@class='header-left-links']/a[@href='/submit-a-recipe/']"));
    submitRecipeBtn.click();
  }

  public void clickDeciderBtn() {
    deciderBtn = driver.findElement(By.xpath("//li[@class='header-left-links']/a[@href='/decider/']"));
    deciderBtn.click();
  }

  public void clickCopyrightPolicyBtn() {
    copyrightPolicyBtn = driver.findElement(By.xpath("//li[@class='header-left-links']/a[@href='/copyright-policy/']"));
    copyrightPolicyBtn.click();
  }

  public void clickMyProfileBtn() {
    myProfileBtn = driver.findElement(By.xpath("//div[contains(@class,'horizontal')]//a[@href='/myprofile']"));
    myProfileBtn.click();
  }

  public String[] homeHref() {
    homeBtn = driver.findElement(By.xpath("//a[@href='/']"));
    String homeHrefValue = homeBtn.getAttribute("href");
    String[] homeList = new String[] { "MyFridgeFood - Home", homeHrefValue };
    return homeList;
  }

  public String[] bookmarksHref() {
    bookmarksBtn = driver.findElement(By.xpath("//li[@class='header-left-links']/a[@href='/bookmarks/']"));
    String bookmarksHrefValue = bookmarksBtn.getAttribute("href");
    String[] bookmarksList = new String[] { "MyFridgeFood - Bookmarks", bookmarksHrefValue };
    return bookmarksList;
  }

  public String[] contestsHref() {
    contestsBtn = driver.findElement(By.xpath("//li[@class='header-left-links']/a[@href='/contests/']"));
    String contestsHrefValue = contestsBtn.getAttribute("href");
    String[] contestsList = new String[] { "MyFridgeFood - Contests", contestsHrefValue };
    return contestsList;
  }

  public String[] tipsHref() {
    tipsBtn = driver.findElement(By.xpath("//li[@class='header-left-links']/a[@href='/tips/']"));
    String tipsHrefValue = tipsBtn.getAttribute("href");
    String[] tipsList = new String[] { "MyFridgeFood - Tips", tipsHrefValue };
    return tipsList;
  }

  public String[] submitRecipeHref() {
    submitRecipeBtn = driver.findElement(By.xpath("//li[@class='header-left-links']/a[@href='/submit-a-recipe/']"));
    String submitRecipeHrefValue = submitRecipeBtn.getAttribute("href");
    String[] submitRecipeList = new String[] { "MyFridgeFood - Submit a Recipe", submitRecipeHrefValue };
    return submitRecipeList;
  }

  public String[] deciderHref() {
    deciderBtn = driver.findElement(By.xpath("//li[@class='header-left-links']/a[@href='/decider/']"));
    String deciderHrefValue = deciderBtn.getAttribute("href");
    String[] deciderList = new String[] { "MyFridgeFood - The Decider", deciderHrefValue };
    return deciderList;
  }

  public String[] copyrightPolicyHref() {
    copyrightPolicyBtn = driver.findElement(By.xpath("//li[@class='header-left-links']/a[@href='/copyright-policy/']"));
    String copyrightPolicyHrefValue = copyrightPolicyBtn.getAttribute("href");
    String[] copyrightPolicyList = new String[] { "MyFridgeFood - Copyright Policy", copyrightPolicyHrefValue };
    return copyrightPolicyList;
  }

  public String[] myProfileHref() {
    myProfileBtn = driver.findElement(By.xpath("//div[contains(@class,'horizontal')]//a[@href='/myprofile']"));
    String myProfileHrefValue = myProfileBtn.getAttribute("href");
    String[] myProfileList = new String[] { "MyFridgeFood - MyProfile", myProfileHrefValue };
    return myProfileList;
  }

  public String[] searchHref(String search) {
    String searchHrefValue = Constant.getURL() + "/Search?q=" + search.replace(" ", "%20");
    String[] searchList = new String[] { "MyFridgeFood - Search", searchHrefValue };
    return searchList;
  }

  public String[] searchIngredientsHref() {
    String searchHrefValue = Constant.getURL() + "/search-by-ingredients";
    String[] searchList = new String[] { "MyFridgeFood - Search By Ingredients", searchHrefValue };
    return searchList;
  }

  public String[] loginHref() {
    String loginHrefValue = Constant.getURL() + "/login";
    String[] loginList = new String[] { "MyFridgeFood - login", loginHrefValue };
    return loginList;
  }

  public String[] registerHref() {
    String registerHrefValue = Constant.getURL() + "/register";
    String[] registerList = new String[] { "MyFridgeFood - Register", registerHrefValue };
    return registerList;
  }

  public String[] logoutHref() {
    String logoutHrefValue = Constant.getURL() + "/#";
    String[] logoutList = new String[] { "MyFridgeFood - Home", logoutHrefValue };
    return logoutList;
  }

  public void searchMethod(String search) {
    searchBox = driver.findElement(By.id("search-box"));
    searchBox.sendKeys(search);
    searchBox.sendKeys(Keys.ENTER);
  }
}
