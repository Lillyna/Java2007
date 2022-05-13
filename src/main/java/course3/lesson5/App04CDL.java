package course3.lesson5;

import java.util.concurrent.CountDownLatch;

public class App04CDL {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);




        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " начинает спать");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " закончил спать");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            System.out.println("Блокируемся");
            countDownLatch.await();
            System.out.println("Поехали");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
