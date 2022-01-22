package homework6;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ZooApp {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        int catsCount = 0;
        int dogsCount = 0;
        for (int i = 0; i < 10; i++) {
            animals.add(new Cat("Tom" + i, 20 * i));
            animals.add(new Dog("Bob" + i, 40 * i, i));
        }
        for (Animal animal : animals) {
            //для проверки, что умеет животина
            //animal.run(100);
            //animal.swim(20);
            if (animal instanceof Cat) catsCount++;

            if (animal instanceof Dog) dogsCount++;
        }

        System.out.println("Создано всего котов: " + catsCount);
        System.out.println("Создано всего собак: " + dogsCount);
        System.out.println("Создано всего животных: " + animals.size());
    }
}
