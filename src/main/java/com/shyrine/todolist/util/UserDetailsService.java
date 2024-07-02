package com.shyrine.todolist.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDetailsService {

    public enum LoginResult {
        SUCCESS,
        INVALID_USERNAME,
        INVALID_PASSWORD,
        DATABASE_ERROR
    }

    public LoginResult validateUser(String username, String password) {
        Connection conn = SQLiteConnectionUtil.getConnection();
        String query = "SELECT * FROM userDetails WHERE username = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                if (storedPassword.equals(password)) {
                    return LoginResult.SUCCESS; // Successful login
                } else {
                    return LoginResult.INVALID_PASSWORD; // Incorrect password
                }
            } else {
                return LoginResult.INVALID_USERNAME; // Username isn't found
            }
        } catch (SQLException e) {
            System.out.println("Error validating user: " + e.getMessage());
            return LoginResult.DATABASE_ERROR; // Database error
        }
    }
}
