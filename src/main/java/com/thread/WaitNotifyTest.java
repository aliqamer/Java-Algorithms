package com.thread;

/**
 * Created by Ali on 8/5/2017.
 */

class q{
    int n;
    boolean flag = false;

    synchronized int get() throws InterruptedException {

        while(!flag){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        System.out.println("got: "+n);
        flag = false;
        Thread.sleep(1000);
        notify();
        return n;
    }

    synchronized void add(int n){

        while(flag){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        this.n = n;
        flag = true;
        System.out.println("add : "+n);
        notify();

    }

}

class produce implements Runnable{

    q queue;

    produce(q q1){
        this.queue = q1;
        new Thread(this, "produce").start();
    }

    @Override
    public void run() {
        int i = 1;
        while(true){
            queue.add(i++);
        }
    }
}

class consume implements Runnable {

    q queue;

    consume(q q1){

        this.queue = q1;
        new Thread(this, "Consume").start();
    }

    @Override
    public void run() {

        while(true){
            try {
                queue.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class WaitNotifyTest {

    public static void main(String args[]) {

        WaitNotifyTest object = new WaitNotifyTest();
        q obj = new q();
        new produce(obj);
        new consume(obj);


    }
}
