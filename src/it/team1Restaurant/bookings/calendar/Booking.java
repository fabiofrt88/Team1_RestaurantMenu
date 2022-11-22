package it.team1Restaurant.bookings;

import it.team1Restaurant.menu.Menu;
import it.team1Restaurant.menu.TypeDishClient;
import it.team1Restaurant.menu.TypeMenu;
import it.team1Restaurant.user.Client;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class Booking {

    private final int bookingNumber;
    private Client client;
    private List<Client> clientList;
    private final String bookedAt;
    private LocalDate date;
    private LocalTime time;
    //private int tableNumber;
    //private int numberOfAdult;
    //private int numberOfChildren;
    //private int numberOfVegetarian;
    //private int numberOfVegan;
    //private int numberOfCeliac;
    private static int bookingNumbers = 0;

    public Booking(Client client, String bookedAt, LocalDate date, LocalTime time) {
        this.bookingNumber = incrementBookingNumbers();
        this.client = client;
        this.clientList = new ArrayList<>();
        this.bookedAt = bookedAt;
        this.date = date;
        this.time = time;
    }

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

    public static int getBookingNumbers() {
        return bookingNumbers;
    }

    public static void setBookingNumbers(int bookingNumbers) {
        Booking.bookingNumbers = bookingNumbers;
    }

    public static int incrementBookingNumbers(){
        return ++bookingNumbers;
    }

    public Integer getNumberOf(TypeDishClient typeDishClient){
        return clientList.stream().filter(client -> client.getTypeDishClient().contains(typeDishClient)).collect(Collectors.toSet()).size();
    }

    public String getBookingDetails() {
        return "Booking #" + bookingNumber +
                "\n\nBooked by: " + client +
                "\nBooked at: " + bookedAt +
                "\nDate: " + date +
                "\nTime: " + time +
                //"\ntableNumber: " + tableNumber +
                "\nNumber of People: " + (clientList.size()) +
                "\nNumber of Adults: " + (clientList.size() - getNumberOf(TypeDishClient.CHILD)) +
                "\nNumber of Children: " + getNumberOf(TypeDishClient.CHILD);
    }

    public void printDetails() {
        System.out.println("Booking #" + bookingNumber +
                "\n\nBooked by: " + client +
                "\nBooked at: " + bookedAt +
                "\nDate: " + date +
                "\nTime: " + time +
                //"\nTable Number: " + tableNumber +
                "\nNumber of People: " + (clientList.size()) +
                "\nNumber of Adults: " + (clientList.size() - getNumberOf(TypeDishClient.CHILD)) +
                "\nNumber of Children: " + getNumberOf(TypeDishClient.CHILD) + "\n");
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

    public static void checkBookingInfo(Booking booking, EnumMap<TypeMenu, Menu> menuMap) {
        System.out.println(menuMap.get(TypeMenu.MEAT).getMenuDetails());
        System.out.println(menuMap.get(TypeMenu.FISH).getMenuDetails());
        if (booking.getNumberOf(TypeDishClient.CHILD) > 0) {
            System.out.println(menuMap.get(TypeMenu.CHILD).getMenuDetails());
        }
        if (booking.getNumberOf(TypeDishClient.VEGETARIAN) > 0) {
            System.out.println(menuMap.get(TypeMenu.VEGETARIAN).getMenuDetails());
        }
        if (booking.getNumberOf(TypeDishClient.VEGAN) > 0) {
            System.out.println(menuMap.get(TypeMenu.VEGAN).getMenuDetails());
        }
        if (booking.getNumberOf(TypeDishClient.CELIAC) > 0) {
            System.out.println(menuMap.get(TypeMenu.CELIAC).getMenuDetails());
        }
    }
}

