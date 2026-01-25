package ru.otus.java.basic.homeworks.homework6;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat[] cats = {
            new Cat("Васька", 32),
            new Cat("Макс", 28),
            new Cat("Барсик", 41),
            new Cat("Леопольд", 30),
            new Cat("Матроскин", 23)
        };

        System.out.println("=== Состояние тарелки до кормления котов ===");
        plate.info();
        System.out.println();

        System.out.println("=== Кормим котов ===");
        for (Cat cat : cats) {
            cat.eat(plate);
        }

        System.out.println();

        System.out.println("=== Состояние тарелки после кормления котов ===");
        plate.info();
        System.out.println();

        System.out.println("=== Состояние котов ===");
        for (Cat cat : cats) {
            cat.info();
        }
    }
}