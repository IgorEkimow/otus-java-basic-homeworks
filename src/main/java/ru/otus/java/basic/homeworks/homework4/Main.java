package ru.otus.java.basic.homeworks.homework4;

import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        User[] users = {
            new User("Иванов", "Иван", "Иванович", LocalDate.of(1958, 5, 21), "ivan@mail.ru"),
            new User("Петров", "Петр", "Петрович", LocalDate.of(1973, 3, 12), "petr@mail.ru"),
            new User("Семенов", "Семен", "Семенович", LocalDate.of(1980, 2, 3), "semen@mail.ru"),
            new User("Сергеев", "Сергей", "Сергеевич", LocalDate.of(1965, 9, 9), "sergey@mail.ru"),
            new User("Алексеев", "Алексей", "Алексеевич", LocalDate.of(2001, 5, 18), "alexey@mail.ru"),
            new User("Юриев", "Юрий", "Юриевич", LocalDate.of(1991, 6, 24), "uriy@mail.ru"),
            new User("Максимов", "Максим", "Максимович", LocalDate.of(2004, 1, 20), "max@mail.ru"),
            new User("Степанов", "Степан", "Степанович", LocalDate.of(1998, 7, 10), "stepan@mail.ru"),
            new User("Борисов", "Борис", "Борисович", LocalDate.of(1968, 4, 19), "boris@mail.ru"),
            new User("Константинов", "Константин", "Константинович", LocalDate.of(1987, 11, 13), "konstantin@mail.ru")
        };

        for (User user : users) {
            LocalDate todayDate = LocalDate.now();
            Period period = Period.between(user.getDateOfBirth(), todayDate);

            if(period.getYears() > 40) {
                user.info();
            }
        }
    }
}