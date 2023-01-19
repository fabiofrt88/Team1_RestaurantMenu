package it.team1Restaurant.dao.testDAO;

import it.team1Restaurant.bookings.Booking;
import it.team1Restaurant.dao.BookingDAO;
import it.team1Restaurant.dao.ClientDAO;
import it.team1Restaurant.user.Client;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TestBookingDAO {

    public static void main(String[] args) {

        BookingDAO bookingDAO = new BookingDAO();
        ClientDAO clientDAO = new ClientDAO();

        bookingDAO.createTable();

        Client client1 = clientDAO.selectClientById(1);
        Client client2 = clientDAO.selectClientById(2);

        /*Booking booking1 = Client.book(client1, new ArrayList<>(List.of(client1)), LocalDate.of(2023, 1, 10), LocalTime.of(12, 30));
        Booking booking2 = Client.book(client1, new ArrayList<>(List.of(client1)), LocalDate.of(2023, 1, 12), LocalTime.of(20, 0));
        Booking booking3 = Client.book(client2, new ArrayList<>(List.of(client2)), LocalDate.of(2023, 1, 12), LocalTime.of(13, 30));
        Booking booking4 = Client.book(client2, new ArrayList<>(List.of(client2)), LocalDate.of(2023, 2, 14), LocalTime.of(21, 0));

        bookingDAO.insertBooking(booking1);
        bookingDAO.insertBooking(booking2);
        bookingDAO.insertBooking(booking3);
        bookingDAO.insertBooking(booking4);*/

        System.out.println("selectAllBookings\n");
        List<Booking> bookingList = bookingDAO.selectAllBookings();
        bookingList.forEach(Booking::printDetails);

        System.out.println("selectBookingById\n");
        Booking booking = bookingDAO.selectBookingById(4);
        if(booking != null){
            booking.printDetails();
        }
        else {
            System.out.println("No booking found");
        }

        System.out.println("selectBookingsByClient\n");
        bookingList = bookingDAO.selectBookingsByClient(client2);
        bookingList.forEach(Booking::printDetails);

        System.out.println("selectBookingsByDate\n");
        bookingList = bookingDAO.selectBookingsByDate(LocalDate.of(2023,1,12));
        bookingList.forEach(Booking::printDetails);

        System.out.println("selectBookingsByInterval\n");
        bookingList = bookingDAO.selectBookingsByInterval(LocalDate.of(2023,1,1), LocalDate.of(2023, 1, 31));
        bookingList.forEach(Booking::printDetails);

    }

}
