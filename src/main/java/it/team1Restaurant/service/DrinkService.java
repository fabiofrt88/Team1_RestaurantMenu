package it.team1Restaurant.service;


import it.team1Restaurant.dao.DrinkDAO;
import it.team1Restaurant.dao.interfaces.IDrinkDAO;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.foods.TypeDrinkEnum;


import java.util.List;

public class DrinkService {
    private IDrinkDAO drinkDAO;

    public DrinkService(DrinkDAO drinkDAO){
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
