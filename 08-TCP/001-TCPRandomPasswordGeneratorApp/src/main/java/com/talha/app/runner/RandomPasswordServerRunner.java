package com.talha.app.runner;

import com.talha.app.client.ClientInfo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

@Component
public class RandomPasswordServerRunner implements ApplicationRunner {
    private final ServerSocket serverSocket;
    private final ExecutorService executorService;
    private final Random random = new Random();
    private final ConcurrentHashMap<Socket, ClientInfo> clientMap;

    public RandomPasswordServerRunner(ServerSocket serverSocket, ExecutorService executorService, ConcurrentHashMap<Socket, ClientInfo> clientMap) {
        this.serverSocket = serverSocket;
        this.executorService = executorService;
        this.clientMap = clientMap;
    }

    private void runForAccept() {
        for (; ; ) {
            this.runServerCallback();
        }
    }

    private void handleClient(Socket clientSocket) {
        writeLogToConsole(clientSocket);
        executorService.execute(() -> generatePassword(clientSocket));

    }

    private void generatePassword(Socket clientSocket) {
        try (clientSocket) {
            var dis = new DataInputStream(clientSocket.getInputStream());
            var bw = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            var dos = new DataOutputStream(clientSocket.getOutputStream());

            var clientInfo = new ClientInfo(clientSocket, clientSocket.getPort());
            clientMap.put(clientSocket, clientInfo);

            int count = dis.readInt();

            synchronized (clientMap) {
                setLastUpdateDate(clientInfo);
            }

            int nChars = dis.readInt();

            synchronized (clientMap) {
                setLastUpdateDate(clientInfo);
                clientInfo.setCompleted(true);
            }

            sendPassword(count, nChars, bw, clientSocket, dos);
        } catch (Exception ex) {
            System.err.println(ex.getLocalizedMessage());
        }
    }

    private void setLastUpdateDate(ClientInfo clientInfo) {
        if (!clientMap.containsKey(clientInfo.getSocket())) {
            return;
        }
        clientInfo.setLastUpdateDate(LocalDateTime.now());
    }

    private void runServerCallback() {
        System.out.println("Random Password Generator Server is waiting for a client");
        try {
            Socket clientSocket = serverSocket.accept();
            handleClient(clientSocket);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private void sendPassword(long count, int nChars, BufferedWriter bufferedWriter, Socket socket, DataOutputStream dos) throws IOException {
        if (count < 1 || count > 10) {
            dos.writeBoolean(false);
            return;
        }
        dos.writeBoolean(true);
        for (int i = 0; i < count; i++) {

            String val = String.valueOf(random.nextInt(nChars));
            System.out.println(val);

            bufferedWriter.write(val + "\r\n");
            bufferedWriter.flush();
        }
    }

    private void writeLogToConsole(Socket clientSocket) {
        var host = clientSocket.getInetAddress().getHostAddress();
        var port = clientSocket.getPort();
        var localPort = clientSocket.getLocalPort();
        System.out.println("Host: " + host + "Port: " + port + "Local Port: " + localPort);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        executorService.execute(this::runForAccept);
    }

    public void schdulerCallback() {
        System.out.println("Client Size: " + clientMap.size());
        schedulerSynchronizedCallback();
    }

    private void schedulerSynchronizedCallback() {
        clientMap.keySet().removeIf(this::isRemovable);
    }

    private boolean isRemovable(Socket socket) {
        var now = LocalDateTime.now();
        var ci = clientMap.get(socket);
        var status = ChronoUnit.SECONDS.between(ci.getLastUpdateDate(), now) > 8;

        try {
            if (status)
                socket.close();
        } catch (IOException ex) {
            System.err.println(ex.getLocalizedMessage());
        }
        return status;
    }
}
