package it.team1Restaurant.bookings.tests;

import it.team1Restaurant.bookings.calendar.CalendarBookings;
import it.team1Restaurant.user.Client;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestBooking {
    public static void main(String[] args) throws Exception {

        CalendarBookings calendarBookings = CalendarBookings.getInstance();
        calendarBookings.createBookingsIntervalFromNow(30);

        Client client = new Client("Pippo","Franco","pippofranco@gmail.com", "389-5264589", false);
        calendarBookings.book(client,getDateFromNow(4), LocalTime.of(12,30), 3, 2);


        Client client2 = new Client("Mario","Rossi","mariorossio@gmail.com", "389-6578904", false);
        calendarBookings.book(client2,getDateFromNow(6), LocalTime.of(13,00), 2, 3);

        calendarBookings.book(client,getDateFromNow(6),LocalTime.of(14,44),3,2);

        calendarBookings.printDetails();


    }

    public static LocalDate getDateFromNow (int numberOfDaysToAdd){
        return LocalDate.now().plusDays(numberOfDaysToAdd);
    }
}
