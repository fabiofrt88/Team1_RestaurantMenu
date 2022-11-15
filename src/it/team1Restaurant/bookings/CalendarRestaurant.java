package it.team1Restaurant.bookings;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarRestaurant {

       List<LocalDate> notWorkingDays;

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


    public void removeNotWorkingDay (LocalDate date) {
           this.notWorkingDays.remove(date);
           // settare Map
       }

       public void addNotWorkingDay (LocalDate date,CalendarBookings calendarBookings) throws Exception {
           if(calendarBookings.checkDateInCalendar(date)){
               if(calendarBookings.getBookingsMap().get(date).isEmpty()){
                    notWorkingDays.add(date);
               }else{
                   throw new Exception("Attenzione: ci sono già delle prenotazioni per questo giorno!");
               }
           }else{
               notWorkingDays.add(date);
           }
       }



}
