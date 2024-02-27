import Encryption.Encrypt;
import Exception.NotSingleWordException;
import FileHandling.CreateNewFile;
import FileHandling.ParseToString;
import Print.PrintString;
import FileHandling.ParseToFile;
import StringHandling.FindWordRepeatedOddTimes;
import StringHandling.StringHandling;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("""
                1. Watch encrypted files;
                2. Find odd word and add to new dir and file.
                """);
        menuProcedure();
    }

    public static void menuProcedure() {
        Scanner in = new Scanner(System.in);
        switch (in.nextInt()) {
            case 1 -> {
                PrintString printString = new PrintString();
                printString.printStringFromFile();
            }
            case 2 -> {
                findOddWordAndPutToNewFileInNewDir();
            }
        }
    }

    public static HashMap<String, Integer> getStringAndSplitInMap() throws FileNotFoundException {
        String stringFromFile = takeInfoFromFile();
        StringHandling operateWithString = new StringHandling(stringFromFile);
        return (HashMap<String, Integer>) operateWithString.divideString();
    }

    public static void createFileAndPutString(String wordRepeatedOddTimes, String encryptedWord) throws IOException {
        CreateNewFile newFile = new CreateNewFile();
        newFile.createNewFileInDir(wordRepeatedOddTimes);
        ParseToFile parseToNewFile = new ParseToFile(newFile.getNewFile());
        parseToNewFile.parseToFile(encryptedWord);
    }

    public static void findOddWordAndPutToNewFileInNewDir() {
        HashMap<String, Integer> wordsFromFileAndTimesTheyRepeated = null;
        try {
            wordsFromFileAndTimesTheyRepeated = getStringAndSplitInMap();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            FindWordRepeatedOddTimes findWordRepeatedOddTimes = new FindWordRepeatedOddTimes(wordsFromFileAndTimesTheyRepeated);
            String wordRepeatedOddTimes = findWordRepeatedOddTimes.findWordRepeatedOddTimes();
            Encrypt encryptString = new Encrypt(wordRepeatedOddTimes);
            String encryptedWord = encryptString.getEncryptedString();
            createFileAndPutString(wordRepeatedOddTimes, encryptedWord);
            System.out.printf("The word which is repeated odd number of times is '%s' was added to file\n", wordRepeatedOddTimes);
        } catch (NotSingleWordException e) {
            System.out.println(e.getMessage() + ":" + e.getWords());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String takeInfoFromFile() throws FileNotFoundException {
        ParseToString stringFromFile = new ParseToString();
        stringFromFile.parseToStringTextTXT();
        return stringFromFile.getStringFromFile();
    }
}