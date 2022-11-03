package com.talha.app.component;

import org.springframework.stereotype.Component;

@Component
public class SharedObject {
    private int val;
    private volatile boolean produce = true;

    public synchronized void setVal(int val) throws InterruptedException {
        while (!produce) {
            this.wait();
        }
        this.val = val;
        produce = false;
        this.notify();
    }

    public synchronized int getVal() throws InterruptedException {
        while (produce) {
            this.wait();
        }
        int val = this.val;

        produce = true;
        this.notify();
        return val;
    }

}
