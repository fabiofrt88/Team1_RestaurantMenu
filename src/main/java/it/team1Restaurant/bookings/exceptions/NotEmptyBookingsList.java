package it.team1Restaurant.bookings.exceptions;

import it.team1Restaurant.bookings.calendar.Day;
import it.team1Restaurant.foods.Food;

import java.time.LocalDate;
import java.util.Set;

/**
 * Questa classe viene utilizzata per lanciare delle eccezioni personalizzate sulle liste aventi delle prenotazioni. <br>
 * È una sottoclasse della classe {@link java.lang.Exception}
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class NotEmptyBookingsList extends Exception{

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.bookings.exceptions.NotEmptyBookingsList},
     * crea un'eccezione con un message mediante il metodo costruttore {@link java.lang.Exception#Exception(String)}
     * della relativa superclasse {@link java.lang.Exception}.
     * @param targetDay Il giorno selezionato suscettibile di eccezione
     */
    public NotEmptyBookingsList (Day targetDay) {
        super("Il giorno " + targetDay.getDate() + " sono presenti delle prenotazioni.");
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.bookings.exceptions.NotEmptyBookingsList},
     * crea un'eccezione con un message mediante il metodo costruttore {@link java.lang.Exception#Exception(String)}
     * della relativa superclasse {@link java.lang.Exception}.
     * @param targetDate La data selezionata suscettibile di eccezione
     */
    public NotEmptyBookingsList(LocalDate targetDate){
        super("Il giorno " + targetDate + " sono presenti delle prenotazioni.");
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.bookings.exceptions.NotEmptyBookingsList},
     * crea un'eccezione con un message mediante il metodo costruttore {@link java.lang.Exception#Exception(String)}
     * della relativa superclasse {@link java.lang.Exception}.
     * @param targetDays Il Set di date suscettibili di eccezione
     */
    public NotEmptyBookingsList(Set<Day> targetDays){
        super("Nei giorni: " + createStringOfDates(targetDays) + " sono già presenti delle prenotazioni" );
    }

    /**
     * Questo metodo ritorna una stringa contenente le date selezionate suscettibili di eccezione. <br>
     * Ad ogni iterazione della lista delle date, verrà concatenata una stringa con la data
     * del day corrente restituita dal metodo {@link Day#getDate()}
     * @return Stringa contenente le date selezionate suscettibili di eccezione
     */
    private static String createStringOfDates (Set<Day> targetDays){
        String str = "";
        for(Day day : targetDays){
            str += day.getDate()  +  " , ";
        }
        return str;
    }

}
