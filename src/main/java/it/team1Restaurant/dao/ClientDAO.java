package it.team1Restaurant.dao;

import it.team1Restaurant.dao.interfaces.IClientDAO;
import it.team1Restaurant.jdbc.DriverJDBC;
import it.team1Restaurant.user.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements IClientDAO {

    protected ClientDAO(){ }

    @Override
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

    @Override
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

    @Override
    public List<Client> selectAllClients(){

        List<Client> clientList = new ArrayList<>();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery = "SELECT * FROM client;";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer clientId = resultSet.getInt("client.id");
                String clientName = resultSet.getString("client.name");
                String clientSurname = resultSet.getString("client.surname");
                String clientEmail = resultSet.getString("client.email");
                String clientPhoneNumber = resultSet.getString("client.phone_number");
                Client client = new Client(clientId, clientName, clientSurname, clientEmail, clientPhoneNumber, null);
                clientList.add(client);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return clientList;

    }

    @Override
    public Client selectClientById(Integer id){

        Client client = null;

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT * FROM client 
                    WHERE client.id =\040""" + id + ";";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer clientId = resultSet.getInt("client.id");
                String clientName = resultSet.getString("client.name");
                String clientSurname = resultSet.getString("client.surname");
                String clientEmail = resultSet.getString("client.email");
                String clientPhoneNumber = resultSet.getString("client.phone_number");
                client = new Client(clientId, clientName, clientSurname, clientEmail, clientPhoneNumber, null);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return client;

    }

}
