package com.thread;

/**
 * Created by Ali on 11/7/2016.
 */
public class Semaphore {

    private int val;

    public Semaphore(int n) {

        if(n < 0){
            val = 0;
        }
        val = n;
    }

    public synchronized void down(){
        while(val == 0){
            try{
                wait();
            }catch (InterruptedException e){}
            val--;
        }
    }

    public synchronized void up(){
        val++;
        notify();
    }
}
