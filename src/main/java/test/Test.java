package test;

import java.util.ArrayList;
import java.util.Locale;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        String str = "ABNVGgDFHG";
        System.out.println( test(str));
        System.out.println(test1("hjfggdDljkh"));
        System.out.println(findShort("6 bitcoin take over the world maybe who knows perhaps"));
        System.out.println(countBits(666));

    }
    public static boolean test(String str){


        return str.length() == str.toLowerCase(Locale.ROOT).chars().distinct().count();

}
public static String test1(String s){

        char[] chars = s.toLowerCase(Locale.ROOT).toCharArray();
        StringBuilder str = new StringBuilder();
    for (int i = 0; i < chars.length; i++) {
        str.append(String.valueOf(chars[i]).toUpperCase(Locale.ROOT));
        for (int j = 0; j < i; j++) {
            str.append(String.valueOf(chars[i]));
        }
        if (i != chars.length -1 )str.append('-');
    }
    return str.toString();
}


        public static int findShort(String s) {
//            String[] array = s.split(" ");
//            TreeSet<Integer> tree = new TreeSet<>();
//            for(String str: array){
//                tree.add(str.length());
//            }
//            return tree.first().intValue();
            String str = Stream.of(s.split(" ")).findFirst().get().toString();
            System.out.println(str);
            int i = Integer.parseInt(str);
            return i;
            //return Stream.of(s.split(" ")).mapToInt(String::length).min().getAsInt();
        }
    public static int countBits(int n){
//        String s = Integer.toBinaryString(n);
//        return ((int)Stream.of(s.split("")).filter(a -> a.equals("1")).count());
        return Integer.bitCount(n);
    }

}
