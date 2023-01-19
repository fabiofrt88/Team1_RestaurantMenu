package it.team1Restaurant.service;

import it.team1Restaurant.dao.interfaces.IMenuDAO;
import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.menu.Menu;

import java.sql.SQLException;
import java.util.List;

public class MenuService {

    private IMenuDAO menuDAO;

    public MenuService(IMenuDAO menuDAO){
        this.menuDAO = menuDAO;
    }

    public void createTable(){
        menuDAO.createTable();
    }
    public void insertMenu(Menu menu){
        menuDAO.insertMenu(menu);
    }
    public List<Menu> selectAllMenu(){
        return menuDAO.selectAllMenu();
    }
    public Menu selectMenuById(Integer id){
        return menuDAO.selectMenuById(id);
    }

    public void addDishToMenu(Integer menuId, Integer dishId) throws SQLException {
        menuDAO.addDishToMenu(menuId, dishId);
    }

    public void addDrinkToMenu(Integer menuId, Integer drinkId){
        menuDAO.addDrinkToMenu(menuId, drinkId);
    }

    public List<Drink> selectDrinksByMenu(Menu menu){
        return menuDAO.selectDrinksByMenu(menu);
    }

    public List<Dish> selectDishesByMenu(Menu menu){
        return menuDAO.selectDishesByMenu(menu);
    }

    public void selectFoodsByMenu(Menu menu){
        menuDAO.selectFoodsByMenu(menu);
    }

}
