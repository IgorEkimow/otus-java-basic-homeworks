package ru.otus.java.basic.homeworks.homework19;

import java.util.ArrayList;
import java.util.List;

class Box<T extends Fruit> {
    private final List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float weight = 0;

        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }

        return weight;
    }

    public boolean compare(Box<? extends Fruit> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001f;
    }

    public void transfer(Box<? super T> box) {
        if (this == box) {
            System.out.println("нельзя пересыпать фрукты в ту же коробку!");

            return;
        }

        if (box != null) {
            for (T fruit : fruits) {
                box.addFruit(fruit);
            }

            System.out.println("фрукты успешно пересыпаны");

            fruits.clear();
        } else {
            System.out.println("невозможно пересыпать фрукты в коробку другого типа");
        }
    }

    public void viewBox() {
        if (fruits.isEmpty()) {
            System.out.println("коробка пуста");
        } else {
            System.out.printf("%d шт., общий вес: %.2f%n", fruits.size(), getWeight());
        }
    }
}