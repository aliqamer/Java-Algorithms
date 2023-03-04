package com.multithreading;

import java.util.LinkedList;
import java.util.Queue;

/**
 * from course Java multithreading and Parallel programming masterclass
 * by Cosmin Lonita
 */
public class WaitNotifyProdCons {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<>();
        Thread t1 = new Thread( new Producer(queue), "Producer");
        Thread t2 = new Thread( new Consumer(queue), "Consumer");

        t1.start();
        t2.start();
    }

    static class Producer implements Runnable {

        private final Queue<String> queue;

        public Producer(Queue<String> q) {
            this.queue = q;
        }

        @Override
        public void run() {

            while(true) {
                try {
                    produceData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void produceData() throws InterruptedException {
            synchronized (queue) {
                if(queue.size() == 10) {
                    System.out.println("In producer, waiting...");
                    queue.wait();
                }

                Thread.sleep(700);

                System.out.println("Producing data with id: "+queue.size());
                queue.add("element_"+queue.size());

                if(queue.size() == 1){
                    queue.notify();
                }
            }
        }
    }

    static class Consumer implements Runnable {

        private final Queue<String> queue;

        public Consumer(Queue<String> q) {
            this.queue = q;
        }

        @Override
        public void run() {

            while(true) {
                try {
                    consumeData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void consumeData() throws InterruptedException {
            synchronized (queue) {
                if(queue.size() == 0) {
                    System.out.println("Consumer, waiting...");
                    queue.wait();
                }
                Thread.sleep(1000);

                System.out.println("Consumer received data: "+queue.remove());
                if(queue.size() == 9){
                    queue.notify();
                }
            }
        }
    }

}
