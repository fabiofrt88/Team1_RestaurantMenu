package it.team1Restaurant.bookings;

import java.time.DayOfWeek;

public class TestCalendarRestaurant {

    public static void main(String[] args) throws Exception {
        CalendarRestaurant calendarRestaurant = CalendarRestaurant.getInstance();
        CalendarBookings calendarBookings = CalendarBookings.getInstance();
        calendarBookings.createBookingsIntervalFromNow(20);
        calendarRestaurant.addDefaultNotWorkingDayOfWeek(DayOfWeek.FRIDAY,calendarBookings);
        calendarRestaurant.printDetails();
        calendarBookings.printDetails();
    }

}
