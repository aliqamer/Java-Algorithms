package com.thread;

/**
 * Created by Ali on 11/7/2016.
 */
public class MutexThread extends Thread{

    private Semaphore mutex;

    public MutexThread(Semaphore s, String str){
        super(str);
        this.mutex = s;
//        start();
    }

    public void run(){
        while(true){
            mutex.down();
            System.out.println("Enter critical section "+getName());
            try{
                sleep((long)Math.random()*1000);
            }catch (InterruptedException e){}
            System.out.println("Exit critical section "+getName());
            mutex.up();
        }
    }

    public static void main(String args[]) {

        int noOfThread = 3;

        Semaphore mutex = new Semaphore(noOfThread);
        for (int i = 1; i <= 10; i++) {
            new MutexThread(mutex, "Thread: "+i).start();
        }

    }
}
