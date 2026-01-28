package ru.otus.java.basic.homeworks.homework7;

public interface Transport {
    boolean move(int distance, Terrain terrain);
    String getType();
}