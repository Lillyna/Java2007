package course2.lesson5;

public class App1 {
    public static void main(String[] args)  {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
        try {
        thread.join(); } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread1  = new Thread( new MyRunnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread " + Thread.currentThread().getName());
            }
        });

    }
}
class MyRunnable implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hi from thread " + Thread.currentThread().getName());
    }
}
