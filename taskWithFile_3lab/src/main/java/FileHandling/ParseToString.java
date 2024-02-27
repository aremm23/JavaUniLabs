package FileHandling;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParseToString {
    private final String ORIGINAL_FILE = "taskWithFile_3lab/src/main/java/Data/text.txt";

    private String stringFromFile;

    public void parseToStringTextTXT() throws FileNotFoundException {
        parseToString(ORIGINAL_FILE);
    }

    public void parseToStringFile(String filePath) throws FileNotFoundException {
        parseToString(filePath);
    }

    private void parseToString(String filePath) throws FileNotFoundException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));) {
            StringBuilder stringFromFileBuilder = new StringBuilder();
            int charFromFile;
            while ((charFromFile = bufferedReader.read()) != -1) {
                stringFromFileBuilder.append((char) charFromFile);
            }
            stringFromFile = stringFromFileBuilder.toString();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File " + filePath + " wasn't founded");
        } catch (IOException e) {
        }
    }

    public String getStringFromFile() {
        return stringFromFile;
    }


}
