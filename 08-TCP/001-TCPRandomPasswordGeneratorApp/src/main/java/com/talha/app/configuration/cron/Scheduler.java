package com.talha.app.configuration.cron;

import com.talha.app.runner.RandomPasswordServerRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Timer;
import java.util.TimerTask;

@Configuration
public class Scheduler implements ApplicationRunner {

    private final RandomPasswordServerRunner server;

    public Scheduler(RandomPasswordServerRunner server) {
        this.server = server;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        var timerTask = new TimerTask() {
            @Override
            public void run() {
                server.schdulerCallback();
            }
        };

        var timer = new Timer();
        timer.schedule(timerTask, 0, 5000);
    }

}
