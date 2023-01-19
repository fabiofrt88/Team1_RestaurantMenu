package it.team1Restaurant.dao;

import it.team1Restaurant.service.BookingService;
import it.team1Restaurant.service.DishService;

public class ServiceDAOFactory {

    public static DishService getDishService(){
        DishDAO dishDAO = new DishDAO();
        return new DishService(dishDAO);
    }

    public static BookingService getBookingService(){
        BookingDAO bookingDAO = new BookingDAO();
        return new BookingService(bookingDAO);
    }

}
