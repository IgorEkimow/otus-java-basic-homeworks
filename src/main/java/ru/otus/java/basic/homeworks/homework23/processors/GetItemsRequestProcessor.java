package ru.otus.java.basic.homeworks.homework23.processors;

import com.google.gson.Gson;
import ru.otus.java.basic.homeworks.homework23.HttpRequest;
import ru.otus.java.basic.homeworks.homework23.HttpResponseBuilder;
import ru.otus.java.basic.homeworks.homework23.HttpStatus;
import ru.otus.java.basic.homeworks.homework23.app.Item;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetItemsRequestProcessor implements RequestProcessor {
    private static final Gson GSON = new Gson();

    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item(1L, "Bread", 50),
                new Item(2L, "Milk", 150),
                new Item(3L, "Cheese", 400)
        ));
        String result = GSON.toJson(items);
        byte[] response = HttpResponseBuilder.create().status(HttpStatus.OK).jsonBody(result).build();
        output.write(response);
    }
}