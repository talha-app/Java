package com.talha.app.client;

import java.net.Socket;
import java.time.LocalDateTime;

public class ClientInfo {
    private Socket socket;
    private LocalDateTime lastUpdateDate = LocalDateTime.now();
    private int ephemeralport;
    private boolean completed;

    public ClientInfo(Socket socket, int ephemeralport) {
        this.socket = socket;
        this.ephemeralport = ephemeralport;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public int getEphemeralport() {
        return ephemeralport;
    }

    public void setEphemeralport(int ephemeralport) {
        this.ephemeralport = ephemeralport;
    }


    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
