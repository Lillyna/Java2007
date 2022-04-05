package course2.homework2;

import static java.lang.String.format;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j) {
        System.out.printf("В ячейке [%s][%s] некорректные данные!%n", i,j);
    }
}
