package it.team1Restaurant.bookings;

import it.team1Restaurant.user.Client;
import java.time.LocalDate;
import java.time.LocalTime;

public class TestBooking {
    public static void main(String[] args) throws Exception {

        CalendarBookings calendarBookings = CalendarBookings.getInstance();

        Client client = new Client("Pippo","Franco","pippofranco@gmail.com", "389-5264589", false);
        calendarBookings.book(client,LocalDate.of(2022,11,11), LocalTime.of(12,30), 3, 2);


        Client client2 = new Client("Mario","Rossi","mariorossio@gmail.com", "389-6578904", false);
        calendarBookings.book(client2,LocalDate.of(2022,11,16), LocalTime.of(13,00), 2, 3);


        //first print details

        calendarBookings.printDetails();
        /*client.printBookingsDetails();
        client2.printBookingsDetails();*/

        //edit book's value

        //client.getBookingList().get(0).setNumberOfAdult(2);
        calendarBookings.getBookingsMap().get(LocalDate.of(2022,11,11)).get(0).setNumberOfChildren(1);


    }
}
