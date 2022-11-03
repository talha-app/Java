package com.talha.app.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;

@Component
public class SharedObject {
    private final Semaphore producerSemaphore;
    private final Semaphore consumerSemaphore;
    private final int[] queue;
    private int head;
    private int tail;

    public SharedObject(@Qualifier("producerSemaphore") Semaphore producerSemaphore,
                        @Qualifier("consumerSemaphore") Semaphore consumerSemaphore,
                        int[] queue) {

        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.queue = queue;
    }

    public void setVal(int val) throws InterruptedException {
        producerSemaphore.acquire(queue.length);
        queue[tail++] = val;
        tail %= queue.length; //circle queue
        consumerSemaphore.release();
    }

    public int getVal() throws InterruptedException {
        consumerSemaphore.acquire();
        int val = queue[head++];
        head %= queue.length;
        producerSemaphore.release(queue.length);
        return val;
    }

}
