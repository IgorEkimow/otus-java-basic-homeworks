package ru.otus.java.basic.homeworks.homework24.processors;

import ru.otus.java.basic.homeworks.homework24.HttpRequest;
import ru.otus.java.basic.homeworks.homework24.HttpResponse;
import ru.otus.java.basic.homeworks.homework24.app.Item;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetItemsRequestProcessor implements RequestProcessor {
    private static List<Item> items = new ArrayList<>(Arrays.asList(
            new Item(1L, "Bread", 50),
            new Item(2L, "Milk", 150),
            new Item(3L, "Cheese", 400)
    ));

    @Override
    public void execute(HttpRequest request, HttpResponse response) throws IOException {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("count", items.size());
        responseBody.put("items", items);

        response.setStatusCode(200).setJsonBody(responseBody).send();
    }
}