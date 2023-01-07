package it.team1Restaurant.dao.mtm;

import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TypeFoodDrinkDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS type_food_drink
                    ( type_food_id INTEGER(10) NOT NULL,
                      drink_id INTEGER(10) NOT NULL,
                      CONSTRAINT type_food_drink_FK_1 FOREIGN KEY (type_food_id) REFERENCES type_food(id)
                      ON UPDATE CASCADE ON DELETE CASCADE,
                      CONSTRAINT drink_type_food_FK_1 FOREIGN KEY (drink_id) REFERENCES drink(id)
                      ON UPDATE CASCADE ON DELETE CASCADE,
                      UNIQUE (type_food_id, drink_id)
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table type_food_drink in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertTypeFoodDrinkKeys(Integer typeFoodId, Integer drinkId){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO type_food_drink (type_food_id,drink_id)
                     VALUES ('""" + typeFoodId + "', '" +drinkId + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Foreign keys for type_food_drink table inserted\n\n");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
