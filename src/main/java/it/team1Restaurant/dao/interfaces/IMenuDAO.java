package it.team1Restaurant.dao.interfaces;

import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.menu.Menu;

import java.sql.SQLException;
import java.util.List;

public interface IMenuDAO {

    void createTable();
    void insertMenu(Menu menu);
    List<Menu> selectAllMenu();
    Menu selectMenuById(Integer id);
    void addDishToMenu(Integer menuId, Integer dishId) throws SQLException;
    void addDrinkToMenu(Integer menuId, Integer drinkId);
    List<Drink> selectDrinksByMenu(Menu menu);
    List<Dish> selectDishesByMenu(Menu menu);
    void selectFoodsByMenu(Menu menu);

}
