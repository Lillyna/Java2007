package course2.lesson5eg;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionApp {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(0);

        Object lock = new Object();
        Thread thread1 = new Thread(()->
        {
            for (int i = 0; i <10000 ; i++) {
                synchronized (lock) {
                    counter.increment1();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(()->
        {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    counter.increment1();
                }
            }
        });
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("Counter = " + counter.getValue()) ;
        
    }
    public static class Counter{

        private AtomicInteger value; //синхронизированный класс
        private int value1;
        public int getValue(){
            return value1;
        }

        public Counter(int value1) {
            this.value = new AtomicInteger(0);
        }

        public void increment(){
            value1++;
        }
        public void increment1(){
            value.incrementAndGet();
        }
//        public synchronized void increment(){
//            value++;
//        }

//        public  void increment(){ то же самое, что предыдущий метод
//            synchronized (this){
//                value++;
//            }
//        }
    }
}
