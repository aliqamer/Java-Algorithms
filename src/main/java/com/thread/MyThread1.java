package com.thread;

/**
 * Created by Ali on 11/7/2016.
 */
public class MyThread1 {

    public static void main(String args[]) {
        TwoThreadExample object = new TwoThreadExample();
    }
}

class TwoThreadExample {
    public TwoThreadExample(){
        new SimpleThread("First").start();
        new SimpleThread("Second").start();
        new SimpleThread("Third").start();
        new SimpleThread("Fourth").start();
        new SimpleThread("Fifth").start();
    }

    private class SimpleThread extends Thread {

        public SimpleThread(String str){
            super(str);
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(getName()+ " : says "+i);
                try{
                    sleep((long)Math.random()*1000);
                }catch (InterruptedException e){  }
                System.out.println(getName()+" is done");
            }
        }
    }
}