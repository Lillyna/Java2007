package course1.lesson3;

import java.util.Arrays;

public class ArrayApp {
    public static void main(String[] args) {
        int[] array = new int[5];// new - выделение новой памяти
        int [] array2 = array; // на ту же область памяти укажет две сслыки array и array2
        array[2] = 199;

        for (int i = 0; i < array.length; i++) {
            array[i] = 100+i*100;
        }
        printArray(array);

        int arr [] = {1,2,3,4,5};
        printArray(arr);

        String [] strings = new String[10];
        System.out.println(Arrays.toString(strings));
        Arrays.fill(strings, "a");
        boolean[] bool = {};
        System.out.println(Arrays.toString(bool));
        int integer =100;
        method1(integer); //передается копия элемента, он не будет изменен в методе
        System.out.println(integer);

        int[] integers = {1,2,3,4,5,6};
        method2(integers); //передается ссылка на область памяти, массив будет изменен
        System.out.println(Arrays.toString(integers));
    }

    public static void printArray (int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");

        }
        System.out.println();
    }
    public static void method1(int a){
        a=a+10;
    }
    public static void method2(int [] a){
        a[2]=10500;
    }
    public static int getAvg(int[] array){
        int sum =0;
        for (int i = 0; i < array.length ; i++) {
            sum+=array[i];
        }
        return sum/ array.length;
    }
}
