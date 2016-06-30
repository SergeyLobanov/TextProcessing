package epam;

import epam.controller.Controller;
import epam.model.TextProcessing;
import epam.view.View;

import java.io.IOException;

/**
 * Created by Сергей on 6/22/2016.
 */
public class TextProcessingMain {

    public static void main(String[] args) throws IOException {
        TextProcessing text = new TextProcessing(Controller.BOOK1_DIRECTORY, Controller.RUS_BOOK);
        Controller controller = new Controller(text, new View());
        controller.processText();
    }
}
