package com.multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    private static int foundPosition = -1;
    private static int numberOfThread = 3;
    private static int numberToSearch = 7;
    private static CountDownLatch countDownLatch = new CountDownLatch(numberOfThread);

    private static int[] array = new int[] {0,1,2,3,4,5,6,7,8,9,10,11,12};

    public static void main(String[] args) throws InterruptedException {

        int threadSlice = array.length / numberOfThread;

        for (int i = 0; i < numberOfThread; i++) {
            Thread t = new Thread(new WorkerThread(i * threadSlice, (i+1) * threadSlice), "Thread-"+(i+1));
            t.start();
        }

        countDownLatch.await();

        System.out.println("The number was found on position: "+foundPosition);
    }

    static class WorkerThread implements Runnable {

        private final int left;
        private final int right;

        public WorkerThread(int l, int r) {
            this.left = l;
            this.right = r;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" searching...");
            for (int i = left; i < right; i++) {
                if(array[i] == numberToSearch) {
                    foundPosition = i;
                    System.out.println("Found by "+Thread.currentThread().getName());
                }
            }
            countDownLatch.countDown();
        }
    }
}
