package homework3;

import java.util.Arrays;

public class HomeWorkApp {
    public static void main(String[] args) {
        //check task1
        System.out.println(Arrays.toString(reverseArray()));

        //check task2
        System.out.println(Arrays.toString(fillArray()));

        //check task3
        System.out.println(Arrays.toString(changeArrayElement()));

        //check task4
        for (int i = 0; i < twoDimentionalArray().length; i++) {
            System.out.println(Arrays.toString(twoDimentionalArray()[i]));
        }

        //check task5
        System.out.println(Arrays.toString(createArray(5, 16)));

        //check task6
        findExtremums();

        //check task7
        System.out.println(checkBalance(new int[]{11, 1, 11, 24}));

        //check task8
        System.out.println(Arrays.toString(shiftArray(new int[]{11, 1, 12, 25}, -3)));

    }

    //task1
    public static int[] reverseArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else if (array[i] == 0) {
                array[i] = 1;
            }
        }
        return array;
    }

    //task2
    public static int[] fillArray() {
        int[] array = new int[100];
        int i = 0;
        while (i < array.length) {
            array[i] = i + 1;
            i++;
        }
        return array;
    }

    //task3
    public static int[] changeArrayElement() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    //task4
    public static int[][] twoDimentionalArray() {
        int[][] array = new int[10][10];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) array[i][j] = 1;
                else if (array.length - i == j + 1) array[i][j] = 1;
            }
        }
        return array;
    }

    //task5
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    //task6
    public static void findExtremums() {
        int[] array = {1, 5, -3, 2, 11, 4, 5, 2, 4, 8, -9, 1};
        Arrays.sort(array);
        System.out.println("Min element = " + array[0] + "; Max element = " + array[array.length - 1]);
    }

    //task7
    public static boolean checkBalance(int[] array) {
        long left = 0;
        long right = Arrays.stream(array).summaryStatistics().getSum();
        for (int i :array) {
            left += i;
            right -= i;
            if (left == right) {
                return true;
            }
        }
        return false;
    }

    //task8
    public static int[] shiftArray(int[] array, int n) {
        //If n is positive then shift elements to the right
        //If n is zero each element stays on its place
        if (n >= 0) {
            for (int i = 0; i < n; i++) {
                int firstElement = array[0];
                int lastElement = array[array.length - 1];
                for (int j = 0; j < array.length - 1; j++) {
                    int el = array[j + 1];
                    array[j + 1] = firstElement;
                    firstElement = el;
                }
                array[0] = lastElement;
            }
        }
        //If n is negative then shift elements to the left
        else {
            for (int i = 0; i < Math.abs(n); i++) {
                int firstElement = array[array.length - 1];
                int lastElement = array[0];
                for (int j = array.length - 1; j > 0; j--) {
                    int el = array[j - 1];
                    array[j - 1] = firstElement;
                    firstElement = el;
                }
                array[array.length - 1] = lastElement;
            }
        }
        return array;
    }
}
