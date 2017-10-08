package com.thread;


class Thread1 extends Thread {

    public Thread1(String name){
        super(name);
    }

    public void run(){

        for (int i = 0; i < 5; i++) {

            System.out.println("Running Thread "+Thread.currentThread()+" i=: "+i);
            try {
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Exiting "+Thread.currentThread());
    }
}

class Thread2 implements Runnable {


    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            System.out.println("Running Thread2 "+Thread.currentThread()+" i=: "+i);
            try {
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Exiting "+Thread.currentThread());

    }
}

public class ThreadRunnable {

    public static void main(String args[]) {

        ThreadRunnable object = new ThreadRunnable();

        Thread1 t1 = new Thread1("Thread1");
        Thread t2 = new Thread(new Thread2(), "Thread2");

        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting main(): "+Thread.currentThread());
    }
}
