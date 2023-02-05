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
    try {
      loginBtn = driver.findElement(By.xpath(Constants.LoginBtnXPath));
      loginBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND LOGIN BUTTON");
    }
  }

  public void clickLogoutBtn() {
    try {
      logoutBtn = driver.findElement(By.xpath(Constants.LogoutBtnXPath));
      logoutBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND LOGOUT BUTTON");
    }
  }

  public void clickHomeBtn() {
    try {
      homeBtn = driver.findElement(By.xpath(Constants.HomeBtnXPath));
      homeBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND HOME BUTTON");
    }
  }

  public void clickBookmarksBtn() {
    try {
      bookmarksBtn = driver.findElement(By.xpath(Constants.BookmarksBtnXPath));
      bookmarksBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND BOOKMARK BUTTON");
    }
  }

  public void clickContestsBtn() {
    try {
      contestsBtn = driver.findElement(By.xpath(Constants.ContestsBtnXPath));
      contestsBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND CONTESTS BUTTON");
    }
  }

  public void clickTipsBtn() {
    try {
      tipsBtn = driver.findElement(By.xpath(Constants.TipsBtnXPath));
      tipsBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND TIPS BUTTON");
    }
  }

  public void clickSubmitRecipeBtn() {
    try {
      submitRecipeBtn = driver.findElement(By.xpath(Constants.SubmitRecipeBtnXPath));
      submitRecipeBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND SUBMIT RECIPE BUTTON");
    }
  }

  public void clickDeciderBtn() {
    try {
      deciderBtn = driver.findElement(By.xpath(Constants.DeciderBtnXPath));
      deciderBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND DECIDER BUTTON");
    }
  }

  public void clickCopyrightPolicyBtn() {
    try {
      copyrightPolicyBtn = driver.findElement(By.xpath(Constants.CopyrightPolicyBtnXPath));
      copyrightPolicyBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND COPYRIGHT POLICY BUTTON");
    }
  }

  public void clickMyProfileBtn() {
    try {
      myProfileBtn = driver.findElement(By.xpath(Constants.MyProfileBtnXPath));
      myProfileBtn.click();
    } catch (Exception e) {
      System.out.println("CAN'T FIND PROFILE BUTTON");
    }
  }

  public String[] homeHref() {
    String[] homeList;
    try {
      homeBtn = driver.findElement(By.xpath(Constants.HomeBtnXPath));
      String homeHrefValue = homeBtn.getAttribute("href");
      homeList = new String[] { "MyFridgeFood - Home", homeHrefValue };
    } catch (Exception e) {
      System.out.println("CAN'T FIND HOME PAGE HREF");
      homeList = new String[] { "NONE" };
    }
    return homeList;
  }

  public String[] bookmarksHref() {
    String[] bookmarksList;
    try {
      bookmarksBtn = driver.findElement(By.xpath(Constants.BookmarksBtnXPath));
      String bookmarksHrefValue = bookmarksBtn.getAttribute("href");
      bookmarksList = new String[] { "MyFridgeFood - Bookmarks", bookmarksHrefValue };
    } catch (Exception e) {
      System.out.println("CAN'T FIND BOOKMARKS PAGE HREF");
      bookmarksList = new String[] { "NONE" };
    }
    return bookmarksList;
  }

  public String[] contestsHref() {
    String[] contestsList;
    try {
      contestsBtn = driver.findElement(By.xpath(Constants.ContestsBtnXPath));
      String contestsHrefValue = contestsBtn.getAttribute("href");
      contestsList = new String[] { "MyFridgeFood - Contests", contestsHrefValue };
    } catch (Exception e) {
      System.out.println("CAN'T FIND CONTESTS PAGE HREF");
      contestsList = new String[] { "NONE" };
    }
    return contestsList;
  }

  public String[] tipsHref() {
    String[] tipsList;
    try {
      tipsBtn = driver.findElement(By.xpath(Constants.TipsBtnXPath));
      String tipsHrefValue = tipsBtn.getAttribute("href");
      tipsList = new String[] { "MyFridgeFood - Tips", tipsHrefValue };
    } catch (Exception e) {
      System.out.println("CAN'T FIND TIPS PAGE HREF");
      tipsList = new String[] { "NONE" };
    }
    return tipsList;
  }

  public String[] submitRecipeHref() {
    String[] submitRecipeList;
    try {
      submitRecipeBtn = driver.findElement(By.xpath(Constants.SubmitRecipeBtnXPath));
      String submitRecipeHrefValue = submitRecipeBtn.getAttribute("href");
      submitRecipeList = new String[] { "MyFridgeFood - Submit a Recipe", submitRecipeHrefValue };
    } catch (Exception e) {
      System.out.println("CAN'T FIND SUBMIT RECIPE PAGE HREF");
      submitRecipeList = new String[] { "NONE" };
    }
    return submitRecipeList;
  }

  public String[] deciderHref() {
    String[] deciderList;
    try {
      deciderBtn = driver.findElement(By.xpath(Constants.DeciderBtnXPath));
      String deciderHrefValue = deciderBtn.getAttribute("href");
      deciderList = new String[] { "MyFridgeFood - The Decider", deciderHrefValue };
    } catch (Exception e) {
      System.out.println("CAN'T FIND DECIDER PAGE HREF");
      deciderList = new String[] { "NONE" };
    }
    return deciderList;
  }

  public String[] copyrightPolicyHref() {
    String[] copyrightPolicyList;
    try {
      copyrightPolicyBtn = driver.findElement(By.xpath(Constants.CopyrightPolicyBtnXPath));
      String copyrightPolicyHrefValue = copyrightPolicyBtn.getAttribute("href");
      copyrightPolicyList = new String[] { "MyFridgeFood - Copyright Policy", copyrightPolicyHrefValue };
    } catch (Exception e) {
      System.out.println("CAN'T FIND COPYRIGHT POLICY PAGE HREF");
      copyrightPolicyList = new String[] { "NONE" };
    }
    return copyrightPolicyList;
  }

  public String[] myProfileHref() {
    String[] myProfileList;
    try {
      myProfileBtn = driver.findElement(By.xpath(Constants.MyProfileBtnXPath));
      String myProfileHrefValue = myProfileBtn.getAttribute("href");
      myProfileList = new String[] { "MyFridgeFood - MyProfile", myProfileHrefValue };
    } catch (Exception e) {
      System.out.println("CAN'T FIND PROFILE PAGE HREF");
      myProfileList = new String[] { "NONE" };
    }
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
    try {
      searchBox = driver.findElement(By.id(Constants.SearchBoxID));
      searchBox.sendKeys(search);
      searchBox.sendKeys(Keys.ENTER);
    } catch (Exception e) {
      System.out.println("CAN'T SEND KEY WORD - SEARCH METHOD");
    }
  }
}
