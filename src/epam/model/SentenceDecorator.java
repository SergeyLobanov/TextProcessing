package epam.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Сергей on 29.06.2016.
 */
public class SentenceDecorator implements TextPart{
    /**
     * sentence to decorate
     */
    private Sentence sentence;
    /**
     * maximal number of repeating of word int the sentence
     */
    private int maxNumberOfRepeatedWord;
    /**
     * the most repeated word in the sentence
     */
    private String commonRepeatedWord;

    public SentenceDecorator(Sentence sentence) {
        this.sentence = sentence;
        this.maxNumberOfRepeatedWord = 0;
        this.commonRepeatedWord = new String();
    }

    /**
     * work with text of sentence without code
     * @return number of maximal repeats for word from sentence
     */
    public int calculateMaxNumberOfRepeatedWord() {
        // remove code from text and split him on lower case words
        String[] words = splitToWords();

        Map<String, Integer> repetition = new HashMap<>();
        for (String word : words) {
            if (repetition.keySet().contains(word)) {
                repetition.put(word, repetition.get(word) + 1);
            } else {
                repetition.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> wordAndRepeat : repetition.entrySet()) {
            if (wordAndRepeat.getValue() > maxNumberOfRepeatedWord) {
                this.maxNumberOfRepeatedWord = wordAndRepeat.getValue();
                this.commonRepeatedWord = wordAndRepeat.getKey();
            }
        }
        return maxNumberOfRepeatedWord;
    }


    /**
     * find java code in text and remove him for processing
     * @return clear text without java code
     */
    public String[] splitToWords() {
        return removeCode()
                .toLowerCase()
                .replaceAll(sentence.getTextLangRegex(), SplitRegex.SIMILAR_SPACE)
                .replaceAll(SplitRegex.REPLACE_SPACES, SplitRegex.SIMILAR_SPACE)
                .split(SplitRegex.SIMILAR_SPACE);
    }

    /**
     * @return text without code(text between brackets)
     */
    public String removeCode() {
        StringBuilder textWithoutCode = new StringBuilder();
        int bracketCounter = 0;
        int tempIndex = 0;
        boolean withBrackets = false;
        String text = sentence.getPart();
        for(int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '{') {
                if (bracketCounter == 0) {
                    textWithoutCode.append(text.substring(tempIndex, i));
                }
                withBrackets = true;
                bracketCounter++;
            }
            if (text.charAt(i) == '}') {
                if (bracketCounter == 1) {
                    tempIndex = i + 1;
                }
                bracketCounter--;
            }
        }

        if (tempIndex != 0) {
            textWithoutCode.append(text.substring(tempIndex));
        }
        if (!withBrackets) {
            return text;
        }

        return textWithoutCode.toString();
    }

    public int getMaxNumberOfRepeatedWord() {
        return maxNumberOfRepeatedWord;
    }

    public String getCommonRepeatedWord() {
        return commonRepeatedWord;
    }

    @Override
    public String getPart() {
        return "Common repeated word is: " + getCommonRepeatedWord()
                + "\nNumber of repetition: " + getMaxNumberOfRepeatedWord()
                + "\nSentence: " +
                sentence.getPart();
    }
}
