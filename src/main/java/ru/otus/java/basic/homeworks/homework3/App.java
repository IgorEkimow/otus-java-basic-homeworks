package ru.otus.java.basic.homeworks.homework3;

public class App {
    public static void main(String[] args) {
        int[][] arr = {{1, 5, -8, 12, -2, 12, 20, -1, 4}, {12, 2, -10, 9, 11, 12, 0}};
        int[][] arrMatrix = {{25, 17, 44}, {9, 18, 4}, {14, 12, 7}};
        int fieldSize = 8;

        System.out.println("Сумма всех элементов двумерного массива: " + sumOfPositiveElements(arr));
        drawField(fieldSize);
        zeroDiagonals(arrMatrix);
        System.out.println("Максимальный элемент массива: " + findMax(arr));
        System.out.println("Сумма элементов второй строки двумерного массива: " + sumSecondRow(arr));
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

    public static void zeroDiagonals(int[][] array) {
        int main = Math.min(array.length, array[0].length);

        for (int i = 0; i < main; i++) {
            array[i][i] = 0;

            int j = main - 1 - i;
            if (i != j) {
                array[i][j] = 0;
            }
        }

        for (int[] row : array) {
            for (int value : row) {
                System.out.print(" " + value + " ");
            }
            System.out.println();
        }
    }

    public static int findMax(int[][] array) {
        int max = array[0][0];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }

        return max;
    }

    public static int sumSecondRow(int[][] array) {
        if (array.length < 2) {
            return -1;
        }

        int sum = 0;

        for (int i = 0; i < array[1].length; i++) {
            sum += array[1][i];
        }

        return sum;
    }
}