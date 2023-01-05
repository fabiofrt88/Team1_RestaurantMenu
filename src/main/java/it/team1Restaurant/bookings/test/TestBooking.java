package it.team1Restaurant.bookings.test;

import it.team1Restaurant.bookings.calendar.CalendarBookings;
import it.team1Restaurant.menu.TypeFoodEnum;
import it.team1Restaurant.user.Client;

import java.util.List;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.EnumSet;

/**
 * Questa classe viene utilizzata per testare il sistema di prenotazione del ristorante
 * e la creazione di un relativo calendario delle prenotazioni dei clienti
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class TestBooking {

    /**
     * Metodo main, rappresenta l'entrypoint di esecuzione della classe {@link it.team1Restaurant.bookings.test.TestBooking}
     * @param args Array di argomenti che possono essere digitati nel programma da terminale
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        CalendarBookings calendarBookings = CalendarBookings.getInstance();
        calendarBookings.createBookingsIntervalFromNow(30);

        Client client = new Client(1, "Pippo","Franco","pippofranco@gmail.com", "389-5264589", EnumSet.of(TypeFoodEnum.GENERIC));
        calendarBookings.book(1, client, List.of(client), getDateFromNow(4), LocalTime.of(12,30));
        calendarBookings.book(2, client, List.of(client), getDateFromNow(4), LocalTime.of(15,30));

        Client client2 = new Client(2, "Mario","Rossi","mariorossio@gmail.com", "389-6578904", EnumSet.of(TypeFoodEnum.VEGAN));
        calendarBookings.book(3, client2, List.of(client2) , getDateFromNow(6), LocalTime.of(13,00));

        calendarBookings.book(4, client, List.of(client), getDateFromNow(6), LocalTime.of(14,44));

        calendarBookings.printDetails();

        System.out.println("------------------------LIST BOOKINGS CLIENT----------------------------\n");
        client.printBookingsDetails();

        System.out.println("\n----------------------CALENDAR BOOKINGS CLIENT------------------------\n");
        client.printCalendarBookingDetails();

        System.out.println("\n----------------------GET BOOKING BY BOOKING NUMBER-------------------\n");
        System.out.println(client.getCalendarBookingsClient().getBookingByBookingNumber(1).getBookingDetails());

        System.out.println("-------------------------------------------------------");

    }

    /**
     * Questo metodo restituisce una data incrementando alla data odierna {@link LocalDate#now()} un numero dei giorni
     * passato come parametro nel metodo
     * @param numberOfDaysToAdd Il numero dei giorni da aggiungere alla data odierna
     * @return La data ottenuta a partire da quella odierna incrementata con il numero di giorni
     * passato come parametro nel metodo
     */
    public static LocalDate getDateFromNow (int numberOfDaysToAdd){
        return LocalDate.now().plusDays(numberOfDaysToAdd);
    }
}
