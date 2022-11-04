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

    public Booking book(Group group, LocalDate date, LocalTime time) {

        return new Booking(this, group, this.getBookedAtDate(), date, time);
    }

    public Booking book(LocalDate date, LocalTime time, int peopleNumber, int childNumber) throws Exception {
        Group group = this.createGroup(peopleNumber, childNumber);
        return new Booking(this, group, this.getBookedAtDate(), date, time);
    }

    public Group createGroup(int peopleNumber, int childNumber) throws Exception {
        if(childNumber > peopleNumber) throw new Exception("The number of children must be less than the people number");
        if(this.isChild) throw new Exception("A child cannot book");
        Group group = new Group();
        group.addClient(this);
        for(int i=1; i<peopleNumber-childNumber; i++) {
            group.addClient(new Client(false));
        }
        for(int i=0; i<childNumber; i++){
            group.addClient(new Client(true));
        }
        return group;
    }

    public String getBookedAtDate(){
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en", "EN"));
        return simpleDateFormat.format(new Date());
    }

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
