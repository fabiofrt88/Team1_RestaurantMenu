package it.team1Restaurant.application;

import it.team1Restaurant.controller.DishController;
import it.team1Restaurant.controller.DrinkController;
import it.team1Restaurant.controller.IngredientController;
import it.team1Restaurant.controller.MenuController;
import it.team1Restaurant.exception.DataAccessException;
import it.team1Restaurant.exception.ExceptionHandler;
import it.team1Restaurant.exception.NotFoundException;

import static spark.Spark.*;

public class Main {

    private static final Integer PORT = 8080;

    public static void main(String[] args) {

        DishController dishController = new DishController();
        ExceptionHandler exceptionHandler = new ExceptionHandler();

        port(PORT);

        System.out.printf("Server Jetty is running on localhost:%s\n\n", PORT);

        before((request, response) -> response.type("application/json"));

        //dishes REST API

        get("/restaurant/dishes", (req, res) -> dishController.getAllDishes(req, res));
        get("/restaurant/dishes/:id", (req, res) -> dishController.getDishById(req, res));
        get("/restaurant/dishes/view/:type_course", (req, res) -> dishController.getAllDishesByView(req, res));

        //drinks REST API

        get("/restaurant/drinks", "application/json", (req, res) -> DrinkController.getAllDrinks(req, res));
        get("/restaurant/drinks/:id", (req, res) -> DrinkController.getDrinkById(req, res));
        get("/restaurant/drinks/view/:type_drink", (req, res) -> DrinkController.getAllDrinksByView(req, res));

        //ingredients REST API

        get("/restaurant/ingredients", (req, res) -> IngredientController.getAllIngredients(req, res));
        get("/restaurant/ingredients/:id", (req, res) -> IngredientController.getIngredientById(req, res));

        //menu REST API

        get("/restaurant/menu", (req, res) -> MenuController.getAllMenu(req, res));
        get("/restaurant/menu/:id", (req, res) -> MenuController.getMenuById(req, res));

        //exception

        exception(DataAccessException.class, (e, req, res) -> exceptionHandler.handleInternalServerError(e, req, res));
        exception(NotFoundException.class, (e, req, res) -> exceptionHandler.handleNotFoundException(e, req, res));
        exception(NumberFormatException.class, (e, req, res) -> exceptionHandler.handleNumberFormatException(e, req, res));

        /*exception(DataAccessException.class, (e, request, response) -> {
            System.out.println(e.getMessage()+ "\n");
            response.status(500);
            response.body("{\"error\":{\"code\": 500,\"message\":\"500 Internal Server Error\"}}");
        });

        exception(NotFoundException.class, (e, request, response) -> {
            System.out.println(e.getMessage()+ "\n");
            response.status(404);
            response.body("{\"error\":{\"code\": 404,\"message\":\"404 Resource not found\"}}");
        });

        exception(NumberFormatException.class, (e, request, response) -> {
            System.out.printf("NumberFormatException %s\n\n", e.getMessage());
            response.status(400);
            response.body("{\"error\":{\"code\": 400,\"message\":\"Bad request\"}}");
        });*/

    }

}
