package course2.lesson3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Monday");
        map.put(2, "Tuesday");
        map.put(3, "Wednesday");
        map.put(4, "Thursday");
        map.put(4, "Friday");//заменит четверг пятницей
        boolean b = map.containsKey(3);
        String s = map.get(4);
        System.out.println(s);
        Collection<String> values = map.values();
        Set<Integer> integers = map.keySet();
        System.out.println(integers);
        System.out.println(values);

    }
}
