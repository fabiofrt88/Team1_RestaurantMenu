package it.team1Restaurant.bookings;

import it.team1Restaurant.user.Client;
import it.team1Restaurant.user.Group;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {

    private final int bookingNumber;
    private Client client;
    private Group group;
    private String bookedAt;
    private LocalDate date;
    private LocalTime time;
    private int tableNumber;
    private static int bookingNumbers = 0;

    public Booking (Client client, Group group, String bookedAt, LocalDate date, LocalTime time) {
        this.bookingNumber = incrementBookingNumbers();
        this.client = client;
        this.group = group;
        this.bookedAt = bookedAt;
        this.date = date;
        this.time = time;
    }

    public Booking (Client client, Group group, String bookedAt, LocalDate date, LocalTime time, int tableNumber) {
        this.bookingNumber = incrementBookingNumbers();
        this.client = client;
        this.group = group;
        this.bookedAt = bookedAt;
        this.date = date;
        this.time = time;
        this.tableNumber = tableNumber;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(String bookedAt) {
        this.bookedAt = bookedAt;
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
                "\n\nGroup:" + group.getGroupDetails() +
                "\nBooked at: " + bookedAt +
                "\nDate: " + date +
                "\nTime: " + time +
                "\ntableNumber: " + tableNumber;
    }

    public void printDetails(){
        System.out.println("Booking #" + bookingNumber +
                "\n\nBooked by: " + client +
                "\n\nGroup:" + group.getGroupDetails() +
                "\nBooked at: " + bookedAt +
                "\nDate: " + date +
                "\nTime: " + time +
                //"\nTable Number: " + tableNumber +
                "\nNumber of People: " + group.getClientList().size() +
                "\nNumber of Adults: " + group.getNumberOfAdult() +
                "\nNumber of Children: " + group.getNumberOfChild() + "\n");
    }
}
