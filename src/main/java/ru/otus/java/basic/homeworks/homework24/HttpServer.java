package ru.otus.java.basic.homeworks.homework24;

import java.io.IOException;
import java.io.InputStream;
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
            String rawRequest = readRequest(socket.getInputStream());

            if (rawRequest == null || rawRequest.isEmpty()) {
                return;
            }

            HttpRequest request = new HttpRequest(rawRequest);
            request.info(true);
            dispatcher.execute(request, socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readRequest(InputStream inputStream) throws IOException {
        StringBuilder headerBuilder = new StringBuilder();
        int contentLength = 0;
        boolean headersComplete = false;

        while (!headersComplete) {
            int ch = inputStream.read();
            if (ch == -1) {
                return null;
            }

            headerBuilder.append((char) ch);

            if (headerBuilder.length() >= 4) {
                String endOfHeaders = headerBuilder.substring(headerBuilder.length() - 4);
                if (endOfHeaders.equals("\r\n\r\n")) {
                    headersComplete = true;
                    String headers = headerBuilder.toString();
                    int contentLengthIndex = headers.indexOf("Content-Length:");
                    if (contentLengthIndex != -1) {
                        int start = contentLengthIndex + "Content-Length:".length();
                        int end = headers.indexOf("\r\n", start);
                        String contentLengthStr = headers.substring(start, end).trim();
                        try {
                            contentLength = Integer.parseInt(contentLengthStr);
                        } catch (NumberFormatException e) {
                            contentLength = 0;
                        }
                    }
                }
            }
        }

        String body = "";
        if (contentLength > 0) {
            char[] bodyChars = new char[contentLength];
            int bytesRead = 0;
            int totalRead = 0;
            String headerSoFar = headerBuilder.toString();
            int bodyStartIndex = headerSoFar.length() - 4;

            if (bodyStartIndex < headerSoFar.length()) {
                String remaining = headerSoFar.substring(bodyStartIndex);
                for (int i = 0; i < remaining.length() && totalRead < contentLength; i++) {
                    bodyChars[totalRead++] = remaining.charAt(i);
                }
            }

            while (totalRead < contentLength) {
                int ch = inputStream.read();
                if (ch == -1) {
                    break;
                }
                bodyChars[totalRead++] = (char) ch;
            }

            body = new String(bodyChars, 0, totalRead);
        }

        return headerBuilder.toString() + body;
    }

    public void stop() {
        threadPool.shutdown();
    }
}