package jm.task.core.jdbc.util;

import com.mysql.cj.protocol.x.StatementExecuteOkFactory;

import java.io.IOException;
import java.sql.*;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static  final String DB_URL = "jdbc:mysql://localhost:3307/mydbtest";
    private static  final String DB_USERNAME = "root";
    private static  final String DB_PASSWORD = "12434";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        } catch ( ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

