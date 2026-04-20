package ru.otus.java.basic.homeworks.homework24.processors;

import ru.otus.java.basic.homeworks.homework24.HttpRequest;
import ru.otus.java.basic.homeworks.homework24.HttpResponse;
import java.io.IOException;

public class DefaultNotFoundRequestProcessor implements RequestProcessor {
    @Override
    public void execute(HttpRequest request, HttpResponse response) throws IOException {
        response.setStatusCode(404).setBody("<html><body><h1>404 - Page Not Found</h1></body></html>").send();
    }
}