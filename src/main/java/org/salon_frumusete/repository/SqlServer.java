package org.salon_frumusete.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlServer {

    public static Connection conn() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/salon_frumusete";
        String username = "ralucx2";
        String password = "ralucx2";

        try {
            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

//    public static void main(String[] args) {
//        String jdbcUrl = "jdbc:mysql://localhost:3306/salon_frumusete";
//        String username = "ralucx2";
//        String password = "ralucx2";
//
//        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
//            System.out.println("Connected to the SQL Server database");
//
//
//        } catch (SQLException e) {
//
//        }
//    }

}