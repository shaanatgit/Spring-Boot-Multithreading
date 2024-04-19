package com.demo.multithreading.executor.api.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ItemService {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

        ItemProducer itemProducer = new ItemProducer(queue);
        ItemConsumer itemConsumer = new ItemConsumer(queue);

        Thread t1 = new Thread(itemProducer);
        Thread t2 = new Thread(itemConsumer);

        t1.start();
        t2.start();
        //t1.join();
        //t2.join();
        /*
        new Thread(itemProducer).start();
        new Thread(itemConsumer).start();
        System.out.println("Item producer and item consumer has been started- Main thread");  //... (1)

         with above code snippet, we are starting new threads and they will get parallel executed with Main thread.
         so you will see System out (1) first and then System out of Producer and consumer.
         But with present join method, you are joining producer and consumer threads so main thread will wait.
         you will see System outs from producer and consumers and at last you would see (1) statement printed.

         so we can implement this producer and consumer pattern without BlockingQueue ,
         using other Collection classes like arrayList or LinkedISt, but then we have to use wait() and notify() methods
         to block the consumer and producer if the ArrayList id empty or full respectively..
         BlockingQueue gives us that functionality out of the box, where it blocks the consumer(take()) , if Queue is empty
         & It blocks the Producer if queue is full.

         BlockingQueue is Asynchronous. means, threads can access(PRODUCER OR CONSUMER) the queue concurrently.
         It is FIFO. It is bounded or unbounded. unbounded is growable. can grow infinitely and cause out of memory exception.
         BlockingQueue is thread-safe implementation of Queue to use in multithreading envi.
         Other thread-safe implementations: ConcurrentHashMap , 
         There is one more specialized Queue- SynchronousQueue:
         It has capacity of zero and each insert operation must wait for corresponding remove operation by another thread.
         Thats why it is synchronous. It is best suited for situation where you need to exchange data between 2 threads synchronously.
         it is like implementing handoff between 2 threads. implement producer-consumer pattern.


         */
        System.out.println("Item producer and item consumer has been started- Main thread");


    }
}
