package it.team1Restaurant.bookings;

import java.util.Comparator;

public class CompareDaysByDate implements Comparator<Day> {

    @Override
    public int compare(Day day1 , Day day2) {
            if(day1.getDate().equals(day2.getDate())) return 0;
            if(day1.getDate().isBefore(day2.getDate())) return -1;
            else return 1;
    }

    @Override
    public boolean equals(Object obj) {  //sistemare
        return obj == this;
    }
}
