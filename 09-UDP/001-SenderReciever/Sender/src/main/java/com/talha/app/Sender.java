package com.talha.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

@Component
public class Sender {
    @Value("${sender.host}")
    private String host;

    @Value("${sender.port}")
    private int port;

    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        try (var datagramSocket = new DatagramSocket()) {
            for (; ; ) {
                System.out.println("Text giriniz:");
                var text = scanner.next();
                if (text.equals("exit")) {
                    break;
                }
                var data = text.getBytes(StandardCharsets.UTF_8);
                var datagramPacket = new DatagramPacket(data,0, data.length, InetAddress.getByName(host), port);
                datagramSocket.send(datagramPacket);
            }

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }
}
