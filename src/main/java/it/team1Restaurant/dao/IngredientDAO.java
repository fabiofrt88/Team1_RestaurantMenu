package it.team1Restaurant.dao;

import it.team1Restaurant.dao.interfaces.IIngredientDAO;
import it.team1Restaurant.exception.DataAccessException;
import it.team1Restaurant.foods.Ingredient;
import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDAO implements IIngredientDAO {

    protected IngredientDAO(){}

    @Override
    public void createTableIngredient(){

        try (Connection conn = DriverJDBC.getConnection()) {

            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String createQuery = """
                    CREATE TABLE IF NOT EXISTS ingredient
                    ( id INTEGER(10) NOT NULL AUTO_INCREMENT,
                      name VARCHAR(50) UNIQUE NOT NULL,
                      CONSTRAINT ingredient_pk PRIMARY KEY (id)
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table ingredient in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
            throw new DataAccessException();
        }

    }
    @Override
    public void insertIngredient(Ingredient ingredient){

        try (Connection conn = DriverJDBC.getConnection()) {

            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO ingredient (name)
                     VALUES ('""" + ingredient.getName() + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Ingredient %s inserted\n\n", ingredient.getName());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
            throw new DataAccessException();
        }

    }
    @Override
    public List<Ingredient> selectAllIngredients(){

        List<Ingredient> ingredientList = new ArrayList<>();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT * FROM ingredient;""";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer ingredientId = resultSet.getInt("ingredient.id");
                String ingredientName = resultSet.getString("ingredient.name");

                Ingredient ingredient = new Ingredient(ingredientId,ingredientName);
                ingredientList.add(ingredient);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
            throw new DataAccessException();
        }

        return ingredientList;

    }
    @Override
    public Ingredient selectIngredientById(Integer id){

        Ingredient ingredient = null;

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT * FROM ingredient        
                    WHERE ingredient.id =\040""" + id + ";";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer ingredientId = resultSet.getInt("ingredient.Id");
                String ingredientName = resultSet.getString("ingredient.name");
                ingredient = new Ingredient(ingredientId,ingredientName);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
            throw new DataAccessException();
        }

        return ingredient;

    }

}
