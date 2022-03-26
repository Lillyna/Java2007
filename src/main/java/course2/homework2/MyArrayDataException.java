package course2.homework2;

import static java.lang.String.format;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(String s) {
        System.out.printf("В ячейке %s некорректные данные!%n", s);
    }
}
