package com.thread;

/**
 * Created by Ali on 11/8/2016.
 */

class AdderThread extends Thread {

    int sum;
    public void run(){
        System.out.println("In run");
        synchronized (this){
            for (int i = 0; i < 1000000; i++) {
                sum += i;
            }
            notifyAll();
        }
    }

}


public class WaitNotify {

    public static void main(String args[]) {

        AdderThread obj = new AdderThread();
        obj.start();

        synchronized (obj){
            try{
                System.out.println("waiting for sum");
                obj.wait();
            }catch (InterruptedException e){}
        }

        System.out.println(obj.sum);
    }
}
