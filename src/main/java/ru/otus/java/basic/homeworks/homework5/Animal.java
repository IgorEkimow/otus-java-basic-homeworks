package ru.otus.java.basic.homeworks.homework5;

/*
* Создайте классы Cat, Dog и Horse с наследованием от класса Animal
* У каждого животного есть имя, скорость бега и плавания (м/с), и выносливость (измеряется в условных единицах)
*
* Затраты выносливости:
* Все животные на 1 метр бега тратят 1 ед выносливости,
* Собаки на 1 метр плавания - 2 ед.
* Лошади на 1 метр плавания тратят 4 единицы
* Кот плавать не умеет.
* Реализуйте методы run(int distance) и swim(int distance), которые должны возвращать время, затраченное на указанное действие, и “понижать выносливость” животного. Если выносливости не хватает, то возвращаем время -1 и указываем что у животного появилось состояние усталости. При выполнении действий пишем сообщения в консоль.
* Добавляем метод info(), который выводит в консоль состояние животного.
* */

public class Animal {
    public String name;
    public int speedRun;
    public int speedSwim;
    public int endurance;

    public Animal(String name, int speedRun, int speedSwim, int endurance) {
        this.name = name;
        this.speedRun = speedRun;
        this.speedSwim = speedSwim;
        this.endurance = endurance;
    }

     public void info() {
        System.out.println("Имя: " + name);
        System.out.println("Скорость бега: " + speedRun);
        System.out.println("Скорость плавания: " + speedSwim);
        System.out.println("Выносливость: " + endurance);
        System.out.println("--------------------------");
    }
}