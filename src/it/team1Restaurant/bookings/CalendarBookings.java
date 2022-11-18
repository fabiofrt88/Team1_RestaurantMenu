package it.team1Restaurant.bookings;
import it.team1Restaurant.user.Client;
import java.text.SimpleDateFormat;
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
        bookingsMap = new TreeMap<>(new CompareDaysByDate());

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

    public void setWorkingDay (LocalDate date,WorkingDayEnum workingDayToSet) throws Exception {
        Day targetDay = getDayByDate(date);
        if(!checkDateInCalendar(date)) throw new DateOutOfCalendar();
        if(workingDayToSet == WorkingDayEnum.WORKING) {
            if(targetDay.getWorkingDay() == WorkingDayEnum.NOT_WORKING){ // verifico che il giorno non sia già settato a working
                targetDay.setWorkingDay(WorkingDayEnum.WORKING);
                calendarRestaurant.getNotWorkingDays().remove(targetDay);
            }
        }
        else {
            if (targetDay.getWorkingDay() == WorkingDayEnum.WORKING) { //verfico che il giorno non sia gia settato a notWorking
                if (bookingsMap.get(targetDay).isEmpty()) {
                    targetDay.setWorkingDay(WorkingDayEnum.NOT_WORKING);
                    calendarRestaurant.getNotWorkingDays().add(targetDay);
                } else
                    throw new Exception("Attenzione: ci sono già delle prenotazioni per questo giorno!");
            }
        }
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
        /*Con gli stream:
        return bookingsMap.keySet().stream()
                                    .filter(day -> day.getDate().equals(date))
                                    .findFirst()
                                    .get();
         */
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



    public void createBookingsIntervalFromStartDate (LocalDate startDate, int numberOfDays) {
        for (int i = 0; i <= numberOfDays; i++) {
            LocalDate nextDate = startDate.plusDays(i);
            Day nextDay;
            if(calendarRestaurant.checkDateInNotWorkingDays(nextDate)){
                nextDay = calendarRestaurant.getDayByDate(nextDate);
            }
            else if(calendarRestaurant.getDefaultNotWorkingDaysOfWeek().contains(startDate.getDayOfWeek())){
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
        System.out.println("-------------CALENDAR BOOKINGS--------------");
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
        System.out.println("--------------------------------------------");
    }
}
