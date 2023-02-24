package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class Startsql {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/newdb";
        String user = "developer";
        String password = "Crediti20$";



        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            stmt.execute("CREATE VIEW Italian_students AS select `st`.`first_name` AS `first_name`,"  +
                                        "`st`.`last_name` AS `last_name` from `students3`"  +
                                       " `st` where (`st`.`country` = 'Italy') ;");
            stmt.execute("CREATE VIEW German_students AS select `st`.`first_name` AS `first_name`,"  +
                    "`st`.`last_name` AS `last_name` from `students3`"  +
                    " `st` where (`st`.`country` = 'Germany') ;");

            String query = "SELECT * from italian_students ";

            List<Student> italianstudents = new ArrayList<>();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                italianstudents.add(new Student(rs.getString("first_name"),
                        (rs.getString("last_name"))));
            }
            rs.close();
            for (Student it : italianstudents) {
                System.out.printf("italianstudents: %s %s %n" , it.getName() , it.getSurname());
            }
            String query2 = "SELECT * from german_students ";
            List<Student> germanstudents = new ArrayList<>();
            ResultSet rs2 = stmt.executeQuery(query2);

            while (rs2.next()) {
                germanstudents.add(new Student(rs2.getString("first_name"),
                        (rs2.getString("last_name"))));
            }
            rs2.close();

            for (Student ger : germanstudents) {
                System.out.printf("germanstudents: %s %s %n" ,ger.getName(),ger.getSurname());
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}





