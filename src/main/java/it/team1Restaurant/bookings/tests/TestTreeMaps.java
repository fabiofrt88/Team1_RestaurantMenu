package it.team1Restaurant.bookings.tests;

import it.team1Restaurant.bookings.calendar.CalendarBookings;
import it.team1Restaurant.bookings.calendar.Day;
import it.team1Restaurant.bookings.calendar.WorkingDayEnum;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Questa classe viene utilizzata per testare il sistema di prenotazione del ristorante
 * e la creazione di un relativo calendario delle prenotazioni dei clienti mediante l'uso dei metodi della {@link java.util.TreeMap}
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class TestTreeMaps {

    /**
     * Metodo main, rappresenta l'entrypoint di esecuzione della classe {@link it.team1Restaurant.bookings.tests.TestTreeMaps}
     * @param args Array di argomenti che possono essere digitati nel programma da terminale
     * @throws Exception
     */
    public static void main(String[] args) {

        CalendarBookings calendarBookings = CalendarBookings.getInstance();

        calendarBookings.printDetails();

        calendarBookings.getBookingsMap().put(new Day(LocalDate.now(), WorkingDayEnum.WORKING), new ArrayList<>());
        calendarBookings.getBookingsMap().put(new Day(LocalDate.now(),WorkingDayEnum.NOT_WORKING),new ArrayList<>());

        calendarBookings.printDetails();

        calendarBookings.getBookingsMap().keySet().stream().forEach(key -> System.out.println(key.getDetails()));
        System.out.println(calendarBookings.getBookingsMap().keySet().size());

    }

}
