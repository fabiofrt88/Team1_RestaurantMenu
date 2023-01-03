package it.team1Restaurant.dao;

import it.team1Restaurant.jdbc.DriverJDBC;
import it.team1Restaurant.menu.TypeFoodEnum;

import java.sql.*;

public class TypeFoodDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS type_food
                    ( id INTEGER(10) NOT NULL,
                      name VARCHAR(30) UNIQUE NOT NULL,
                      CONSTRAINT type_food_pk PRIMARY KEY (id)
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table type_food in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertTypeFood(TypeFoodEnum typeFood){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO type_food (id, name)
                     VALUES ('""" + typeFood.getId() + "', '" + typeFood.getTypeFoodName() + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Type Food %s inserted\n\n", typeFood.getTypeFoodName());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
