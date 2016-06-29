package epam.model;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Pack200;

/**
 * Created by Сергей on 6/24/2016.
 */
public class TextComposite implements TextPart {
    private List<TextPart> components = new ArrayList<>();

    public void addComponent(TextPart component) {
        components.add(component);
    }

    public void removeComponent(TextPart component) {
        components.remove(component);
    }

    /**
     * @return list of sentences from composite
     */
    public List<Sentence> getComponentSentences() {
        List<Sentence> sentences = new ArrayList<>();
        for (TextPart textPart : components) {
            if (textPart instanceof Sentence) {
                sentences.add((Sentence)textPart);
            }
        }
        return sentences;
    }

    @Override
    public String getPart() {
        StringBuilder part = new StringBuilder();

        for (TextPart component : components) {
            part.append(component.getPart() + " ");
        }

        return part.toString();
    }
}
