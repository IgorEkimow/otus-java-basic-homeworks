package ru.otus.java.basic.homeworks.homework11;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            list.add(i);
        }

        System.out.println("Исходный отсортированный список: " + list);

        BinaryTree<Integer> binaryTree = new BinaryTree<>(list);

        System.out.println("\nПоиск элементов:");
        System.out.println("Поиск числа 7: " + binaryTree.find(7));
        System.out.println("Поиск числа 21: " + binaryTree.find(21));
    }
}