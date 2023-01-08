package it.team1Restaurant.application;

import it.team1Restaurant.controller.DishController;
import it.team1Restaurant.controller.DrinkController;
import it.team1Restaurant.controller.IngredientController;

import static spark.Spark.*;

public class Main {
    private static final Integer PORT = 8080;

    public static void main(String[] args) {

        port(PORT);

        System.out.printf("Server Jetty is running on localhost:%s\n\n", PORT);

        //dishes REST API

        get("/restaurant/dishes", (req, res) -> DishController.getAllDishes(req, res));
        get("/restaurant/dishes/:id", (req, res) -> DishController.getDishById(req, res));
        get("/restaurant/dishes/view/:type_course", (req, res) -> DishController.getAllDishesByView(req, res));

        //drinks REST API

        get("/restaurant/drinks", (req, res) -> DrinkController.getAllDrinks(req, res));
        get("/restaurant/drinks/:id", (req, res) -> DrinkController.getDrinkById(req, res));
        get("/restaurant/drinks/view/:type_drink", (req, res) -> DrinkController.getAllDrinksByView(req, res));

        //ingredients REST API

        get("/restaurant/ingredients", (req, res) -> IngredientController.getAllIngredients(req, res));
        get("/restaurant/ingredients/:id", (req, res) -> IngredientController.getIngredientById(req, res));

    }

}
