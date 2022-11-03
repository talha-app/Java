package com.talha.app.configuration.client;

import com.talha.app.client.ClientInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class ClientInfoConfig {
    @Bean
    public ConcurrentHashMap getClientMap() {
        return new ConcurrentHashMap<Socket, ClientInfo>();
    }
}
