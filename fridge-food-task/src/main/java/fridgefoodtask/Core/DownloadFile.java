package fridgefoodtask.Core;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class DownloadFile {
  public File DownloadFileMethod(String fileURL, String filePath) throws MalformedURLException, IOException {
    File DestFile = new File(filePath);
    FileUtils.copyURLToFile(
        new URL(fileURL),
        DestFile);
    return DestFile;
  }

  public static void main(String[] args) throws MalformedURLException, IOException {
    DownloadFile dfile = new DownloadFile();
    dfile.DownloadFileMethod("https://myfridgefood.com//Media/Recipe/photo%204.JPG",
        Constant.getDownloadsPath() + "images.jpg");
  }
}
