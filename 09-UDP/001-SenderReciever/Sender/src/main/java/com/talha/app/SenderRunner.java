package com.talha.app;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SenderRunner implements ApplicationRunner {
    private final Sender sender;

    public SenderRunner(Sender sender) {
        this.sender = sender;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        sender.run();
    }
}
