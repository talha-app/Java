package com.talha.app.runner;

import com.talha.app.component.SharedObject;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ExecutorService;

@Component
public class ProducerRunner implements ApplicationRunner {
    private final SharedObject sharedObject;
    private final ExecutorService executorService;
    private final Random random;

    public ProducerRunner(SharedObject sharedObject, ExecutorService executorService, Random random) {
        this.sharedObject = sharedObject;
        this.executorService = executorService;
        this.random = random;
    }

    @Override
    public void run(ApplicationArguments args) {
        executorService.execute(this::producerCallback);
        executorService.shutdown();
    }

    private void producerCallback() {
        int i = 0;
        for (; ; ) {

            try {
                Thread.sleep(random.nextInt(500) + 100);
                sharedObject.setVal(i);
            } catch (InterruptedException ignore) {
            }

            if (i == 99)
                break;
            ++i;
        }
    }

}
