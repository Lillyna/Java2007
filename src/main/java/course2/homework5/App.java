package course2.homework5;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        fillMethod();
        splitAndFillMethod();
    }

    /**
     * Fill an array in parallel threads
     * Count the time for the operation
     */
    public static void fillMethod() {
        final int size = 10000000;
        float[] arr = new float[size];
        Arrays.fill(arr, 1.0f);

        //start timestamp
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        //end timestamp
        System.out.println("It took " + (System.currentTimeMillis() - a) + "ms in fillMethod");
    }

    /**
     * Split an array and fill parts in parallel threads
     * Count the time for the operation
     */
    public static void splitAndFillMethod() {
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] arr1 = new float[h];
        float[] arr2 = new float[h];
        float[] arrMerged = new float[size];
        Arrays.fill(arr, 1.0f);

        //start timestamp
        long a = System.currentTimeMillis();

        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);
        MyThread myThread1 = new MyThread(arr1);
        MyThread myThread2 = new MyThread(arr2);
        myThread1.start();
        myThread2.start();
        try {
            myThread1.join();
            myThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(arr1, 0, arrMerged, 0, h);
        System.arraycopy(arr2, 0, arrMerged, h, h);

        //end timestamp
        System.out.println("It took " + (System.currentTimeMillis() - a) + "ms in splitAndFillMethod");
    }


}

class MyThread extends Thread {
    final private float[] arr;


    public MyThread(float[] arr) {
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}