package com.demo.multithreading.executor.api.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class ItemProducer implements Runnable {

    private BlockingQueue<String> blockingQueue;

    public ItemProducer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            String msg = " " + i;
            try {
                blockingQueue.put(msg);
                System.out.println("Produced item: " + msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String msg= "finished";
        try{
            blockingQueue.put(msg);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
