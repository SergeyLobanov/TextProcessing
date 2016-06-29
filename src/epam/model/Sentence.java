package epam.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 6/22/2016.
 */
public class Sentence implements TextPart{
    /**
     * list of setence words
     */
    private List<TextPart> words;
    /**
     * text of the sentence
     */
    private String text;
    /**
     * text language
     */
    private String textLangRegex;

    public Sentence(String text, String textLangRegex) {
        this.text = text.trim();
        this.textLangRegex = textLangRegex;
        splitToWord();
    }

    /**
     * split text of sentence on words and creates word list
     */
    private void splitToWord() {
        this.words = new ArrayList<>();
        WordFactory wordFactory = new WordFactory();
        for (String word : text.replaceAll(getTextLangRegex(), SplitRegex.SIMILAR_SPACE)
                .replaceAll(SplitRegex.REPLACE_SPACES, SplitRegex.SIMILAR_SPACE)
                .split(SplitRegex.SIMILAR_SPACE)) {
            words.add(wordFactory.getWord(word));
        }
    }

    public String getTextLangRegex() {
        return textLangRegex;
    }

    @Override
    public String getPart() {
        return text;
    }

    @Override
    public String toString() {
        return text;
    }
}