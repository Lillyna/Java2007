package course2.lesson5eg;

public class TaskApp {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new MyThread();
        thread1.start();
        thread2.start();
        System.out.println("Я все запустил и уже закончил, жду остальных");
        //thread1.start(); //так нельзя, поток одноразовый
        //3) anonimus
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 10; i < 15; i++) {
                    System.out.println("Thread out " + i);
                }
            }
        });
        thread3.start();

        //4) lambda
        Thread thread4 = new Thread(()->{
            for (int i = 15; i < 20; i++) {
                System.out.println("Thread out " + i);
            }
        });
        thread4.start();



    }

    //1)Runnable
    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread out " + i);
            }
        }
    }
    //2)Наследование от класса thread
    public static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 5; i < 10; i++) {
                System.out.println("Thread out " + i);
            }
        }
    }

}
