package course3.lesson5;

import java.util.concurrent.ArrayBlockingQueue;

//Consumer - Producer
public class CAP {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(6);
        new Thread(()->{
            Producer producer = new Producer(queue);
            for (int i = 0; i < 12; i++) {
                producer.put(String.valueOf(i));

                try{
                    Thread.sleep(50);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(()->{
            Consumer consumer = new Consumer(queue);for (int i = 0; i < 12; i++) {
                consumer.get();
                try{
                    Thread.sleep(200);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        }).start();
    }
}
class Producer {
    private final ArrayBlockingQueue<String> queue;

    public Producer(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void put (String x){
        System.out.println("Producer adds " + x);
        try {
            queue.put(x);
            System.out.println("size: "+queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer {
    private final ArrayBlockingQueue<String> queue;

    public Consumer(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }
    public String get(){
        try {
            String take = queue.take();
            System.out.println("Consumer got " + take);
            return take;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;


    }
}
