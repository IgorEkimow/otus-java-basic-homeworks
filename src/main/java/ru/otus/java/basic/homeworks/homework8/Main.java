package ru.otus.java.basic.homeworks.homework8;

/*
- Реализуйте метод, аргументом которого является двумерный строковый массив размером 4х4.
Если передан массив другого размера необходимо бросить исключение AppArraySizeException.
- Метод должен обойти все элементы массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование
не удалось (например, в ячейке лежит текст вместо числа), должно быть брошено исключение AppArrayDataException с детализацией,
в какой именно ячейке лежат неверные данные.
- В методе main() необходимо вызвать полученный метод, обработать возможные исключения AppArraySizeException и
и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
*/

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

        for (String[] strings : array) {
            for (String string : strings) {
                try {
                    int value = Integer.parseInt(string);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Преобразование в число выполнить невозможно");
                }
            }
        }

        return sum;
    }
}