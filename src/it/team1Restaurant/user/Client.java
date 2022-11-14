package it.team1Restaurant.user;
import it.team1Restaurant.bookings.Booking;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Client {

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private boolean isChild;
    //private List<Booking> bookingList = new ArrayList<>();

    public Client () {} ;

    public Client (boolean isChild){
        this.isChild = isChild;
    }

    //da chiedere se settare email e phone number come stringhe vuote
    public Client(String name, String surname, boolean isChild) {
        this.name = name;
        this.surname = surname;
        this.isChild = isChild;
    }

    public Client(String name, String surname, String email, String phoneNumber, boolean isChild) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isChild = isChild;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getSurname() { return surname;}

    public void setSurname(String surname) {this.surname = surname;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public boolean isChild() {return isChild;}

    public void setChild(boolean child) {isChild = child;}

    /*public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }*/

    public Booking book(LocalDate date, LocalTime time, int numberOfAdults, int numberOfChildren) throws Exception {
        Booking book = new Booking(this, this.getBookedAtDate(), date, time, numberOfAdults, numberOfChildren);
        //this.bookingList.add(book);
        return book;
    }

    public String getBookedAtDate(){
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en", "EN"));
        return simpleDateFormat.format(new Date());
    }

    /*public void printBookingsDetails(){
        System.out.printf("Bookings of %s %s\n\n", this.name, this.surname);
        for(Booking book : bookingList){
            System.out.println(book.getBookingDetails() + "\n");
        }
    }*/

    public void printDetails(){
        System.out.println("User details" +
                "\nName: " + name +
                "\nSurname: " + surname +
                "\nEmail: " + email +
                "\nPhone Number: " + phoneNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name: " + name + '\'' +
                ", surname: " + surname + '\'' +
                ", email: " + email + '\'' +
                ", phoneNumber: " + phoneNumber + '\'' +
                ", isChild: " + isChild +
                '}';
    }
}
