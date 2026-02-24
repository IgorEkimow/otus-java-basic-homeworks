package ru.otus.java.basic.homeworks.homework14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayThread {
    private static final int ARRAY_SIZE = 100_000_000;
    private static final int THREADS = 4;

    public static void main(String[] args) {
        System.out.println("Скорость выполнения операции заполнения массива, размером " + ARRAY_SIZE + " элементов\n");

        long singleThreadTime = singleThread();
        long multiThreadTime = multiThread();

        compareResults(singleThreadTime, multiThreadTime);
    }

    private static long singleThread() {
        System.out.println("======= Реализация №1: 1 поток =======");

        double[] array = new double[ARRAY_SIZE];
        long start = System.nanoTime();

        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = calculate(i);
        }

        long end = System.nanoTime();
        long duration = end - start;

        System.out.println("Время выполнения: " + duration + " нс (" + (duration / 1_000_000_000.0) + " сек)");

        return duration;
    }

    private static long multiThread() {
        System.out.println("======= Реализация №2: " + THREADS + " потока =======");

        double[] array = new double[ARRAY_SIZE];
        int segmentSize = ARRAY_SIZE / THREADS;
        long start = System.nanoTime();

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

        long end = System.nanoTime();
        long duration = end - start;

        System.out.println("Время выполнения: " + duration + " нс (" + (duration / 1_000_000_000.0) + " сек)");

        return duration;
    }

    private static double calculate(int i) {
        return 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
    }

    private static void compareResults(long singleTime, long multiTime) {
        System.out.println("\n======= Результаты сравнения =======");

        double speed = (double) singleTime / multiTime;
        double percent = (1 - (double) multiTime / singleTime) * 100;

        System.out.printf("Многопоточная версия быстрее в %.2f раз(а)%n", speed);
        System.out.printf("Это на %.1f%% быстрее однопоточной версии%n", percent);
    }
}