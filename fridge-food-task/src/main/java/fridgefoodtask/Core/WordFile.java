package fridgefoodtask.Core;

import java.util.List;

public class WordFile {
  public static void WriteTitleWithParagraphs(String filePath, String header, String footer, String title,
      List<String> paragraphs) {

  }

  public static void WriteRecipeFile(String filePath, String header, String footer, String title,
      List<String> paragraphs, String pictureURL, List<String> tableValues) {

  }

  public static void WriteContestFile(String filePath, String header, String footer, String title,
      List<String> paragraphs, String pictureURL) {
    WriteTitleWithParagraphs(filePath, header, footer, title, paragraphs);

  }
}
