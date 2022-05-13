package course3.lesson4.eg;

import java.util.ArrayList;
import java.util.List;

public class WaitNotifApp {
    private static List<String> list = new ArrayList<>();

    private static int MAX_SIZE = 10;

    public static void main(String[] args) throws InterruptedException {
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {while(true){ synchronized (list){

                        Thread.sleep(100);

                    while(list.size() >10){
                        list.wait();
                    }

                        list.add("string");
                        list.notifyAll();
                    }
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        producer.start();

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {while(true) {
                    synchronized (list) {
                        Thread.sleep(1000);
                        while(list.size() == 0){
                            list.wait();
                        }
                        list.remove(list.size() - 1);
                        if(list.size()<5){
                            list.notifyAll();
                        }
                    }
                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        consumer.start();
        while(true){
            Thread.sleep(1000);
            System.out.println(list.size());
        }

    }
}
