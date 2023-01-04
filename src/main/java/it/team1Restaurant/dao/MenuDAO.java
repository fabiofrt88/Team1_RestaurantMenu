package it.team1Restaurant.dao;

import it.team1Restaurant.jdbc.DriverJDBC;
import it.team1Restaurant.menu.Menu;
import it.team1Restaurant.menu.TypeFoodEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Menu> selectAllMenu(){

        List<Menu> menuList = new ArrayList<>();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT menu.id, menu.label, type_food.name FROM menu
                    INNER JOIN type_food ON menu.type_menu_id = type_food.id;""";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer menuId = resultSet.getInt("menu.id");
                String menuLabel = resultSet.getString("menu.label");
                String typeFoodName = resultSet.getString("type_food.name");
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
                    SELECT menu.id, menu.label, drink.price, type_food.name FROM menu
                    INNER JOIN type_food ON menu.type_menu_id = type_food.id
                    WHERE menu.id =\040""" + id + ";";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){
                Integer menuId = resultSet.getInt("menu.id");
                String menuLabel = resultSet.getString("menu.label");
                String typeFoodName = resultSet.getString("type_food.name");
                menu = new Menu(menuId, menuLabel, TypeFoodEnum.getTypeFoodByName(typeFoodName));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return menu;

    }

}
