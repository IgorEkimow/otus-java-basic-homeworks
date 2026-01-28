package ru.otus.java.basic.homeworks.homework7;

public class Atv implements Transport {
    private int fuel;
    private static final int FUEL_CONSUMPTION = 24;
    private static final int MAX_FUEL = 200;

    public Atv(int fuel) {
        this.fuel = Math.min(fuel, MAX_FUEL);
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        int requiredFuel = distance * FUEL_CONSUMPTION / 100;
        if (requiredFuel > fuel) {
            System.out.println("Недостаточно топлива у вездехода. Нужно: " + requiredFuel + ", есть: " + fuel);

            return false;
        }

        fuel -= requiredFuel;
        System.out.print("Вездеход проехал " + distance + " км по " + terrain.getTerrainName() + ". Осталось топлива: " + fuel + ". ");

        return true;
    }

    @Override
    public String getType() {
        return "Вездеход";
    }
}