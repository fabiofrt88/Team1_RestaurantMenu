package it.team1Restaurant.bookings.tests;

import it.team1Restaurant.bookings.calendar.CalendarBookings;
import it.team1Restaurant.bookings.calendar.Day;
import it.team1Restaurant.bookings.calendar.WorkingDayEnum;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestTreeMaps {
    public static void main(String[] args) {
        CalendarBookings calendarBookings = CalendarBookings.getInstance();
        calendarBookings.printDetails();
        calendarBookings.getBookingsMap().put(new Day(LocalDate.now(), WorkingDayEnum.WORKING), new ArrayList<>());
        calendarBookings.getBookingsMap().put(new Day(LocalDate.now(),WorkingDayEnum.NOT_WORKING),new ArrayList<>());
        calendarBookings.printDetails();
        calendarBookings.getBookingsMap().keySet().stream().forEach(key -> System.out.println(key.getDetails()));
        System.out.println(calendarBookings.getBookingsMap().keySet().size());
    }

}
