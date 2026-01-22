package ru.otus.java.basic.homeworks.homework5;

public class Cat extends Animal {
    private static final int SWIM_FACTOR = 0;

    public Cat(String name, int runSpeed, int endurance) {
        super(name, runSpeed, 0, endurance);
    }

    @Override
    protected int getSwimFactor() {
        return SWIM_FACTOR;
    }

    @Override
    public int swim(int distance) {
        if (getSwimFactor() == 0) {
            System.out.println(name + " не умеет плавать!");

            return -1;
        }

        return -1;
    }
}