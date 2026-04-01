package ru.otus.java.basic.homeworks.homework20;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите имя файла: ");
            String filename = scanner.nextLine().trim();

            System.out.print("Введите искомую строку: ");
            String searchString = scanner.nextLine();

            File file = new File(filename);
            if (!file.exists()) {
                System.err.println("Ошибка: Файл '" + filename + "' не найден!");
                return;
            }

            if (searchString.isEmpty()) {
                System.err.println("Ошибка: Искомая строка не может быть пустой!");
                return;
            }

            int count = conjunctionCount(filename, searchString);

            System.out.println("\nРезультат:");
            System.out.println("Последовательность символов \"" + searchString + "\" встречается " + count + " раз(а)");
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Неожиданная ошибка: " + e.getMessage());
        }
    }

    public static int conjunctionCount(String filename, String string) throws IOException {
        if (string == null || string.isEmpty()) {
            return 0;
        }

        int count = 0;
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        }

        String content = fileContent.toString();

        int index = 0;
        while ((index = content.indexOf(string, index)) != -1) {
            count++;
            index += string.length();
        }

        return count;
    }
}