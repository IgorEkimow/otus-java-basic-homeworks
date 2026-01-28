package ru.otus.java.basic.homeworks.homework7;

public enum Terrain {
    FOREST ("густому лесу"),
    PLAIN ("равнине"),
    SWAMP ("болоту");

    private final String name;

    Terrain(String name) {
        this.name = name;
    }

    public String getTerrainName() {
        return name;
    }
}