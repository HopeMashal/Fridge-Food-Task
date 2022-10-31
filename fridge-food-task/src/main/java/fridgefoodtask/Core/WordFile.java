package fridgefoodtask.Core;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordFile {
  XWPFDocument document;
  String filePath;
  FileOutputStream outputFile;

  public WordFile(String filePath) {
    this.filePath = filePath;
    document = new XWPFDocument();
  }

  public void AddTitle(String title) {
    XWPFParagraph titleParagraph = document.createParagraph();
    titleParagraph.setAlignment(ParagraphAlignment.CENTER);
    XWPFRun titleRun = titleParagraph.createRun();
    titleRun.setText(title);
    titleRun.setColor("d51717");
    titleRun.setBold(true);
    titleRun.setFontFamily("New Roman");
    titleRun.setFontSize(20);
  }

  public void AddSubtitle(String subTitle) {
    XWPFParagraph subTitleParagraph = document.createParagraph();
    subTitleParagraph.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun subTitleRun = subTitleParagraph.createRun();
    subTitleRun.setText(subTitle);
    subTitleRun.setColor("ec4f4f");
    subTitleRun.setFontFamily("Courier");
    subTitleRun.setFontSize(16);
    subTitleRun.setItalic(true);
    subTitleRun.setTextPosition(20);
    subTitleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
  }

  public void AddParagraph(String paragraph) {
    XWPFParagraph paragraphParagraph = document.createParagraph();
    paragraphParagraph.setAlignment(ParagraphAlignment.LEFT);
    XWPFRun subTitleRun = paragraphParagraph.createRun();
    subTitleRun.setText(paragraph);
    subTitleRun.setColor("000000");
    subTitleRun.setFontFamily("Calibri");
    subTitleRun.setFontSize(14);
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

  public static void main(String[] args) throws IOException {
    WordFile wfile = new WordFile(Constant.getOutputFilesPath()+"test.docx");
    wfile.AddTitle("Hello");
    wfile.AddSubtitle("How are you!!");
    wfile.AddParagraph("I'm OK!!!");
    wfile.WriteWordFile();
  }
}
