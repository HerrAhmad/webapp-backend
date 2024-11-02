package org.example;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.start();
            System.out.println("Server started");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}