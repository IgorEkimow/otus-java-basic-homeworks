package ru.otus.java.basic.homeworks.homework6;

public class Plate {
    private int maxFood;
    private int foodAmount;

    public Plate(int volume) {
        this.maxFood = volume;
        this.foodAmount = volume;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;

            if (foodAmount > maxFood) {
                foodAmount = maxFood;
            }

            System.out.println("В тарелку добавлено " + amount + " еды. Теперь в тарелке: " + foodAmount + " еды");
        }
    }

    public boolean decreaseFood(int amount) {
        if (amount <= 0) {
            return false;
        }

        if (foodAmount >= amount) {
            foodAmount -= amount;

            return true;
        }

        return false;
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

    public void info() {
        System.out.println("Тарелка: " + foodAmount + " / " + maxFood + " еды");
    }
}