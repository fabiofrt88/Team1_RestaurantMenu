package it.team1Restaurant.bookings;

import it.team1Restaurant.user.Client;
import it.team1Restaurant.user.Group;

import java.time.LocalDate;
import java.time.LocalTime;

public class TestBooking {
    public static void main(String[] args) throws Exception {

        Calendar calendar = Calendar.getInstance();

        Client client = new Client("Pippo","Franco","pippofranco@gmail.com", "389-5264589", false);
        Group group = client.createGroup(4, 1);
        calendar.addBooking(client.book(group, LocalDate.of(2022,11,11), LocalTime.of(12,30)));

        Client client2 = new Client("Mario","Rossi","mariorossio@gmail.com", "389-6578904", false);
        Group group2 = client2.createGroup(5, 3);
        calendar.addBooking(client2.book(group2, LocalDate.of(2022,11,16), LocalTime.of(13,00)));

        calendar.printDetails();

    }
}
