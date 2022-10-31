package fridgefoodtask.Core;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
  public static String getProperty(String filePath, String propertyName) throws IOException {
    FileReader readFile = new FileReader(filePath);
    Properties prop = new Properties();
    prop.load(readFile);
    return prop.getProperty(propertyName);
  }
}
