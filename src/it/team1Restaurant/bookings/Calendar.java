package it.team1Restaurant.bookings;
import it.team1Restaurant.user.Client;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class Calendar {

    private Map<LocalDate,List<Booking>> bookingsMap;

    private static Calendar calendar = new Calendar();

    public Calendar ( ){
        bookingsMap = new HashMap<>();

    }

    public static  Calendar getInstance(){
        return calendar;
    }

    public Map<LocalDate, List<Booking>> getBookingsMap() {
        return bookingsMap;
    }

    public void setBookingsMap(Map<LocalDate, List<Booking>> bookingsMap) {
        this.bookingsMap = bookingsMap;
    }

    public void addBooking (Booking booking){
        if(bookingsMap.get(booking.getDate()) == null){
            bookingsMap.put(booking.getDate(), new ArrayList<>());
        }
        bookingsMap.get(booking.getDate()).add(booking);
    }


    public void book (Client client, LocalDate date, LocalTime time, int numberOfAdults, int numberOfChildren)  {
        Booking book = new Booking(client,createBookedAtDate(), date, time, numberOfAdults, numberOfChildren);
        //client.bookingList.add(book);
        addBooking(book);
        System.out.println("La prenotazione per " + client.getName() + " e' stata effettuata con successo: " +
                            "\n" + book.getBookingDetails());
    }

    public void book2 (Client client, LocalDate date, LocalTime time, int numberOfAdults, int numberOfChildren, int numberOfVegetarian, int numberOfVegan, int numberOfCeliac)  {
        Booking book = new Booking(client,createBookedAtDate(), date, time, numberOfAdults, numberOfChildren, numberOfVegetarian, numberOfVegan, numberOfCeliac);
        //client.bookingList.add(book);
        addBooking(book);
        System.out.println("La prenotazione per " + client.getName() + " e' stata effettuata con successo: " +
                "\n" + book.getBookingDetails());
    }

    private String createBookedAtDate(){
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en", "EN"));
        return simpleDateFormat.format(new Date());
    }

    /*DA IMPLEMENTARE
    public boolean checkBooking () {

    }*/


    public String getCalendarDetails() {
        String str = "";
        for(List<Booking> dayBookingList : bookingsMap.values()){
            String dayStr = "";
            for(Booking booking:dayBookingList){
                dayStr += booking.getBookingDetails();
            }
            str += dayStr;
        }
        return str;
    }

    public void printDetails() {
        for(List<Booking> dayBookingList : bookingsMap.values()){
            for(Booking booking : dayBookingList){
                booking.printDetails();
            }
        }
    }

}
