package com.talha.app.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Semaphore;

@Configuration
public class SemaphoreConfig {
    @Bean("producerSemaphore")
    public Semaphore getProducerSemaphore() {
        return new Semaphore(10, true);
    }

    @Bean("consumerSemaphore")
    public Semaphore getConsumerSemaphore() {
        return new Semaphore(0);
    }
}
