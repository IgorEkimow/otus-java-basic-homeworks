package ru.otus.java.basic.homeworks.homework13;

import java.util.Scanner;
import java.net.Socket;
import java.net.InetSocketAddress;
import java.io.IOException;

public class CalculatorClient {
    private static final int PORT = 8080;
    private static final int TIMEOUT = 5000;

    public static void main(String[] args) {
        System.out.println("======= Приложение «Калькулятор» =======");

        Scanner scanner = new Scanner(System.in);

        try {
            Socket serverSocket = new Socket();
            serverSocket.connect(new InetSocketAddress("localhost", PORT), TIMEOUT);

            Client client = new Client(serverSocket.getInputStream(), serverSocket.getOutputStream());
            String operations = client.receive();
            System.out.println("\n" + operations);
            System.out.println("Пример формата ввода выражения: 15 + 7, 30 - 15, 2.5 * 7, 40 / 5");

            while (true) {
                System.out.println("\nВведите математическое выражение (или «exit» для выхода):");
                String userInput = scanner.nextLine().trim();

                if (userInput.isEmpty()) {
                    System.out.println("Ошибка: введена пустая строка");

                    continue;
                }

                if (userInput.equalsIgnoreCase("exit")) {
                    client.send("exit");
                    System.out.println("Завершение работы ...");

                    break;
                }

                String response = client.sendAndReceive(userInput);
                System.out.println(response);
            }

            client.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("\nОшибка подключения к серверу: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("\nОшибка: " + e.getMessage());
        }
    }
}