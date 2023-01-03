package it.team1Restaurant.dao;

import it.team1Restaurant.jdbc.DriverJDBC;
import it.team1Restaurant.menu.Menu;

import java.sql.*;

public class MenuDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS menu
                    ( id INTEGER(10) NOT NULL AUTO_INCREMENT,
                      label VARCHAR(30) UNIQUE NOT NULL,
                      type_menu_id INTEGER(5) NOT NULL,
                      CONSTRAINT menu_pk PRIMARY KEY (id),
                      CONSTRAINT type_menu_FK_1 FOREIGN KEY (type_menu_id) REFERENCES type_food(id)
                      ON UPDATE CASCADE ON DELETE CASCADE
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table menu in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertMenu(Menu menu){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO menu (label, type_menu_id)
                     VALUES ('""" + menu.getLabel() + "', '" + menu.getTypeMenuId() + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Menu %s inserted\n\n", menu.getLabel());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
