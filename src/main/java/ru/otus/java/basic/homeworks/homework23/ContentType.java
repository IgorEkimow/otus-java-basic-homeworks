package ru.otus.java.basic.homeworks.homework23;

public enum ContentType {
    TEXT_HTML("text/html"),
    TEXT_PLAIN("text/plain"),
    APPLICATION_JSON("application/json"),
    APPLICATION_XML("application/xml");

    private final String value;

    ContentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}