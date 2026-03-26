package ru.otus.java.basic.homeworks.homework19;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Fruit> mixedBox = new Box<>();

        for (int i = 0; i < 5; i++) {
            appleBox.addFruit(new Apple());
        }

        for (int j = 0; j < 10; j++) {
            orangeBox.addFruit(new Orange());
        }

        for (int k = 0; k < 15; k++) {
            mixedBox.addFruit(new Apple());
            mixedBox.addFruit(new Orange());
        }

        System.out.println("\n=== Типы коробок ===");
        System.out.print("Коробка с яблоками: ");
        appleBox.viewBox();
        System.out.print("Коробка с апельсинами: ");
        orangeBox.viewBox();
        System.out.print("Универсальная коробка: ");
        mixedBox.viewBox();

        System.out.println("\n=== Сравнение коробок ===");
        System.out.printf("Вес коробки с яблоками (%.2f) и коробки с апельсинами (%.2f) %s%n", appleBox.getWeight(), orangeBox.getWeight(), appleBox.compare(orangeBox) ? "равен" : "не равен");
        System.out.printf("Вес коробки с апельсинами (%.2f) и универсальной коробки (%.2f) %s%n", orangeBox.getWeight(), mixedBox.getWeight(), orangeBox.compare(mixedBox) ? "равен" : "не равен");

        System.out.println("\n=== Пересыпание фруктов ===");
        Box<Fruit> mixedFruitBox = new Box<>();
        Box<Orange> orangeFruitBox = new Box<>();

        for (int i = 0; i < 3; i++) {
            orangeFruitBox.addFruit(new Orange());
        }

        System.out.print("Универсальная коробка до пересыпания: ");
        mixedFruitBox.viewBox();
        System.out.print("Коробка с апельсинами до пересыпания: ");
        orangeFruitBox.viewBox();
        System.out.print("Пересыпаем апельсины в универсальную коробку: ");
        orangeFruitBox.transfer(mixedFruitBox);
        System.out.print("Универсальная коробка после всех пересыпаний: ");
        mixedFruitBox.viewBox();
        System.out.print("Коробка с апельсинами после всех пересыпаний: ");
        orangeFruitBox.viewBox();
    }
}