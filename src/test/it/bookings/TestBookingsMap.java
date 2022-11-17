package test.it.bookings;

import it.team1Restaurant.bookings.Booking;
import it.team1Restaurant.bookings.CalendarBookings;
import it.team1Restaurant.bookings.Day;
import it.team1Restaurant.bookings.WorkingDayEnum;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestBookingsMap {

    private CalendarBookings calendarBookings = new CalendarBookings();


    @Test
    public void addTwoDaysWithSameDateInBookingsMap () {
        Map <Day,List<Booking>> bookingsMap =(TreeMap) calendarBookings.getBookingsMap();
        Day nowWorking = new Day(LocalDate.now(), WorkingDayEnum.WORKING);
        Day nowNotWorking = new Day(LocalDate.now(), WorkingDayEnum.NOT_WORKING);
        bookingsMap.put(nowWorking, new ArrayList<>());
        bookingsMap.put(nowNotWorking,new ArrayList<>());
        boolean nowWorkingIsInBookingsMap = bookingsMap.containsKey(nowWorking);
        boolean nowNotWorkingIsInBookingsMap = bookingsMap.containsKey(nowNotWorking);
        Assert.assertTrue(nowWorkingIsInBookingsMap);
        Assert.assertFalse(nowNotWorkingIsInBookingsMap);
    }

}
