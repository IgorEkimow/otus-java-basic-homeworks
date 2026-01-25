package ru.otus.java.basic.homeworks.homework7;

public interface Transport {
    void move(int distance, Terrain terrain);
    String getType();
}