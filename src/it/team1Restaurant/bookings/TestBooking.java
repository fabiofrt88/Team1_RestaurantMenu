package it.team1Restaurant.bookings;

import it.team1Restaurant.user.Client;
import it.team1Restaurant.user.Group;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class TestBooking {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();


        Group group = new Group(new ArrayList<>(Arrays.asList(
                new Client("Pippo","Franco","pippofranco@gmail.com", "389-5264589", false),
                new Client(true),
                new Client(false),
                new Client(false)
        )));
        calendar.addBooking(new Booking(group, LocalDate.of(2022,11,11), LocalTime.of(12,30)));

        System.out.println(calendar.printDetails());
    }
}
