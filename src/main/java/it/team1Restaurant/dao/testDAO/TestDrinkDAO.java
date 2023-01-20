package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.exception.DataAccessException;
import it.team1Restaurant.foods.*;
import it.team1Restaurant.service.DrinkService;

import java.util.List;

public class TestDrinkDAO {
    public static void main(String[] args) throws NoSuchMethodException {

        try {

            DrinkService drinkService = ServiceDAOFactory.getDrinkService();

            drinkService.createTable();

            drinkService.createViewByTypeDrink(TypeDrinkEnum.SOFT_DRINK);
            drinkService.createViewByTypeDrink(TypeDrinkEnum.WINE);
            drinkService.createViewByTypeDrink(TypeDrinkEnum.BEER);
            drinkService.createViewByTypeDrink(TypeDrinkEnum.COCKTAIL);
            drinkService.createViewByTypeDrink(TypeDrinkEnum.FRUIT_JUICE);
            drinkService.createViewByTypeDrink(TypeDrinkEnum.LIQUOR);



            List<Drink> drinkList = FoodStorageSql.getDrinkList();
            drinkList.forEach(drinkService::insertDrink);

            System.out.println("selectAllDrinkByView soft_drink\n");
            List<Drink> softDrink = drinkService.selectAllDrinksByView(TypeDrinkEnum.SOFT_DRINK);
            softDrink.forEach(System.out::println);

            System.out.println("\nselectAllDrink\n");
            List<Drink> drinks = drinkService.selectAllDrinks();
            drinks.forEach(System.out::println);

            System.out.println("\nselectDrinkById\n");
            Drink drink = drinkService.selectDrinkById(6);
            System.out.println(drink);

        } catch (DataAccessException e) {
            System.out.println(e.getMessage());
        }


    }
}

