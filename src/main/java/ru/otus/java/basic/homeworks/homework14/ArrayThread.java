package ru.otus.java.basic.homeworks.homework14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayThread {
    private static final int ARRAY_SIZE = 100_000_000;
    private static final int THREADS = 4;

    public static void main(String[] args) {
        System.out.println("Скорость выполнения операции заполнения массива, размером " + ARRAY_SIZE + " элементов\n");

        singleThread();
        multiThread();
    }

    private static void singleThread() {
        System.out.println("======= Реализация №1: 1 поток =======");

        double[] array = new double[ARRAY_SIZE];
        long start = System.currentTimeMillis();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = calculate(i);
        }

        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("Время выполнения: " + duration + " мс (" + (duration / 1000.0) + " сек)");
    }

    private static void multiThread() {
        System.out.println("======= Реализация №2: " + THREADS + " потока =======");

        double[] array = new double[ARRAY_SIZE];
        int segmentSize = ARRAY_SIZE / THREADS;
        long start = System.currentTimeMillis();

        try (ExecutorService executor = Executors.newFixedThreadPool(THREADS)) {
            for (int j = 0; j < THREADS; j++) {
                final int segmentStart = j * segmentSize;
                final int segmentEnd = (j == THREADS - 1) ? ARRAY_SIZE : (j + 1) * segmentSize;

                executor.execute(() -> {
                    for (int i = segmentStart; i < segmentEnd; i++) {
                        array[i] = calculate(i);
                    }
                });
            }
        }

        long end = System.currentTimeMillis();
        long duration = end - start;

        System.out.println("Время выполнения: " + duration + " мс (" + (duration / 1000.0) + " сек)");
    }

    private static double calculate(int i) {
        return 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
    }
}