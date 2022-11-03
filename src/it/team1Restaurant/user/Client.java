package it.team1Restaurant.user;

import it.team1Restaurant.bookings.Booking;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private boolean isChild;

    public Client () {} ;

    public Client ( boolean isChild){
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

    public Booking book (LocalDate date, LocalTime time, int peopleNumber, int childNumber) throws Exception {
        if(childNumber>peopleNumber) throw new Exception("The number of children must be less than the people number");
        List<Client> clientList = new ArrayList<>();
        clientList.add(this);
        for(int i=1; i<peopleNumber-childNumber; i++) {
            clientList.add(new Client(false));
        }
        for(int i=0; i<childNumber; i++){
            clientList.add(new Client(true));
        }
        Group group = new Group(clientList);
        return new Booking(group,date,time);
    }


    public void printDetail(){
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
