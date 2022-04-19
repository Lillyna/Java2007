package course2.lesson5eg;

public class JoinApp {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->
        {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        });

        //
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.start();
        thread.join();
        System.out.println("END");
    }
}
