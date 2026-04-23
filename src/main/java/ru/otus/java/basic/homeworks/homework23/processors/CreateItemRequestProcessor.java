package ru.otus.java.basic.homeworks.homework23.processors;

import com.google.gson.Gson;
import ru.otus.java.basic.homeworks.homework23.HttpRequest;
import ru.otus.java.basic.homeworks.homework23.HttpResponseBuilder;
import ru.otus.java.basic.homeworks.homework23.HttpStatus;
import ru.otus.java.basic.homeworks.homework23.app.Item;
import java.io.IOException;
import java.io.OutputStream;

public class CreateItemRequestProcessor implements RequestProcessor {
    private static final Gson GSON = new Gson();

    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        Item item = GSON.fromJson(request.getBody(), Item.class);
        System.out.println(item);
        byte[] response = HttpResponseBuilder.create().status(HttpStatus.CREATED).build();
        output.write(response);
    }
}