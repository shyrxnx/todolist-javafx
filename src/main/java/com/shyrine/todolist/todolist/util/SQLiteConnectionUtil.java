package com.shyrine.todolist.todolist.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnectionUtil {

    private static Connection conn = null;
    private static final String url = "jdbc:sqlite:C:/sqlite3/todolist.db"; // Replace with your database path

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url);
                System.out.println("Connected to SQLite database.");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Disconnected from SQLite database.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
