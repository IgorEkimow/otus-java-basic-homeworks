package ru.otus.java.basic.homeworks.homework10;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class PhoneBook {
    private final Map<String, List<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            List<String> phones = phoneBook.get(name);
            phones.add(phone);
        } else {
            phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phone);
        }
    }

    public List<String> find(String name) {
        return new ArrayList<>(phoneBook.getOrDefault(name, Collections.emptyList()));
    }

    public boolean containsPhoneNumber(String phone) {
        for (List<String> phones : phoneBook.values()) {
            if (phones.contains(phone)) {
                return true;
            }
        }

        return false;
    }

    public void getPhoneBook() {
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}