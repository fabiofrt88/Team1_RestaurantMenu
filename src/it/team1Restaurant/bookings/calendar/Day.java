package it.team1Restaurant.bookings.calendar;

import java.time.LocalDate;

/**
 * Questa classe rappresenta un giorno (day) da inserire nel calendario delle prenotazioni.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class Day {

    /**
     * Lo stato di operatività del giorno. Vedi enum {@link it.team1Restaurant.bookings.calendar.WorkingDayEnum}
     */
    private WorkingDayEnum workingDay;

    /**
     * La data del giorno (day) da inserire nel calendario delle prenotazioni
     */
    private LocalDate date;

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.bookings.calendar.Day},
     * setta le variabili d'istanza della classe con i relativi parametri passati nel costruttore
     * @param date La data del giorno (day) da inserire nel calendario delle prenotazioni
     * @param workingDay Lo stato di operatività del giorno
     */
    public Day (LocalDate date, WorkingDayEnum workingDay){
        this.date = date;
        this.workingDay = workingDay;
    }

    /**
     * Metodo getter che restituisce lo stato di operatività del giorno.
     * @return Stato di operatività del giorno.
     */
    public WorkingDayEnum getWorkingDay() {
        return workingDay;
    }

    /**
     * Metodo setter che setta lo stato di operatività del giorno.
     * @param workingDay Lo stato di operatività del giorno.
     */
    public void setWorkingDay(WorkingDayEnum workingDay) {
        this.workingDay = workingDay;
    }

    /**
     * Metodo getter che restituisce la data del giorno.
     * @return Data del giorno.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Metodo setter che setta la data del giorno.
     * @param date La data del giorno.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Questo metodo restituisce i dati del giorno (data, nome del giorno della settimana, stato di operatività)
     * @return Stringa con i dati del giorno (data, nome del giorno della settimana, stato di operatività)
     */
    public String getDetails () {
        return "Date: " + date + ", " + date.getDayOfWeek().name().toLowerCase() + " - " + workingDay.name().toLowerCase() + " day" ;
    }

}
