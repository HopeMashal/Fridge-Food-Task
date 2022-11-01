package fridgefoodtask.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Navbar {
  WebDriver driver;
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
    homeBtn = driver.findElement(By.xpath("//a[@href='/']"));
    bookmarksBtn = driver.findElement(By.linkText("Bookmarks"));
    contestsBtn = driver.findElement(By.linkText("Contests"));
    tipsBtn = driver.findElement(By.linkText("Tips"));
    submitRecipeBtn = driver.findElement(By.linkText("Submit a Recipe"));
    deciderBtn = driver.findElement(By.linkText("Decider"));
    copyrightPolicyBtn = driver.findElement(By.linkText("Copyright Policy"));
    searchBox = driver.findElement(By.id("search-box"));
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
    homeBtn.click();
  }

  public void clickBookmarksBtn() {
    bookmarksBtn.click();
  }

  public void clickContestsBtn() {
    contestsBtn.click();
  }

  public void clickTipsBtn() {
    tipsBtn.click();
  }

  public void clickSubmitRecipeBtn() {
    submitRecipeBtn.click();
  }

  public void clickDeciderBtn() {
    deciderBtn.click();
  }

  public void clickCopyrightPolicyBtn() {
    copyrightPolicyBtn.click();
  }

  public void clickMyProfileBtn() {
    myProfileBtn = driver.findElement(By.linkText("My Profile"));
    myProfileBtn.click();
  }

  public String[] homeHref() {
    String homeHrefValue = homeBtn.getAttribute("href");
    String[] homeList = new String[] { "Home", homeHrefValue };
    return homeList;
  }

  public String[] bookmarksHref() {
    String bookmarksHrefValue = bookmarksBtn.getAttribute("href");
    String[] bookmarksList = new String[] { "Bookmarks", bookmarksHrefValue };
    return bookmarksList;
  }

  public String[] contestsHref() {
    String contestsHrefValue = contestsBtn.getAttribute("href");
    String[] contestsList = new String[] { "Contests", contestsHrefValue };
    return contestsList;
  }

  public String[] tipsHref() {
    String tipsHrefValue = tipsBtn.getAttribute("href");
    String[] tipsList = new String[] { "Tips", tipsHrefValue };
    return tipsList;
  }

  public String[] submitRecipeHref() {
    String submitRecipeHrefValue = submitRecipeBtn.getAttribute("href");
    String[] submitRecipeList = new String[] { "Submit a Recipe", submitRecipeHrefValue };
    return submitRecipeList;
  }

  public String[] deciderHref() {
    String deciderHrefValue = deciderBtn.getAttribute("href");
    String[] deciderList = new String[] { "Decider", deciderHrefValue };
    return deciderList;
  }

  public String[] copyrightPolicyHref() {
    String copyrightPolicyHrefValue = copyrightPolicyBtn.getAttribute("href");
    String[] copyrightPolicyList = new String[] { "Copyright Policy", copyrightPolicyHrefValue };
    return copyrightPolicyList;
  }

  public String[] myProfileHref() {
    myProfileBtn = driver.findElement(By.linkText("My Profile"));
    String myProfileHrefValue = myProfileBtn.getAttribute("href");
    String[] myProfileList = new String[] { "MyProfile", myProfileHrefValue };
    return myProfileList;
  }

  public void searchMethod(String search) {
    searchBox.sendKeys(search);
    searchBox.sendKeys(Keys.ENTER);
  }
}
