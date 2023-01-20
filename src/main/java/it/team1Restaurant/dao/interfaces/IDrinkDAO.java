package it.team1Restaurant.dao.interfaces;

import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.foods.TypeDrinkEnum;

import java.util.List;

public interface IDrinkDAO {
    void createTable();

    void insertDrink(Drink drink);

    void createViewByTypeDrink(TypeDrinkEnum typeDrinkEnum);

    List<Drink> selectAllDrinksByView(TypeDrinkEnum typeDrinkEnum);

    List<Drink> selectAllDrinks();

    Drink selectDrinkById(Integer id);
}
