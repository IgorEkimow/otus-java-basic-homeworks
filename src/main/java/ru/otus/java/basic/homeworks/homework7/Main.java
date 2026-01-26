package ru.otus.java.basic.homeworks.homework7;

public class Main {
    public static void main(String[] args) {
        Human human = new Human("Александр");
        Car car = new Car(250);
        Horse horse = new Horse(720);
        Bike bike = new Bike(200);
        Atv atv = new Atv(180);

        System.out.println("--- Пешком ---");
        human.move(12, Terrain.FOREST);

        System.out.println("--- На машине ---");
        human.getIn(car);
        human.move(30, Terrain.PLAIN);
        human.move(11, Terrain.FOREST);
        human.move(27, Terrain.SWAMP);
        human.getOut();

        System.out.println("--- На лошади ---");
        human.getIn(horse);
        human.move(21, Terrain.FOREST);
        human.move(12, Terrain.SWAMP);
        human.getOut();

        System.out.println("--- На велосипеде ---");
        human.getIn(bike);
        human.move(10, Terrain.PLAIN);
        human.move(8, Terrain.SWAMP);
        human.getOut();

        System.out.println("--- На вездеходе ---");
        human.getIn(atv);
        human.move(14, Terrain.FOREST);
        human.move(26, Terrain.SWAMP);
        human.move(39, Terrain.PLAIN);
        human.getOut();
    }
}