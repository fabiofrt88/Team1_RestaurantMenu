package test.it.bookings;

import it.team1Restaurant.bookings.CalendarBookings;
import it.team1Restaurant.bookings.Day;
import it.team1Restaurant.bookings.WorkingDayEnum;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestBookingsMap {

    private CalendarBookings calendarBookings = new CalendarBookings();

    @Test
    public void addTwoDaysWithSameDateInBookingsMap () {
        calendarBookings.getBookingsMap().put(new Day(LocalDate.now(), WorkingDayEnum.WORKING), new ArrayList<>());
        calendarBookings.getBookingsMap().put(new Day(LocalDate.now(),WorkingDayEnum.NOT_WORKING),new ArrayList<>());
    }

}
