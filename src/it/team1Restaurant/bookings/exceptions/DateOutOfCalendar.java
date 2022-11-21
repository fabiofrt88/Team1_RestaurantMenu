package it.team1Restaurant.bookings.exceptions;

public class DateOutOfCalendar extends Exception{
    public DateOutOfCalendar() {
        super("La data inserita non e' attualmente valida.");
    }
}
