package it.team1Restaurant.dao;

import it.team1Restaurant.service.*;
import it.team1Restaurant.service.interfaces.IService;

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

    public static IService getService(ServiceEnum serviceEnum){

        IService service = null;

        switch(serviceEnum) {

            case DISH: //DishService
                DishDAO dishDAO = new DishDAO();
                service = new DishService(dishDAO);
                break;

            case DRINK: //DrinkService
                DrinkDAO drinkDAO = new DrinkDAO();
                service = new DrinkService(drinkDAO);
                break;

            case INGREDIENT: //IngredientService
                IngredientDAO ingredientDAO = new IngredientDAO();
                service = new IngredientService(ingredientDAO);
                break;

            case MENU: //MenuService
                MenuDAO menuDAO = new MenuDAO();
                service = new MenuService(menuDAO);
                break;

            case BOOKING: //BookingService
                BookingDAO bookingDAO = new BookingDAO();
                service = new BookingService(bookingDAO);
                break;

            case CLIENT: //ClientService
                ClientDAO clientDAO = new ClientDAO();
                service = new ClientService(clientDAO);
                break;

        }

        return service;

    }

}
