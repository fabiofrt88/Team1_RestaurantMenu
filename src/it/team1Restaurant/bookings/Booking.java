package it.team1Restaurant.bookings;

import it.team1Restaurant.user.Group;

import java.time.LocalDate;
import java.time.LocalTime;

public class Booking {

    private Group group;

    private LocalDate date;

    private LocalTime time;

    private int tableNumber;

    public Booking ( Group group, LocalDate date, LocalTime time) {
        this.group = group;
        this.date = date;
        this.time = time;
    }

    public Booking (Group group, LocalDate date, LocalTime time, int tableNumber) {
        this.group = group;
        this.date = date;
        this.time = time;
        this.tableNumber = tableNumber;
    }


    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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

    public String printDetails() {
        return "Booking " +
                "\nGroup:" + group.printDetails() +
                "\nDate: " + date +
                "\nTime: " + time +
                "\ntableNumber: " + tableNumber;
    }
}
