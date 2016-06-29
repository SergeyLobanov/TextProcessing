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
        //TextProcessing text = new TextProcessing(BookDirectories.BOOK1_DIRECTORY, LanguageRegex.RUS_BOOK);
        TextProcessing text = new TextProcessing(Controller.BOOK1_DIRECTORY, Controller.RUS_BOOK);
        Controller controller = new Controller(text, new View());
        controller.processText();
        /*String text1 = new String("Аналогично, в предыдущем примере вторая пара методов различается именем аргументов, которые также не входят в определение сигнатуры и делают невозможным определение, какой их двух методов должен быть вызван.\n" +
                "Аналогично, третья пара различается лишь модификаторами доступа, что также недопустимо. Наконец, завершает заголовок метода throws-выражение. Оно применяется для корректной работы с ошибками в Java и будет подробно рассмотрено в соответствующей лекции.\n" +
                "Пример объявления метода:\n" +
                "public final ");
        for (String str : text1.split("(\\w*[a-zA-Z]+\\w*)|([a-zA-Z_]+\\w*)")) {//[^а-яА-Я]+|[^.,!?:;@]+
            //for(String str2 : str.split(""))
            System.out.println(str);
        }*/
    }
}
