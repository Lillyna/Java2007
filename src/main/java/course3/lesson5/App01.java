package course3.lesson5;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class App01 {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(10);
//        int i1 = i.incrementAndGet();
//        i.getAndIncrement();
        AtomicReference atomicReference = new AtomicReference(new Object());
        int i2 = i.accumulateAndGet(1, (x, y) -> x / y);
        System.out.println(i2);

        //коллекции, которые могут работать в многопоточной среде
        Vector<String> stringVector = new Vector<>(); //непроизводительный (все методы синхронизированные)
        List<Object> objects = Collections.synchronizedList(new ArrayList<>());//устаревший способ тоже
        ArrayList<String> strings = new ArrayList<>();
        Iterator<String> iterator = strings.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            iterator.remove();
        }
        for(String string : new ArrayList<>(strings)){
            strings.remove(string);
        }
        CopyOnWriteArrayList<Object> objects1 = new CopyOnWriteArrayList<>();//методы несинхронизированные, быстрее
        CopyOnWriteArraySet<Object> objects2 = new CopyOnWriteArraySet<>();
        //Collections.synchronizedMap(); // при чтении и записи блокируется вся мапа
        ConcurrentHashMap<Integer, String> integerStringConcurrentHashMap = new ConcurrentHashMap<>();// при чтении и записи
        // блокируется только рабочий бакет, остальные могут быть использованы другими потоками

    }
}
