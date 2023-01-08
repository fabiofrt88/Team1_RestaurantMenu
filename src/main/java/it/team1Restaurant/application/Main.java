package it.team1Restaurant.application;

import it.team1Restaurant.controller.DishController;

import static spark.Spark.*;

public class Main {
    private static final Integer PORT = 8080;

    public static void main(String[] args) {

        port(PORT);

        System.out.printf("Server Jetty is running on localhost:%s\n\n", PORT);

        get("/restaurant/dishes", (req, res) -> DishController.getAllDishes(req, res));
        get("/restaurant/dishes/:id", (req, res) -> DishController.getDishById(req, res));
        get("/restaurant/dishes/view/:type_course", (req, res) -> DishController.getAllDishesByView(req, res));

    }

}
