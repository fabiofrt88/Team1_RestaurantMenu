package it.team1Restaurant.dao;

import it.team1Restaurant.foods.TypeDrinkEnum;
import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.*;

public class TypeDrinkDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS type_drink
                    ( id INTEGER(10) NOT NULL,
                      name VARCHAR(30) UNIQUE NOT NULL,
                      CONSTRAINT type_drink_pk PRIMARY KEY (id)
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table type_drink in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertTypeDrink(TypeDrinkEnum typeDrink){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO type_drink (id, name)
                     VALUES ('""" + typeDrink.getId() + "', '" + typeDrink.getTypeDrink() + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Type Drink %s inserted\n\n", typeDrink.getTypeDrink());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
