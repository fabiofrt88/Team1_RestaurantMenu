package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.dao.DrinkDAO;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.foods.TypeDrinkEnum;

import java.util.List;

public class TestDrinkDAO {
    public static void main(String[] args) throws NoSuchMethodException {

        DrinkDAO drinkDAO = new DrinkDAO();

        drinkDAO.createTable();

        drinkDAO.createViewByTypeDrink(TypeDrinkEnum.WINE);
        drinkDAO.createViewByTypeDrink(TypeDrinkEnum.FRUIT_JUICE);
        drinkDAO.createViewByTypeDrink(TypeDrinkEnum.SOFT_DRINK);
        drinkDAO.createViewByTypeDrink(TypeDrinkEnum.COCKTAIL);
        drinkDAO.createViewByTypeDrink(TypeDrinkEnum.BEER);
        drinkDAO.createViewByTypeDrink(TypeDrinkEnum.LIQUOR);

        drinkDAO.insertDrink(new Drink(null, "Acqua", 2, TypeDrinkEnum.SOFT_DRINK));
        drinkDAO.insertDrink(new Drink(null, "Vino Rosso", 15, TypeDrinkEnum.WINE));
        drinkDAO.insertDrink(new Drink(null, "Vino Bianco", 16, TypeDrinkEnum.WINE));
        drinkDAO.insertDrink(new Drink(null,"Birra", 6, TypeDrinkEnum.BEER));
        drinkDAO.insertDrink(new Drink(null, "Coca Cola", 3, TypeDrinkEnum.SOFT_DRINK));
        drinkDAO.insertDrink(new Drink(null, "Aranciata", 3, TypeDrinkEnum.FRUIT_JUICE));
        drinkDAO.insertDrink(new Drink(null, "Birra senza glutine",7, TypeDrinkEnum.BEER));
        drinkDAO.insertDrink(new Drink(null, "Cocco drink",6.5, TypeDrinkEnum.COCKTAIL));

        System.out.println("selectAllDrinksByView wine_drinks\n");
        List<Drink> wineDrinks = drinkDAO.selectAllDrinksByView(TypeDrinkEnum.WINE);
        wineDrinks.forEach(System.out::println);

        System.out.println("\nselectAllDrinks\n");
        List<Drink> drinkList = drinkDAO.selectAllDrinks();
        drinkList.forEach(System.out::println);

        System.out.println("\nselectDrinkById\n");
        Drink drink = drinkDAO.selectDrinkById(5);
        System.out.println(drink);

    }
}

