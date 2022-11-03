package com.talha.app.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

@Component
public class ConsoleClientRunner implements ApplicationRunner {

    Scanner scanner = new Scanner(System.in);

    @Value("${localserver.host}")
    private String host;

    @Value("${localserver.port}")
    private int port;

    @Override

    public void run(ApplicationArguments args) throws Exception {
        new Thread(this::runClient).start();
    }

    private void runClient() {
        displayMenu();

    }

    private void displayMenu() {
        for (; ; ) {
            System.out.println("1. Send Data");
            System.out.println("2. Exit");
            System.out.println("Select option");
            int option = scanner.nextInt();
            try {
                doWorkForOption(option);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }

    }

    private void doWorkForOption(int option) {
        switch (option) {
            case 1:
                serverProc();
                break;
            case 2:
                System.exit(1);
                break;
            default:
                System.err.println("Invalid option");
                break;
        }
    }

    private void serverProc() {

        for (; ; ) {
            try (var socket = new Socket(host, port)) {
                var dos = new DataOutputStream(socket.getOutputStream());
                var dis = new DataInputStream(socket.getInputStream());
                var br = new BufferedReader(new InputStreamReader((socket.getInputStream())));

                System.out.println("count:");
                var count = scanner.nextInt();

                System.out.println("nChar:");
                var nChar = scanner.nextInt();

                dos.writeInt(count);
                dos.writeInt(nChar);
                dos.flush();

                if (!dis.readBoolean()) {
                    System.out.println("false");
                    break;
                }
                for (int i = 0; i < count; i++) {
                    var val = br.readLine();
                    System.out.println(val);
                }
                break;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                break;
            }
        }
    }

}
