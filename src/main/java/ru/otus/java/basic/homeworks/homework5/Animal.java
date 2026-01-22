package ru.otus.java.basic.homeworks.homework5;

public abstract class Animal {
    public String name;
    public int runSpeed;
    public int swimSpeed;
    public int endurance;
    protected boolean isTired;

    public Animal(String name, int runSpeed, int swimSpeed, int endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.endurance = endurance;
        this.isTired = false;
    }

    protected abstract int getSwimFactor();

    public int run(int distance) {
        if (isTired) {
            System.out.println(name + " устал и не может бежать!");

            return -1;
        }

        if (distance > endurance) {
            System.out.println(name + " не хватает выносливости для бега на " + distance + " м!");
            System.out.println("Нужно " + distance + " ед выносливости, а есть только " + endurance);
            isTired = true;

            return -1;
        }

        endurance -= distance;

        endurance = Math.max(0, endurance);

        int time = distance / runSpeed;

        System.out.println(name + " пробежал " + distance + " м за " + time + " сек. " + "Затрачено выносливости: " + distance + ". " + "Осталось выносливости: " + endurance);

        if (endurance == 0) {
            isTired = true;
            System.out.println(name + " полностью выдохся!");
        }

        return time;
    }

    public int swim(int distance) {
        if (isTired) {
            System.out.println(name + " устал и не может плыть!");

            return -1;
        }

        int enduranceCost = distance * getSwimFactor();

        if (enduranceCost > endurance) {
            System.out.println(name + " не хватает выносливости для плавания на " + distance + " м!");
            System.out.println("Нужно " + enduranceCost + " ед выносливости, а есть только " + endurance);
            isTired = true;

            return -1;
        }

        endurance -= enduranceCost;

        endurance = Math.max(0, endurance);

        int time = distance / swimSpeed;

        System.out.println(name + " проплыл " + distance + " м за " + time + " сек. " + "Затрачено выносливости: " + enduranceCost + ". " + "Осталось выносливости: " + endurance);

        if (endurance == 0) {
            isTired = true;
            System.out.println(name + " полностью выдохся!");
        }

        return time;
    }

    public void info() {
        System.out.println("Имя: " + name);
        System.out.println("Скорость бега: " + runSpeed  + " м/с");
        System.out.println("Скорость плавания: " + swimSpeed  + " м/с");
        System.out.println("Выносливость: " + endurance);
        System.out.println("Статус: " + (isTired ? "уставший" : "бодрый"));
    }
}