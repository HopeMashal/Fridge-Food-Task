package fridgefoodtask.Core;

public class Constants {
  public static String FilesPath = "./src/files/";
  public static String ScreenShotsPath = FilesPath + "Screenshots/";
  public static String CSVFilesPath = FilesPath + "CSVFiles/";
  public static String WordFilesPath = FilesPath + "WordFiles/";
  public static String PropertiesFilesPath = FilesPath + "PropertiesFiles/";
  public static String DownloadsPath = FilesPath + "Downloads/";

  public static String URL = "https://www.myfridgefood.com";

  public static String CardNameCssSelector = "div[class='line-item-body']>a";
  public static String CardLinkCssSelector = "div[class='line-item-image-container']>a";
  public static String CardDetailsCssSelector = "div[class='line-item-details']>p";
  public static String CardImgSrcCssSelector = "div[class='line-item-image-container']>a>img";
  public static String RecipeCardCookingTimeCssSelector = "div[class='line-item-details']";
  public static String MissingIngredientsCssSelector = "div[class='missing-ingred-container']>span";
  public static String IngredientNameCssSelector = "div[class='flex-row']>span[class='AddIngredientName']";
  public static String DeciderCardNameCssSelector = "div[class='line-item-body']>div>a";
  public static String CardBookmarksBtnCssSelector = "div[class='recipe-results-bookmark']>span";
  public static String FirstPageResultsCssSelector = "div[class='recipe-tile recipe']";
  public static String ContestTipTitleCssSelector = "div[class='page-block']>h1";
  public static String ContestPTipDescCssSelector = "div[class='page-block']>p";
  public static String ContestListCssSelector = "div[class='page-block']>ul>li";
  public static String ContestImgCssSelector = "div[class='page-block']>p>img";
  public static String ContestArchivedListCssSelector = "div[class='archived-contests']>ul>li";
  public static String CopyrightFirstElementCssSelector = "div[class='content-main']>div>span";
  public static String PickOneResultBtnCssSelector = "p[style='text-align:center;margin:30px 0;']>a:nth-of-type(1)";
  public static String CheckClearBtnCssSelector = "div[class='Empty']+div[style='display: block;']>div[class='remove']";
  public static String ClearBtnCssSelector = "div[class='Clear']>div[class='remove']";
  public static String FindRecipesBtnCssSelector = "div[class='button submit']";
  public static String IngredientCheckBoxCssSelector = "div[class='tile ingredient tiles-item']>span[class='check-box']>span[class='ingredient-checkbox']";
  public static String CheckStateCssSelector = "select[id='ddstate']>option";
  public static String RecipeNameCssSelector = "div[class='recipe-title']>h1";
  public static String RecipeBookmarksBtnCssSelector = "div>a[id='bookmark-it']";
  public static String RecipeInformationCssSelector = "div[class='recipe-text']>div";
  public static String SubmitRecipeListCssSelector = "p+ul>li";
  public static String RecipeImgBoxCssSelector = "input[type='file']";
  public static String TipParagraphCssSelector = "div[class='page-block']>div>p";

  public static String LoginBtnXPath = "//div/a[@href='/login']";
  public static String LogoutBtnXPath = "//div[contains(@class,'header-right-links')]/a[@href='#']";
  public static String HomeBtnXPath = "//a[@href='/']";
  public static String BookmarksBtnXPath = "//li[@class='header-left-links']/a[@href='/bookmarks/']";
  public static String ContestsBtnXPath = "//li[@class='header-left-links']/a[@href='/contests/']";
  public static String TipsBtnXPath = "//li[@class='header-left-links']/a[@href='/tips/']";
  public static String SubmitRecipeBtnXPath = "//li[@class='header-left-links']/a[@href='/submit-a-recipe/']";
  public static String DeciderBtnXPath = "//li[@class='header-left-links']/a[@href='/decider/']";
  public static String CopyrightPolicyBtnXPath = "//li[@class='header-left-links']/a[@href='/copyright-policy/']";
  public static String MyProfileBtnXPath = "//div[contains(@class,'horizontal')]//a[@href='/myprofile']";
  public static String CopyrightSecondFourthElementXPath = "//*[@class='content-main']/div";
  public static String CopyrightSixthElementXPath = "//*[@class='content-main']/p";
  public static String SubmitBtnXPath = "//div[contains(@class,'SubmitRecipe')]";

  public static String SearchBoxID = "search-box";
  public static String EmailBoxID = "txtEmail";
  public static String PasswordBoxID = "txtpassword";
  public static String SubmitBtnID = "getbutton";
  public static String RegistrationBtnID = "registration";
  public static String FirstNameBoxID = "txtfname";
  public static String LastNameBoxID = "txtlname";
  public static String CountryBoxID = "ddcountry";
  public static String StateSelectID = "ddstate";
  public static String StateBoxID = "txtstate";
  public static String CityBoxID = "txtCity";
  public static String ConfirmPasswordBoxID = "txtconfirmpassword";

  public static String StartOverBtnLinkText = "Start Over";

  public static String RecipeTableClassName = "recipe-stats";
  public static String RecipeImgClassName = "recipe-image";
  public static String NameBoxClassName = "txtAuthor";
  public static String RecipeNameBoxClassName = "txtRecipeName";
  public static String PhotoCreditBoxClassName = "txtCredit";
  public static String DescriptionBoxClassName = "txtDescription";
  public static String CookingTimeBtnClassName = "slctTimes";
  public static String ServingsBtnClassName = "slctServings";
  public static String IngredientsListBoxClassName = "txtIngredients";
  public static String DirectionBoxClassName = "txtDirections";
  public static String TipImgClassName = "recipe-img";

  public static String CopyrightListXPath(int i) {
    return "//*[@class='content-main']/ul[" + i + "]/li";
  }
}
