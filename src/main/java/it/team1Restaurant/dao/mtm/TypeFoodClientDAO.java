package it.team1Restaurant.dao.mtm;

import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TypeFoodClientDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS type_food_client
                    ( type_food_id INTEGER(10) NOT NULL,
                      client_id INTEGER(10) NOT NULL,
                      CONSTRAINT type_food_FK_1 FOREIGN KEY (type_food_id) REFERENCES type_food(id)
                      ON UPDATE CASCADE ON DELETE CASCADE,
                      CONSTRAINT client_FK_1 FOREIGN KEY (client_id) REFERENCES client(id)
                      ON UPDATE CASCADE ON DELETE CASCADE,
                      UNIQUE (type_food_id, client_id)
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table type_food_client in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertTypeFoodClientKeys(Integer typeFoodId, Integer clientId){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO type_food_client (type_food_id, client_id)
                     VALUES ('""" + typeFoodId + "', '" + clientId + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Foreign keys for type_food_client table inserted\n\n");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
