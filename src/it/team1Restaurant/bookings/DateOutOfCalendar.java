package it.team1Restaurant.bookings;

public class DateOutOfCalendar extends Exception{
    public DateOutOfCalendar() {
        super("La data inserita non è attualmente valida.");
    }
}
