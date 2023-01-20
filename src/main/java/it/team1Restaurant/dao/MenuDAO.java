package it.team1Restaurant.dao;

import it.team1Restaurant.dao.interfaces.IMenuDAO;
import it.team1Restaurant.dao.mtm.MenuDishDAO;
import it.team1Restaurant.dao.mtm.MenuDrinkDAO;
import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.foods.TypeCourseEnum;
import it.team1Restaurant.foods.TypeDrinkEnum;
import it.team1Restaurant.jdbc.DriverJDBC;
import it.team1Restaurant.menu.Menu;
import it.team1Restaurant.menu.TypeFoodEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO implements IMenuDAO {

    public void createTableMenu(){

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

    public List<Menu> selectAllMenu(){

        List<Menu> menuList = new ArrayList<>();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT menu.id, menu.label, type_food.name AS type_menu FROM menu
                    INNER JOIN type_food ON menu.type_menu_id = type_food.id;""";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer menuId = resultSet.getInt("menu.id");
                String menuLabel = resultSet.getString("menu.label");
                String typeFoodName = resultSet.getString("type_menu");
                Menu menu = new Menu(menuId, menuLabel, TypeFoodEnum.getTypeFoodByName(typeFoodName));
                menuList.add(menu);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return menuList;

    }

    public Menu selectMenuById(Integer id){

        Menu menu = null;

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT menu.id, menu.label, type_food.name AS type_menu FROM menu
                    INNER JOIN type_food ON menu.type_menu_id = type_food.id
                    WHERE menu.id =\040""" + id + ";";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer menuId = resultSet.getInt("menu.id");
                String menuLabel = resultSet.getString("menu.label");
                String typeFoodName = resultSet.getString("type_menu");
                menu = new Menu(menuId, menuLabel, TypeFoodEnum.getTypeFoodByName(typeFoodName));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return menu;

    }

    public void addDishToMenu(Integer menuId, Integer dishId){

        Menu menu = this.selectMenuById(menuId);
        Dish dish = new DishDAO().selectDishById(dishId);

        if(menu != null && dish != null){

            MenuDishDAO menuDishDAO = new MenuDishDAO();
            menuDishDAO.insertMenuDishKeys(menuId, dishId);

        } else {
            System.out.println("Dish not added to menu\n");
        }

    }

    public void addDrinkToMenu(Integer menuId, Integer drinkId){

        Menu menu = this.selectMenuById(menuId);
        Drink drink = new DrinkDAO().selectDrinkById(drinkId);

        if(menu != null && drink != null){

            MenuDrinkDAO menuDrinkDAO = new MenuDrinkDAO();
            menuDrinkDAO.insertMenuDrinkKeys(menuId, drinkId);

        } else {
            System.out.println("Drink not added to menu\n");
        }

    }

    public List<Drink> selectDrinksByMenu(Menu menu){

        List<Drink> drinkList = new ArrayList<>();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT drink.id, drink.name, drink.price, type_drink.name AS type_drink_name FROM drink
                    INNER JOIN type_drink ON drink.type_drink_id = type_drink.id
                    INNER JOIN menu_drink ON drink.id = menu_drink.drink_id
                    INNER JOIN menu ON menu.id = menu_drink.menu_id
                    WHERE menu.id =\040""" + menu.getId() + ";";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer drinkId = resultSet.getInt("drink.id");
                String drinkName = resultSet.getString("drink.name");
                Double drinkPrice = resultSet.getDouble("drink.price");
                String typeDrinkName = resultSet.getString("type_drink_name");
                Drink drink = new Drink(drinkId, drinkName, drinkPrice, TypeDrinkEnum.getTypeDrinkByName(typeDrinkName));
                menu.addDrink(drink);
                drinkList.add(drink);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return drinkList;

    }

    public List<Dish> selectDishesByMenu(Menu menu){

        List<Dish> dishList = new ArrayList<>();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT dish.id, dish.name, dish.price, type_course.name AS type_course_name FROM dish
                    INNER JOIN type_course ON dish.type_course_id = type_course.id
                    INNER JOIN menu_dish ON dish.id = menu_dish.dish_id
                    INNER JOIN menu ON menu.id = menu_dish.menu_id
                    WHERE menu.id =\040""" + menu.getId() + ";";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer dishId = resultSet.getInt("dish.id");
                String dishName = resultSet.getString("dish.name");
                Double dishPrice = resultSet.getDouble("dish.price");
                String typeCourseName = resultSet.getString("type_course_name");
                Dish dish = new Dish(dishId, dishName, dishPrice, TypeCourseEnum.getTypeCourseByName(typeCourseName));
                menu.addDish(dish.getTypeCourse(), dish);
                dishList.add(dish);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return dishList;

    }

    public void selectFoodsByMenu(Menu menu){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                            SELECT drink.id, drink.name, drink.price, type_drink.name AS type_name FROM drink
                            INNER JOIN type_drink ON drink.type_drink_id = type_drink.id
                            INNER JOIN menu_drink ON drink.id = menu_drink.drink_id
                            INNER JOIN menu ON menu.id = menu_drink.menu_id
                            WHERE menu.id =\040""" + menu.getId() + """
                            \040UNION
                            SELECT dish.id, dish.name, dish.price, type_course.name AS type_name FROM dish
                            INNER JOIN type_course ON dish.type_course_id = type_course.id
                            INNER JOIN menu_dish ON dish.id = menu_dish.dish_id
                            INNER JOIN menu ON menu.id = menu_dish.menu_id
                            WHERE menu.id =\040""" + menu.getId() + ";";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){

                String typeName = resultSet.getString("type_name");
                TypeDrinkEnum typeDrinkEnum = TypeDrinkEnum.getTypeDrinkByName(typeName);
                if(typeDrinkEnum != null){

                    Integer drinkId = resultSet.getInt("id");
                    String drinkName = resultSet.getString("name");
                    Double drinkPrice = resultSet.getDouble("price");
                    Drink drink = new Drink(drinkId, drinkName, drinkPrice, typeDrinkEnum);
                    System.out.println(drink);
                    menu.addDrink(drink);

                } else {

                    TypeCourseEnum typeCourseEnum = TypeCourseEnum.getTypeCourseByName(typeName);
                    if(typeCourseEnum != null){

                        Integer dishId = resultSet.getInt("id");
                        String dishName = resultSet.getString("name");
                        Double dishPrice = resultSet.getDouble("price");
                        Dish dish = new Dish(dishId, dishName, dishPrice, typeCourseEnum);
                        System.out.println(dish);
                        menu.addDish(dish.getTypeCourse(), dish);

                    }

                }

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

}
