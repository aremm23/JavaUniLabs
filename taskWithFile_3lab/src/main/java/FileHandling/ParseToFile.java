package FileHandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ParseToFile {
    private File parseToFile;

    public ParseToFile(File parseToFile) {
        this.parseToFile = parseToFile;
    }

    public void parseToFile(String stringToFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(parseToFile))) {
            bufferedWriter.write(stringToFile);
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
