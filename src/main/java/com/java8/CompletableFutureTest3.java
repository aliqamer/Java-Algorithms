package com.java8;

import java.util.concurrent.CompletableFuture;

//combine example
public class CompletableFutureTest3 {

    public static void main(String[] args) {

        CompletableFuture<Integer> google = CompletableFuture
                .supplyAsync(() -> getStockPrice("google", 1));

        CompletableFuture<Integer> amazon = CompletableFuture
                .supplyAsync(() -> getStockPrice("amazon", 1));

        google.thenAccept(value -> printIt(value));
        amazon.thenAccept(value -> printIt(value));

        //combine future objects
        google.thenCombine(amazon, (g, a) -> g + a)
                .thenAccept(value -> printIt(value));
    }

    private static void printIt(Integer value) {
        System.out.println(value);
    }

    private static <U> Integer getStockPrice(String ticker, int value) {
        Integer price = 500;

        if(ticker == "google") {
            price = 1000;
        }

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        return price;
    }
}
