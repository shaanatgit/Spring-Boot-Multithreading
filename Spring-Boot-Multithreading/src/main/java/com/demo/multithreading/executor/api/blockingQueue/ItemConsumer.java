package com.demo.multithreading.executor.api.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class ItemConsumer implements Runnable {

    private BlockingQueue<String> blockingQueue;

    public ItemConsumer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        String msg;
        try {
            while (!(msg= blockingQueue.take()).equals("finished")){
                Thread.sleep(1000);
                System.out.println("Consumed item: " + msg);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
