package course2.lesson5eg;

public class WaitNotifyApp {
    Object lock = new Object();
    private String currentLetter = "A";

    public static void main(String[] args) {

        WaitNotifyApp app = new WaitNotifyApp();
        Thread thread1 = new Thread(() ->
        {
            app.printA();
        });
        Thread thread2 = new Thread(() ->
        {
            app.printB();
        });
        thread1.start();
        thread2.start();
    }

    public void printA() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (!currentLetter.equals("A")) {
                        lock.wait();
                    }
                    System.out.print('A');
                    currentLetter = "B";
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void printB() {
        synchronized (lock) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (!currentLetter.equals("B")) {
                        lock.wait();
                    }
                    System.out.print('B');
                    currentLetter = "A";
                    lock.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
