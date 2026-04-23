package ru.otus.java.basic.homeworks.homework24.processors;

import com.google.gson.Gson;
import ru.otus.java.basic.homeworks.homework24.HttpRequest;
import ru.otus.java.basic.homeworks.homework24.HttpResponse;
import ru.otus.java.basic.homeworks.homework24.app.Item;
import ru.otus.java.basic.homeworks.homework24.repository.ItemRepository;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateItemRequestProcessor implements RequestProcessor {
    private static final Gson GSON = new Gson();
    private final ItemRepository itemRepository;

    public CreateItemRequestProcessor(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void execute(HttpRequest request, HttpResponse response) throws IOException {
        try {
            Item item = GSON.fromJson(request.getBody(), Item.class);

            if (item.getName() == null || item.getName().trim().isEmpty()) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "Название товара обязательно");
                response.setStatusCode(400).setJsonBody(error).send();

                return;
            }

            if (item.getPrice() <= 0) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "Цена должна быть положительным числом");
                response.setStatusCode(400).setJsonBody(error).send();

                return;
            }

            Item savedItem = itemRepository.save(item);

            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("status", "success");
            responseBody.put("message", "Товар успешно создан");
            responseBody.put("item", savedItem);

            response.setStatusCode(201).setJsonBody(responseBody).send();

            System.out.println("Создан новый товар: " + savedItem);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Неверный формат JSON: " + e.getMessage());
            response.setStatusCode(400).setJsonBody(error).send();
        }
    }
}