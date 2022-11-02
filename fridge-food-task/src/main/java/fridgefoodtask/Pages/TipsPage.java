package fridgefoodtask.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;

import fridgefoodtask.Components.Navbar;

public class TipsPage extends Navbar {

  public TipsPage(WebDriver driver) {
    super(driver);
    // TODO Auto-generated constructor stub
  }

  public List<String[]> getFirstPageResults() {
    SearchPage tipsPage = new SearchPage(driver);
    return tipsPage.getFirstPageResults();
  }

  public void clickSelectResult(int index) {
    SearchPage tipsPage = new SearchPage(driver);
    tipsPage.clickSelectResult(index);
  }
}
