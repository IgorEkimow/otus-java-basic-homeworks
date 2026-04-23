package ru.otus.java.basic.homeworks.homework24.processors;

import ru.otus.java.basic.homeworks.homework24.HttpRequest;
import ru.otus.java.basic.homeworks.homework24.HttpResponse;
import ru.otus.java.basic.homeworks.homework24.repository.ItemRepository;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetItemsRequestProcessor implements RequestProcessor {
    private final ItemRepository itemRepository;

    public GetItemsRequestProcessor(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void execute(HttpRequest request, HttpResponse response) throws IOException {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", "success");
        responseBody.put("count", itemRepository.getCount());
        responseBody.put("items", itemRepository.findAll());

        response.setStatusCode(200).setJsonBody(responseBody).send();
    }
}