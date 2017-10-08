package com.thread;

import java.util.Vector;

/**
 * Created by Ali on 11/7/2016.
 */
public class ProducerConsumer {

    public static void main(String args[]) {

        Vector queue = new Vector();
        int size = 5;
        Thread producerThread = new Thread(new Producer(queue, size), "producer");
        Thread consumerThread = new Thread(new Consumer(queue, size), "consumer");
        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {

    private final Vector queue;
    private final int size;

    public Producer(Vector q, int s){
        this.queue = q;
        this.size = s;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Producer trying to produce item: "+i);
            try{
                produce(i);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }

    private void produce(int i) throws InterruptedException{
        while(queue.size() == size){
            synchronized (queue){
                System.out.println("Queue is full "+Thread.currentThread().getName()+" is waiting, size "+size);
                queue.wait();
            }
        }

        synchronized (queue){
            queue.add(i);
            queue.notifyAll();
        }
    }
}


class Consumer implements Runnable {

    private final Vector queue;
    private final int size;

    public Consumer(Vector q, int s){
        this.queue = q;
        this.size = s;
    }

    public void run(){

        while(true){
            try {
                System.out.println("Consuming element "+ consume());
                Thread.sleep(1000l);
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }

    private int consume() throws InterruptedException{

        while(queue.isEmpty()){
            synchronized (queue){
                System.out.println("Queue is empty "+Thread.currentThread().getName()+ " is waiting for next element");
                queue.wait();
            }
        }

        synchronized (queue){
            queue.notifyAll();
            return (Integer) queue.remove(0);
        }
    }
}

