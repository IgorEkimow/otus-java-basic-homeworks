package ru.otus.java.basic.homeworks.homework7;

public class Human {
    public String name;
    public Transport currentTransport;

    public Human(String name) {
        this.name = name;
        this.currentTransport = null;
    }

    public String getName() {
        return name;
    }

    public Transport getCurrentTransport() {
        return currentTransport;
    }
}