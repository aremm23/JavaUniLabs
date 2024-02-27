package StringHandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContainWords {
    private Map<String, Integer> mapWithWords = new HashMap<>();
    private String currentWord;

    public void addToMapWithWords(ArrayList<String> words) {
        for (String word : words) {
            currentWord = word.toLowerCase();
            if (isSuchWordInMap()) {
                replaceInMap();
            } else {
                addNewToMap();
            }
        }
    }

    private void addNewToMap() {
        mapWithWords.put(currentWord, 1);
    }

    private void replaceInMap() {
        mapWithWords.replace(currentWord, mapWithWords.get(currentWord) + 1);
    }

    private boolean isSuchWordInMap() {
        return mapWithWords.containsKey(currentWord);
    }

    public Map<String, Integer> getMapWithWords() {
        return mapWithWords;
    }
}
