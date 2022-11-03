package com.talha.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

@Component
public class Receiver {
    @Value("${receiver.bufsize}")
    private int bufsize;

    @Value("${receiver.port}")
    private int port;

    public void run() {
        try (var datagramSocket = new DatagramSocket(port)) {

            var buf = new byte[bufsize];
            for (; ; ) {
                System.out.println("Waiting for a sender ");
                var datagramPacket = new DatagramPacket(buf, buf.length);
                datagramSocket.receive(datagramPacket);
                var length = datagramPacket.getLength();
                byte[] data = Arrays.copyOf(datagramPacket.getData(), length);
                var text = new String(data);
                System.out.println(text);
                System.out.println(datagramPacket.getAddress().getHostAddress());
            }

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }
}
