package ru.otus.java.basic.homeworks.homework4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        User[] users = {
            new User("Иванов", "Иван", "Иванович", "21.05.1958", "ivan@mail.ru"),
            new User("Петров", "Петр", "Петрович", "12.03.1973", "petr@mail.ru"),
            new User("Семенов", "Семен", "Семенович", "03.02.1980", "semen@mail.ru"),
            new User("Сергеев", "Сергей", "Сергеевич", "09.09.1965", "sergey@mail.ru"),
            new User("Алексеев", "Алексей", "Алексеевич", "18.05.2001", "alexey@mail.ru"),
            new User("Юриев", "Юрий", "Юриевич", "24.06.1991", "uriy@mail.ru"),
            new User("Максимов", "Максим", "Максимович", "20.01.2004", "max@mail.ru"),
            new User("Степанов", "Степан", "Степанович", "10.07.1998", "stepan@mail.ru"),
            new User("Борисов", "Борис", "Борисович", "19.04.1968", "boris@mail.ru"),
            new User("Константинов", "Константин", "Константинович", "13.11.1987", "konstantin@mail.ru")
        };

        for (User user : users) {
            LocalDate birthDate = LocalDate.parse(user.getDateOfBirth(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            LocalDate todayDate = LocalDate.now();
            Period period = Period.between(birthDate, todayDate);

            if(period.getYears() > 40) {
                user.info();
            }
        }

        System.out.println("--------------------------------------");

        Box box = new Box("30", "Красный");
        box.info();
    }
}