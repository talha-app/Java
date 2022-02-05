package com.talha.app.configuration.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.net.ServerSocket;

@Configuration
public class ServerSocketConfig {
    @Value("${socket.port:50500}")
    private int port;

    @Value("${socket.backlog:50}")
    private int backlog;

    @Bean
    public ServerSocket getServerSocket() throws IOException {
        return new ServerSocket(port, backlog);
    }
}
