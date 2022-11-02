package fridgefoodtask.Core;

public class Constant {
  private static String FilesPath = "./src/files/";
  private static String ScreenShotsPath = FilesPath + "Screenshots/";
  private static String CSVFilesPath = FilesPath + "CSVFiles/";
  private static String WordFilesPath = FilesPath + "WordFiles/";
  private static String PropertiesFilesPath = FilesPath + "PropertiesFiles/";
  private static String DownloadsPath = FilesPath + "Downloads/";
  private static String URL = "https://www.myfridgefood.com";

  public static String getFilesPath() {
    return FilesPath;
  }

  public static String getScreenShotsPath() {
    return ScreenShotsPath;
  }

  public static String getCSVFilesPath() {
    return CSVFilesPath;
  }

  public static String getWordFilesPath() {
    return WordFilesPath;
  }

  public static String getPropertiesFilesPath() {
    return PropertiesFilesPath;
  }

  public static String getURL() {
    return URL;
  }

  public static String getDownloadsPath() {
    return DownloadsPath;
  }

}
