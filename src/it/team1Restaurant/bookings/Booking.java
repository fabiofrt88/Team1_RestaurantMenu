package it.team1Restaurant.bookings;

import it.team1Restaurant.user.Client;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

public class Booking {

    private final int bookingNumber;
    private Client client;
    private final String bookedAt;
    private LocalDate date;
    private LocalTime time;
    private int tableNumber;
    private int numberOfAdult;
    private int numberOfChildren;
    private static int bookingNumbers = 0;

    public Booking (Client client, String bookedAt, LocalDate date, LocalTime time, int numberOfAdult, int numberOfChildren) {
        this.bookingNumber = incrementBookingNumbers();
        this.client = client;
        this.bookedAt = bookedAt;
        this.date = date;
        this.time = time;
        this.numberOfAdult = numberOfAdult;
        this.numberOfChildren = numberOfChildren;
    }

    public Booking (Client client, String bookedAt, LocalDate date, LocalTime time, int tableNumber, int numberOfAdult, int numberOfChildren) {
        this.bookingNumber = incrementBookingNumbers();
        this.client = client;
        this.bookedAt = bookedAt;
        this.date = date;
        this.time = time;
        this.tableNumber = tableNumber;
        this.numberOfAdult = numberOfAdult;
        this.numberOfChildren = numberOfChildren;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getBookedAt() {
        return bookedAt;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getNumberOfAdult() {
        return numberOfAdult;
    }

    public void setNumberOfAdult(int numberOfAdult) {
        this.numberOfAdult = numberOfAdult;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public static int getBookingNumbers() {
        return bookingNumbers;
    }

    public static void setBookingNumbers(int bookingNumbers) {
        Booking.bookingNumbers = bookingNumbers;
    }


    public static int incrementBookingNumbers(){ return ++bookingNumbers; }

    public String getBookingDetails() {
        return "Booking #" + bookingNumber +
                "\n\nBooked by: " + client +
                "\nBooked at: " + bookedAt +
                "\nDate: " + date +
                "\nTime: " + time +
                //"\ntableNumber: " + tableNumber +
                "\nNumber of People: " + (numberOfAdult + numberOfChildren) +
                "\nNumber of Adults: " + numberOfAdult +
                "\nNumber of Children: " + numberOfChildren;
    }

    public void printDetails(){
        System.out.println("Booking #" + bookingNumber +
                "\n\nBooked by: " + client +
                "\nBooked at: " + bookedAt +
                "\nDate: " + date +
                "\nTime: " + time +
                //"\nTable Number: " + tableNumber +
                "\nNumber of People: " + (numberOfAdult + numberOfChildren) +
                "\nNumber of Adults: " + numberOfAdult +
                "\nNumber of Children: " + numberOfChildren + "\n");
    }
}
