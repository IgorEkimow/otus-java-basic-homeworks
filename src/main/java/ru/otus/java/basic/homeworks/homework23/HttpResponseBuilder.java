package ru.otus.java.basic.homeworks.homework23;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpResponseBuilder {
    private HttpStatus status = HttpStatus.OK;
    private final Map<String, String> headers = new HashMap<>();
    private String body = "";

    public HttpResponseBuilder status(HttpStatus status) {
        this.status = status;
        return this;
    }

    public HttpResponseBuilder header(String name, String value) {
        headers.put(name, value);
        return this;
    }

    public HttpResponseBuilder header(HttpHeader header, String value) {
        headers.put(header.getValue(), value);
        return this;
    }

    public HttpResponseBuilder contentType(ContentType contentType) {
        headers.put(HttpHeader.CONTENT_TYPE.getValue(), contentType.getValue());
        return this;
    }

    public HttpResponseBuilder jsonBody(String json) {
        this.body = json;
        contentType(ContentType.APPLICATION_JSON);
        return this;
    }

    public HttpResponseBuilder htmlBody(String html) {
        this.body = html;
        contentType(ContentType.TEXT_HTML);
        return this;
    }

    public HttpResponseBuilder textBody(String text) {
        this.body = text;
        contentType(ContentType.TEXT_PLAIN);
        return this;
    }

    public byte[] build() {
        if (!headers.containsKey(HttpHeader.CONTENT_LENGTH.getValue()) && !body.isEmpty()) {
            headers.put(HttpHeader.CONTENT_LENGTH.getValue(), String.valueOf(body.getBytes(StandardCharsets.UTF_8).length));
        }

        StringBuilder response = new StringBuilder();
        response.append("HTTP/1.1 ").append(status.getStatusLine()).append("\r\n");

        for (Map.Entry<String, String> header : headers.entrySet()) {
            response.append(header.getKey()).append(": ").append(header.getValue()).append("\r\n");
        }

        response.append("\r\n");

        if (!body.isEmpty()) {
            response.append(body);
        }

        return response.toString().getBytes(StandardCharsets.UTF_8);
    }

    public static HttpResponseBuilder create() {
        return new HttpResponseBuilder();
    }
}