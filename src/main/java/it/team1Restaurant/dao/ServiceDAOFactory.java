package it.team1Restaurant.dao;

import it.team1Restaurant.service.BookingService;
import it.team1Restaurant.service.ClientService;
import it.team1Restaurant.service.DishService;
import it.team1Restaurant.service.IngredientService;

public class ServiceDAOFactory {

    public static DishService getDishService(){
        DishDAO dishDAO = new DishDAO();
        return new DishService(dishDAO);
    }

    public static IngredientService getIngredientService(){
        IngredientDAO ingredientDAO = new IngredientDAO();
        return new IngredientService(ingredientDAO);
    }

    public static BookingService getBookingService(){
        BookingDAO bookingDAO = new BookingDAO();
        return new BookingService(bookingDAO);
    }

    public static ClientService getClientService(){
        ClientDAO clientDAO = new ClientDAO();
        return new ClientService(clientDAO);
    }

}
