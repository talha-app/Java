package com.talha.app.component;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.concurrent.Semaphore;

@Component
public class SharedObject {
    private int val;
    private final Semaphore producerSemaphore;
    private final Semaphore consumerSemaphore;

    public SharedObject(@Qualifier("producerSemaphore") Semaphore producerSemaphore,
                        @Qualifier("consumerSemaphore") Semaphore consumerSemaphore) {

        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
    }

    public void setVal(int val) throws InterruptedException {
        producerSemaphore.acquire();
        this.val = val;
        consumerSemaphore.release();
    }

    public int getVal() throws InterruptedException {
        consumerSemaphore.acquire();
        int val = this.val;
        producerSemaphore.release();
        return val;
    }

}
