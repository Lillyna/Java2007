package course2.homework2;

import static java.lang.String.format;

public class MyArrayApp {

    public static void main(String[] args) {
        String[][] myArray = {{"1", "2", "3", "4"}, {"13", "24", "1", "8"}, {"16", "26", "36", "6"}, {"61", "26", "63", "64"}};
        int sum = 0;
        try {
            sum = convertAndSumArray(myArray);
        } catch (MyArraySizeException ase) {
            System.out.println("Поймали исключение MyArraySizeException");
            ase.printStackTrace();
        } catch (MyArrayDataException ade) {
            System.out.println("Поймали исключение MyArrayDataException");
            ade.printStackTrace();
        } catch (Exception e) {
            System.out.println("Поймали другое исключение");
            e.printStackTrace();
        }

        System.out.printf("Сумма элементов массива: %s%n", sum);
    }

    /**
     * Проверяем размер входного массива: размер должен быть 4х4
     * Конвертируем элементы массива в int и суммируем их
     * @param myArray: входной массив
     * @return сумма элементов
     */
    static int convertAndSumArray(String[][] myArray) {

        int sum = 0;

        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i].length != 4 || i > 4) {
                throw new MyArraySizeException("Массив недопустимой длины");
            }
            for (int j = 0; j < myArray[i].length; j++) {

                try {
                    sum += Integer.parseInt(myArray[i][j]);
                } catch (NumberFormatException de) {
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return sum;
    }
}
