package course3.homework1;

import java.util.ArrayList;
import java.util.Collections;

public class Task2 {
    public static void main(String[] args) {
        String[] arrayString = {"el1", "el2", "el3"};
        ArrayList<String> stringArrayList = convertArray(arrayString);
        stringArrayList.add("el4");
        System.out.println(stringArrayList);

        Integer[] arrayInteger = {1, 2, 3};
        ArrayList<Integer> integerArrayList = convertArray(arrayInteger);
        integerArrayList.add(4);
        System.out.println(integerArrayList);

    }

    private static <E> ArrayList<E> convertArray(E[] array) {
        ArrayList<E> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, array);
        return arrayList;
    }

}
