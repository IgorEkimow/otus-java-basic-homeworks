package ru.otus.java.basic.homeworks.homework24.processors;

import ru.otus.java.basic.homeworks.homework24.HttpRequest;
import ru.otus.java.basic.homeworks.homework24.HttpResponse;
import java.io.IOException;

public interface RequestProcessor {
    void execute(HttpRequest request, HttpResponse response) throws IOException;
}