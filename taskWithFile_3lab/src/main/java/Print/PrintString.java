package Print;

import Encryption.Decrypt;
import FileHandling.ParseToString;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrintString {
    private String getStringFromFile() throws FileNotFoundException {
        ParseToString parseToString = new ParseToString();
        parseToString.parseToStringFile(takeFromWhichFile());
        return decryptString(parseToString.getStringFromFile());
    }
    private String decryptString(String stringToDecrypt) {
        Decrypt decrypt = new Decrypt(stringToDecrypt);
        return decrypt.getDecryptedString();
    }

    public void printStringFromFile() {
        try {
            System.out.println(getStringFromFile());
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    private String takeFromWhichFile() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter file to read string from");
        String fileName = in.next();
        return "taskWithFile_3lab/src/main/java/Data/OutputData/" + fileName + "/" + fileName + ".txt";
    }
}
