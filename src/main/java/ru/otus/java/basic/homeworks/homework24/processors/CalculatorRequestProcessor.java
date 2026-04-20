package ru.otus.java.basic.homeworks.homework24.processors;

import ru.otus.java.basic.homeworks.homework24.HttpRequest;
import ru.otus.java.basic.homeworks.homework24.HttpResponse;
import java.io.IOException;

public class CalculatorRequestProcessor implements RequestProcessor {
    @Override
    public void execute(HttpRequest request, HttpResponse response) throws IOException {
        try {
            String aParam = request.getParameter("a");
            String bParam = request.getParameter("b");

            if (aParam == null || bParam == null) {
                response.setStatusCode(400).setBody("<html><body><h1>Ошибка: параметры 'a' и 'b' обязательны</h1></body></html>").send();

                return;
            }

            int a = Integer.parseInt(aParam);
            int b = Integer.parseInt(bParam);
            String result = a + " + " + b + " = " + (a + b);

            response.setStatusCode(200).setBody("<html><body><h1>" + result + "</h1></body></html>").send();
        } catch (NumberFormatException e) {
            response.setStatusCode(400).setBody("<html><body><h1>Ошибка: параметры должны быть числами</h1></body></html>").send();
        }
    }
}