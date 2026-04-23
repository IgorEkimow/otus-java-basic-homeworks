package ru.otus.java.basic.homeworks.homework24;

import java.io.OutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpResponse {
    private int statusCode;
    private String statusMessage;
    private Map<String, String> headers;
    private String body;
    private OutputStream outputStream;

    public HttpResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.headers = new HashMap<>();
        this.statusCode = 200;
        this.statusMessage = "OK";
        this.body = "";
        this.headers.put("Content-Type", "text/html");
    }

    public HttpResponse setStatusCode(int statusCode) {
        this.statusCode = statusCode;
        this.statusMessage = getStatusMessage(statusCode);

        return this;
    }

    public HttpResponse setHeader(String key, String value) {
        this.headers.put(key, value);

        return this;
    }

    public HttpResponse setBody(String body) {
        this.body = body;
        this.headers.put("Content-Length", String.valueOf(body.getBytes(StandardCharsets.UTF_8).length));

        return this;
    }

    public HttpResponse setJsonBody(Object obj) {
        com.google.gson.Gson gson = new com.google.gson.Gson();
        String json = gson.toJson(obj);
        setHeader("Content-Type", "application/json");
        setBody(json);

        return this;
    }

    public void send() throws IOException {
        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 ").append(statusCode).append(" ").append(statusMessage).append("\r\n");

        for (Map.Entry<String, String> header : headers.entrySet()) {
            response.append(header.getKey()).append(": ").append(header.getValue()).append("\r\n");
        }

        response.append("\r\n");
        response.append(body);

        outputStream.write(response.toString().getBytes(StandardCharsets.UTF_8));
        outputStream.flush();
    }

    private String getStatusMessage(int statusCode) {
        switch (statusCode) {
            case 200: return "OK";
            case 201: return "Created";
            case 400: return "Bad Request";
            case 403: return "Forbidden";
            case 404: return "Not Found";
            case 405: return "Method Not Allowed";
            case 500: return "Internal Server Error";

            default: return "Unknown";
        }
    }
}