package com.demo.multithreading.executor.api.blockingQueue;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
f
 */
public class CompletableFutureInfo {


    void exampleMethodOnly(){
        for(int i=0; i< 100; i++){
            ExecutorService cpuBound= Executors.newFixedThreadPool(4);
            ExecutorService ioBound= Executors.newCachedThreadPool();

            CompletableFuture.supplyAsync(()->getOrder(), ioBound)
                    .thenApplyAsync(order-> enrich(order), cpuBound)
                    .thenApplyAsync(o-> performPayment(o), ioBound)
                    .thenApplyAsync(order-> disPatch(order))
                    .thenAccept(order-> sendEmail(order));
        }
    }

    private void sendEmail(Object order) {
        //send email
    }

    private Object disPatch(Object order) {
        return order;
    }

    private Object performPayment(Object o) {
        return o;
    }

    private Object enrich(Object order) {
        return order;
    }

    private Object getOrder() {
        return new Object();
    }






}
