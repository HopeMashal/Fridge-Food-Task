package fridgefoodtask.Core;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class WordFile {
  XWPFDocument document;
  String filePath;
  FileOutputStream outputFile;

  public WordFile(String filePath) {
    this.filePath = filePath;
    document = new XWPFDocument();
  }

  public void AddTitle() {

  }

  public void AddSubtitle() {

  }

  public void AddParagraph() {

  }

  public void AddImage() {

  }

  public void AddTable() {

  }

  public void AddHeader() {

  }

  public void AddFooter() {

  }

  public void AddLists() {

  }

  public void WriteWordFile() throws IOException {
    outputFile = new FileOutputStream(filePath);
    document.write(outputFile);
    outputFile.close();
    document.close();
  }

}
