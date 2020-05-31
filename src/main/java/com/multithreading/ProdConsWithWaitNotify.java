package com.multithreading;


import java.util.Vector;

class Prod implements Runnable{

    private Vector<Integer> vector;
    private Integer size;

    public Prod(Vector<Integer> vector, int size){
        this.vector = vector;
        this.size = size;
    }

    @Override
    public void run() {



    }
}

class Cons implements Runnable {

    private Vector<Integer> vector;
    private Integer size;

    public Cons(Vector<Integer> vector, Integer s){
        this.vector = vector;
        this.size = s;
    }

    @Override
    public void run() {

        while(true){
            if(vector.size() == size){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

public class ProdConsWithWaitNotify {

    public static void main(String args[]) {

        ProdConsWithWaitNotify object = new ProdConsWithWaitNotify();

        Vector<Integer> vector = new Vector<>();
        Prod producer = new Prod(vector, 10);
        Cons consumer = new Cons(vector, 10);

        Thread t1 = new Thread(producer, "Producer");
        Thread t2 = new Thread(consumer, "Consumer");

        t1.start();
        t2.start();
    }
}
