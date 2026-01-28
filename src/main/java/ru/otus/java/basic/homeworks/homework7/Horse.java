package ru.otus.java.basic.homeworks.homework7;

public class Horse implements Transport {
    private int stamina;
    private static final int STAMINA_CONSUMPTION = 20;
    private static final int MAX_STAMINA = 1000;

    public Horse(int stamina) {
        this.stamina = Math.min(stamina, MAX_STAMINA);
    }

    @Override
    public boolean move(int distance, Terrain terrain) {
        if (terrain == Terrain.SWAMP) {
            System.out.print("Лошадь не может идти по " + terrain.getTerrainName() + ". ");

            return false;
        }

        int requiredStamina = distance * STAMINA_CONSUMPTION / 100;
        if (requiredStamina > stamina) {
            System.out.println("Лошадь устала. Нужно сил: " + requiredStamina + ", осталось: " + stamina);

            return false;
        }

        stamina -= requiredStamina;
        System.out.print("Лошадь прошла " + distance + " км по " + terrain.getTerrainName() + ". Осталось сил: " + stamina + ". ");

        return true;
    }

    @Override
    public String getType() {
        return "Лошадь";
    }
}