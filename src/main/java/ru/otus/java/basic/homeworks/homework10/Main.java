package ru.otus.java.basic.homeworks.homework10;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов Иван Иванович", "+7-911-111-11-11");
        phoneBook.add("Петров Петр Петрович", "+7-922-222-22-22");
        phoneBook.add("Семенов Семен Семенович", "+7-933-333-33-33");
        phoneBook.add("Сергеев Сергей Сергеевич", "+7-944-444-44-44");
        phoneBook.add("Алексеев Алексей Алексеевич", "+7-955-555-55-55");
        phoneBook.add("Константинов Константин Константинович", "+7-966-666-66-66");
        phoneBook.add("Максимов Максим Максимович", "+7-977-777-77-77");
        phoneBook.add("Петров Петр Петрович", "+7-988-888-88-88");
        phoneBook.add("Алексеев Алексей Алексеевич", "+7-999-999-99-99");
        phoneBook.add("Алексеев Алексей Алексеевич", "+7-900-000-00-00");

        System.out.println("\n--- Поиск ---");
        System.out.println("Алексеев А. А.: " + phoneBook.find("Алексеев Алексей Алексеевич"));
        System.out.println("Максимов М.М.: " + phoneBook.find("Максимов Максим Максимович"));
        System.out.println("Петров П.П.: " + phoneBook.find("Петров Петр Петрович"));

        System.out.println("\n--- Проверка наличия номара в справочнике ---");
        System.out.println("Номер +7-911-765-43-21 существует: " + phoneBook.containsPhoneNumber("+7-999-123-45-67"));
        System.out.println("Номер +7-911-111-11-11 существует: " + phoneBook.containsPhoneNumber("+7-911-111-11-11"));

        System.out.println("\n--- Вся телефонная книга ---");
        phoneBook.getPhoneBook();
    }
}