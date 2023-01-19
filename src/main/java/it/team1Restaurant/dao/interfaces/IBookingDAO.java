package it.team1Restaurant.dao.interfaces;

import it.team1Restaurant.bookings.Booking;
import it.team1Restaurant.user.Client;

import java.time.LocalDate;
import java.util.List;

public interface IBookingDAO {

    void createTable();
    void insertBooking(Booking booking);
    List<Booking> selectAllBookings();
    Booking selectBookingById(Integer id);
    List<Booking> selectBookingsByClient(Client client);
    List<Booking> selectBookingsByDate(LocalDate date);
    List<Booking> selectBookingsByInterval(LocalDate startDate, LocalDate endDate);

}
