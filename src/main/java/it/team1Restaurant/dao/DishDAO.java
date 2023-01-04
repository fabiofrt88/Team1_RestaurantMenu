package it.team1Restaurant.dao;

import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.TypeCourseEnum;
import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DishDAO {

    public void createTable(){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS dish
                    ( id INTEGER(10) NOT NULL AUTO_INCREMENT,
                      name VARCHAR(30) UNIQUE NOT NULL,
                      price FLOAT(10),
                      type_course_id INTEGER(5) NOT NULL,
                      CONSTRAINT dish_pk PRIMARY KEY (id),
                      CONSTRAINT type_course_FK_1 FOREIGN KEY (type_course_id) REFERENCES type_course(id)
                      ON UPDATE CASCADE ON DELETE CASCADE
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table dish in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertDish(Dish dish){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO dish (name, price, type_course_id)
                     VALUES ('""" + dish.getName() + "', '" + dish.getPrice() + "', '" + dish.getTypeCourseId() + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Dish %s inserted\n\n", dish.getName());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public List<Dish> selectAllDishes(){

        List<Dish> dishList = new ArrayList<>();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT dish.id, dish.name, dish.price, type_course.name FROM dish
                    INNER JOIN type_course ON dish.type_course_id = type_course.id;""";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer dishId = resultSet.getInt("dish.id");
                String dishName = resultSet.getString("dish.name");
                Double dishPrice = resultSet.getDouble("dish.price");
                String typeCourseName = resultSet.getString("type_course.name");
                Dish dish = new Dish(dishId, dishName, dishPrice, TypeCourseEnum.getTypeCourseByName(typeCourseName));
                dishList.add(dish);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return dishList;

    }

    public Dish selectDishById(Integer id){

        Dish dish = null;

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT dish.id, dish.name, dish.price, type_course.name FROM dish
                    INNER JOIN type_course ON dish.type_course_id = type_course.id
                    WHERE dish.id =\040""" + id + ";";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer dishId = resultSet.getInt("dish.id");
                String dishName = resultSet.getString("dish.name");
                Double dishPrice = resultSet.getDouble("dish.price");
                String typeCourseName = resultSet.getString("type_course.name");
                dish = new Dish(dishId, dishName, dishPrice, TypeCourseEnum.getTypeCourseByName(typeCourseName));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return dish;

    }

}
