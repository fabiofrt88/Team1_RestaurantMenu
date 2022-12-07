package it.team1Restaurant.bookings.calendar;

import it.team1Restaurant.bookings.exceptions.DateOutOfCalendar;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CalendarBookingsClient {

    private Map<Day, List<Booking>> bookingsMap;

    public CalendarBookingsClient(){

        bookingsMap = new TreeMap<>(new Comparator<Day>() {
            @Override
            public int compare(Day day1 , Day day2) {
                if(day1.getDate().equals(day2.getDate())) return 0;  // day1 == day2
                if(day1.getDate().isBefore(day2.getDate())) return -1; // day1 < day2
                else return 1;        // day1 > day2
            }
        });

    }

    public Map<Day, List<Booking>> getBookingsMap() {
        return bookingsMap;
    }

    public void setBookingsMap(Map<Day, List<Booking>> bookingsMap) {
        this.bookingsMap = bookingsMap;
    }

    public void addBooking(Booking booking) throws Exception {
        LocalDate targetDate = booking.getDate();
        if(bookingsMap.isEmpty() || !bookingsMap.containsKey(new Day(targetDate, WorkingDayEnum.WORKING))){
            bookingsMap.put(new Day(targetDate, WorkingDayEnum.WORKING), new ArrayList<>());
        }
        Day targetDay = getDayByDate(targetDate);
        List<Booking> targetBookingsList = bookingsMap.get(targetDay);
        if(checkDateInCalendar(targetDate) && !targetBookingsList.contains(booking)) {
            targetBookingsList.add(booking);
        }else{
            throw new DateOutOfCalendar();
        }
    }

    public Day getDayByDate(LocalDate date) throws DateOutOfCalendar {
        Day dayFound = null;
        for (Day day : bookingsMap.keySet()) {
            if (day.getDate().equals(date)) {
                dayFound = day;
                break;
            }
        }
        if (dayFound == null) throw new DateOutOfCalendar();
        else return dayFound;
    }

    public boolean checkDateInCalendar(LocalDate date) {
        return bookingsMap.keySet().stream()
                .map(day -> day.getDate())
                .collect(Collectors.toSet())
                .contains(date);
    }

    public List<Booking> getBookingsListByDate(LocalDate date) throws DateOutOfCalendar {
        return bookingsMap.get(getDayByDate(date));
    }

    public Booking getBookingByBookingNumber(Integer bookingNumber) throws Exception {
        Booking bookingFound = null;
        mapLoop:
        for(List<Booking> currentBookingList : bookingsMap.values()){
            for(Booking currentBooking : currentBookingList){
                if(currentBooking.getBookingNumber() == bookingNumber){
                    bookingFound = currentBooking;
                    break mapLoop;
                }
            }
        }
        if(!Objects.nonNull(bookingFound)){
            throw new Exception("Booking not found for this booking number");
        }
        else{
            return bookingFound;
        }

    }

    public void printCalendarBookingDetails() {
        for(Day day : bookingsMap.keySet()){
            List<Booking> dayBookingList = bookingsMap.get(day);
            System.out.println(day.getDetails());
            for (Booking booking : dayBookingList) {
                booking.printDetails();
            }
        }
    }


}
