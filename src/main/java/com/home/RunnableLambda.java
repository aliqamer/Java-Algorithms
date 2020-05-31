package com.home;

public class RunnableLambda {

    public static void main(String args[]) {


        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Running Thread !!!");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Lambda Runnable "+i);
            }
        });

        thread1.start();
        thread2.start();

    }
}
