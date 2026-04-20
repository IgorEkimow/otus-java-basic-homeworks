package ru.otus.java.basic.homeworks.homework24;

import ru.otus.java.basic.homeworks.homework24.processors.*;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class Dispatcher {
    private Map<String, RequestProcessor> processors;
    private RequestProcessor defaultNotFoundRequestProcessor;

    public Dispatcher() {
        this.defaultNotFoundRequestProcessor = new DefaultNotFoundRequestProcessor();
        this.processors = new HashMap<>();
        this.processors.put("GET /calculator", new CalculatorRequestProcessor());
        this.processors.put("GET /hello", new HelloRequestProcessor());
        this.processors.put("GET /items", new GetItemsRequestProcessor());
        this.processors.put("POST /items", new CreateItemRequestProcessor());
    }

    public void execute(HttpRequest request, OutputStream output) throws IOException {
        HttpResponse response = new HttpResponse(output);

        if (!processors.containsKey(request.getRoutingKey())) {
            defaultNotFoundRequestProcessor.execute(request, response);

            return;
        }

        processors.get(request.getRoutingKey()).execute(request, response);
    }
}