package course2.homework2;

import java.util.Arrays;

public class HomeworkApp {
    public static void main(String[] args) {
        String[][] arrayWrongSymbol = {{"1", "2", "3", "3"}, {"1", "3", "F", "5"}, {"1", "3", "4", "5"}, {"1", "2", "3", "4"}};
        String[][] arrayWrongX = {{"1", "2", "3", "3", "6"}, {"1", "3", "2", "5"}, {"1", "3", "4", "5"}, {"1", "2", "3", "4"}};
        String[][] arrayWrongY = {{"1", "2", "3", "3"}, {"1", "3", "4", "5"}, {"1", "3", "4", "5"}, {"1", "2", "3", "4"}, {"6"}};
        String[][] goodArray = {{"1", "2", "3", "3"}, {"1", "3", "1", "5"}, {"1", "3", "4", "5"}, {"1", "2", "3", "4"}};
        catchException(arrayWrongSymbol);
        catchException(arrayWrongX);
        catchException(arrayWrongY);
        catchException(goodArray);
    }

    static void sizeExceptionMethod(String[][] array) throws MyArraySizeException, MyArrayDataException {
        //task1
        if (array.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
        }

        //task2
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        System.out.println("Сумма значений массива = " + sum);
    }

    static void catchException(String[][] array) {
        System.out.println("Проверяем массив");
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
        try {
            sizeExceptionMethod(array);

        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Поймал исключение!");
            e.printStackTrace(System.out);
        }
        System.out.println();
    }
}
