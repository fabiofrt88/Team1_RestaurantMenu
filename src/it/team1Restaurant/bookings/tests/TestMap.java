package it.team1Restaurant.bookings.tests;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {


        Map<Integer, String> testMap = new TreeMap<>();

        testMap.put(0,"r");
        testMap.put(0,"s");

        System.out.println(testMap.values());
    }



}
