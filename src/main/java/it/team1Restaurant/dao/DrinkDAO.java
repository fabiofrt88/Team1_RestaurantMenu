package it.team1Restaurant.dao;

import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.*;

public class DrinkDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS drink
                    ( id INTEGER(10) NOT NULL AUTO_INCREMENT,
                      name VARCHAR(30) UNIQUE NOT NULL,
                      price FLOAT(10),
                      type_drink_id INTEGER(5) NOT NULL,
                      CONSTRAINT drink_pk PRIMARY KEY (id),
                      CONSTRAINT type_drink_FK_1 FOREIGN KEY (type_drink_id) REFERENCES type_drink(id)
                      ON UPDATE CASCADE ON DELETE CASCADE
                    );
                    """;


            statement.executeUpdate(createQuery);
            System.out.printf("Created table drink in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertDrink(Drink drink){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO drink (name, price, type_drink_id)
                     VALUES ('""" + drink.getName() + "', '" + drink.getPrice() + "', '" + drink.getTypeDrinkId() + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Drink %s inserted\n\n", drink.getName());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
