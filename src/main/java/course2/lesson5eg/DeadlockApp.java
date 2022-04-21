package course2.lesson5eg;

import javax.management.ImmutableDescriptor;
import java.util.HashMap;

public class DeadlockApp {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(()->{
            synchronized (lock1){
                System.out.println("Thread 1 locker lock1");
                synchronized (lock2){
                    System.out.println("Thread 1 locker lock2");
                }
            }
        }).start();
        new Thread(()->{
            synchronized (lock2){
                System.out.println("Thread 2 locker lock2");
                synchronized (lock1){
                    System.out.println("Thread 2 locker lock1");
                }
            }
        }).start();
    }
}
