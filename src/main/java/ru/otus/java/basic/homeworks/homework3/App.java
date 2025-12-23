package ru.otus.java.basic.homeworks.homework3;

public class App {
    /* TODO
    * Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента целочисленный двумерный массив, метод должен посчитать и вернуть сумму всех элементов массива, которые больше 0;
    * Реализовать метод, который принимает в качестве аргумента int size и печатает в консоль квадрат из символов * со сторонами соответствующей длины;
    * Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив, и зануляющий его диагональные элементы (можете выбрать любую из диагоналей, или занулить обе);
    * Реализовать метод findMax(int[][] array) который должен найти и вернуть максимальный элемент массива;
    * Реализуйте метод, который считает сумму элементов второй строки двумерного массива, если второй строки не существует, то в качестве результата необходимо вернуть -1
    * */

    public static void main(String[] args) {
        int[][] arr = {{1, 5, -8, 12, -2, 12, 20, -1, 4}, {12, 2, -10, 9, 11, 12, 0}};
        int fieldSize = 8;

        System.out.println("Сумма всех элементов двумерного массива: " + sumOfPositiveElements(arr));

        drawField(fieldSize);
    }

    public static int sumOfPositiveElements(int[][] array) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] > 0) {
                    count += array[i][j];
                }
            }
        }

        return count;
    }

    public static void drawField(int size) {
        if (size <= 0) {
            System.out.println("Размер должен быть положительным числом");
            return;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

}
