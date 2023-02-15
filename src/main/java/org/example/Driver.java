package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            // db parameters
            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "Crediti20$";


            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) ;
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }


    }
    }
