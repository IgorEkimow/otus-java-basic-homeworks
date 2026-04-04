package ru.otus.java.basic.homeworks.homework22;

public class ArrayTools {
    public static int[] getLastElements(int[] array) {
        if (array == null) {
            throw new RuntimeException("Массив null");
        }

        int indexOne = -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                indexOne = i;
            }
        }

        if (indexOne == -1) {
            throw new RuntimeException("Массив не содержит единиц");
        }

        int newArraySize = array.length - indexOne - 1;
        int[] result = new int[newArraySize];

        for (int i = 0; i < newArraySize; i++) {
            result[i] = array[indexOne + 1 + i];
        }

        return result;
    }

    public static boolean validateArray(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }

        boolean isOne = false;
        boolean isTwo = false;

        for (int number : array) {
            if (number == 1) {
                isOne = true;
            } else if (number == 2) {
                isTwo = true;
            } else {
                return false;
            }
        }

        return isOne && isTwo;
    }
}