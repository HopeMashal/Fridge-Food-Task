package fridgefoodtask.Core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

import io.qameta.allure.Allure;

public class AllureAttached {

  public AllureAttached() {
  }

  public void addImage(File image) throws IOException {
    Allure.addAttachment(
        image.getName(),
        FileUtils.openInputStream(image));
  }

  public void addFile(File file, String fileType) throws IOException {
    byte[] array = Files.readAllBytes(Paths.get(file.getPath()));
    ByteArrayOutputStream attachmentContent = new ByteArrayOutputStream();
    attachmentContent.write(array);
    Allure.addAttachment(file.getName(), "text/" + fileType, new ByteArrayInputStream(attachmentContent.toByteArray()),
        "." + fileType);
  }
}
