package it.team1Restaurant.bookings;

import it.team1Restaurant.foods.Food;
import it.team1Restaurant.foods.Ingredient;
import it.team1Restaurant.foods.TypeFood;
import it.team1Restaurant.menu.TypeDish;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        CalendarBookings calendarBookings = CalendarBookings.getInstance();
        //CalendarRestaurant calendarRestaurant = CalendarRestaurant.getInstance();
        //calendarRestaurant.addNotWorkingDay(LocalDate.of(2022,11,29),calendarBookings);
        //calendarBookings.createBookingsIntervalFromTwoDates(LocalDate.now(),LocalDate.of(2022,11,20));
        //calendarBookings.createBookingsIntervalFromStartDate(LocalDate.now(),10);
        calendarBookings.printDetails();
        calendarBookings.getBookingsMap().put(new Day(LocalDate.now(), WorkingDayEnum.WORKING), new ArrayList<>());
        calendarBookings.getBookingsMap().put(new Day(LocalDate.now(),WorkingDayEnum.NOT_WORKING),new ArrayList<>());
        calendarBookings.printDetails();
        calendarBookings.getBookingsMap().keySet().stream().forEach(key -> System.out.println(key.getDetails()));
        System.out.println(calendarBookings.getBookingsMap().keySet().size());

    }

}
