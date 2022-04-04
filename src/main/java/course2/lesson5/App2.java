package course2.lesson5;
class Counter{
    private long count;
    private final Object monitor = new Object();

    public synchronized void inc(){
        count++; // race condition (состояние гонки)
        // или вот так
//        synchronized(monitor){
//            count++;
//        }
    }

    public long getCount(){
        return count;
    }
}
public class App2 {


    public static void main(String[] args) {
        final Counter counter = new Counter();
        MyThread11 t1 = new MyThread11(counter);
        MyThread11 t2 = new MyThread11(counter);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println( counter.getCount());
    }


}
class MyThread11 extends Thread{

    private final Counter counter;

    public MyThread11(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++) {
            counter.inc();
        }
    }
}