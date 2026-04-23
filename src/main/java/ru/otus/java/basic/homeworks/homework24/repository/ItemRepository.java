package ru.otus.java.basic.homeworks.homework24.repository;

import ru.otus.java.basic.homeworks.homework24.app.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class ItemRepository {
    private final List<Item> items;
    private final AtomicLong idGenerator;

    public ItemRepository() {
        this.items = new CopyOnWriteArrayList<>();
        this.idGenerator = new AtomicLong(4);

        items.add(new Item(1L, "Bread", 50));
        items.add(new Item(2L, "Milk", 150));
        items.add(new Item(3L, "Cheese", 400));
    }

    public List<Item> findAll() {
        return new ArrayList<>(items);
    }

    public Item save(Item item) {
        if (item.getId() == null) {
            item.setId(idGenerator.getAndIncrement());
        }
        items.add(item);
        return item;
    }

    public int getCount() {
        return items.size();
    }
}