package ru.otus.java.basic.homeworks.homework7;

public class Human {
    private final String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
        this.currentTransport = null;
    }

    public String getName() {
        return name;
    }

    public Transport getCurrentTransport() {
        return currentTransport;
    }

    public void getIn(Transport transport) {
        if (currentTransport != null) {
            System.out.println(name + " уже находится на транспорте: " + currentTransport.getType());

            return;
        }

        currentTransport = transport;
        System.out.println(name + " сел на " + transport.getType());
    }

    public void getOut() {
        if (currentTransport == null) {
            System.out.println(name + " не находится на транспорте");

            return;
        }

        System.out.println(name + " слез с " + currentTransport.getType());
        currentTransport = null;
    }

    public boolean move(int distance, Terrain terrain) {
        if (currentTransport == null) {
            System.out.println(name + " прошел " + distance + " км пешком по " + terrain.getTerrainName());

            return true;
        }

        boolean result = currentTransport.move(distance, terrain);

        if (result) {
            System.out.println(name + " успешно переместился на " + distance + " км");
        } else {
            System.out.println(name + " не смог переместиться на транспорте");
        }

        return result;
    }
}