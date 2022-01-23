package course1.lesson7;

import java.util.Arrays;
import java.util.Locale;

public class StringApp {
    public static void main(String[] args) {
        String str = "String";
        //str.toCharArray(); //переводим в массив и работаем дальше с массивом
        System.out.println(Arrays.toString(str.toCharArray()));
        String str2 = new String(str.toCharArray()); // переводим обратно в строку

        str.toUpperCase(); // не изменится значение переменной

        System.out.println(str);

        str = str.toUpperCase(); // изменится значение переменной

        System.out.println(str);

        System.out.println(str.contains("ING"));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Test").append(" ").append(2); // этот код более производительный, чем str = str.toUpperCase();
        System.out.println(stringBuilder);
        String newString = stringBuilder.toString();
        StringBuilder stringBuilder1 = new StringBuilder(newString);
        stringBuilder.reverse();
        System.out.println(stringBuilder);

        StringBuffer stringBuf = new StringBuffer();// работает также как StringBuilder, но умеет работать с потоками, но StringBuilder быстрее
    }
}
