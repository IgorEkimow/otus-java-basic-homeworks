package ru.otus.java.basic.homeworks.homework4;

import java.time.LocalDate;

public class User {
    private String lastName;
    private String firstName;
    private String patronymic;
    private LocalDate dateOfBirth;
    private String email;

    public User(String lastName, String firstName, String patronymic, LocalDate dateOfBirth, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void info() {
        System.out.println("ФИО: " + lastName + " " + firstName + " " + patronymic);
        System.out.println("Год рождения: " + dateOfBirth.format(java.time.format.DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        System.out.println("E-mail: " + email);
        System.out.println("------------------------------");
    }
}