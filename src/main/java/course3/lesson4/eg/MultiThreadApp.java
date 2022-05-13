package course3.lesson4.eg;

public class MultiThreadApp {
    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("In my Runnable " + Thread.currentThread().getName());
        }
    }

    public static class MyThread extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("In my Thread" + Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) throws InterruptedException {
        //1)Runnable
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        //2)extends Thread
        Thread thread2 = new MyThread();
        thread2.start();

        //3)unanimous class
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In anonimus" + Thread.currentThread().getName());
            }
        });
        thread3.start();

        //4)lambda
        Thread thread4 = new Thread(() -> System.out.println("In lambda " + Thread.currentThread().getName()));
        thread4.start();
        thread.join();

    }


}
