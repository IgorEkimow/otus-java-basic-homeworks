package ru.otus.java.basic.homeworks.homework11;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> implements SearchTree<T> {
    private final Node<T> root;

    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public BinaryTree(List<T> list) {
        if (list == null || list.isEmpty()) {
            root = null;
        } else {
            if (!isSorted(list)) {
                throw new IllegalArgumentException("Список должен быть отсортирован");
            }

            root = buildTree(list, 0, list.size() - 1);
        }
    }

    private boolean isSorted(List<T> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                return false;
            }
        }

        return true;
    }

    private Node<T> buildTree(List<T> list, int start, int end) {
        if (start > end) {
            return null;
        }

        int middle = (start + end) / 2;
        Node<T> node = new Node<>(list.get(middle));

        node.left = buildTree(list, start, middle - 1);
        node.right = buildTree(list, middle + 1, end);

        return node;
    }

    @Override
    public T find(T element) {
        return findRecursive(root, element);
    }

    private T findRecursive(Node<T> node, T element) {
        if (node == null) {
            return null;
        }

        int compare = element.compareTo(node.value);

        if (compare == 0) {
            return node.value;
        } else if (compare < 0) {
            return findRecursive(node.left, element);
        } else {
            return findRecursive(node.right, element);
        }
    }

    @Override
    public List<T> getSortedList() {
        List<T> result = new ArrayList<>();
        treeTraversal(root, result);

        return result;
    }

    private void treeTraversal(Node<T> node, List<T> result) {
        if (node != null) {
            treeTraversal(node.left, result);
            result.add(node.value);
            treeTraversal(node.right, result);
        }
    }
}