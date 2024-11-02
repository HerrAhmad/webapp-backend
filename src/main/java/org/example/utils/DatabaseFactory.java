package org.example.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseFactory {
    private static final String URL = System.getenv("db.url");
    private static final String USER = System.getenv("db.user");
    private static final String PASSWORD = System.getenv("db.password");

    private DatabaseFactory() {}

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
