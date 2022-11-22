package it.team1Restaurant.bookings.calendar;
import it.team1Restaurant.bookings.Booking;
import it.team1Restaurant.bookings.exceptions.DateOutOfCalendar;
import it.team1Restaurant.bookings.exceptions.NotEmptyBookingsList;
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

    private Set<DayOfWeek> defaultNotWorkingDaysOfWeek;
    private static CalendarBookings calendarBookings = new CalendarBookings();

    private CalendarBookings(){
        bookingsMap = new TreeMap<>(new CompareDaysByDate());
        defaultNotWorkingDaysOfWeek = new HashSet<>();
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




    // ---------------- METODO PER CREARE LA DATA IN CUI VIENE EFFETTUATA LA PRENOTAZIONE -----------------

    private String createBookedAtDate(){
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en", "EN"));
        return simpleDateFormat.format(new Date());
    }




    // -------------------- METODO PER SETTARE GIORNO LAVORATIVO / NON LAVORATIVO -----------------------------

    public void setWorkingDay (LocalDate date, WorkingDayEnum workingDayToSet) throws Exception {
        Day targetDay = getDayByDate(date);
        if(!checkDateInCalendar(date)) throw new DateOutOfCalendar();
        if(workingDayToSet == WorkingDayEnum.WORKING) {
            if(targetDay.getWorkingDay() == WorkingDayEnum.NOT_WORKING){ // verifico che il giorno non sia già settato a working
                targetDay.setWorkingDay(WorkingDayEnum.WORKING);
            }
        }
        else {
            if (targetDay.getWorkingDay() == WorkingDayEnum.WORKING) { //verfico che il giorno non sia gia settato a notWorking
                if (bookingsMap.get(targetDay).isEmpty()) {
                    targetDay.setWorkingDay(WorkingDayEnum.NOT_WORKING);
                } else
                    throw new NotEmptyBookingsList(date);
            }
        }
    }



    //  ---------------------- METODI PER PRENOTARE ----------------------------

    public void addBooking (Booking booking) throws Exception {
        LocalDate targetDate = booking.getDate();
        Day targetDay = getDayByDate(targetDate);
        List<Booking> targetBookingsList = bookingsMap.get(targetDay);
        if(checkDateInCalendar(targetDate)) {
            if(targetDay.getWorkingDay() == WorkingDayEnum.WORKING) {
                targetBookingsList.add(booking);
            }else{
                throw new Exception("Il giorno per cui si vuole prenotare non è lavorativo");
            }
        }else{
            throw new DateOutOfCalendar();
        }
    }

    public void book (Client client, List<Client> clientList, LocalDate date, LocalTime time) throws Exception {
        //Mettere un controllo su numberOfAdults e numberChildren ???
        Booking book = new Booking(client, clientList, createBookedAtDate(), date, time);
        //client.bookingList.add(book);
        addBooking(book);
        System.out.println("La prenotazione per " + client.getName() + " e' stata effettuata con successo: " +
                            "\n" + book.getBookingDetails());
    }

      /*DA IMPLEMENTARE
    public boolean checkBooking () {

    }*/



    //  ------------- METODI PER ATTIVARE/DISATTIVARE INTERVALLI IN BOOKINGSMAP ----------------------------

    public void createBookingsIntervalFromStartDate (LocalDate startDate, int numberOfDays) {
        for (int i = 0; i <= numberOfDays; i++) {
            LocalDate nextDate = startDate.plusDays(i);
            Day nextDay;
            if(checkDateInCalendar(nextDate)){ //non aggiungo i giorni già presenti in bookingsMap
                continue;
            }
            else if(defaultNotWorkingDaysOfWeek.contains(startDate.getDayOfWeek())){
               nextDay = new Day(nextDate,WorkingDayEnum.NOT_WORKING);
            }
            else{
                nextDay = new Day(nextDate,WorkingDayEnum.WORKING);
            }
            bookingsMap.put(nextDay,new ArrayList<>());
        }
    }


    public void createBookingsIntervalFromTwoDates (LocalDate startDate, LocalDate endDate){
        int numberOfDays = (int)ChronoUnit.DAYS.between(startDate,endDate);
        createBookingsIntervalFromStartDate(startDate,numberOfDays);
    }

    public void createBookingsIntervalFromNow(int numberOfDays){
        createBookingsIntervalFromStartDate(LocalDate.now(),numberOfDays);
    }

    public void removeBookingsIntervalFromStartDate (LocalDate startDate,  int numberOfDays) throws Exception {
        for (int i = 0; i <= numberOfDays; i++) {
            LocalDate nextDate = startDate.plusDays(i);
            if(getBookingsListByDate(nextDate).isEmpty()) {
                bookingsMap.remove(getDayByDate(nextDate));
            }else{
                throw new NotEmptyBookingsList(nextDate);
            }
        }
    }

    public void removeBookingsIntervalFromTwoDates (LocalDate startDate, LocalDate endDate) throws Exception {
        int numberOfDays = (int)ChronoUnit.DAYS.between(startDate,endDate);
        removeBookingsIntervalFromStartDate(startDate,numberOfDays);
    }





    // ----------------- METODI PER SETTARE GIORNI NON LAVORATIVI DELLA SETTIMANA DI DEFAULT -----------------------

    public void addDefaultNotWorkingDayOfWeek (DayOfWeek dayOfWeek) throws Exception {
        Set<Day> targetDays = getDayByDayOfWeekFromBookingsMap(dayOfWeek);
        Set<Day> possibleNotEmptyDays = targetDays.stream().filter(day -> !bookingsMap.get(day).isEmpty()).collect(Collectors.toSet());
        if(possibleNotEmptyDays.size() != 0) throw new NotEmptyBookingsList(possibleNotEmptyDays);
        targetDays.stream().forEach(day -> day.setWorkingDay(WorkingDayEnum.NOT_WORKING));
        defaultNotWorkingDaysOfWeek.add(dayOfWeek);
    }

    public void removeDefaultNotWorkingDayOfWeek (DayOfWeek dayOfWeek) throws Exception {
        defaultNotWorkingDaysOfWeek.remove(dayOfWeek);
        for(Day day : bookingsMap.keySet()){
            if(day.getDate().getDayOfWeek() == dayOfWeek){
                setWorkingDay(day.getDate(),WorkingDayEnum.WORKING);
            }
        }
    }



    // -------------- METODI PER FARE RICERCHE A PARTIRE DALLA DATA ----------------------

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
        /*Con gli stream:
        return bookingsMap.keySet().stream()
                                    .filter(day -> day.getDate().equals(date))
                                    .findFirst()
                                    .get();
         */
    }

    private Set<Day> getDayByDayOfWeekFromBookingsMap (DayOfWeek dayOfWeek) {
        return bookingsMap.keySet().stream()
                .filter(day->day.getDate().getDayOfWeek() == dayOfWeek)
                .collect(Collectors.toSet());
    }

    public boolean checkDateInCalendar (LocalDate date) {
        return bookingsMap.keySet().stream()
                                    .map(day -> day.getDate())
                                    .collect(Collectors.toSet())
                                    .contains(date);
    }



    // ---------------- METODO PER RESETTARE IL CALENDAR ------------------------------------

    public void reset () {
        bookingsMap = new TreeMap<>(new CompareDaysByDate());
        defaultNotWorkingDaysOfWeek = new HashSet<>();
    }





    // ----------------- METODI DETAILS ------------------------------------


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
        System.out.println("-------------CALENDAR BOOKINGS--------------");
        for(Day day : bookingsMap.keySet()){
            switch(day.getWorkingDay()){
                case NOT_WORKING:
                    System.out.println(day.getDetails());
                    System.out.println("Non e' un giorno lavorativo\n");
                    break;
                case WORKING:
                    List<Booking> dayBookingList = bookingsMap.get(day);
                    System.out.println(day.getDetails());
                    if (dayBookingList.isEmpty()) {
                        System.out.println("Non ci sono prenotazioni per questo giorno\n");
                    } else {
                        System.out.println("");
                        for (Booking booking : dayBookingList) {
                            booking.printDetails();
                        }
                    }
                    break;
            }
        }
        System.out.println("--------------------------------------------");
    }
}
