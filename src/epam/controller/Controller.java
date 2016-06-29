package epam.controller;

import epam.model.TextProcessing;
import epam.view.View;

import java.io.IOException;

/**
 * Created by Сергей on 6/24/2016.
 */
public class Controller {
    private TextProcessing textProcessing;
    private View view;

    //constants
    public static final String BOOK1_DIRECTORY = "src/epam/data/oop.txt";

    //regex
    public static final String RUS_BOOK = "[^а-яА-Я]+";
    public static final String ENG_BOOK = "[^a-zA-Z]+";

    public Controller(TextProcessing textProcessing, View view){
        this.textProcessing = textProcessing;
        this.view = view;
    }

    public void processText() throws IOException {
        view.printMessege(View.TASK);
        view.printMessege(View.RESULT);
        textProcessing.processText();

    }
}
