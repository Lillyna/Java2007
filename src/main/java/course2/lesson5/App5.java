package course2.lesson5;

public class App5 {
    //wait, notify
    public static void main(String[] args) {
        Object m = new Object();
        T1 t1 = new T1(m);
        T2 t2 = new T2(m);
        t1.start();
        t2.start();
    }
}
class T1 extends Thread{
    private final Object monitor;

    public T1(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor){
            System.out.println("1 захватил");
            try {
                monitor.wait();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (monitor){
                System.out.println("1 освободил");
            }
        }

    }
}

class T2 extends Thread{
    private final Object monitor;

    public T2(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        synchronized (monitor){
            System.out.println("2 захватил");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (monitor){
            monitor.notify();
            System.out.println("2 освободил");

        }

    }
}
