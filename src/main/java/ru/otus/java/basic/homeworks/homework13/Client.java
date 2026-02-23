package ru.otus.java.basic.homeworks.homework13;

import java.io.*;

public class Client implements AutoCloseable {
    private final DataInputStream inputStream;
    private final DataOutputStream outputStream;

    public Client(InputStream inputStream, OutputStream outputStream) {
        this.inputStream = new DataInputStream(inputStream);
        this.outputStream = new DataOutputStream(outputStream);
    }

    public void send(String message) throws IOException {
        outputStream.writeUTF(message);
        outputStream.flush();
    }

    public String sendAndReceive(String message) throws IOException {
        outputStream.writeUTF(message);
        outputStream.flush();

        return inputStream.readUTF();
    }

    public String receive() throws IOException {
        return inputStream.readUTF();
    }

    @Override
    public void close() throws IOException {
        inputStream.close();
        outputStream.close();
    }
}