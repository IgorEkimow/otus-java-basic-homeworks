package ru.otus.java.basic.homeworks.homework6;

public class Cat {
    private String name;
    private int appetite;
    private boolean fill;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fill = false;
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            fill = true;

            System.out.println(name + " поел " + appetite + " еды и теперь сыт!");
        } else {
            System.out.println(name + " не стал есть: в тарелке недостаточно еды (" + plate.getFoodAmount() + "), нужно " + appetite);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public boolean isFill() {
        return fill;
    }

    public void info() {
        System.out.println(name + " (аппетит: " + appetite + "): " + (fill ? "сыт" : "голоден"));
    }
}