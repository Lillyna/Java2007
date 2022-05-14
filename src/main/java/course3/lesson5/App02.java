package course3.lesson5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class App02 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        try {
            boolean b = reentrantLock.tryLock(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            reentrantLock.unlock();
        }
        reentrantLock.lock();
        try{

        } finally {
            reentrantLock.unlock();
        }

        //Read lock - если ни один поток не пишет, то любое число потоков может читать
        //Write lock - если ни один поток не читает, то один поток может писать
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(()->{
                reentrantReadWriteLock.readLock().lock();
                try {

                    System.out.println("Начало чтения " + finalI);
                    Thread.sleep(1000);
                    System.out.println("Конец чтения " + finalI);
                } catch(InterruptedException e){
                    e.printStackTrace();

                } finally{
                    reentrantReadWriteLock.readLock().unlock();
                }
            }).start();

        }
        for (int i = 0; i < 2; i++) {
            int finalI = i;
            new Thread(()->{
                reentrantReadWriteLock.writeLock().lock();
                try{
                    System.out.println("Начало записи " + finalI);
                    Thread.sleep(1000);
                    System.out.println("Конец записи " + finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally{
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }).start();
        }


    }
}
