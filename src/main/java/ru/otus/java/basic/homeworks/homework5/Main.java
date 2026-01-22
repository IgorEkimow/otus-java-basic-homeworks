package ru.otus.java.basic.homeworks.homework5;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик", 7, 100);
        Dog dog = new Dog("Барбос", 12, 5, 200);
        Horse house = new Horse("Плотва", 20, 3, 500);

        System.out.println("----- Кот -----");
        cat.run(100);
        cat.swim(100);
        cat.info();
        System.out.println();

        System.out.println("--- Собака ---");
        dog.run(100);
        dog.swim(100);
        dog.info();
        System.out.println();

        System.out.println("--- Лошадь ---");
        house.run(100);
        house.swim(100);
        house.info();
    }
}