package ru.otus.java.basic.homeworks.homework23.processors;

import ru.otus.java.basic.homeworks.homework23.HttpRequest;
import ru.otus.java.basic.homeworks.homework23.HttpResponseBuilder;
import ru.otus.java.basic.homeworks.homework23.HttpStatus;
import java.io.IOException;
import java.io.OutputStream;

public class DefaultNotFoundRequestProcessor implements RequestProcessor {
    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        byte[] response = HttpResponseBuilder.create().status(HttpStatus.NOT_FOUND).htmlBody("<html><body><h1>404.. Page Not Found</h1></body></html>").build();
        output.write(response);
    }
}