package it.team1Restaurant.bookings.calendar;

import it.team1Restaurant.menu.Menu;
import it.team1Restaurant.menu.TypeDishClientEnum;
import it.team1Restaurant.menu.TypeMenuEnum;
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
    private final int bookingNumber;

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
    //private int tableNumber;
    //private int numberOfAdult;
    //private int numberOfChildren;
    //private int numberOfVegetarian;
    //private int numberOfVegan;
    //private int numberOfCeliac;

    /**
     * Contatore delle prenotazioni (inizializzato con il valore 0)
     */
    private static int bookingNumbers = 0;

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.bookings.calendar.Booking},
     * setta le variabili d'istanza della classe con i relativi parametri passati nel costruttore,
     * viene istanziata una lista di clienti inizialmente vuota
     * @param client Il cliente che effettua la prenotazione
     * @param bookedAt Il timestamp della prenotazione effettuata
     * @param date La data della prenotazione
     * @param time L'orario inserito nella prenotazione
     */
    public Booking(Client client, String bookedAt, LocalDate date, LocalTime time) {
        this.bookingNumber = incrementBookingNumbers();
        this.client = client;
        this.clientList = new ArrayList<>();
        this.bookedAt = bookedAt;
        this.date = date;
        this.time = time;
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.bookings.calendar.Booking},
     * setta le variabili d'istanza della classe con i relativi parametri passati nel costruttore,
     * @param client Il cliente che effettua la prenotazione
     * @param clientList La lista dei clienti inseriti nella prenotazione
     * @param bookedAt Il timestamp della prenotazione effettuata
     * @param date La data della prenotazione
     * @param time L'orario inserito nella prenotazione
     */
    public Booking(Client client, List<Client> clientList, String bookedAt, LocalDate date, LocalTime time) {
        this.bookingNumber = incrementBookingNumbers();
        this.client = client;
        this.clientList = clientList;
        this.bookedAt = bookedAt;
        this.date = date;
        this.time = time;
    }

    /*
    public Booking(Client client, String bookedAt, LocalDate date, LocalTime time, int numberOfAdult, int numberOfChildren, int numberOfVegetarian, int numberOfVegan, int numberOfCeliac) {
        this.bookingNumber = incrementBookingNumbers();
        this.client = client;
        this.bookedAt = bookedAt;
        this.date = date;
        this.time = time;
        this.numberOfAdult = numberOfAdult;
        this.numberOfChildren = numberOfChildren;
        this.numberOfVegetarian = numberOfVegetarian;
        this.numberOfVegan = numberOfVegan;
        this.numberOfCeliac = numberOfCeliac;
    }*/

    /**
     * Metodo getter che restituisce il numero identificativo della prenotazione.
     * @return Numero identificativo della prenotazione.
     */
    public int getBookingNumber() {
        return bookingNumber;
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

    /**
     * Metodo getter che restituisce il numero corrente delle prenotazioni effettuate
     * @return Numero corrente delle prenotazioni effettuate
     */
    public static int getBookingNumbers() {
        return bookingNumbers;
    }

    /**
     * Metodo setter che setta il numero delle prenotazioni precedentemente inizializzato a 0 <br>
     * La modifica del numero delle prenotazioni avrà luogo soltanto se il nuovo numero è maggiore di quello corrente,
     * onde evitare che le nuove prenotazioni possano avere in seguito lo stesso numero di prenotazione di quelle precedenti
     * @param bookingNumbers Numero delle prenotazioni (contatore)
     */
    public static void setBookingNumbers(int bookingNumbers) {
        if(bookingNumbers > Booking.bookingNumbers){
            Booking.bookingNumbers = bookingNumbers;
        }
    }

    /**
     * Questo metodo incrementa di uno il numero delle prenotazioni alla creazione di una prenotazione <br>
     * Il suo valore verrà assegnato alla variabile {@link Booking#bookingNumber} come numero identificativo
     * della prenotazione alla creazione della prenotazione nel suo costruttore, pertanto ogni prenotazione presenterà
     * un codice numerico autoincrementale che le identificherà univocamente dalle altre prenotazioni
     * @return Numero delle prenotazioni incrementato di uno
     */
    public static int incrementBookingNumbers(){
        return ++bookingNumbers;
    }

    /**
     * Questo metodo restituisce il timestamp della prenotazione effettuata (non modificabile), <br>
     * si tratta di una stringa formattata opportunamente secondo pattern a partire da un'istanza di {@link java.util.Date}
     * @return Timestamp della prenotazione effettuata (non modificabile)
     */
    public String getBookedAtDate(){
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en", "EN"));
        return simpleDateFormat.format(new Date());
    }

    /**
     * Questo metodo restituisce il numero dei clienti per tipologia alimentare mediante utilizzo degli stream
     * @param typeDishClient La lista dei clienti inseriti nella prenotazione
     * @return Il numero dei clienti per tipologia alimentare
     */
    public Integer getNumberOf(TypeDishClientEnum typeDishClient){
        return clientList.stream().filter(client -> client.getTypeDishClient().contains(typeDishClient)).collect(Collectors.toSet()).size();
    }

    /**
     * Questo metodo restituisce nel dettaglio i dati della prenotazione
     * @return Stringa contenente i dati della prenotazione
     */
    public String getBookingDetails() {
        return "Booking #" + bookingNumber +
                "\n\nBooked by: " + client +
                "\nBooked at: " + bookedAt +
                "\nDate: " + date +
                "\nTime: " + time +
                //"\ntableNumber: " + tableNumber +
                "\nNumber of People: " + (clientList.size()) +
                "\nNumber of Adults: " + (clientList.size() - getNumberOf(TypeDishClientEnum.CHILD)) +
                "\nNumber of Children: " + getNumberOf(TypeDishClientEnum.CHILD);
    }

    /**
     * Questo metodo stampa a video nel dettaglio i dati della prenotazione
     */
    public void printDetails() {
        System.out.println("Booking #" + bookingNumber +
                "\n\nBooked by: " + client +
                "\nBooked at: " + bookedAt +
                "\nDate: " + date +
                "\nTime: " + time +
                //"\nTable Number: " + tableNumber +
                "\nNumber of People: " + (clientList.size()) +
                "\nNumber of Adults: " + (clientList.size() - getNumberOf(TypeDishClientEnum.CHILD)) +
                "\nNumber of Children: " + getNumberOf(TypeDishClientEnum.CHILD) + "\n");
    }

    /*public static void checkBookingInfo(Booking booking, EnumMap<TypeMenu, Menu> menuMap) {
        System.out.println(menuMap.get(TypeMenu.MEAT).getMenuDetails());
        System.out.println(menuMap.get(TypeMenu.FISH).getMenuDetails());
        if (booking.getNumberOfChildren() > 0) {
            for (TypeMenu typeMenu : menuMap.keySet()) {
                if (typeMenu.equals(TypeMenu.CHILD)) {
                    System.out.println(menuMap.get(typeMenu).getMenuDetails());
                }
            }
        }
        if (booking.getNumberOfVegetarian() > 0) {
            for (TypeMenu typeMenu : menuMap.keySet()) {
                if (typeMenu.equals(TypeMenu.VEGETARIAN)) {
                    System.out.println(menuMap.get(typeMenu).getMenuDetails());
                }
            }
        }
        if (booking.getNumberOfVegan() > 0) {
            for (TypeMenu typeMenu : menuMap.keySet()) {
                if (typeMenu.equals(TypeMenu.VEGAN)) {
                    System.out.println(menuMap.get(typeMenu).getMenuDetails());
                }
            }
        }
        if (booking.getNumberOfCeliac() > 0) {
            for (TypeMenu typeMenu : menuMap.keySet()) {
                if (typeMenu.equals(TypeMenu.CELIAC)) {
                    System.out.println(menuMap.get(typeMenu).getMenuDetails());
                }
            }
        }
    }*/

    /**
     * Questo metodo stampa a video nel dettaglio i dati dei menu. <br>
     * Diversamente dai menu a base di carne {@link it.team1Restaurant.menu.TypeMenuEnum#MEAT}
     * e di pesce {@link it.team1Restaurant.menu.TypeMenuEnum#FISH}, per quelli delle tipologie
     * {@link it.team1Restaurant.menu.TypeMenuEnum#CHILD}, {@link it.team1Restaurant.menu.TypeMenuEnum#VEGETARIAN},
     * {@link it.team1Restaurant.menu.TypeMenuEnum#VEGAN} e {@link it.team1Restaurant.menu.TypeMenuEnum#CELIAC},
     * prima della stampa dei menu, si verifica dalla lista dei clienti della prenotazione se sono presenti
     * rispettivamente clienti bambini, vegetariani, vegani e celiaci
     * @param booking La prenotazione selezionata da controllare
     * @param menuMap La mappa dei menu differenziati per tipologia alimentare
     */
    public static void checkBookingInfo(Booking booking, EnumMap<TypeMenuEnum, Menu> menuMap) {
        System.out.println(menuMap.get(TypeMenuEnum.MEAT).getMenuDetails());
        System.out.println(menuMap.get(TypeMenuEnum.FISH).getMenuDetails());
        if (booking.getNumberOf(TypeDishClientEnum.CHILD) > 0) {
            System.out.println(menuMap.get(TypeMenuEnum.CHILD).getMenuDetails());
        }
        if (booking.getNumberOf(TypeDishClientEnum.VEGETARIAN) > 0) {
            System.out.println(menuMap.get(TypeMenuEnum.VEGETARIAN).getMenuDetails());
        }
        if (booking.getNumberOf(TypeDishClientEnum.VEGAN) > 0) {
            System.out.println(menuMap.get(TypeMenuEnum.VEGAN).getMenuDetails());
        }
        if (booking.getNumberOf(TypeDishClientEnum.CELIAC) > 0) {
            System.out.println(menuMap.get(TypeMenuEnum.CELIAC).getMenuDetails());
        }
    }
}

