package it.team1Restaurant.bookings.exceptions;

import it.team1Restaurant.bookings.calendar.Day;

import java.time.LocalDate;
import java.util.Set;

public class NotEmptyBookingsList extends Exception{
    public NotEmptyBookingsList (Day targetDay) {
        super("Il giorno " + targetDay.getDate() + " sono presenti delle prenotazioni.");
    }

    public NotEmptyBookingsList(LocalDate targetDate){
        super("Il giorno " + targetDate + " sono presenti delle prenotazioni.");
    }

    public NotEmptyBookingsList(Set<Day> targetDays){
        super("Nei giorni: " + createStringOfDates(targetDays) + " sono già presenti delle prenotazioni" );
    }

    private static  String createStringOfDates (Set<Day> targetDays){
        String str = "";
        for(Day day : targetDays){
            str += day.getDate()  +  " , ";
        }
        return str;
    }

}
