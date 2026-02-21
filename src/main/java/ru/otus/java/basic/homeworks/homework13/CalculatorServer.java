package ru.otus.java.basic.homeworks.homework13;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("======= Приложение «Калькулятор» =======");
        System.out.println("\nСервер запущен на порту: " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Ожидание подключений ...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream())
                ) {
                    System.out.println("\nКлиент с IP: " + clientSocket.getInetAddress() + " подключен");

                    String operations = "Доступные операции: + (сложение), - (вычитание), * (умножение), / (деление)";
                    outputStream.writeUTF(operations);
                    outputStream.flush();

                    boolean active = true;
                    while (active) {
                        try {
                            String userInput = inputStream.readUTF();
                            System.out.println("\nПолучен запрос: " + userInput);

                            if (userInput.equalsIgnoreCase("exit")) {
                                System.out.println("Клиент завершил работу");

                                break;
                            }

                            String[] parts = userInput.split(" ");
                            if (parts.length != 3) {
                                outputStream.writeUTF("Ошибка: неверный формат");
                                outputStream.flush();

                                continue;
                            }

                            try {
                                double num1 = Double.parseDouble(parts[0]);
                                String operation = parts[1];
                                double num2 = Double.parseDouble(parts[2]);

                                double result = calculate(num1, num2, operation);

                                outputStream.writeUTF("Результат: " + num1 + " " + operation + " " + num2 + " = " + result);
                                outputStream.flush();
                            } catch (NumberFormatException e) {
                                outputStream.writeUTF("Ошибка: указаны некорректные числа");
                                outputStream.flush();
                            } catch (ArithmeticException | IllegalArgumentException e) {
                                outputStream.writeUTF("Ошибка: " + e.getMessage());
                                outputStream.flush();
                            }
                        } catch (IOException e) {
                            System.out.println("Клиент отключился");
                            active = false;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка при подключении клиента: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка сервера: " + e.getMessage());
        }
    }

    private static double calculate(double a, double b, String operation) {
        return switch (operation) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("деление на ноль не имеет смысла");
                }
                yield a / b;
            }

            default -> throw new IllegalArgumentException("неизвестная операция: " + operation);
        };
    }
}