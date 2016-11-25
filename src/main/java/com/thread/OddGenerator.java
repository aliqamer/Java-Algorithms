package com.thread;

/**
 * Created by Ali on 11/7/2016.
 */

/*class odd {
    private int n = 1;

    public int next() {
        ++n;
        try{
            Thread.sleep(1000l);
        }catch (InterruptedException e){}
        ++n;
        return n;
    }
}*/

class odd3 {
    private int n = 1;
    Semaphore mutex;

    public odd3(){
        mutex = new Semaphore(1);
    }

    public int next() {
        mutex.down();
        ++n;
        try{
            Thread.sleep(1000l);
        }catch (InterruptedException e){}
        ++n;
        mutex.up();
        return n;
    }
}

class odd2 extends Thread{

    private odd3 odd;

    public odd2(odd3 o){
        this.odd = o;
    }

    public void run(){
        for (int i = 1; i < 10; i++) {
            System.out.println("result: "+odd.next());
        }
    }
}

public class OddGenerator extends Thread {

    public static void main(String args[]) {
//        odd e = new odd();
        odd3 e = new odd3();
        odd2 t1 = new odd2(e);
        odd2 t2 = new odd2(e);

        t1.start();
        t2.start();
    }
}
