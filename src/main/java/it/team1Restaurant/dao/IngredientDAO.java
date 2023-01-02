package it.team1Restaurant.dao;

import it.team1Restaurant.foods.Ingredient;
import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class IngredientDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String createQuery = """
                    CREATE TABLE IF NOT EXISTS ingredient
                    ( id NOT NULL AUTO INCREMENT,
                      name VARCHAR(30) UNIQUE NOT NULL,
                      CONSTRAINT ingredient_pk PRIMARY KEY (id)
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table ingredient in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertIngredient(Ingredient ingredient){

        try (Connection conn = DriverJDBC.getConnection()) {

            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO ingredient (name)
                     VALUES ('""" + ingredient.getName() + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Ingredient %s inserted\n\n", ingredient.getName());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
