package it.team1Restaurant.bookings;

import java.util.List;
import java.util.TreeMap;

public class BookingsMap extends TreeMap<Day, List<Booking>> {
    @Override
    public List<Booking> put(Day key, List<Booking> value) {
        for(Day day : this.keySet()){
            day.getDate().isEqual(key.getDate());
            return null;
        }
        return super.put(key,value);
    }
}
