package it.team1Restaurant.bookings;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendar {

    private Map<LocalDate,List<Booking>> bookingsMap;

    private static Calendar calendar = new Calendar();

    public Calendar ( ){
        bookingsMap = new HashMap<>();

    }

    public static  Calendar getInstance(){
        return calendar;
    }

    public void addBooking (Booking booking){
        if(bookingsMap.get(booking.getDate()) == null){
            bookingsMap.put(booking.getDate(), new ArrayList<>());
        }
        bookingsMap.get(booking.getDate()).add(booking);
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
