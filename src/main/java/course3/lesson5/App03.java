package course3.lesson5;

import java.util.concurrent.Semaphore;

public class App03 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();
        Runnable runnable = () -> {
            try {
                semaphore.acquire();
                System.out.println("Поток " + Thread.currentThread().getName() + " выполняет долгую работу");
                Thread.sleep(1000);
                System.out.println("Поток " + Thread.currentThread().getName() + " закончил долгую работу");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
            }
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();

        }
    }


}
