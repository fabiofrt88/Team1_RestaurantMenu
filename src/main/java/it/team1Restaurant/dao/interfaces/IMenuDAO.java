package it.team1Restaurant.dao.interfaces;

import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.menu.Menu;

import java.util.List;

public interface IMenuDAO {

    void createTableMenu();
    void insertMenu(Menu menu);
    List<Menu> selectAllMenu();
    Menu selectMenuById(Integer id);
    void addDishToMenu(Integer menuId, Integer dishId);
    void addDrinkToMenu(Integer menuId, Integer drinkId);
    List<Drink> selectDrinksByMenu(Menu menu);
    List<Dish> selectDishesByMenu(Menu menu);
    void selectFoodsByMenu(Menu menu);


}
