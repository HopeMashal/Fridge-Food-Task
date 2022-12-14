package fridgefoodtask.Core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFFooter;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

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
    XWPFRun paragraphRun = paragraphParagraph.createRun();
    paragraphRun.setText(paragraph);
    paragraphRun.setColor("000000");
    paragraphRun.setFontFamily("Calibri");
    paragraphRun.setFontSize(14);
  }

  public void AddImage(String imagePath) throws InvalidFormatException, IOException {
    FileInputStream imageFile = new FileInputStream(imagePath);
    XWPFParagraph paragraph = document.createParagraph();
    paragraph.setAlignment(ParagraphAlignment.CENTER);
    XWPFRun paragraphRun = paragraph.createRun();
    paragraphRun.setTextPosition(20);
    paragraphRun.addPicture(imageFile,
        Document.PICTURE_TYPE_PNG, // png file
        imagePath,
        Units.toEMU(250),
        Units.toEMU(250));
  }

  public void AddTable(List<String[]> TableElements) {
    XWPFTable table = document.createTable();
    table.setTableAlignment(TableRowAlign.CENTER);
    XWPFTableRow firstRow = table.getRow(0);
    firstRow.getCell(0).setText(TableElements.get(0)[0]);
    for (int j = 1; j < TableElements.get(0).length; j++) {
      firstRow.addNewTableCell().setText(TableElements.get(0)[j]);
    }
    for (int i = 1; i < TableElements.size(); i++) {
      XWPFTableRow nextRow = table.createRow();
      for (int j = 0; j < TableElements.get(0).length; j++) {
        nextRow.getCell(j).setText(TableElements.get(i)[j]);
      }
    }
    document.createParagraph();
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

  public void AddLists(List<String> lists) {
    for (String element : lists) {
      XWPFParagraph paragraphParagraph = document.createParagraph();
      paragraphParagraph.setAlignment(ParagraphAlignment.LEFT);
      XWPFRun paragraphRun = paragraphParagraph.createRun();
      paragraphRun.setText(element);
      paragraphRun.setColor("e78e8e");
      paragraphRun.setFontFamily("Arial");
      paragraphRun.setFontSize(11);
      paragraphParagraph.setFirstLineIndent(10);
      paragraphParagraph.setNumID(BigInteger.valueOf(lists.size()));
    }
  }

  public void WriteWordFile() throws IOException {
    outputFile = new FileOutputStream(filePath);
    document.write(outputFile);
    outputFile.close();
    document.close();
  }

}
