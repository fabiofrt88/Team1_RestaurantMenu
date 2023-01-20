package it.team1Restaurant.service;

import it.team1Restaurant.dao.interfaces.IDrinkDAO;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.foods.TypeDrinkEnum;
import it.team1Restaurant.service.interfaces.IService;


import java.util.List;

public class DrinkService implements IService {
    private IDrinkDAO drinkDAO;

    public DrinkService(IDrinkDAO drinkDAO){
        this.drinkDAO = drinkDAO;
    }

    public void createTable(){
        drinkDAO.createTable();
    }

    public void insertDrink(Drink drink){
        drinkDAO.insertDrink(drink);
    }

    public void createViewByTypeDrink(TypeDrinkEnum typeDrinkEnum){
        drinkDAO.createViewByTypeDrink(typeDrinkEnum);
    }

    public List<Drink> selectAllDrinksByView(TypeDrinkEnum typeDrinkEnum){
        return drinkDAO.selectAllDrinksByView(typeDrinkEnum);
    }

    public List<Drink> selectAllDrinks(){
        return drinkDAO.selectAllDrinks();
    }

    public Drink selectDrinkById(Integer id){
        return drinkDAO.selectDrinkById(id);
    }
}
