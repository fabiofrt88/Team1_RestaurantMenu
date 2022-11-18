package it.team1Restaurant.bookings;
import it.team1Restaurant.user.Client;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;



public class CalendarBookings {

    private Map<Day,List<Booking>> bookingsMap;

    private CalendarRestaurant calendarRestaurant;
    private static CalendarBookings calendarBookings = new CalendarBookings();

    private CalendarBookings(){
        bookingsMap = new TreeMap<>(new Comparator<Day>() {
            @Override
            public int compare(Day day1, Day day2) {
                if(day1.getDate().equals(day2.getDate())) return 0;
                if(day1.getDate().isBefore(day2.getDate())) return -1;
                else return 1;
            }
        });

        calendarRestaurant = CalendarRestaurant.getInstance();
    }

    public static CalendarBookings getInstance(){
        return calendarBookings;
    }

    public Map<Day, List<Booking>> getBookingsMap() {
        return bookingsMap;
    }

    public void setBookingsMap(Map<Day, List<Booking>> bookingsMap) {
        this.bookingsMap = bookingsMap;
    }

    // toDo pensare meglio al collegamento con calendarRestaurant
    public void setWorkingDay (LocalDate date,WorkingDayEnum workingDayEnum) throws Exception {
        //if(!checkDateInCalendar(date)) throw new DateOutOfCalendar; toDo check da inserire?
        getDayByDate(date).setWorkingDay(workingDayEnum);
    }

    public List<Booking> getBookingsListByDate (LocalDate date) throws Exception {
        return bookingsMap.get(getDayByDate(date));
    }

    public Day getDayByDate (LocalDate date) throws Exception {
        if(!checkDateInCalendar(date)) throw new DateOutOfCalendar();
        Day dayFound = null;
        for(Day day : bookingsMap.keySet()){
            if(day.getDate().equals(date)){
                dayFound = day;
                break;
            }
        }
        return dayFound;
    }



    public void addBooking (Booking booking) throws Exception {
        if(checkDateInCalendar(booking.getDate())) {
            bookingsMap.get(booking.getDate()).add(booking);
        }else{
            throw new DateOutOfCalendar();
        }
    }


    public void book (Client client, LocalDate date, LocalTime time, int numberOfAdults, int numberOfChildren) throws Exception {
        //Mettere un controllo su numberOfAdults e numberChildren ???
        Booking book = new Booking(client,createBookedAtDate(), date, time, numberOfAdults, numberOfChildren);
        //client.bookingList.add(book);
        addBooking(book);
        System.out.println("La prenotazione per " + client.getName() + " e' stata effettuata con successo: " +
                            "\n" + book.getBookingDetails());
    }

    private String createBookedAtDate(){
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en", "EN"));
        return simpleDateFormat.format(new Date());
    }


    public void createBookingsIntervalFromStartDateUsingCalendarRestourant (LocalDate startDate, int numberOfDays){
        //mettere mercoledì not working.
        for(int i=0; i<=numberOfDays; i++){
            if(calendarRestaurant.getNotWorkingDays().contains(startDate.plusDays(i))){
                bookingsMap.put(new Day(startDate.plusDays(i),WorkingDayEnum.NOT_WORKING), new ArrayList<>());
            }else {
                bookingsMap.put(new Day(startDate.plusDays(i),WorkingDayEnum.WORKING), new ArrayList<>());
            }
        }
    }


    public void createBookingsIntervalFromStartDate (LocalDate startDate, int numberOfDays) {
        //mettere mercoledì not working
        for (int i = 0; i <= numberOfDays; i++) {
            if (calendarRestaurant.getNotWorkingDays().contains(startDate.plusDays(i))) {
                bookingsMap.put(new Day(startDate.plusDays(i), WorkingDayEnum.NOT_WORKING), new ArrayList<>());
            } else {
                bookingsMap.put(new Day(startDate.plusDays(i), WorkingDayEnum.WORKING), new ArrayList<>());
            }
        }
    }

    public void setDefaultNotWorkingDayOfWeek (DayOfWeek dayOfWeek) {
        for (Day day : bookingsMap.keySet()) {
            if(day.getDate().getDayOfWeek() == dayOfWeek){
                day.setWorkingDay(WorkingDayEnum.NOT_WORKING);
                calendarRestaurant.notWorkingDays.add(day.getDate());

            }
        }
    }


    public void createBookingsIntervalFromTwoDates (LocalDate startDate, LocalDate endDate){
        int numberOfDays = (int)ChronoUnit.DAYS.between(startDate,endDate);
        createBookingsIntervalFromStartDate(startDate,numberOfDays);
    }

    public void createBookingIntervalFromNow(int numberOfDays){
        createBookingsIntervalFromStartDate(LocalDate.now(),numberOfDays);
    }

    public boolean checkDateInCalendar (LocalDate date) {
        return bookingsMap.keySet().stream()
                                    .map(day -> day.getDate())
                                    .collect(Collectors.toSet())
                                    .contains(date);
    }


    /*DA IMPLEMENTARE
    public boolean checkBooking () {

    }*/


    public String getCalendarDetails() {
        String str = "";
        for(List<Booking> dayBookingList : bookingsMap.values()){
            String dayStr = "";
            for(Booking booking:dayBookingList){
                dayStr += booking.getBookingDetails();
            }
            str += dayStr;
        }
        return str;
    }



    public void printDetails () {
        for(Day day : bookingsMap.keySet()){
            switch(day.getWorkingDay()){
                case NOT_WORKING:
                    System.out.println(day.getDetails());
                    System.out.println("Non e' un giorno lavorativo\n");
                    break;
                case WORKING:
                    List<Booking> dayBookingList = bookingsMap.get(day);
                    if (dayBookingList.isEmpty()) {
                        System.out.println(day.getDetails());
                        System.out.println("Non ci sono prenotazioni per questo giorno\n");
                    } else {
                        for (Booking booking : dayBookingList) {
                            System.out.println(day.getDetails());
                            booking.printDetails();
                        }
                    }
                    break;
            }
        }
    }
}
