package ru.otus.java.basic.homeworks.homework1;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 5:");
        int number = scanner.nextInt();

        switch (number) {
            case 1:
                System.out.println("Выполняется метод greetings:\n");
                greetings();
                break;
            case 2:
                System.out.println("Выполняется метод checkSign:\n");
                checkSign((int) (Math.random() * 20), (int) (Math.random() * 20), (int) (Math.random() * 20));
                break;
            case 3:
                System.out.println("Выполняется метод selectColor:\n");
                selectColor();
                break;
            case 4:
                System.out.println("Выполняется метод compareNumbers:\n");
                compareNumbers();
                break;
            case 5:
                System.out.println("Выполняется метод addOrSubtractAndPrint:\n");
                addOrSubtractAndPrint((int) (Math.random() * 20), (int) (Math.random() * 20), true);
                break;
            default:
                System.out.println("Ошибка! Принимаются только целые числа в диапазоне от 1 до 5");
        }
    }

    public static void greetings() {
        System.out.println("Hello\nWorld\nfrom\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;

        System.out.println(sum >= 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    public static void selectColor() {
        int data = 2;

        if(data <= 10) {
            System.out.println("Красный");
        } else if(data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 4;
        int b = 3;

        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        System.out.println(increment ? initValue + delta : initValue - delta);
    }
}
