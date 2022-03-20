package course2.homework1;

public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    //task 2
    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple\n");
    }

    //task 3
    public static void checkSumSign() {
        int a = 5;
        int b = -5;
        System.out.println(a + b >= 0 ? "Сумма положительная\n" : "Сумма отрицательная\n");
    }

    //task 4
    public static void printColor() {
        int value = 0;
        if (value <= 0) {
            System.out.println("Красный\n");
        } else if (0 < value && value <= 100) {
            System.out.println("Желтый\n");
        } else System.out.println("Зеленый\n");
    }

    //task 5
    public static void compareNumbers() {
        int a = 5;
        int b = -15;
        System.out.println(a >= b ? "a >= b\n" : "a < b\n");
    }


}
