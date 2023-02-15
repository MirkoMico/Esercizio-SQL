package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class Sql02 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/newdb";
        String user = "developer";
        String password = "Crediti20$";
       try {
           Connection connection = DriverManager.getConnection(url, user, password);
           Statement statement = connection.createStatement();
           statement.execute("CREATE TABLE IF NOT EXISTS newdb . students3 (\n" +
                   "\t`student_id` INT(10) NOT NULL AUTO_INCREMENT,\n" +
                   "\t`last_name` VARCHAR(30) NULL ,\n" +
                   "\t`first_name` VARCHAR(30) NULL ,\n" +
                   " constraint students3_pk PRIMARY KEY (student_id));");
           statement.execute("insert into students3 (last_name, first_name)values('Rossi','Paolo');");
           statement.execute("insert into students3 (last_name, first_name)values('Bianchi','Luca');");
           statement.execute("insert into students3 (last_name, first_name)values('Verdi','Piero');");
           statement.execute("insert into students3 (last_name, first_name)values('Neri','Lino');");
           connection.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }


        }
    }

