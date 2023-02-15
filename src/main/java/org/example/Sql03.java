package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Sql03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/newdb";
        String user = "developer";
        String password = "Crediti20$";

        try {

            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            String query = "SELECT last_name,first_name FROM students3 ";
            ResultSet rs = stmt.executeQuery(query);

            List<String> surname = new ArrayList<>();

            while (rs.next()) {
                String names = rs.getString("first_name");
                String surnames = rs.getString("last_name");

                System.out.println(names);
                surname.add(surnames);
            }
            System.out.println(surname);
            con.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
