package it.team1Restaurant.dao.testDAO;
import com.google.gson.GsonBuilder;
import it.team1Restaurant.dao.DishDAO;
import it.team1Restaurant.dao.DrinkDAO;
import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.foods.TypeDrinkEnum;

import java.util.List;


public class TestDrinkDAO {
    public static void main(String[] args) throws NoSuchMethodException {

        DrinkDAO drinkDAO = new DrinkDAO();

        drinkDAO.createTable();

        drinkDAO.insertDrink(new Drink(null, "Acqua", 2, TypeDrinkEnum.SOFT_DRINK));
        drinkDAO.insertDrink(new Drink(null, "Vino Rosso", 15, TypeDrinkEnum.WINE));
        drinkDAO.insertDrink(new Drink(null, "Vino Bianco", 16, TypeDrinkEnum.WINE));
        drinkDAO.insertDrink(new Drink(null,"Birra", 6, TypeDrinkEnum.BEER));
        drinkDAO.insertDrink(new Drink(null, "Coca Cola", 3, TypeDrinkEnum.SOFT_DRINK));
        drinkDAO.insertDrink(new Drink(null, "Aranciata", 3, TypeDrinkEnum.FRUIT_JUICE));
        drinkDAO.insertDrink(new Drink(null, "Birra senza glutine",7, TypeDrinkEnum.BEER));
        drinkDAO.insertDrink(new Drink(null, "Cocco drink",6.5, TypeDrinkEnum.COCKTAIL));

        System.out.println("selectAllDrinks\n");
        List<Drink> drinkList = drinkDAO.selectAllDrinks();
        drinkList.forEach(System.out::println);

        System.out.println("\nselectDrinkById\n");
        Drink drink = drinkDAO.selectDrinkById(5);
        System.out.println(drink);

    }
}

