package course3.homework1;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        String[] arrayString = {"ABC", "DEF", "GHI"};
        for (String i : arrayString) {
            System.out.print(i + " ");
        }
        System.out.print(" -> ");
        String[] arrayStringSwitch = switchElements(arrayString, 0, 1);
        for (String i : arrayStringSwitch) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        Integer[] arrayBool = {11, 22, 33, 44};
        for (Integer i : arrayBool) {
            System.out.print(i + " ");
        }
        System.out.print(" -> ");
        Integer[] arrayBoolSwitch = switchElements(arrayBool, 2, 0);
        for (Integer i : arrayBoolSwitch) {
            System.out.print(i + " ");
        }
    }

    private static <V> V[] switchElements(V[] array, int index1, int index2) {
        V[] resultArray = Arrays.copyOf(array, array.length);
        resultArray[index1] = array[index2];
        resultArray[index2] = array[index1];
        return resultArray;
    }
}
