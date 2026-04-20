package ru.otus.java.basic.homeworks.homework24;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpServer {
    private int port;
    private Dispatcher dispatcher;
    private ExecutorService threadPool;

    public HttpServer(int port) {
        this.port = port;
        this.dispatcher = new Dispatcher();
        this.threadPool = Executors.newFixedThreadPool(20);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);

            while (true) {
                try {
                    Socket socket = serverSocket.accept();

                    threadPool.submit(()->handleRequest(socket));
                } catch (IOException e) {
                    System.err.println("Ошибка подключения: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleRequest(Socket socket) {
        try (socket) {
            byte[] buffer = new byte[8192];
            int n = socket.getInputStream().read(buffer);

            if (n < 1) {
                return;
            }

            String rawRequest = new String(buffer, 0, n);
            HttpRequest request = new HttpRequest(rawRequest);

            request.info(true);

            dispatcher.execute(request, socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        threadPool.shutdown();
    }
}