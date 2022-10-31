package fridgefoodtask.Core;

public class Constant {
  private static String FilesPath = "./src/files/";
  private static String ScreenShotsPath = FilesPath + "Screenshots/";
  private static String InputFilesPath = FilesPath + "InputFiles/";
  private static String OutputFilesPath = FilesPath + "OutputFiles/";
  private static String CSVInputFilesPath = InputFilesPath + "CSVFiles/";
  private static String CSVOutputFilesPath = OutputFilesPath + "CSVFiles/";
  private static String WordFilesPath = OutputFilesPath + "WordFiles/";
  private static String PropertiesFilesPath = InputFilesPath + "PropertiesFiles/";
  private static String DownloadsPath = FilesPath + "Downloads/";
  private static String URL = "https://www.myfridgefood.com";

  public static String getFilesPath() {
    return FilesPath;
  }

  public static String getScreenShotsPath() {
    return ScreenShotsPath;
  }

  public static String getInputFilesPath() {
    return InputFilesPath;
  }

  public static String getOutputFilesPath() {
    return OutputFilesPath;
  }

  public static String getCSVInputFilesPath() {
    return CSVInputFilesPath;
  }

  public static String getCSVOutputFilesPath() {
    return CSVOutputFilesPath;
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
