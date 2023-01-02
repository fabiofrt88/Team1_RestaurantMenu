package it.team1Restaurant.dao;

import it.team1Restaurant.jdbc.DriverJDBC;
import it.team1Restaurant.menu.TypeClientMenuEnum;

import java.sql.*;

public class TypeClientMenuDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS type_client_menu
                    ( id INTEGER(10) NOT NULL,
                      name VARCHAR(30) UNIQUE NOT NULL,
                      CONSTRAINT type_client_menu_pk PRIMARY KEY (id)
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table type_client_menu in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertTypeClientMenu(TypeClientMenuEnum typeClientMenu){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO type_client_menu (id, name)
                     VALUES ('""" + typeClientMenu.getId() + "', '" + typeClientMenu.getTypeClientMenuName() + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Type Client Menu %s inserted\n\n", typeClientMenu.getTypeClientMenuName());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
