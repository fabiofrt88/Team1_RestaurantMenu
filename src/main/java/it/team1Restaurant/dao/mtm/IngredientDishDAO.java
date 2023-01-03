package it.team1Restaurant.dao.mtm;

import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class IngredientDishDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS ingredient_dish
                    ( ingredient_id INTEGER(10) NOT NULL,
                      dish_id INTEGER(10) NOT NULL,
                      CONSTRAINT ingredient_FK_1 FOREIGN KEY (ingredient_id) REFERENCES ingredient(id)
                      ON UPDATE CASCADE ON DELETE CASCADE,
                      CONSTRAINT dish_FK_1 FOREIGN KEY (dish_id) REFERENCES dish(id)
                      ON UPDATE CASCADE ON DELETE CASCADE,
                      UNIQUE (ingredient_id, dish_id)
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table ingredient_dish in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertIngredientDishKeys(Integer ingredientId, Integer dishId){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO ingredient_dish (ingredient_id, dish_id)
                     VALUES ('""" + ingredientId + "', '" + dishId + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Foreign keys for ingredient_dish table inserted\n\n");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
