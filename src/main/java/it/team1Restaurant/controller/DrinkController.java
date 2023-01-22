package it.team1Restaurant.controller;

import com.google.gson.GsonBuilder;
import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.exception.NotFoundException;
import it.team1Restaurant.foods.Drink;
import it.team1Restaurant.foods.TypeDrinkEnum;
import it.team1Restaurant.service.DrinkService;
import it.team1Restaurant.service.ServiceEnum;
import spark.Request;
import spark.Response;

import java.util.List;

public class DrinkController {

    private DrinkService drinkService = (DrinkService) ServiceDAOFactory.getService(ServiceEnum.DRINK);

    public String getAllDrinksByView(Request request, Response response){
        String typeDrink = request.params(":type_drink");
        TypeDrinkEnum typeDrinkEnum = TypeDrinkEnum.getTypeDrinkByName(typeDrink);
        List<Drink> drinkList = drinkService.selectAllDrinksByView(typeDrinkEnum);
        return new GsonBuilder().setPrettyPrinting().create().toJson(drinkList);
    }

    public String getAllDrinks(Request request, Response response) {
        List<Drink> drinkList = drinkService.selectAllDrinks();
        return new GsonBuilder().setPrettyPrinting().create().toJson(drinkList);
    }

    public String getDrinkById(Request request, Response response) {
        Integer id = Integer.parseInt(request.params(":id"));
        Drink drink = drinkService.selectDrinkById(id);
        if(drink == null){
            throw new NotFoundException();
        }
        return new GsonBuilder().setPrettyPrinting().create().toJson(drink);
    }

}