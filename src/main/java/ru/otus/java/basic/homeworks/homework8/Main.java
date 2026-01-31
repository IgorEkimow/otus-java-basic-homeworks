package ru.otus.java.basic.homeworks.homework8;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "16"}
        };

        try {
            int result = convertStringArray(array);
            System.out.println("Сумма элементов массива: " + result);
        } catch (AppArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
        } catch (AppArrayDataException e) {
            System.out.println("Ошибка данных в массиве: " + e.getMessage());
        }
    }

    public static int convertStringArray(String[][] array) throws AppArraySizeException, AppArrayDataException {
        if(array.length != 4) {
            throw new AppArraySizeException("Массив должен иметь размер 4х4");
        }

        int sum = 0;

        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array[i].length ; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(String.format("Невозможно выполнить преобразование в число в ячейке - [%d][%d]", i, j));
                }
            }
        }

        return sum;
    }
}