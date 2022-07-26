package p1;

import java.util.*;

public class PhraseChecker {
    private static final Set<String> INVALID_WORDS = new HashSet<>(Arrays.asList("idiot", "stupid"));
    private static final String SPACE = " ";
    private static final char HASH = '#';

    public String validatePhrase(String initialPhrase) {

        final String[] words = initialPhrase.split(SPACE);
        StringJoiner stringJoiner = new StringJoiner(SPACE);
        for (String word : words) {
            stringJoiner.add(processWord(word));
        }
        return stringJoiner.toString();
    }

    private String processWord(String word) {
        if (INVALID_WORDS.contains(word.toLowerCase())) {
            for (int i = 0; i < word.length(); i++) {
                word = word.replace(word.charAt(i), HASH);
            }
        }
        return word;
    }
}
