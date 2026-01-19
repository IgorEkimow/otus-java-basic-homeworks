package ru.otus.java.basic.homeworks.homework5;

public class Horse extends Animal {
    private static final int SWIM_FACTOR = 4;

    public Horse(String name, int runSpeed, int swimSpeed, int endurance) {
        super(name, runSpeed, swimSpeed, endurance);
    }

    @Override
    protected int getSwimFactor() {
        return SWIM_FACTOR;
    }
}