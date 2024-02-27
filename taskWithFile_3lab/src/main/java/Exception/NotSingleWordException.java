package Exception;

import java.util.List;

public class NotSingleWordException extends RuntimeException {
    private List<String> words;

    public NotSingleWordException(String message, List<String> words) {
        super(message);
        this.words = words;
    }

    public List<String> getWords() {
        return words;
    }
}
