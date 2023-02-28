package jm.task.core.jdbc.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static  final String DB_URL = "jdbc:mysql://localhost:3307/mydbtest";
    private static  final String DB_USERNAME = "root";
    private static  final String DB_PASSWORD = "12434";
    private static Connection connection = null;
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}

