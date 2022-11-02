package fridgefoodtask.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    loginBtn = driver.findElement(By.linkText("Login"));
    loginBtn.click();
  }

  public void clickLogoutBtn() {
    logoutBtn = driver.findElement(By.linkText("Logout"));
    logoutBtn.click();
  }

  public void clickHomeBtn() {
    homeBtn = driver.findElement(By.xpath("//a[@href='/']"));
    homeBtn.click();
  }

  public void clickBookmarksBtn() {
    bookmarksBtn = driver.findElement(By.linkText("Bookmarks"));
    bookmarksBtn.click();
  }

  public void clickContestsBtn() {
    contestsBtn = driver.findElement(By.linkText("Contests"));
    contestsBtn.click();
  }

  public void clickTipsBtn() {
    tipsBtn = driver.findElement(By.linkText("Tips"));
    tipsBtn.click();
  }

  public void clickSubmitRecipeBtn() {
    submitRecipeBtn = driver.findElement(By.linkText("Submit a Recipe"));
    submitRecipeBtn.click();
  }

  public void clickDeciderBtn() {
    deciderBtn = driver.findElement(By.linkText("Decider"));
    deciderBtn.click();
  }

  public void clickCopyrightPolicyBtn() {
    copyrightPolicyBtn = driver.findElement(By.linkText("Copyright Policy"));
    copyrightPolicyBtn.click();
  }

  public void clickMyProfileBtn() {
    myProfileBtn = driver.findElement(By.linkText("My Profile"));
    myProfileBtn.click();
  }

  public String[] homeHref() {
    homeBtn = driver.findElement(By.xpath("//a[@href='/']"));
    String homeHrefValue = homeBtn.getAttribute("href");
    String[] homeList = new String[] { "MyFridgeFood - Home", homeHrefValue };
    return homeList;
  }

  public String[] bookmarksHref() {
    bookmarksBtn = driver.findElement(By.linkText("Bookmarks"));
    String bookmarksHrefValue = bookmarksBtn.getAttribute("href");
    String[] bookmarksList = new String[] { "MyFridgeFood - Bookmarks", bookmarksHrefValue };
    return bookmarksList;
  }

  public String[] contestsHref() {
    contestsBtn = driver.findElement(By.linkText("Contests"));
    String contestsHrefValue = contestsBtn.getAttribute("href");
    String[] contestsList = new String[] { "MyFridgeFood - Contests", contestsHrefValue };
    return contestsList;
  }

  public String[] tipsHref() {
    tipsBtn = driver.findElement(By.linkText("Tips"));
    String tipsHrefValue = tipsBtn.getAttribute("href");
    String[] tipsList = new String[] { "MyFridgeFood - Tips", tipsHrefValue };
    return tipsList;
  }

  public String[] submitRecipeHref() {
    submitRecipeBtn = driver.findElement(By.linkText("Submit a Recipe"));
    String submitRecipeHrefValue = submitRecipeBtn.getAttribute("href");
    String[] submitRecipeList = new String[] { "MyFridgeFood - Submit a Recipe", submitRecipeHrefValue };
    return submitRecipeList;
  }

  public String[] deciderHref() {
    deciderBtn = driver.findElement(By.linkText("Decider"));
    String deciderHrefValue = deciderBtn.getAttribute("href");
    String[] deciderList = new String[] { "MyFridgeFood - The Decider", deciderHrefValue };
    return deciderList;
  }

  public String[] copyrightPolicyHref() {
    copyrightPolicyBtn = driver.findElement(By.linkText("Copyright Policy"));
    String copyrightPolicyHrefValue = copyrightPolicyBtn.getAttribute("href");
    String[] copyrightPolicyList = new String[] { "MyFridgeFood - Copyright Policy", copyrightPolicyHrefValue };
    return copyrightPolicyList;
  }

  public String[] myProfileHref() {
    myProfileBtn = driver.findElement(By.linkText("My Profile"));
    String myProfileHrefValue = myProfileBtn.getAttribute("href");
    String[] myProfileList = new String[] { "MyFridgeFood - MyProfile", myProfileHrefValue };
    return myProfileList;
  }

  public String[] searchHref(String search) {
    String searchHrefValue = "/Search?q=" + search.replace(" ", "%20");
    String[] searchList = new String[] { "MyFridgeFood - Search", searchHrefValue };
    return searchList;
  }

  public String[] searchIngredientsHref() {
    String searchHrefValue = "/search-by-ingredients";
    String[] searchList = new String[] { "MyFridgeFood - Search By Ingredients", searchHrefValue };
    return searchList;
  }

  public String[] loginHref() {
    String loginHrefValue = "/login";
    String[] loginList = new String[] { "MyFridgeFood - login", loginHrefValue };
    return loginList;
  }

  public String[] registerHref() {
    String registerHrefValue = "/register";
    String[] registerList = new String[] { "MyFridgeFood - Register", registerHrefValue };
    return registerList;
  }

  public void searchMethod(String search) {
    searchBox = driver.findElement(By.id("search-box"));
    searchBox.sendKeys(search);
    searchBox.sendKeys(Keys.ENTER);
  }
}
