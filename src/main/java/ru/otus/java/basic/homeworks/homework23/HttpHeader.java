package ru.otus.java.basic.homeworks.homework23;

public enum HttpHeader {
    CONTENT_TYPE("Content-Type"),
    CONTENT_LENGTH("Content-Length"),
    CONNECTION("Connection"),
    SERVER("Server");

    private final String value;

    HttpHeader(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}