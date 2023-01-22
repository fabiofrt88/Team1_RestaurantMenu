package it.team1Restaurant.user;

import it.team1Restaurant.bookings.Booking;
import it.team1Restaurant.bookings.calendar.CalendarBookingsClient;
import it.team1Restaurant.menu.TypeFoodEnum;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Questa classe rappresenta un cliente del ristorante.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class Client {

    /**
     * Il codice identificativo del client (chiave primaria univoca autoincrementale non modificabile).
     */
    private final Integer id;

    /**
     * EnumSet delle tipologie alimentari del cliente. Vedi enum {@link TypeFoodEnum}
     */
    private EnumSet<TypeFoodEnum> typeSet;

    /**
     * Il nome del cliente.
     */
    private String name;

    /**
     * Il cognome del cliente.
     */
    private String surname;

    /**
     * L'indirizzo email del cliente.
     */
    private String email;

    /**
     * Il numero di telefono del cliente.
     */
    private String phoneNumber;

    /**
     * Flag booleana che indica se il cliente è un adulto oppure un bambino.
     */
    private boolean isChild;

    /*private List<Booking> bookingList = new ArrayList<>();

    private CalendarBookingsClient calendarBookingsClient = new CalendarBookingsClient();*/

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.user.Client},
     * setta le variabili d'istanza con i relativi parametri passati nel costruttore,
     * EnumSet delle tipologie alimentari inizializzato di default con la tipologia {@link TypeFoodEnum#GENERIC}
     * @param name Il nome del cliente
     * @param surname Il cognome del cliente
     */
    public Client(String name, String surname) {
        this.id = null;
        this.name = name;
        this.surname = surname;
        this.typeSet = EnumSet.of(TypeFoodEnum.GENERIC);
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.user.Client},
     * setta le variabili d'istanza con i relativi parametri passati nel costruttore,
     * @param typeSet EnumSet delle tipologie alimentari del cliente
     * @param name Il nome del cliente
     * @param surname Il cognome del cliente
     * @param email L'email del cliente
     * @param phoneNumber Il numero di telefono del cliente
     */
    public Client(Integer id, String name, String surname, String email, String phoneNumber, EnumSet<TypeFoodEnum> typeSet) {
        this.id = id;
        this.typeSet = initTypeSet(typeSet);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    /**
     * Metodo getter che restituisce il nome del cliente.
     * @return Nome del cliente.
     */
    public String getName() {
        return name;
    }

    /**
     * Metodo setter che setta il nome del cliente.
     * @param name Il nome del cliente.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Metodo getter che restituisce il cognome del cliente.
     * @return Cognome del cliente.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Metodo setter che setta il cognome del cliente.
     * @param surname Il cognome del cliente.
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Metodo getter che restituisce l'indirizzo email cliente.
     * @return Indirizzo email del cliente.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo setter che setta l'indirizzo email del cliente.
     * @param email L'indirizzo email del cliente.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo getter che restituisce il numero di telefono cliente.
     * @return Numero di telefono del cliente.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Metodo setter che setta il numero di telefono del cliente.
     * @param phoneNumber Il numero di telefono del cliente.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Metodo getter che restituisce la flag booleana isChild.
     * @return La flag booleana isChild.
     */
    public boolean isChild() {
        return isChild;
    }

    /**
     * Metodo setter che setta la flag booleana isChild.
     * @param isChild La flag booleana isChild.
     */
    public void setChild(boolean isChild) {
        this.isChild = isChild;
    }

    /**
     * Metodo getter che restituisce l'EnumSet delle tipologie alimentari del cliente.
     * @return EnumSet delle tipologie alimentari del cliente.
     */
    public EnumSet<TypeFoodEnum> getTypeSet() {
        return typeSet;
    }

    /**
     * Metodo setter che setta l'EnumSet delle tipologie alimentari del cliente.
     * @param typeSet l'EnumSet delle tipologie alimentari del cliente.
     */
    public void setTypeSet(EnumSet<TypeFoodEnum> typeSet) {
        this.typeSet = typeSet;
    }

    /*public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public CalendarBookingsClient getCalendarBookingsClient() {
        return calendarBookingsClient;
    }

    public void setCalendarBookingsClient(CalendarBookingsClient calendarBookingsClient) {
        this.calendarBookingsClient = calendarBookingsClient;
    }*/

    public EnumSet<TypeFoodEnum> initTypeSet(EnumSet<TypeFoodEnum> typeSet){
        return (typeSet != null) ? typeSet : EnumSet.noneOf(TypeFoodEnum.class);
    }

    public static Booking book(Client client, List<Client> clientList, LocalDate date, LocalTime time){
        return new Booking(null, client, clientList, Booking.getBookedAtDate(), date, time);
    }

    /*public void printBookingsDetails(){
        System.out.printf("Bookings of %s %s\n\n", this.name, this.surname);
        for(Booking booking : bookingList){
            System.out.println(booking.getBookingDetails());
        }
    }

    public void printCalendarBookingDetails(){
        System.out.printf("Bookings of %s %s\n\n", this.name, this.surname);
        calendarBookingsClient.printCalendarBookingDetails();
    }

    /*public void addBooking(Booking booking){
        if(!this.bookingList.contains(booking)){
            this.bookingList.add(booking);
        }
        else{
            System.out.println("\nPrenotazione già inserita\n");
        }
    }*/

    /**
     * Questo metodo stampa i dati del cliente.
     */
    public void printDetails(){
        System.out.println("User details" +
                "\nId: " + id +
                "\nType: " + typeSet +
                "\nName: " + name +
                "\nSurname: " + surname +
                "\nEmail: " + email +
                "\nPhone Number: " + phoneNumber);
    }

    /**
     * Override del metodo {@link Object#toString()}, restituisce i dati del cliente.
     * @return Stringa con i dati del cliente.
     */
    @Override
    public String toString() {
        return "Client{" +
                "id: " + id +
                ", type: " + typeSet +
                ", name: " + name +
                ", surname: " + surname +
                ", email: " + email +
                ", phoneNumber: " + phoneNumber +
                //", isChild: " + isChild +
                '}';
    }
}
