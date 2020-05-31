package com.java8;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

/**
 * 30 05 2020
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws Exception {

        ForkJoinPool pool = new ForkJoinPool(10);

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(CompletableFutureTest::generate, pool);

        System.out.println("main started...");
        Thread.sleep(1000);

        ForkJoinPool pool2 = new ForkJoinPool(10);

        future.thenAcceptAsync(CompletableFutureTest::printIt, pool2);
        Thread.sleep(1000);

        System.out.println("Inside main() :: "+Thread.currentThread());
    }

    private static void printIt(Integer integer) {
        System.out.println("Inside printIt() :: " +Thread.currentThread() +" : "+integer);
    }

    private static <U> Integer generate() {
        System.out.println("Inside generate() :: "+Thread.currentThread());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2;
    }
}
