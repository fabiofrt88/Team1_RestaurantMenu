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

/**
 * This class is used to activate an interval of days, among witch is possible make bookings. It is possible to set
 * a specific not working day or to set some default not working days for each week. It may be only one calendar, so
 * this class is instantiated as a singleton.
 */
public class CalendarBookings {

    /**
     * This map represents the current activated interval in which is possible make bookings.
     * The keys are {@link it.team1Restaurant.bookings.calendar.Day} objects and, for each Day, the corresponding value
     * is a List of {@link Booking} objects.
     * In the constructor the Map is initialized as a TreeMap, with an assigned comparator that compares the Days only
     * considering their date. In this way,  is excluded the possibility that could be multiple keys with the same date.
     * Furthermore the Map results automatically ordered by dates.
     */
    private Map<Day,List<Booking>> bookingsMap;

    /**
     * This is a Set that stores the @see<a href="https://docs.oracle.com/javase/8/docs/api/java/time/DayOfWeek.html">DayOfWeek</a>
     * selected as default not working days.
     */
    private Set<DayOfWeek> defaultNotWorkingDaysOfWeek;

    private static CalendarBookings calendarBookings = new CalendarBookings();

    private CalendarBookings(){
        bookingsMap = new TreeMap<>(new Comparator<Day>() {
            @Override
            public int compare(Day day1 , Day day2) {
                if(day1.getDate().equals(day2.getDate())) return 0;  // day1 == day2
                if(day1.getDate().isBefore(day2.getDate())) return -1; // day1 < day2
                else return 1;        // day1 > day2
            }
        });
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


    /**
     *This method is used to create the date on which the booking is made.
     * @return The date on which the booking is made.
     */
    private String createBookedAtDate(){
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("en", "EN"));
        return simpleDateFormat.format(new Date());
    }

    // -------------------- METODO PER SETTARE GIORNO LAVORATIVO / NON LAVORATIVO -----------------------------

    /**
     * This method set the parameter workingDay of the Day in the bookingsMap corresponding to the date given in input.
     * Pay attention: the date insert must be in the activate days, and if you want to change a day from
     * {@link it.team1Restaurant.bookings.calendar.WorkingDayEnum#WORKING} to {@link it.team1Restaurant.bookings.calendar.WorkingDayEnum#NOT_WORKING}
     * the corresponding list of the bookings must be empty!
     * @param date The date for which you want to change the parameter workingDay.
     * @param workingDayToSet The new type to set in the target Day.
     * @throws DateOutOfCalendar This method incurs in a {@link it.team1Restaurant.bookings.exceptions.DateOutOfCalendar} if the date isn't activated in the bookingsMap.
     * @throws NotEmptyBookingsList The method incurs in a {@link it.team1Restaurant.bookings.exceptions.NotEmptyBookingsList} if you try to change a working day,
     * whose corresponding bookings list is not empty, in a not working day.
     */
    public void setWorkingDay (LocalDate date, WorkingDayEnum workingDayToSet) throws Exception {
        Day targetDay = getDayByDate(date);
        if(!checkDateInCalendar(date)) throw new DateOutOfCalendar();
        if(workingDayToSet == WorkingDayEnum.WORKING) {
            targetDay.setWorkingDay(WorkingDayEnum.WORKING);
        }
        else {
            if (bookingsMap.get(targetDay).isEmpty()) {
                targetDay.setWorkingDay(WorkingDayEnum.NOT_WORKING);
            } else
                throw new NotEmptyBookingsList(date);
            }
    }

    //  ---------------------- METODI PER PRENOTARE ----------------------------

    /**
     * This method is used to add a booking to the bookingsMap.
     * @param booking The booking to add into the bookingsMap.
     * @throws DateOutOfCalendar This method incurs in a {@link it.team1Restaurant.bookings.exceptions.DateOutOfCalendar} if the date isn't activated in the bookingsMap.
     * @throws Exception This method incurs in an exception if the target day isn't a working day.
     */
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

    /**
     * This method is used to create a new {@link Booking} and add it to the
     * {@link it.team1Restaurant.bookings.calendar.CalendarBookings#bookingsMap} using the method
     * {@link it.team1Restaurant.bookings.calendar.CalendarBookings#addBooking}.
     * @param client The client who is making the booking.
     * @param clientList The client list of the target booking.
     * @param date The target date of the booking.
     * @param time The target time of the booking.
     * @throws Exception The exceptions are inherited from the method {@link it.team1Restaurant.bookings.calendar.CalendarBookings#addBooking}
     */
    public void book (Client client, List<Client> clientList, LocalDate date, LocalTime time) throws Exception {
        //Mettere un controllo su numberOfAdults e numberChildren ???

        Booking booking = new Booking(client,clientList,createBookedAtDate(), date, time);

        addBooking(booking);
        client.addBooking(booking);
        client.getCalendarBookingsClient().addBooking(booking);
        System.out.println("La prenotazione per " + client.getName() + " e' stata effettuata con successo: " +
                            "\n" + booking.getBookingDetails());
    }

      /*DA IMPLEMENTARE
    public boolean checkBooking () {

    }*/

    //  ------------- METODI PER ATTIVARE/DISATTIVARE INTERVALLI IN BOOKINGSMAP ----------------------------

    /**
     * This method is used to activate a new interval in the {@link it.team1Restaurant.bookings.calendar.CalendarBookings#bookingsMap}.
     * The new interval is generated starting from the startDate given in input, for the given number of days. If some days of
     * the new interval are just present in the bookingsMap, they aren't substituted. If a day is present in the
     * {@link it.team1Restaurant.bookings.calendar.CalendarBookings#defaultNotWorkingDaysOfWeek}, the days is set as not working day.
     * Else, a new working day is created, and put in the bookingsMap with an empty bookingList.
     *
     * @param startDate The date from which you want to create the interval.
     * @param numberOfDays The number of days of the new interval.
     */
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

    /**
     * This method create a new interval, between two given dates, in the bookingsMap, using the method
     * {@link it.team1Restaurant.bookings.calendar.CalendarBookings#createBookingsIntervalFromStartDate}
     * @param startDate The starting date.
     * @param endDate The ending date.
     */
    public void createBookingsIntervalFromTwoDates (LocalDate startDate, LocalDate endDate){
        int numberOfDays = (int)ChronoUnit.DAYS.between(startDate,endDate);
        createBookingsIntervalFromStartDate(startDate,numberOfDays);
    }

    /**
     * This method creates a new interval, starting from the current date, for the given number of days. It uses the method
     * {@link it.team1Restaurant.bookings.calendar.CalendarBookings#createBookingsIntervalFromStartDate}.
     * @param numberOfDays The number of days of the new interval.
     */
    public void createBookingsIntervalFromNow(int numberOfDays){
        createBookingsIntervalFromStartDate(LocalDate.now(),numberOfDays);
    }

    /**
     * This method removes from the bookingsMap the number of days specified, starting from the given startDate.
     * @param startDate The starting date from which you would remove the days.
     * @param numberOfDays The number of days to remove.
     * @throws NotEmptyBookingsList This method incurs in an exception if some of the days to remove presents a non empty
     * bookingsList.
     * @throws DateOutOfCalendar This method incurs in an exception if there is some day to remove out of the calendar.
     */
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

    /**
     * This method removes from the bookingsMap the number the interval between the two dates given in input, using the method
     * {@link it.team1Restaurant.bookings.calendar.CalendarBookings#removeBookingsIntervalFromStartDate}.
     * @param startDate The starting date of the interval to remove.
     * @param endDate The ending date of the interval to remove.
     * @throws Exception The same exceptions of the method: {@link it.team1Restaurant.bookings.calendar.CalendarBookings#removeBookingsIntervalFromStartDate}.
     */
    public void removeBookingsIntervalFromTwoDates (LocalDate startDate, LocalDate endDate) throws Exception {
        int numberOfDays = (int)ChronoUnit.DAYS.between(startDate,endDate);
        removeBookingsIntervalFromStartDate(startDate,numberOfDays);
    }

    // ----------------- METODI PER SETTARE GIORNI NON LAVORATIVI DELLA SETTIMANA DI DEFAULT -----------------------

    /**
     * This method is used to set, in the bookingsMap, a default not working day for each week (for example Monday).
     * Of course all the target days must present an empty bookingsList.
     * @param dayOfWeek The  @see<a href="https://docs.oracle.com/javase/8/docs/api/java/time/DayOfWeek.html">DayOfWeek</a> to
     *                  set as not working day.
     * @throws NotEmptyBookingsList This method incurs in an exception if some of the target days presents a not empty bookingsList.
     */
    public void addDefaultNotWorkingDayOfWeek (DayOfWeek dayOfWeek) throws Exception {
        Set<Day> targetDays = getDayByDayOfWeekFromBookingsMap(dayOfWeek);
        Set<Day> daysWithNotEmptyBookingsList = targetDays.stream().filter(day -> !bookingsMap.get(day).isEmpty()).collect(Collectors.toSet());
        if(daysWithNotEmptyBookingsList.size() != 0) throw new NotEmptyBookingsList(daysWithNotEmptyBookingsList);
        targetDays.stream().forEach(day -> day.setWorkingDay(WorkingDayEnum.NOT_WORKING));
        defaultNotWorkingDaysOfWeek.add(dayOfWeek);
    }

    /**
     * This method is used to remove a default not working day of week.
     * @param dayOfWeek The day of week to remove from the default not working days.
     */
    public void removeDefaultNotWorkingDayOfWeek (DayOfWeek dayOfWeek)  {
        defaultNotWorkingDaysOfWeek.remove(dayOfWeek);
        for(Day day : bookingsMap.keySet()){
            if(day.getDate().getDayOfWeek() == dayOfWeek){
                try {
                    setWorkingDay(day.getDate(), WorkingDayEnum.WORKING);
                }catch(Exception e){  //Non si presenta mai l'eccezione
                    e.printStackTrace();
                }
            }
        }
    }

    // -------------- METODI PER FARE RICERCHE A PARTIRE DALLA DATA ----------------------

    /**
     * This method returns the bookingsList present in the bookingsMap, corresponding to the given date.
     * @param date The day of which you want to know the bookingsList.
     * @return The bookingsList corresponding to tje given date.
     * @throws DateOutOfCalendar If the given date is out of calendar.
     */
    public List<Booking> getBookingsListByDate (LocalDate date) throws DateOutOfCalendar {
        return bookingsMap.get(getDayByDate(date));
    }

    /**
     * This method returns, if it is present, the Day in the bookingsMap corresponding to date given in input.
     * @param date The day of which we want to get the corresponding Day.
     * @return The Day corresponding to the date given in input.
     * @throws DateOutOfCalendar If the date isn't in the bookingsMap.
     */
    public Day getDayByDate (LocalDate date) throws DateOutOfCalendar {
        Day dayFound = null;
        for(Day day : bookingsMap.keySet()){
            if(day.getDate().equals(date)){
                dayFound = day;
                break;
            }
        }
        if(dayFound == null) throw new DateOutOfCalendar();
        else return dayFound;

        /*Altri due metodi per ottenere lo stesso risultato:

        1) Sfruttando il comparatore:
        Day dayFound = bookingsMap.get(new Day(date,null));
        if(dayFound == null) throw new DateOutOfCalendar();
        else return dayFound;

        2)Con gli stream:
        Optional dayFound bookingsMap.keySet().stream()
                                    .filter(day -> day.getDate().equals(date))
                                    .findFirst();
        if(!dayFound.isPresent()) throw new DateOutOfCalendar();
        else return dayFound.get();
         */
    }

    /**
     * This method returns all the Days in the BookingsMap that corresponding to the
     * @see<a href="https://docs.oracle.com/javase/8/docs/api/java/time/DayOfWeek.html">DayOfWeek</a>  given in input.
     * @param dayOfWeek The day of week for which we want to know the Days is present in the bookingsMap.
     * @return The Days that matches the given DayOfWeek.
     */
    private Set<Day> getDayByDayOfWeekFromBookingsMap (DayOfWeek dayOfWeek) {
        return bookingsMap.keySet().stream()
                .filter(day->day.getDate().getDayOfWeek() == dayOfWeek)
                .collect(Collectors.toSet());
    }

    /**
     * This method check if the given date is present in the bookingsMap.
     * @param date The target date.
     * @return The method returns true if the date is in the bookingsMap, otherwise it returns false.
     */
    public boolean checkDateInCalendar (LocalDate date) {
        return bookingsMap.keySet().stream()
                                    .map(day -> day.getDate())
                                    .collect(Collectors.toSet())
                                    .contains(date);
    }

    // ----------------- METODI DETAILS ------------------------------------

    public String getCalendarDetails() {
        String str = "";
        for(List<Booking> dayBookingList : bookingsMap.values()){
            String dayStr = "";
            for(Booking booking : dayBookingList){
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
    }

}
