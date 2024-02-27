package StringHandling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class StringHandling {
    private final String stringToOperateWith;

    public StringHandling(String stringBeforeOperation) {
        this.stringToOperateWith = stringBeforeOperation;
    }

    public Map<String, Integer> divideString() {
        ContainWords containWords = new ContainWords();
        String[] words = stringToOperateWith.split("[?!,. \n\r]");
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));
        while (wordsList.contains("")) {
            wordsList.remove("");
        }
        containWords.addToMapWithWords(wordsList);
        return containWords.getMapWithWords();
    }

    public String getStringToOperateWith() {
        return stringToOperateWith;
    }
}
