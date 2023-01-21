package it.team1Restaurant.dao;

import it.team1Restaurant.service.*;

public class ServiceDAOFactory {

    public static DishService getDishService(){
        DishDAO dishDAO = new DishDAO();
        return new DishService(dishDAO);
    }

    public static DrinkService getDrinkService(){
        DrinkDAO drinkDAO = new DrinkDAO();
        return new DrinkService(drinkDAO);
    }

    public static IngredientService getIngredientService(){
        IngredientDAO ingredientDAO = new IngredientDAO();
        return new IngredientService(ingredientDAO);
    }

    public static MenuService getMenuService(){
        MenuDAO menuDAO = new MenuDAO();
        return new MenuService(menuDAO);
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
