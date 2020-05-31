package com.java8;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest2 {

    public static void main(String[] args) {

        CompletableFuture<Integer> future = new CompletableFuture<>();

        CompletableFuture.supplyAsync(CompletableFutureTest2::generate)
                .exceptionally(throwable -> processError(throwable))
                .thenApply(data -> data * 2)
                .exceptionally(throwable -> processError(throwable))
                .thenAccept(data -> printIt(data));

        future.thenApply(data -> data * 2).thenAccept(data -> printIt(data));
        System.out.println(future.isDone());
        System.out.println(future.isCancelled());

        future.complete(5);
    }

    private static int processError(Throwable throwable) {
        System.out.println("Error : "+throwable.getMessage());
        throw new RuntimeException("Again error");
//        return 0;
    }

    private static void printIt(Integer data) {
        System.out.println(data);
    }

    private static <U> Integer generate() {
        throw new RuntimeException("oops something went wrong");
//        return 2;
    }
}
