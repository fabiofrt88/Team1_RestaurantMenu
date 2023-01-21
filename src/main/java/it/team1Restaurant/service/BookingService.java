package it.team1Restaurant.service;

import it.team1Restaurant.bookings.Booking;
import it.team1Restaurant.dao.interfaces.IBookingDAO;
import it.team1Restaurant.user.Client;

import java.time.LocalDate;
import java.util.List;

public class BookingService {

    private IBookingDAO bookingDAO;

    public BookingService(IBookingDAO bookingDAO){
        this.bookingDAO = bookingDAO;
    }

    public void createTable(){
        bookingDAO.createTable();
    }

    public void insertBooking(Booking booking){
        bookingDAO.insertBooking(booking);
    }

    public List<Booking> selectAllBookings(){
        return bookingDAO.selectAllBookings();
    }

    public Booking selectBookingById(Integer id){
        return bookingDAO.selectBookingById(id);
    }

    public List<Booking> selectBookingsByClient(Client client){
        return bookingDAO.selectBookingsByClient(client);
    }

    public List<Booking> selectBookingsByDate(LocalDate date){
        return bookingDAO.selectBookingsByDate(date);
    }

    public List<Booking> selectBookingsByInterval(LocalDate startDate, LocalDate endDate){
        return bookingDAO.selectBookingsByInterval(startDate, endDate);
    }

}
