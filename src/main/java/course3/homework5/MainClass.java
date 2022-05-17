package course3.homework5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        Object object;
        CountDownLatch countDownLatch = new CountDownLatch(CARS_COUNT);
        Semaphore semaphore = new Semaphore(CARS_COUNT / 2);
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(semaphore), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), countDownLatch);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        try {
            countDownLatch.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            List<Thread> list = new ArrayList<>();
            for (int i = 0; i < cars.length; i++) {
                int finalI = i;
                Thread thread = new Thread(() -> {
                    cars[finalI].start();
                });
                thread.start();
                list.add(thread);
            }
            for (Thread thread : list) {
                thread.join();
            }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}