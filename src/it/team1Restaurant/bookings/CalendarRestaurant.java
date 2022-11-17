package it.team1Restaurant.bookings;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarRestaurant {

       private List<LocalDate> notWorkingDays;

       private static CalendarRestaurant calendarRestaurant = new CalendarRestaurant();

       private CalendarRestaurant () {
           this.notWorkingDays = new ArrayList<>();
       };

       public static CalendarRestaurant getInstance() {
           return calendarRestaurant;
       }

    public List<LocalDate> getNotWorkingDays() {
        return notWorkingDays;
    }

    public void setNotWorkingDays(List<LocalDate> notWorkingDays) {
        this.notWorkingDays = notWorkingDays;
    }


    public void removeNotWorkingDay (LocalDate date,CalendarBookings calendarBookings)  {
           this.notWorkingDays.remove(date);
           try {
                calendarBookings.setWorkingDay(date,WorkingDayEnum.WORKING);
            } catch (Exception e) {
                e.getMessage();
            }
    }

       public void addNotWorkingDay (LocalDate date,CalendarBookings calendarBookings) throws Exception {
           if(calendarBookings.checkDateInCalendar(date)){
               if(calendarBookings.getBookingsListByDate(date).isEmpty()){
                    notWorkingDays.add(date);
                    calendarBookings.setWorkingDay(date,WorkingDayEnum.NOT_WORKING);
               }else{
                   throw new Exception("Attenzione: ci sono già delle prenotazioni per questo giorno!");
               }
           }else{
               notWorkingDays.add(date);
           }
       }





}
