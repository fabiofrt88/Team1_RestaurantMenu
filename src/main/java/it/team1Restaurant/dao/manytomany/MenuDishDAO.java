package it.team1Restaurant.dao.manytomany;

import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MenuDishDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS menu_dish
                    ( menu_id INTEGER(10) NOT NULL,
                      dish_id INTEGER(10) NOT NULL,
                      CONSTRAINT menu_FK_1 FOREIGN KEY (menu_id) REFERENCES menu(id)
                      ON UPDATE CASCADE ON DELETE CASCADE,
                      CONSTRAINT dish_FK_1 FOREIGN KEY (dish_id) REFERENCES dish(id)
                      ON UPDATE CASCADE ON DELETE CASCADE,
                      UNIQUE (menu_id, dish_id)
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table menu_dish in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertMenuDishKeys(Integer menuId, Integer dishId){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO menu_dish (menu_id, dish_id)
                     VALUES ('""" + menuId + "', '" + dishId + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Foreign keys for menu_dish table inserted\n\n");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
