package ru.otus.java.basic.homeworks.homework7;

public class Bike implements Transport {
    private int riderStamina;
    private static final int STAMINA_CONSUMPTION = 15;
    private static final int MAX_STAMINA = 225;

    public Bike(int riderStamina) {
        this.riderStamina = Math.min(riderStamina, MAX_STAMINA);
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrain == Terrain.SWAMP) {
            System.out.print("Велосипед не может ехать по " + terrain.getTerrainName() + ". ");

            return false;
        }

        int requiredStamina = distance * STAMINA_CONSUMPTION / 100;
        if (requiredStamina > riderStamina) {
            System.out.println("Велосипедист устал. Нужно сил: " + requiredStamina + ", осталось: " + riderStamina);

            return false;
        }

        riderStamina -= requiredStamina;
        System.out.print("Велосипед проехал " + distance + " км по " + terrain.getTerrainName() + ". Осталось сил: " + riderStamina + ". ");

        return true;
    }

    @Override
    public String getType() {
        return "Велосипед";
    }
}