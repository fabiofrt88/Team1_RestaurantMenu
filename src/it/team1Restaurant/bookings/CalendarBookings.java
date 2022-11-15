package it.team1Restaurant.bookings;
import it.team1Restaurant.user.Client;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class CalendarBookings {

    private Map<LocalDate,List<Booking>> bookingsMap;

    private CalendarRestaurant calendarRestaurant;
    private static CalendarBookings calendarBookings = new CalendarBookings();

    public CalendarBookings(){
        bookingsMap = new TreeMap<>();
        calendarRestaurant = CalendarRestaurant.getInstance();
    }

    public static CalendarBookings getInstance(){
        return calendarBookings;
    }

    public Map<LocalDate, List<Booking>> getBookingsMap() {
        return bookingsMap;
    }

    public void setBookingsMap(Map<LocalDate, List<Booking>> bookingsMap) {
        this.bookingsMap = bookingsMap;
    }

    public void addBooking (Booking booking) throws Exception {
        if(checkDateInCalendar(booking.getDate())) {
            bookingsMap.get(booking.getDate()).add(booking);
        }else{
            throw new Exception("La data per cui si vuole prenotare non è al momento attiva.");
        }
    }


    public void book (Client client, LocalDate date, LocalTime time, int numberOfAdults, int numberOfChildren) throws Exception {
        //Mettere un controllo su numberOfAdults e numberChildren ???
        Booking book = new Booking(client,createBookedAtDate(), date, time, numberOfAdults, numberOfChildren);
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


    public void createBookingsIntervalFromStartDate (LocalDate startDate, int numberOfDays){
        for(int i=0; i<=numberOfDays; i++){
            if(calendarRestaurant.getNotWorkingDays().contains(startDate.plusDays(i))){
                bookingsMap.put(startDate.plusDays(i), new ArrayList<>());
            }else {
                bookingsMap.put(startDate.plusDays(i), new ArrayList<>());
            }
        }
    }

    public void createBookingsIntervalFromTwoDates (LocalDate startDate, LocalDate endDate){
        int numberOfDays = (int)ChronoUnit.DAYS.between(startDate,endDate);
        createBookingsIntervalFromStartDate(startDate,numberOfDays);
    }

    public void createBookingIntervalFromNow(int numberOfDays){
        createBookingsIntervalFromStartDate(LocalDate.now(),numberOfDays);
    }

    public boolean checkDateInCalendar (LocalDate date) {
        return bookingsMap.keySet().contains(date);
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

    /*

    public void printDetails () {
        for(LocalDate date : bookingsMap.keySet()){
            switch(day.getWorkingDay()){
                case NOT_WORKING:
                    System.out.println(day.getDate());
                    System.out.println("Non è un giorno lavorativo\n");
                    break;
                case WORKING:
                    List<Booking> dayBoolingList = bookingsMap.get(day);
                    if (dayBoolingList.isEmpty()) {
                        System.out.println(day.getDate());
                        System.out.println("Non ci sono prenotazioni per questo giorno\n");
                    } else {
                        for (Booking booking : dayBoolingList) {
                            System.out.println(day.getDate());
                            booking.printDetails();
                        }
                    }
                    break;
            }
        }
    }*/
}
