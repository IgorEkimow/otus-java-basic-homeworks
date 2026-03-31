package ru.otus.java.basic.homeworks.homework21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static volatile char currentLetter = 'A';
    private static final Object lock = new Object();

    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            executor.submit(new Task('A', 5));
            executor.submit(new Task('B', 5));
            executor.submit(new Task('C', 5));
            executor.shutdown();

            try {
                executor.awaitTermination(1, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\nПрограмма завершена");
    }

    static class Task implements Runnable {
        private final char letter;
        private final int count;

        public Task(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }

        @Override
        public void run() {
            for (int i = 0; i < count; i++) {
                synchronized (lock) {
                    while (currentLetter != letter) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print(letter);
                    currentLetter = getLetter(letter);
                    lock.notifyAll();
                }
            }
        }

        private char getLetter(char current) {
            return switch (current) {
                case 'A' -> 'B';
                case 'B' -> 'C';
                case 'C' -> 'A';

                default -> 'A';
            };
        }
    }
}