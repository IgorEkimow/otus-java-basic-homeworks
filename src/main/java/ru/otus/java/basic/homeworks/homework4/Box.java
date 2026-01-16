package ru.otus.java.basic.homeworks.homework4;

/*
* Попробуйте реализовать класс по его описания: объекты класса Коробка должны иметь размеры и цвет. Коробку можно открывать и закрывать.
* Коробку можно перекрашивать. Изменить размер коробки после создания нельзя. У коробки должен быть метод, печатающий информацию о ней в консоль.
* В коробку можно складывать предмет (если в ней нет предмета), или выкидывать его оттуда (только если предмет в ней есть), только при условии что
* коробка открыта (предметом читаем просто строку). Выполнение методов должно сопровождаться выводом сообщений в консоль.
*/

public class Box {
    private final String size;
    private String color;

    public Box(String size, String color) {
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void open () {
        System.out.println("Коробка открыта");
    }

    public void close() {
        System.out.println("Коробка закрыта");
    }

    public void rePrint() {
        System.out.println("Коробка перекрашена");
    }

    public void info() {
        System.out.println("Информация о коробке");
        System.out.println("Размер коробки: " + size);
        System.out.println("Цвет коробки: " + color);
    }
}
