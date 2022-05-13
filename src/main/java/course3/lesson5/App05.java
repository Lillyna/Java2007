package course3.lesson5;

import java.awt.image.ImagingOpException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class App05 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{

                try {
                    System.out.println("Подготовка " + Thread.currentThread().getName());
                    Thread.sleep(500);
                    System.out.println("Готов " + Thread.currentThread().getName());
                    cyclicBarrier.await();
                    System.out.println("Поехали " + Thread.currentThread().getName());
                    cyclicBarrier.await();
                    System.out.println("Снова поехали " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }

    }
}
