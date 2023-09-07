package com.example.message_board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    public static void main(String[] args) {
        // JDBC URL (這裡需要替換為您的資料庫連接資訊)
        String jdbcUrl = "jdbc:mysql://localhost:3306/message_board?useSSL=false&serverTimezone=UTC";
        String username = "root";
        String password = "abc123";

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            if (connection != null) {
                System.out.println("Successfully connected to the database!");
                connection.close();
            } else {
                System.out.println("Failed to connect to the database.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database.");
            e.printStackTrace();
        }
    }
}

