package it.team1Restaurant.bookings;

import it.team1Restaurant.menu.Menu;
import it.team1Restaurant.menu.TypeFoodEnum;
import it.team1Restaurant.user.Client;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Questa classe rappresenta una prenotazione di un cliente da inserire nel calendario delle prenotazioni.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class Booking {

    /**
     * Il numero identificativo della prenotazione (codice numerico univoco autoincrementale non modificabile)
     */
    private final Integer id;

    /**
     * Il cliente che ha effettuato la prenotazione
     */
    private Client client;

    /**
     * La lista dei clienti (guests) inseriti nella prenotazione
     */
    private List<Client> clientList;

    /**
     * Il timestamp della prenotazione effettuata (non modificabile)
     */
    private final String bookedAt;

    /**
     * La data prenotata inserita nella prenotazione
     */
    private LocalDate date;

    /**
     * L'orario inserito nella prenotazione
     */
    private LocalTime time;

    /**
     * Metodo costruttore della classe {@link Booking},
     * setta le variabili d'istanza della classe con i relativi parametri passati nel costruttore,
     * viene istanziata una lista di clienti inizialmente vuota
     * @param id Il codice identificativo della prenotazione
     * @param client Il cliente che effettua la prenotazione
     * @param bookedAt Il timestamp della prenotazione effettuata
     * @param date La data della prenotazione
     * @param time L'orario inserito nella prenotazione
     */
    public Booking(Integer id, Client client, String bookedAt, LocalDate date, LocalTime time) {
        this.id = id;
        this.client = client;
        this.clientList = new ArrayList<>(Arrays.asList(client));
        this.bookedAt = bookedAt;
        this.date = date;
        this.time = time;
    }

    /**
     * Metodo costruttore della classe {@link Booking},
     * setta le variabili d'istanza della classe con i relativi parametri passati nel costruttore,
     * @param id Il codice identificativo della prenotazione
     * @param client Il cliente che effettua la prenotazione
     * @param clientList La lista dei clienti inseriti nella prenotazione
     * @param bookedAt Il timestamp della prenotazione effettuata
     * @param date La data della prenotazione
     * @param time L'orario inserito nella prenotazione
     */
    public Booking(Integer id, Client client, List<Client> clientList, String bookedAt, LocalDate date, LocalTime time) {
        this.id = id;
        this.client = client;
        this.clientList = initClientList(clientList);
        this.bookedAt = bookedAt;
        this.date = date;
        this.time = time;
    }

    /**
     * Metodo getter che restituisce il numero identificativo della prenotazione.
     * @return Numero identificativo della prenotazione.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Metodo getter che restituisce il cliente che ha effettuato la prenotazione.
     * @return Cliente che ha effettuato la prenotazione.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Metodo setter che setta il cliente che ha effettuato la prenotazione.
     * @param client Il cliente che ha effettuato la prenotazione.
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Metodo getter che restituisce il timestamp della prenotazione effettuata.
     * @return Timestamp della prenotazione effettuata.
     */
    public String getBookedAt() {
        return bookedAt;
    }

    /**
     * Metodo getter che restituisce la data prenotata inserita nella prenotazione
     * @return Data prenotata inserita nella prenotazione
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Metodo setter che setta la data selezionata da inserire nella prenotazione.
     * @param date La data selezionata da inserire nella prenotazione.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Metodo getter che restituisce l'orario inserito nella prenotazione
     * @return Orario selezionato inserito nella prenotazione
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * Metodo setter che setta l'orario da inserire nella prenotazione.
     * @param time L'orario selezionato da inserire nella prenotazione.
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public List<Client> initClientList(List<Client> clientList){
        return (clientList != null && !clientList.isEmpty()) ? new ArrayList<>(clientList) : new ArrayList<>(Arrays.asList(client));
    }

    /**
     * Questo metodo restituisce il timestamp della prenotazione effettuata (non modificabile), <br>
     * si tratta di una stringa formattata opportunamente secondo pattern a partire da un'istanza di {@link java.util.Date}
     * @return Timestamp della prenotazione effettuata (non modificabile)
     */
    public static String getBookedAtDate(){
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en", "EN"));
        return simpleDateFormat.format(new Date());
    }

    /**
     * Questo metodo restituisce il numero dei clienti per tipologia alimentare mediante utilizzo degli stream
     * @param typeFood La lista delle tipologie alimentari dei clienti inseriti nella prenotazione
     * @return Il numero dei clienti per tipologia alimentare
     */
    public Integer getNumberOf(TypeFoodEnum typeFood){
        return clientList.stream().filter(client -> client.getTypeSet().contains(typeFood)).collect(Collectors.toSet()).size();
    }

    /**
     * Questo metodo stampa a video nel dettaglio i dati della prenotazione
     */
    public void printDetails() {
        System.out.println("Booking #" + id +
                "\n\nBooked by: " + client +
                "\nBooked at: " + bookedAt +
                "\nDate: " + date +
                "\nTime: " + time +
                //"\nTable Number: " + tableNumber +
                "\nNumber of People: " + (clientList.size()) +
                "\nNumber of Adults: " + (clientList.size() - getNumberOf(TypeFoodEnum.CHILD)) +
                "\nNumber of Children: " + getNumberOf(TypeFoodEnum.CHILD) + "\n");
    }

    /**
     * Questo metodo restituisce nel dettaglio i dati della prenotazione
     * @return Stringa contenente i dati della prenotazione
     */
    public String getBookingDetails() {
        return "Booking #" + id +
                "\n\nBooked by: " + client +
                "\nBooked at: " + bookedAt +
                "\nDate: " + date +
                "\nTime: " + time +
                //"\ntableNumber: " + tableNumber +
                "\nNumber of People: " + (clientList.size()) +
                "\nNumber of Adults: " + (clientList.size() - getNumberOf(TypeFoodEnum.CHILD)) +
                "\nNumber of Children: " + getNumberOf(TypeFoodEnum.CHILD) + "\n";
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id = " + id +
                ", client = " + client +
                ", clientList = " + clientList +
                ", bookedAt = '" + bookedAt + '\'' +
                ", date = " + date +
                ", time = " + time +
                '}';
    }

    /**
     * Questo metodo stampa a video nel dettaglio i dati dei menu. <br>
     * Diversamente dai menu a base di carne {@link TypeFoodEnum#MEAT}
     * e di pesce {@link TypeFoodEnum#FISH}, per quelli delle tipologie
     * {@link TypeFoodEnum#CHILD}, {@link TypeFoodEnum#VEGETARIAN},
     * {@link TypeFoodEnum#VEGAN} e {@link TypeFoodEnum#CELIAC},
     * prima della stampa dei menu, si verifica dalla lista dei clienti della prenotazione se sono presenti
     * rispettivamente clienti bambini, vegetariani, vegani e celiaci
     * @param booking La prenotazione selezionata da controllare
     * @param menuMap La mappa dei menu differenziati per tipologia alimentare
     */
    public static void checkBookingMenu(Booking booking, EnumMap<TypeFoodEnum, Menu> menuMap) {
        System.out.println(menuMap.get(TypeFoodEnum.MEAT).getMenuDetails());
        System.out.println(menuMap.get(TypeFoodEnum.FISH).getMenuDetails());
        if (booking.getNumberOf(TypeFoodEnum.CHILD) > 0) {
            System.out.println(menuMap.get(TypeFoodEnum.CHILD).getMenuDetails());
        }
        if (booking.getNumberOf(TypeFoodEnum.VEGETARIAN) > 0) {
            System.out.println(menuMap.get(TypeFoodEnum.VEGETARIAN).getMenuDetails());
        }
        if (booking.getNumberOf(TypeFoodEnum.VEGAN) > 0) {
            System.out.println(menuMap.get(TypeFoodEnum.VEGAN).getMenuDetails());
        }
        if (booking.getNumberOf(TypeFoodEnum.CELIAC) > 0) {
            System.out.println(menuMap.get(TypeFoodEnum.CELIAC).getMenuDetails());
        }
    }
}

