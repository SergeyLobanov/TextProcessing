package epam.model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 6/22/2016.
 */
public class TextProcessing {
    /**
     * file directory
     */
    private String directory;

    /**
     * text language
     */
    private String textLangRegex;

    public TextProcessing(String directory, String textLangRegex) {
        this.directory = directory;
        this.textLangRegex = textLangRegex;
    }

    /**
     * find sentences with the bigger number of repeating words
     */
    public void processText() throws IOException {
        String text = readTextFile();
        TextComposite textComposite = new TextComposite();

        List<Sentence> requiredSentences = new ArrayList<>();
        int maxNumberOfRepeatedWord = 0;

        // split text on sentences
        for (String sentence : splitOnSentences(text)) {
            textComposite.addComponent(new Sentence(sentence, textLangRegex));
        }

        for(Sentence sentence : textComposite.getComponentSentences()) {
            SentenceDecorator sentenceDecorator = new SentenceDecorator(sentence);
            int tempRepeatedNumber = sentenceDecorator.calculateMaxNumberOfRepeatedWord();
            if (tempRepeatedNumber < maxNumberOfRepeatedWord) {
                continue;
            } else if(tempRepeatedNumber > maxNumberOfRepeatedWord) {
                requiredSentences = new ArrayList<>();
                maxNumberOfRepeatedWord = tempRepeatedNumber;
            }
            requiredSentences.add(sentence);
        }

        System.out.println(requiredSentences);
    }

    // split text on sentences
    private String[] splitOnSentences(String text) {
        return text.split(SplitRegex.SPLIT_TO_SENTENCE);
    }

    /**
     * read text from file
     * @return sting representation of file text
     * @throws IOException
     */
    private String readTextFile() throws IOException {
        StringBuilder text = new StringBuilder();
        try (FileReader reader = new FileReader(directory)) {
            int c;
            while ((c = reader.read()) != -1) {
                text.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return text.toString();
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void setTextLangRegex(String textLangRegex) {
        this.textLangRegex = textLangRegex;
    }
}
