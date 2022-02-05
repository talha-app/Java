package com.talha.app;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RecieverRunner implements ApplicationRunner {
    private final Receiver sender;

    public RecieverRunner(Receiver sender) {
        this.sender = sender;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        sender.run();
    }
}
