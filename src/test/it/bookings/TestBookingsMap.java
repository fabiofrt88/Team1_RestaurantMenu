package test.it.bookings;

import it.team1Restaurant.bookings.Booking;
import it.team1Restaurant.bookings.calendar.CalendarBookings;
import it.team1Restaurant.bookings.calendar.Day;
import it.team1Restaurant.bookings.calendar.WorkingDayEnum;
import it.team1Restaurant.user.Client;
/*import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;*/
import org.testng.annotations.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class TestBookingsMap {

    private CalendarBookings calendarBookings = CalendarBookings.getInstance();

    private Map <Day,List<Booking>> bookingsMap = calendarBookings.getBookingsMap();

    Client client1 = new Client("Mario","Rossi");

    public static LocalDate getDateFromNow (int numberOfDaysToAdd){
        return LocalDate.now().plusDays(numberOfDaysToAdd);
    }


    /*@AfterEach
    public void resetCalendars () {
        calendarBookings.reset();
    }

    @BeforeEach
    public void activateOneMonthFromNow () {
        calendarBookings.createBookingsIntervalFromNow(30);
    }*/

    @Test
    public void addTwoDaysWithSameDateInBookingsMap () {
        Day nowWorking = new Day(LocalDate.now(), WorkingDayEnum.WORKING);
        System.out.println("workingday" + nowWorking);
        Day nowNotWorking = new Day(LocalDate.now(), WorkingDayEnum.NOT_WORKING);
        System.out.println("notworkingday" + nowNotWorking);
        Booking booking1 = new Booking (new Client(), "2222-11-11 23:00",LocalDate.now(), LocalTime.now());
        System.out.println("booking1:" + booking1);
        Booking booking2 = new Booking (new Client(), "5555-11-11 23:00",LocalDate.now(), LocalTime.now());
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
/*
    //toDo test if filter creates a new object or not

    @Test // create an interval over just activated interval
    public void testCreateBookingsInterval ( ) throws Exception {
        calendarBookings.createBookingsIntervalFromNow(10);
        calendarBookings.book(client1, List.of(client1), getDateFromNow(7),LocalTime.of(12,00));
        calendarBookings.createBookingsIntervalFromStartDate(getDateFromNow(5),10);
        calendarBookings.printDetails();
    }

    @Test  // change an empty working day in a not working day
    public void testSetWorkingDays_01 ( ) throws Exception {
        calendarBookings.createBookingsIntervalFromNow(30);
        calendarBookings.setWorkingDay(getDateFromNow(3),WorkingDayEnum.NOT_WORKING);
        calendarBookings.printDetails();
    }

    @Test // try to change a not empty working day in a not working day
    public void testSetWorkingDays_02 ( ) throws Exception {
        calendarBookings.createBookingsIntervalFromNow(30);
        LocalDate date = getDateFromNow(3);
        calendarBookings.book(client1,List.of(client1), date,LocalTime.of(12,00));
        try {
            calendarBookings.setWorkingDay(date,WorkingDayEnum.NOT_WORKING);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test // try to set a day not in calendar
    public void testSetWorkingDays_03 ( ) throws Exception {
        calendarBookings.createBookingsIntervalFromNow(2);
        LocalDate date = getDateFromNow(3);
        try {
            calendarBookings.setWorkingDay(date,WorkingDayEnum.NOT_WORKING);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test //add default not working day of week on an empty calendar
    public void testAddDefaultNotWorkingDayOfWeek_01 ( ) throws Exception {
        calendarBookings.createBookingsIntervalFromNow(30);
        calendarBookings.addDefaultNotWorkingDayOfWeek(DayOfWeek.SATURDAY);
        //calendarBookings.printDetails();
    }


    @Test // add default not working day of week on a non empty calendar
    public void testAddDefaultNotWorkingDayOfWeek_02 ( ) throws Exception {
        calendarBookings.createBookingsIntervalFromStartDate(LocalDate.of(2022,11,21),12);
        calendarBookings.book(client1,List.of(client1), LocalDate.of(2022,11,23),LocalTime.of(12,00));
        try {
            calendarBookings.addDefaultNotWorkingDayOfWeek(DayOfWeek.WEDNESDAY);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //calendarBookings.printDetails();
    }*/


}
