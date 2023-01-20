package it.team1Restaurant.dao;

import it.team1Restaurant.dao.interfaces.IDrinkDAO;
import it.team1Restaurant.exception.DataAccessException;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.foods.TypeDrinkEnum;
import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DrinkDAO implements IDrinkDAO {

    protected DrinkDAO(){ }

    @Override
    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS drink
                    ( id INTEGER(10) NOT NULL AUTO_INCREMENT,
                      name VARCHAR(50) UNIQUE NOT NULL,
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
            throw new DataAccessException();
        }

    }

    @Override
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
            throw new DataAccessException();
        }

    }

    @Override
    public void createViewByTypeDrink(TypeDrinkEnum typeDrinkEnum){

        String nameView = typeDrinkEnum.getTypeDrinkName().replaceAll("\\s+", "_").toLowerCase();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String createQuery =
                    """
                    CREATE VIEW\040""" + nameView + """ 
                    _drinks AS SELECT drink.id, drink.name, drink.price, type_drink.name AS type_drink_name FROM drink
                    INNER JOIN type_drink ON drink.type_drink_id = type_drink.id 
                    WHERE type_drink.name =\040'""" + typeDrinkEnum.getTypeDrinkName() + "';";

            statement.executeUpdate(createQuery);

            System.out.printf("Created view %s_drinks in the database %s\n\n", nameView, conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
            throw new DataAccessException();
        }

    }

    @Override
    public List<Drink> selectAllDrinksByView(TypeDrinkEnum typeDrinkEnum){

        String nameView = typeDrinkEnum.getTypeDrinkName().replaceAll("\\s+", "_").toLowerCase();
        List<Drink> drinkList = new ArrayList<>();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery = "SELECT * FROM " + nameView + "_drinks";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer drinkId = resultSet.getInt(nameView + "_drinks.id");
                String drinkName = resultSet.getString(nameView + "_drinks.name");
                Double drinkPrice = resultSet.getDouble(nameView + "_drinks.price");
                String typeDrinkName = resultSet.getString(nameView + "_drinks.type_drink_name");
                Drink drink = new Drink(drinkId, drinkName, drinkPrice, TypeDrinkEnum.getTypeDrinkByName(typeDrinkName));
                drinkList.add(drink);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
            throw new DataAccessException();
        }

        return drinkList;

    }

    @Override
    public List<Drink> selectAllDrinks(){

        List<Drink> drinkList = new ArrayList<>();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT drink.id, drink.name, drink.price, type_drink.name AS type_drink_name FROM drink
                    INNER JOIN type_drink ON drink.type_drink_id = type_drink.id;""";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer drinkId = resultSet.getInt("drink.id");
                String drinkName = resultSet.getString("drink.name");
                Double drinkPrice = resultSet.getDouble("drink.price");
                String typeDrinkName = resultSet.getString("type_drink_name");
                Drink drink = new Drink(drinkId, drinkName, drinkPrice, TypeDrinkEnum.getTypeDrinkByName(typeDrinkName));
                drinkList.add(drink);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
            throw new DataAccessException();
        }

        return drinkList;

    }

    @Override
    public Drink selectDrinkById(Integer id){

        Drink drink = null;

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT drink.id, drink.name, drink.price, type_drink.name AS type_drink_name FROM drink
                    INNER JOIN type_drink ON drink.type_drink_id = type_drink.id
                    WHERE drink.id =\040""" + id + ";";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer drinkId = resultSet.getInt("drink.id");
                String drinkName = resultSet.getString("drink.name");
                Double drinkPrice = resultSet.getDouble("drink.price");
                String typeDrinkName = resultSet.getString("type_drink_name");
                drink = new Drink(drinkId, drinkName, drinkPrice, TypeDrinkEnum.getTypeDrinkByName(typeDrinkName));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
            throw new DataAccessException();
        }

        return drink;

    }

}
