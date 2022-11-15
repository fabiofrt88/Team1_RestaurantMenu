package it.team1Restaurant.bookings;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarRestaurant {

       List<LocalDate> notWorkingDays;

       private static CalendarRestaurant calendarRestaurant = new CalendarRestaurant();

       private CalendarRestaurant () {
           this.notWorkingDays = new ArrayList<>();
       };

       public CalendarRestaurant getInstance () {
           return calendarRestaurant;
       }



}
