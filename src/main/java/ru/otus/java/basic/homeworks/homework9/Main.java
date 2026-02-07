package ru.otus.java.basic.homeworks.homework9;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(rangeElements(1, 7));
        System.out.println("-------------");
        System.out.println(sumElements(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
        System.out.println("-------------");
        System.out.println(rewriteElements(3, List.of(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)));
        System.out.println("-------------");
        System.out.println(increaseElements(2, List.of(1, 2, 3, 4, 5)));
        System.out.println("-------------");

        int minAge = 25;
        int minAverageAge = 26;

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Александр", 21));
        employees.add(new Employee("Юлия", 33));
        employees.add(new Employee("Анастасия", 23));
        employees.add(new Employee("Екатерина", 28));

        System.out.println("Список имен сотрудников: " + getEmployeeName(employees));
        System.out.println("Список сотрудников старше " + minAge + " лет: " + getEmployeeMinAge(employees, minAge));
        System.out.println("Средний возраст сотрудников больше " + minAverageAge + " лет: " + getEmployeeAverageAge(employees, minAverageAge));
        System.out.println("Самый молодой сотрудник: " + getYoungestEmployee(employees).getName() + ", возраст: " + getYoungestEmployee(employees).getAge());
    }

    public static List<Integer> rangeElements(int min, int max) {
        List<Integer> list = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            list.add(i);
        }

        return list;
    }

    public static int sumElements(List<Integer> elements) {
        int result = 0;

        for (int element : elements) {
            if (element > 5) {
                result += element;
            }
        }

        return result;
    }

    public static List<Integer> rewriteElements(int number, List<Integer> elements) {
        List<Integer> list = new ArrayList<>(elements);

        for (int i = 0; i < list.size(); i++) {
            list.set(i, number);
        }

        return list;
    }

    public static List<Integer> increaseElements(int number, List<Integer> elements) {
        List<Integer> list = new ArrayList<>();

        for (int element : elements) {
            list.add(element + number);
        }

        return list;
    }

    public static List<String> getEmployeeName(List<Employee> employees) {
        List<String> names = new ArrayList<>();

        for (Employee employee : employees) {
            names.add(employee.getName());
        }

        return names;
    }

    public static List<String> getEmployeeMinAge(List<Employee> employees, int minAge) {
        List<String> list = new ArrayList<>();

        for (Employee employee : employees) {
            if(employee.getAge() >= minAge) {
                list.add(employee.getName());
            }
        }

        return list;
    }

    public static boolean getEmployeeAverageAge(List<Employee> employees, int minAverageAge) {
        int totalAge = 0;

        for (Employee employee : employees) {
            totalAge += employee.getAge();
        }

        double averageAge = (double) totalAge / employees.size();

        return averageAge > minAverageAge;
    }

    public static Employee getYoungestEmployee(List<Employee> employees) {
        Employee youngest = employees.getFirst();

        for (Employee employee : employees) {
            if (employee.getAge() < youngest.getAge()) {
                youngest = employee;
            }
        }

        return youngest;
    }
}