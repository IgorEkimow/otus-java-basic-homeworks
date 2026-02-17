package ru.otus.java.basic.homeworks.homework12;

import java.io.*;
import java.util.*;

public class FileTextManager {
    private static final String PROJECT_PATH = System.getProperty("user.dir");

    public static void main(String[] args) {
        System.out.println("\n============ Файловый менеджер ============");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                showFilesList();
                System.out.print("\nВведите имя файла (или «exit» для выхода): ");
                String fileName = scanner.nextLine().trim();

                if (fileName.equalsIgnoreCase("exit")) {
                    System.out.println("\nПрограмма завершена");
                    break;
                }

                if (fileName.isEmpty()) {
                    System.out.println("\nИмя файла не может быть пустым");
                    continue;
                }

                if (!fileName.endsWith(".txt")) {
                    fileName += ".txt";
                }

                File file = new File(PROJECT_PATH, fileName);

                if(!file.exists()) {
                    System.out.println("\nФайл с именем " + file.getName() + " не найден");
                    continue;
                }

                showFileContent(file);
                System.out.println("\nВведите данные для записи в файл (или «enter» для выхода):");
                writeToFile(file, scanner);
                System.out.println("\n" + "=".repeat(60) + "\n");
            }
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    public static void showFilesList() {
        System.out.println("\n=== Текстовые файлы в корневом каталоге ===");

        File rootDir = new File(PROJECT_PATH);
        File[] files = rootDir.listFiles((d, name)->name.endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("Текстовые файлы не найдены");
        } else {
            for (File file : files) {
                System.out.println("- " + file.getName());
            }
        }
    }

    private static void showFileContent(File file) throws IOException {
        System.out.println("\n===== Содержимое файла '" + file.getName() + "' =====");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            boolean isEmpty = true;
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                isEmpty = false;
            }

            if (isEmpty) {
                System.out.println("\n[Файл пуст]");
            }
        }
    }

    private static void writeToFile(File file, Scanner scanner) throws IOException {
        try (FileWriter writer = new FileWriter(file, true)) {
            String line;

            while (true) {
                System.out.print("> ");
                line = scanner.nextLine();

                if (line.isEmpty()) {
                    break;
                }

                writer.write(line + System.lineSeparator());
                writer.flush();
            }
        }
    }
}