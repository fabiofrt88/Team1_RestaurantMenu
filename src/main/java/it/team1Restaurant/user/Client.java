package it.team1Restaurant.user;

import it.team1Restaurant.bookings.calendar.Booking;
import it.team1Restaurant.bookings.calendar.CalendarBookingsClient;
import it.team1Restaurant.menu.TypeDishClientEnum;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Questa classe rappresenta un cliente del ristorante.
 * @author Fabio Frattarelli, Pietro Gallina, Francesco Consiglio, Giovanni Tirone, Dino Petrucci, Christian Carollo
 * @version 1.0
 */
public class Client {

    private final Integer id;

    /**
     * EnumSet delle tipologie alimentari del cliente. Vedi enum {@link it.team1Restaurant.menu.TypeDishClientEnum}
     */
    private EnumSet<TypeDishClientEnum> typeDishClient;

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

    private List<Booking> bookingList = new ArrayList<>();

    private CalendarBookingsClient calendarBookingsClient = new CalendarBookingsClient();

    private static Integer clientNumbers = 0;

    /**
     * Metodo costruttore di default non parametrico della classe {@link it.team1Restaurant.user.Client}
     */
    public Client () {
        this.id = incrementClientNumbers();
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.user.Client},
     * setta la variabile d'istanza booleana isChild con il relativo parametro passato nel costruttore
     * @param isChild La flag booleana che indica se il cliente è un adulto oppure un bambino.
     */
    public Client (boolean isChild){
        this.id = incrementClientNumbers();
        this.isChild = isChild;
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.user.Client},
     * setta le variabili d'istanza con i relativi parametri passati nel costruttore,
     * EnumSet delle tipologie alimentari inizializzato di default con la tipologia {@link it.team1Restaurant.menu.TypeDishClientEnum#GENERIC}
     * @param name Il nome del cliente
     * @param surname Il cognome del cliente
     */
    public Client(String name, String surname) {
        this.id = incrementClientNumbers();
        this.name = name;
        this.surname = surname;
        this.typeDishClient = EnumSet.of(TypeDishClientEnum.GENERIC);
    }

    /**
     * Metodo costruttore della classe {@link it.team1Restaurant.user.Client},
     * setta le variabili d'istanza con i relativi parametri passati nel costruttore,
     * @param typeDishClient EnumSet delle tipologie alimentari del cliente
     * @param name Il nome del cliente
     * @param surname Il cognome del cliente
     * @param email L'email del cliente
     * @param phoneNumber Il numero di telefono del cliente
     */
    public Client(EnumSet<TypeDishClientEnum> typeDishClient, String name, String surname, String email, String phoneNumber) {
        this.id = incrementClientNumbers();
        this.typeDishClient = typeDishClient;
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
    public EnumSet<TypeDishClientEnum> getTypeDishClient() {
        return typeDishClient;
    }

    /**
     * Metodo setter che setta l'EnumSet delle tipologie alimentari del cliente.
     * @param typeDishClient l'EnumSet delle tipologie alimentari del cliente.
     */
    public void setTypeDishClient(EnumSet<TypeDishClientEnum> typeDishClient) {
        this.typeDishClient = typeDishClient;
    }

    public List<Booking> getBookingList() {
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
    }

    public static Integer getClientNumbers() {
        return clientNumbers;
    }

    public static void setClientNumbers(Integer clientNumbers) {
        Client.clientNumbers = clientNumbers;
    }

    public static int incrementClientNumbers(){
        return ++clientNumbers;
    }

    public void printBookingsDetails(){
        System.out.printf("Bookings of %s %s\n\n", this.name, this.surname);
        for(Booking booking : bookingList){
            System.out.println(booking.getBookingDetails() + "\n");
        }
    }

    public void printCalendarBookingDetails(){
        System.out.printf("Bookings of %s %s\n\n", this.name, this.surname);
        calendarBookingsClient.printCalendarBookingDetails();
    }

    public void addBooking(Booking booking){
        if(!this.bookingList.contains(booking)){
            this.bookingList.add(booking);
        }
        else{
            System.out.println("\nPrenotazione già inserita\n");
        }
    }

    /**
     * Questo metodo stampa i dati del cliente.
     */
    public void printDetails(){
        System.out.println("User details" +
                "\nType: " + typeDishClient.toString() +
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
                "id: " + id + '\'' +
                ", type: " + typeDishClient.toString() + '\'' +
                ", name: " + name + '\'' +
                ", surname: " + surname + '\'' +
                ", email: " + email + '\'' +
                ", phoneNumber: " + phoneNumber + '\'' +
                ", isChild: " + isChild +
                '}';
    }
}
