package com.thread;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Ali on 11/8/2016.
 */



class Signal {

    private boolean isReady;

    Signal(){
        isReady = false;
    }

    public synchronized boolean isReady(){
        return isReady;
    }

    public synchronized void setReady(){
        isReady = true;
    }
}


public class TestSignal extends Thread {
    public static void main(String[] args) {

        Queue<Integer> q = new PriorityQueue<>();
        final Signal obj = new Signal();

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!obj.isReady()){
                    System.out.println("waiting to get ready !!!");
                }
                System.out.println("Its ready now go !!!");
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("going to sleep");
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("going to make ready !!!");
                obj.setReady();
                System.out.println("Its ready !!!");
            }
        });

        a.start();
        b.start();
    }
}