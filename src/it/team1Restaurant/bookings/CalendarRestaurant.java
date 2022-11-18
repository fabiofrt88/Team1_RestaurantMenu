package it.team1Restaurant.bookings;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarRestaurant {

       private List<Day> notWorkingDays;

       private static CalendarRestaurant calendarRestaurant = new CalendarRestaurant();

       private CalendarRestaurant () {
           this.notWorkingDays = new ArrayList<>();
       };

       public static CalendarRestaurant getInstance() {
           return calendarRestaurant;
       }

    public List<Day> getNotWorkingDays() {
        return notWorkingDays;
    }

    public void setNotWorkingDays(List<Day> notWorkingDays) {
        this.notWorkingDays = notWorkingDays;
    }


    public void removeNotWorkingDay (LocalDate date,CalendarBookings calendarBookings)  {
           notWorkingDays.remove(date);
           try {
                calendarBookings.setWorkingDay(date,WorkingDayEnum.WORKING);
            } catch (Exception e) {
                e.getMessage();
            }
    }

    public void addNotWorkingDay (LocalDate date,CalendarBookings calendarBookings) throws Exception {
           if(calendarBookings.checkDateInCalendar(date)){
               if(calendarBookings.getBookingsListByDate(date).isEmpty()){
                   Day targetDay = calendarBookings.getDayByDate(date);
                   targetDay.setWorkingDay(WorkingDayEnum.NOT_WORKING);
                   notWorkingDays.add(targetDay);
               }else{
                   throw new Exception("Attenzione: ci sono già delle prenotazioni per questo giorno!");
               }
           }else{
               notWorkingDays.add(new Day(date,WorkingDayEnum.NOT_WORKING));
           }
       }

    public Day getDayByDate (LocalDate date) {
           return
    }



}
