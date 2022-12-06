package it.team1Restaurant.bookings.exceptions;

/**
 * Questa classe viene utilizzata per lanciare delle eccezioni personalizzate sulle date. <br>
 * È una sottoclasse della classe {@link java.lang.Exception}
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class DateOutOfCalendar extends Exception{

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.bookings.exceptions.DateOutOfCalendar}, <br>
     * crea un'eccezione con un message mediante il metodo costruttore {@link java.lang.Exception#Exception(String)}
     * della relativa superclasse {@link java.lang.Exception}.
     */
    public DateOutOfCalendar() {
        super("La data inserita non e' attualmente valida.");
    }

}
