package com.java8;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

// thenCompose example
public class CompletableFutureTest4 {

    private static void printIt(Integer value) {
        System.out.println(value);
    }

    private static <U> CompletableFuture<Integer> getStockPrice(String ticker, int value) {
        return CompletableFuture.supplyAsync(() -> {
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
        });
    }
    public static void main(String[] args) throws InterruptedException {

        List<String> stocks = Arrays.asList("google", "amazon");

        CompletableFuture.supplyAsync(() -> stocks.get(0))
                .thenApply(symbol -> getStockPrice(symbol, 2));
//                .thenAccept(value -> printIt(value));
        //CompletableFuture<CompletableFuture<Integer>>

        CompletableFuture.supplyAsync(() -> stocks.get(0))
                .thenCompose(symbol -> getStockPrice(symbol, 2))
                .thenAccept(value -> printIt(value));
        //<CompletableFuture<Integer>

//        Thread.sleep(2000);
    }
}
