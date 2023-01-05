package it.team1Restaurant.dao;

import it.team1Restaurant.foods.TypeCourseEnum;
import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.*;

public class TypeCourseDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS type_course
                    ( id INTEGER(10) NOT NULL,
                      name VARCHAR(30) UNIQUE NOT NULL,
                      CONSTRAINT type_course_pk PRIMARY KEY (id)
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table type_course in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertTypeCourse(TypeCourseEnum typeCourse){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO type_course (id, name)
                     VALUES ('""" + typeCourse.getId() + "', '" + typeCourse.getTypeCourse() + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Type Course %s inserted\n\n", typeCourse.getTypeCourse());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
