package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.exception.DataAccessException;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.foods.FoodStorageSql;
import it.team1Restaurant.foods.TypeDrinkEnum;
import it.team1Restaurant.service.DrinkService;

import java.util.List;

public class TestDrinkDAO {
    public static void main(String[] args) throws DataAccessException {

        try {

            DrinkService drinkService = ServiceDAOFactory.getDrinkService();

            drinkService.createTable();

            drinkService.createViewByTypeDrink(TypeDrinkEnum.WINE);
            drinkService.createViewByTypeDrink(TypeDrinkEnum.FRUIT_JUICE);
            drinkService.createViewByTypeDrink(TypeDrinkEnum.SOFT_DRINK);
            drinkService.createViewByTypeDrink(TypeDrinkEnum.COCKTAIL);
            drinkService.createViewByTypeDrink(TypeDrinkEnum.BEER);
            drinkService.createViewByTypeDrink(TypeDrinkEnum.LIQUOR);

            List<Drink> drinkList = FoodStorageSql.getDrinkList();
            drinkList.forEach(drinkService::insertDrink);

            System.out.println("selectAllDrinksByView wine_drinks\n");
            List<Drink> wineDrinks = drinkService.selectAllDrinksByView(TypeDrinkEnum.WINE);
            wineDrinks.forEach(System.out::println);

            System.out.println("\nselectAllDrinks\n");
            List<Drink> drinks = drinkService.selectAllDrinks();
            drinks.forEach(System.out::println);

            System.out.println("\nselectDrinkById\n");
            Drink drink = drinkService.selectDrinkById(5);
            System.out.println(drink);

        } catch (DataAccessException | ClassCastException | NullPointerException e) {
            System.out.println(e.getMessage());
        }

    }
}

