package com.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    private static final String PROPERTIES_FILE = "com/example/util/db.properties";

    public static Connection getConnection() throws SQLException {
        Properties prop = new Properties();
        try (InputStream inputStream = DatabaseConnection.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new SQLException("Error loading database properties");
        }

        String url = prop.getProperty("db.url");
        String username = prop.getProperty("db.username");
        String password = prop.getProperty("db.password");

        return DriverManager.getConnection(url, username, password);
    }
}
