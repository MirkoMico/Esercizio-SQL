package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql04 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/newdb";
        String user = "developer";
        String password = "Crediti20$";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            stmt.execute("ALTER TABLE students3 ADD COLUMN country VARCHAR (30) NULL;");
            stmt.execute("UPDATE `newdb`.`students3` SET `country`='Italy' WHERE  `student_id`=1;");
            stmt.execute("UPDATE `newdb`.`students3` SET `country`='Italy' WHERE  `student_id`=2;");
            stmt.execute("UPDATE `newdb`.`students3` SET `country`='Germany' WHERE  `student_id`=3;");
            stmt.execute("UPDATE `newdb`.`students3` SET `country`='Germany' WHERE  `student_id`=4;");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
