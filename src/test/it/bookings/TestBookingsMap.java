package test.it.bookings;

import it.team1Restaurant.bookings.Booking;
import it.team1Restaurant.bookings.calendar.CalendarBookings;
import it.team1Restaurant.bookings.calendar.Day;
import it.team1Restaurant.bookings.calendar.WorkingDayEnum;
import it.team1Restaurant.user.Client;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class TestBookingsMap {

    private CalendarBookings calendarBookings = CalendarBookings.getInstance();

    /*
    @AfterEach
    public void resetCalendars () {
        calendarBookings.reset();
        calendarRestaurant.reset();
    }*/

    @Test
    public void addTwoDaysWithSameDateInBookingsMap () {
        Map <Day,List<Booking>> bookingsMap =(TreeMap) calendarBookings.getBookingsMap();
        Day nowWorking = new Day(LocalDate.now(), WorkingDayEnum.WORKING);
        System.out.println("workingday" + nowWorking);
        Day nowNotWorking = new Day(LocalDate.now(), WorkingDayEnum.NOT_WORKING);
        System.out.println("notworkingday" + nowNotWorking);
        Booking booking1 = new Booking (new Client(), "2222-11-11 23:00",LocalDate.now(), LocalTime.now(),3, 3);
        System.out.println("booking1:" + booking1);
        Booking booking2 = new Booking (new Client(), "5555-11-11 23:00",LocalDate.now(), LocalTime.now(),3, 3);
        System.out.println("booking1:" + booking2);
        bookingsMap.put(nowWorking, new ArrayList<>(Arrays.asList(booking1)));
        System.out.println("Map keys after first adding: " + bookingsMap.keySet());
        System.out.println("Map values after first adding: " + bookingsMap.values());
        bookingsMap.put(nowNotWorking,new ArrayList<>(Arrays.asList( booking2)));
        System.out.println("Map keys after second adding: " + bookingsMap.keySet());
        System.out.println("Map values after second adding: " + bookingsMap.values());

        /*boolean nowWorkingIsInBookingsMap = bookingsMap.keySet().contains(nowWorking);
        boolean nowNotWorkingIsInBookingsMap = bookingsMap.keySet().contains(nowNotWorking);
        System.out.println(nowWorkingIsInBookingsMap);
        System.out.println(nowNotWorkingIsInBookingsMap);
        System.out.println(bookingsMap.keySet());
        System.out.println(bookingsMap.values());
        Assert.assertTrue(nowWorkingIsInBookingsMap);
        Assert.assertTrue(nowNotWorkingIsInBookingsMap);*/
    }

    //toDo test if filter creates a new object or not

    @Test
    public void testSetWorkingDays ( ) {

    }

}