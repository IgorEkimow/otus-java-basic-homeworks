package ru.otus.java.basic.homeworks.homework6;

public class Plate {
    public int volume;
    public int maxFood;
    public int foodAmount;

    public Plate(int volume, int maxFood, int foodAmount) {
        this.volume = volume;
        this.maxFood = maxFood;
        this.foodAmount = foodAmount;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getMaxFood() {
        return maxFood;
    }

    public void setMaxFood(int maxFood) {
        this.maxFood = maxFood;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        this.foodAmount = foodAmount;
    }
}