package ru.otus.java.basic.homeworks.homework5;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик", 10, 3, 100);
        Dog dog = new Dog("Барбос", 20, 5, 100);
        Horse house = new Horse("Плотва", 60, 15, 100);

        cat.info();
        dog.info();
        house.info();
    }
}
