package epam.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * word factory for each sentence
 * Created by Сергей on 6/22/2016.
 */
public class WordFactory {
    /**
     * map of string word representation and word objects
     */
    private static final Map<String, Word> words = new HashMap<>();

    public Word getWord(String wordString) {
        Word word = words.get(wordString);

        if (word == null) {
            word = new Word(wordString);
            words.put(wordString, word);
        }

        return word;
    }
}
