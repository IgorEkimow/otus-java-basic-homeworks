package ru.otus.java.basic.homeworks.homework4;

public class Box {
    private final int width;
    private final int height;
    private final int depth;
    private String color;
    private String item;
    private boolean isOpen;

    public Box(int width, int height, int depth, String color) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.color = color;
        this.item = null;
        this.isOpen = false;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }

    public String getSize() {
        return width + "x" + height + "x" + depth + " см";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getItem() {
        return item;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("Коробка открыта");
        } else {
            System.out.println("Коробка уже открыта");
        }
    }

    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Коробка закрыта");
        } else {
            System.out.println("Коробка уже закрыта");
        }
    }

    public void rePaint(String newColor) {
        this.color = newColor;
        System.out.println("Коробка перекрашена в " + newColor + " цвет");
    }

    public void putItem(String item) {
        if (!isOpen) {
            System.out.println("Нельзя положить предмет: коробка закрыта");
            return;
        }

        if (this.item != null) {
            System.out.println("Нельзя положить предмет: в коробке уже есть " + this.item);
            return;
        }

        this.item = item;
        System.out.println("Предмет '" + item + "' положен в коробку");
    }

    public void removeItem() {
        if (!isOpen) {
            System.out.println("Нельзя выбросить предмет: коробка закрыта");
            return;
        }

        if (this.item == null) {
            System.out.println("Нельзя выбросить предмет: коробка пуста");
            return;
        }

        System.out.println("Предмет '" + item + "' выброшен из коробки");
        this.item = null;
    }

    public void info() {
        System.out.println("---- Информация о коробке ----");
        System.out.println("Размеры: " + getSize());
        System.out.println("Цвет: " + color);
        System.out.println("Состояние: " + (isOpen ? "открыта" : "закрыта"));
        System.out.println("Содержимое: " + (item == null ? "пусто" : item));
        System.out.println("------------------------------");
    }
}