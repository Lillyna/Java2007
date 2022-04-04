package course2.lesson5;

public class App {
    public static void main(String[] args)  {
        App app = new App();
        app.threadInfo();
        MyThread myThread = new MyThread();
        myThread.setPriority(10);
        myThread.setDaemon(true);
        myThread.start();
        MyThread myThread1 = new MyThread();
        myThread1.setDaemon(true);
        myThread1.start();
        try{
            myThread.join();
            myThread1.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }


    }

    private void threadInfo() {
        System.out.println("Tread " + Thread.currentThread().getName());
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true){

        }
        //System.out.println("Привет из потока " + Thread.currentThread().getName());
    }
}
