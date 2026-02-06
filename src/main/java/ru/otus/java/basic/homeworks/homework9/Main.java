package ru.otus.java.basic.homeworks.homework9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
    - Создайте класс Сотрудник с полями: имя, возраст;
    - Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
    - Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, и возвращающий
    список сотрудников, возраст которых больше либо равен указанному аргументу;
    - Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, и проверяющий
    что средний возраст сотрудников превышает указанный аргумент;
    - Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника.
    */

    public static void main(String[] args) {
        System.out.println(rangeElements(1, 7));
        System.out.println("-------------");
        System.out.println(sumElements(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        System.out.println("-------------");
        System.out.println(rewriteElements(3, List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)));
        System.out.println("-------------");
        System.out.println(increaseElements(2, List.of(1, 2, 3, 4, 5)));
    }

    public static ArrayList<Integer> rangeElements(int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            list.add(i);
        }

        return list;
    }

    public static int sumElements(List<Integer> elements) {
        int result = 0;

        for (int element : elements) {
            if (element > 5) {
                result += element;
            }
        }

        return result;
    }

    public static List<Integer> rewriteElements(int number, List<Integer> elements) {
        List<Integer> list = new ArrayList<>(elements);

        for (int i = 0; i < list.size(); i++) {
            list.set(i, number);
        }

        return list;
    }

    public static List<Integer> increaseElements(int number, List<Integer> elements) {
        List<Integer> list = new ArrayList<>();

        for (int element : elements) {
            list.add(element + number);
        }

        return list;
    }
}