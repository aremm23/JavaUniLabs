package StringHandling;

import Exception.NotSingleWordException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWordRepeatedOddTimes {
    private HashMap<String, Integer> hashMapWithWords;

    public FindWordRepeatedOddTimes(HashMap<String, Integer> hashMapWithWords) {
        this.hashMapWithWords = hashMapWithWords;
    }

    public String findWordRepeatedOddTimes() {
        List<String> listWithWords = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : hashMapWithWords.entrySet()) {
            if (stringIntegerEntry.getValue() % 2 != 0) {
                listWithWords.add(stringIntegerEntry.getKey());
            }
        }
        if (isSingle(listWithWords)) {
            return listWithWords.get(0);
        } else {
            throw new NotSingleWordException("Odd word can be only one", listWithWords);
        }

    }

    public boolean isSingle(List<String> listWithWords) {
        return listWithWords.size() == 1;
    }
}