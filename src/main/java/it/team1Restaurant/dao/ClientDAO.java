package it.team1Restaurant.dao;

import it.team1Restaurant.jdbc.DriverJDBC;
import it.team1Restaurant.user.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS client
                    ( id INTEGER(10) NOT NULL AUTO_INCREMENT,
                      name VARCHAR(30) NOT NULL,
                      surname VARCHAR(30) NOT NULL,
                      email VARCHAR(30) UNIQUE NOT NULL,
                      phone_number VARCHAR(20) NOT NULL,
                      CONSTRAINT client_pk PRIMARY KEY (id)
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table client in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertClient(Client client){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO client (name, surname, email, phone_number)
                     VALUES ('""" + client.getName() + "', '" + client.getSurname() + "', '" + client.getEmail() + "', '" + client.getPhoneNumber() + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Client %s %s inserted\n\n", client.getName(), client.getSurname());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
