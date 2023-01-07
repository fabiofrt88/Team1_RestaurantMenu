package it.team1Restaurant.dao.mtm;

import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MenuDrinkDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS menu_drink
                    ( menu_id INTEGER(10) NOT NULL,
                      drink_id INTEGER(10) NOT NULL,
                      CONSTRAINT menu_drink_FK_1 FOREIGN KEY (menu_id) REFERENCES menu(id)
                      ON UPDATE CASCADE ON DELETE CASCADE,
                      CONSTRAINT drink_menu_FK_1 FOREIGN KEY (drink_id) REFERENCES drink(id)
                      ON UPDATE CASCADE ON DELETE CASCADE,
                      UNIQUE (menu_id, drink_id)
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table menu_drink in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertMenuDrinkKeys(Integer menuId, Integer drinkId){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO menu_drink (menu_id, drink_id)
                     VALUES ('""" + menuId + "', '" + drinkId + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Foreign keys for menu_drink table inserted\n\n");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
