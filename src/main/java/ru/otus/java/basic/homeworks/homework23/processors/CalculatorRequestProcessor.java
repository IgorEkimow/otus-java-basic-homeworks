package ru.otus.java.basic.homeworks.homework23.processors;

import ru.otus.java.basic.homeworks.homework23.HttpRequest;
import ru.otus.java.basic.homeworks.homework23.HttpResponseBuilder;
import ru.otus.java.basic.homeworks.homework23.HttpStatus;
import java.io.IOException;
import java.io.OutputStream;

public class CalculatorRequestProcessor implements RequestProcessor {
    @Override
    public void execute(HttpRequest request, OutputStream output) throws IOException {
        String aParam = request.getParameter("a");
        String bParam = request.getParameter("b");

        if (aParam == null || bParam == null) {
            sendErrorResponse(output, 400, "Missing parameters: 'a' and 'b' are required");
            return;
        }

        if (aParam.trim().isEmpty() || bParam.trim().isEmpty()) {
            sendErrorResponse(output, 400, "Parameters 'a' and 'b' cannot be empty");
            return;
        }

        try {
            int a = Integer.parseInt(aParam.trim());
            int b = Integer.parseInt(bParam.trim());

            String result = a + " + " + b + " = " + (a + b);
            byte[] response = HttpResponseBuilder.create().status(HttpStatus.OK).jsonBody(result).build();
            output.write(response);
        } catch (NumberFormatException e) {
            sendErrorResponse(output, 400, "Invalid number format: 'a' and 'b' must be valid integers");
        }
    }

    private void sendErrorResponse(OutputStream output, int statusCode, String errorMessage) throws IOException {
        HttpStatus status = statusCode == 400 ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR;
        byte[] response = HttpResponseBuilder.create().status(status).htmlBody("<html><body><h1>" + status.getCode() + " " + status.getMessage() + "</h1>" + "<p>" + errorMessage + "</p></body></html>").build();
        output.write(response);
    }
}