package it.team1Restaurant.bookings.tests;


import it.team1Restaurant.bookings.calendar.CalendarBookings;
import it.team1Restaurant.menu.TypeDishClientEnum;
import it.team1Restaurant.user.Client;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumSet;

public class TestBooking {
    public static void main(String[] args) throws Exception {

        CalendarBookings calendarBookings = CalendarBookings.getInstance();
        calendarBookings.createBookingsIntervalFromNow(30);

        Client client = new Client(EnumSet.of(TypeDishClientEnum.GENERIC), "Pippo","Franco","pippofranco@gmail.com", "389-5264589");
        calendarBookings.book(client, List.of(client),getDateFromNow(4), LocalTime.of(12,30));


        Client client2 = new Client(EnumSet.of(TypeDishClientEnum.VEGAN), "Mario","Rossi","mariorossio@gmail.com", "389-6578904");


        calendarBookings.book(client2, List.of(client2) ,getDateFromNow(6), LocalTime.of(13,00));

        calendarBookings.book(client, List.of(client),getDateFromNow(6),LocalTime.of(14,44));


        calendarBookings.printDetails();


    }

    public static LocalDate getDateFromNow (int numberOfDaysToAdd){
        return LocalDate.now().plusDays(numberOfDaysToAdd);
    }
}
