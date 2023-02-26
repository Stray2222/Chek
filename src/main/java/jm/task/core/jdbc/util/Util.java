package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static  final String DB_URL = "jdbc:mysql://localhost:3307/mydbtest";
    private static  final String DB_USERNAME = "root";
    private static  final String DB_PASSWORD = "12434";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        return connection;
    }

}
