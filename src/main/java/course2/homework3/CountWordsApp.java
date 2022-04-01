package course2.homework3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class CountWordsApp {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int number = random.nextInt(100);
            String str = String.valueOf(number);
            words.add(str);
            if (i % 3 == 0) {
                words.add(str);
            }
        }
        System.out.println(words);

        //Просто удалить дубликаты
        HashSet<String> uniqueWords = new HashSet<>(words);
        System.out.println(uniqueWords);

        //Сразу удалить дубликаты и посчитать вхождения
        countWords(words);
    }

    /**
     * Считает количество уникальных значений в списке строк
     *
     * @param words входной список строк
     */
    private static void countWords(ArrayList<String> words) {
        HashMap<String, Integer> uniqueWordsCount = new HashMap<>();
//        uniqueWordsCount = words.stream()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (String word : words) {

            uniqueWordsCount.merge(word, 1, (a,b) -> a+b); // в одну строчку

//            int value = uniqueWordsCount.getOrDefault(word,0) + 1; //в две строчки
//            uniqueWordsCount.put(word,value);

//            Integer count = uniqueWordsCount.get(word);
//            if (count == null) {
//                count = 0;
//            }
//            count++;
//            uniqueWordsCount.put(word, count);
        }

        for (String str : uniqueWordsCount.keySet()) {
            System.out.printf("%s : %s%n", str, uniqueWordsCount.get(str));

        }
    }

}
