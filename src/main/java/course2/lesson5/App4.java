package course2.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class App4 {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        //deadlock
        MyThreadMom t1 = new MyThreadMom(a,b);
        MyThreadMom2 t2 = new MyThreadMom2(a,b);
        t1.start();
        t2.start();


    }
}

class MyThreadMom extends Thread{
    private final Object a;
    private final Object b;

    public MyThreadMom(Object a, Object b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (a){
            System.out.println("Monitor a occupied by thread 1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b){
                System.out.println("Monitor b occupied by thread 1");
            }
        }

    }
}

class MyThreadMom2 extends Thread{
    private final Object a;
    private final Object b;

    public MyThreadMom2(Object a, Object b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (b){

            System.out.println("Monitor b occupied by thread 1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (a){
                System.out.println("Monitor a occupied by thread 1");
            }
        }

    }
}
