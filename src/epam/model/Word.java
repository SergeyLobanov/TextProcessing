package epam.model;

/**
 * Created by Сергей on 6/22/2016.
 */
public class Word implements TextPart{
    /**
     * word in lower case
     */
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String getPart() {
        return word;
    }
}
