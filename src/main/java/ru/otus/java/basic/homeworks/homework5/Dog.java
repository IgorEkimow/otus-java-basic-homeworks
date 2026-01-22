package ru.otus.java.basic.homeworks.homework5;

public class Dog extends Animal {
    private static final int SWIM_FACTOR = 2;

    public Dog(String name, int runSpeed, int swimSpeed, int endurance) {
        super(name, runSpeed, swimSpeed, endurance);
    }

    @Override
    protected int getSwimFactor() {
        return SWIM_FACTOR;
    }
}