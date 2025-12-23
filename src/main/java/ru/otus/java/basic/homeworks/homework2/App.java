package ru.otus.java.basic.homeworks.homework2;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        int num = 4;
        int[] arr = {-1, 5, 4, -10, 7, -20, 12, -3, 8};
        String text = "Hello, World!";

        printMultipleString(num, text);
        sumElementsMoreFive(arr);
        fillArray(num, Arrays.copyOf(arr, arr.length));
        increaseArray(num, Arrays.copyOf(arr, arr.length));
        diffHalfArray(arr);
    }

    public static void printMultipleString(int count, String text) {
        if (count < 0) {
            System.out.println("Количество повторений не может быть отрицательным");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static void sumElementsMoreFive(int[] array) {
        int sum = 0;

        for (int i : array) {
            if (i > 5) {
                sum += i;
            }
        }

        System.out.println("Сумма элементов: " + sum);
    }

    public static void fillArray(int value, int[] array) {
        Arrays.fill(array, value);

        System.out.print("Массив после замены всех ячеек: ");

        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.print("\n");
    }

    public static void increaseArray(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += value;
        }

        System.out.print("Массив после увеличения каждого элемента на указанное число: ");

        for (int num : array) {
            System.out.print(num + " ");
        }

        System.out.print("\n");
    }

    public static void diffHalfArray(int[] array) {
        int middle = array.length / 2;
        int leftPart = 0;
        int rightPart = 0;

        for (int i = 0; i < middle; i++) {
            leftPart += array[i];
        }

        for (int i = middle; i < array.length; i++) {
            rightPart += array[i];
        }

        if (leftPart > rightPart) {
            System.out.println("Сумма элементов левой половины больше правой");
        } else if (rightPart > leftPart) {
            System.out.println("Сумма элементов правой половины больше левой");
        } else {
            System.out.println("Суммы половин равны");
        }
    }
}