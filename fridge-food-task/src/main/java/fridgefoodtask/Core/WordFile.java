package fridgefoodtask.Core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
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

  public void AddImage(String imagePath) throws InvalidFormatException, IOException {
    FileInputStream imageFile = new FileInputStream(imagePath);
    XWPFParagraph paragraph = document.createParagraph();
    paragraph.setAlignment(ParagraphAlignment.CENTER);
    XWPFRun paragraphRun = paragraph.createRun();
    paragraphRun.addPicture(imageFile,
        Document.PICTURE_TYPE_PNG, // png file
        imagePath,
        Units.toEMU(250),
        Units.toEMU(250));
  }

  public void AddTable() {

  }

  public void AddHeader(String header) {
    XWPFHeader head = document.createHeader(HeaderFooterType.DEFAULT);
    head.createParagraph()
        .createRun()
        .setText(header);
  }

  public void AddFooter(String footer) {
    XWPFFooter foot = document.createFooter(HeaderFooterType.DEFAULT);
    foot.createParagraph()
        .createRun()
        .setText(footer);
  }

  public void AddLists() {

  }

  public void WriteWordFile() throws IOException {
    outputFile = new FileOutputStream(filePath);
    document.write(outputFile);
    outputFile.close();
    document.close();
  }

  public static void main(String[] args) throws IOException, InvalidFormatException {
    WordFile wfile = new WordFile(Constant.getOutputFilesPath() + "test.docx");
    wfile.AddTitle("Hello");
    wfile.AddSubtitle("How are you!!");
    wfile.AddParagraph("I'm OK!!!");
    wfile.AddFooter("Document Footer");
    wfile.AddHeader("Document Header");
    DownloadFile dfile = new DownloadFile();
    File image = dfile.DownloadFileMethod("https://myfridgefood.com//Media/Recipe/photo%204.JPG",
        Constant.getDownloadsPath() + "images.jpg");
    wfile.AddImage(image.getPath());
    wfile.WriteWordFile();
  }
}
