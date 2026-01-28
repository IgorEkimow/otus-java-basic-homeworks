package ru.otus.java.basic.homeworks.homework7;

public class Car implements Transport {
    private int fuel;
    private static final int FUEL_CONSUMPTION = 20;
    private static final int MAX_FUEL = 300;

    public Car(int fuel) {
        this.fuel = Math.min(fuel, MAX_FUEL);
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrain == Terrain.FOREST || terrain == Terrain.SWAMP) {
            System.out.print("Машина не может ехать по " + terrain.getTerrainName() + ". ");

            return false;
        }

        int requiredFuel = distance * FUEL_CONSUMPTION / 100;
        if (requiredFuel > fuel) {
            System.out.println("Недостаточно топлива. Нужно: " + requiredFuel + ", есть: " + fuel);

            return false;
        }

        fuel -= requiredFuel;
        System.out.print("Машина проехала " + distance + " км по " + terrain.getTerrainName() + ". Осталось топлива: " + fuel + ". ");

        return true;
    }

    @Override
    public String getType() {
        return "Машина";
    }
}