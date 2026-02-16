package ru.otus.java.basic.homeworks.homework12;

import java.io.*;
import java.util.*;

public class FileManager {
    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/src/main/java/ru/otus/java/basic/homeworks/homework12";

    public static void main(String[] args) {
         /*
        - Реализуйте приложение, позволяющее работать с текстовыми файлами
        - При старте приложения, в консоль выводится список текстовых файлов из корневого каталоге проекта
        - Далее программа запрашивает имя файла, с которым хочет работать пользователь
        - Содержимое файла выводится в консоль
        - Затем любую введенную пользователем строку необходимо записывать в указанный файл
        */

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                displayFilesList();

                System.out.print("\nВведите имя файла (или 'exit' для выхода): ");
                String fileName = scanner.nextLine().trim();

                if (fileName.equalsIgnoreCase("exit")) {
                    System.out.println("Программа завершена.");
                    break;
                }


            }
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static void displayFilesList() throws IOException {
        System.out.println("\n--- Текстовые файлы в корневом каталоге ---");

        File rootDir = new File(PROJECT_PATH);
        File[] files = rootDir.listFiles((d, name)->name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("Текстовые файлы не найдены");
        } else {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }



}