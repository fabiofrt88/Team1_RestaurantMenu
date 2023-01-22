package it.team1Restaurant.application;

import com.google.gson.JsonIOException;
import it.team1Restaurant.controller.*;
import it.team1Restaurant.exception.DataAccessException;
import it.team1Restaurant.exception.ExceptionHandler;
import it.team1Restaurant.exception.NotFoundException;

import java.time.format.DateTimeParseException;

import static spark.Spark.*;

public class Main {

    private static final Integer PORT = 8080;

    public static void main(String[] args) {

        DishController dishController = new DishController();
        DrinkController drinkController = new DrinkController();
        IngredientController ingredientController = new IngredientController();
        MenuController menuController = new MenuController();
        ClientController clientController = new ClientController();
        BookingController bookingController = new BookingController();

        ExceptionHandler exceptionHandler = new ExceptionHandler();

        port(PORT);

        System.out.printf("Server Jetty is running on localhost:%s\n\n", PORT);

        before((request, response) -> response.type("application/json"));

        //dishes REST API

        get("/restaurant/dishes", (req, res) -> dishController.getAllDishes(req, res));
        get("/restaurant/dishes/:id", (req, res) -> dishController.getDishById(req, res));
        get("/restaurant/dishes/view/:type_course", (req, res) -> dishController.getAllDishesByView(req, res));

        //drinks REST API

        get("/restaurant/drinks", "application/json", (req, res) -> drinkController.getAllDrinks(req, res));
        get("/restaurant/drinks/:id", (req, res) -> drinkController.getDrinkById(req, res));
        get("/restaurant/drinks/view/:type_drink", (req, res) -> drinkController.getAllDrinksByView(req, res));

        //ingredients REST API

        get("/restaurant/ingredients", (req, res) -> ingredientController.getAllIngredients(req, res));
        get("/restaurant/ingredients/:id", (req, res) -> ingredientController.getIngredientById(req, res));

        //menu REST API

        get("/restaurant/menu", (req, res) -> menuController.getAllMenu(req, res));
        get("/restaurant/menu/:id", (req, res) -> menuController.getMenuById(req, res));

        //clients REST API

        get("/restaurant/clients", (req, res) -> clientController.getAllClients(req, res));
        get("/restaurant/clients/:id", (req, res) -> clientController.getClientById(req, res));

        //bookings REST API

        get("/restaurant/bookings", (req, res) -> bookingController.getAllBookings(req, res));
        get("/restaurant/bookings/:id", (req, res) -> bookingController.getBookingById(req, res));
        get("/restaurant/bookings/client/:id", (req, res) -> bookingController.getBookingsByClient(req, res));
        get("/restaurant/bookings/date/:date", (req, res) -> bookingController.getBookingsByDate(req, res));
        get("/restaurant/bookings/date/:startDate/:endDate", (req, res) -> bookingController.getBookingsByInterval(req, res));

        //exception

        exception(DataAccessException.class, (e, req, res) -> exceptionHandler.handleInternalServerError(e, req, res));
        exception(ClassCastException.class, (e, req, res) -> exceptionHandler.handleClassCastException(e, req, res));
        exception(NotFoundException.class, (e, req, res) -> exceptionHandler.handleNotFoundException(e, req, res));
        exception(NumberFormatException.class, (e, req, res) -> exceptionHandler.handleNumberFormatException(e, req, res));
        exception(JsonIOException.class, (e, req, res) -> exceptionHandler.handleJsonIOException(e, req, res));
        exception(DateTimeParseException.class, (e, req, res) -> exceptionHandler.handleDateTimeParseException(e, req, res));

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
