package it.team1Restaurant.user;

import it.team1Restaurant.menu.TypeDishClient;

import java.util.EnumSet;

public class Client {

    private EnumSet<TypeDishClient> typeDishClient;
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
    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.typeDishClient = EnumSet.of(TypeDishClient.GENERIC);
    }

    public Client(EnumSet<TypeDishClient> typeDishClient, String name, String surname, String email, String phoneNumber) {
        this.typeDishClient = typeDishClient;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isChild() {
        return isChild;
    }

    public void setChild(boolean child) {
        isChild = child;
    }

    public EnumSet<TypeDishClient> getTypeDishClient() {
        return typeDishClient;
    }

    public void setTypeDishClient(EnumSet<TypeDishClient> typeDishClient) {
        this.typeDishClient = typeDishClient;
    }

    /*public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }*/


    /*public void printBookingsDetails(){
        System.out.printf("Bookings of %s %s\n\n", this.name, this.surname);
        for(Booking book : bookingList){
            System.out.println(book.getBookingDetails() + "\n");
        }
    }*/

    public void printDetails(){
        System.out.println("User details" +
                "\nType: " + typeDishClient.toString() +
                "\nName: " + name +
                "\nSurname: " + surname +
                "\nEmail: " + email +
                "\nPhone Number: " + phoneNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "Type: " + typeDishClient.toString() + '\'' +
                "name: " + name + '\'' +
                ", surname: " + surname + '\'' +
                ", email: " + email + '\'' +
                ", phoneNumber: " + phoneNumber + '\'' +
                ", isChild: " + isChild +
                '}';
    }
}
