package course3.lesson4.eg;

public class RaceApp {

    private static Object lock = new Object();
    private static class Counter{
        private int count;
        void increment(){
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    private static Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    synchronized (lock){
                   counter.increment();
                }}
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    synchronized (lock){
                    counter.increment();
                }}
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(counter.count);
    }
}
