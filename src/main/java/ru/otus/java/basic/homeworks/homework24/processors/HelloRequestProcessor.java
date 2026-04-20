package ru.otus.java.basic.homeworks.homework24.processors;

import ru.otus.java.basic.homeworks.homework24.HttpRequest;
import ru.otus.java.basic.homeworks.homework24.HttpResponse;
import java.io.IOException;

public class HelloRequestProcessor implements RequestProcessor {
    @Override
    public void execute(HttpRequest request, HttpResponse response) throws IOException {
        response.setStatusCode(200).setBody("<html><body><h1>Hello World!!!</h1></body></html>").send();
    }
}