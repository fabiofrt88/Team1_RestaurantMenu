package it.team1Restaurant.dao;

import it.team1Restaurant.service.DishService;
import it.team1Restaurant.service.DrinkService;

public class ServiceDAOFactory {

    public static DishService getDishService(){
        DishDAO dishDAO = new DishDAO();
        return new DishService(dishDAO);
    }

    public static DrinkService getDrinkService(){
        DrinkDAO drinkDAO = new DrinkDAO();
        return new DrinkService(drinkDAO);
    }

}
