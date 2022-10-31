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
}
