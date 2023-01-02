package it.team1Restaurant.dao.manytomany;

import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class IngredientDrinkDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS ingredient_drink
                    ( ingredient_id INTEGER(10) NOT NULL,
                      drink_id INTEGER(10) NOT NULL,
                      CONSTRAINT ingredient_FK_1 FOREIGN KEY (ingredient_id) REFERENCES ingredient(id)
                      ON UPDATE CASCADE ON DELETE CASCADE,
                      CONSTRAINT drink_FK_1 FOREIGN KEY (drink_id) REFERENCES drink(id)
                      ON UPDATE CASCADE ON DELETE CASCADE,
                      UNIQUE (ingredient_id, drink_id)
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table ingredient_drink in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertIngredientDrinkKeys(Integer ingredientId, Integer drinkId){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO ingredient_drink (ingredient_id, drink_id)
                     VALUES ('""" + ingredientId + "', '" + drinkId + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Foreign keys for ingredient_drink table inserted\n\n");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
