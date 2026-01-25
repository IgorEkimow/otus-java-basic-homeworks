package ru.otus.java.basic.homeworks.homework6;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тарелка:");
        Plate plate = new Plate(400, 300, 300);
        System.out.println(plate.getVolume());
        System.out.println(plate.getMaxFood());
        System.out.println(plate.getFoodAmount());
        System.out.println();

        System.out.println("Кот:");
        Cat cat = new Cat("Барсик", 300);
        System.out.println(cat.getName());
        System.out.println(cat.getAppetite());
    }
}
