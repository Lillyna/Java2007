package course2.lesson4;

import com.sun.source.util.Trees;
import course2.lesson1.homework1.Cat;

import java.util.*;

public class App {
    //Анонимный класс
//    TreeSet<Cat> cats = new TreeSet<course1.lesson9.Cat>((o1, o2) -> {
//        if(o1.getName().equals(o2.getName)){
//            return o1.getAge() - o2.getAge();
//        }
//        return o1.getName().compareTo(o2.getName());
//    });

    public static void main(String[] args) {
        List<Integer> i = Arrays.asList(1,2,3,4,4,5,6,6);
        int s = 0;
        for (Integer j : i){
            s+=j;
        }
        int sum = i.stream().mapToInt(Integer::intValue).sum();//функциональный стиль того же самого, что и выше в цикле
        int sum1 = i.stream().skip(3).mapToInt(Integer::intValue).sum();//функциональный стиль того же самого, что и выше в цикле без первых трех значений
        int sum2 = i.stream()
                .skip(3)
                .filter(j->j%2 == 0) // фильтр по условию делится на 2
                .mapToInt(Integer::intValue)
                .sum();//функциональный стиль того же самого, что и выше в цикле без первых трех значений
    }

}
