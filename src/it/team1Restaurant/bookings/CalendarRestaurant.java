package it.team1Restaurant.bookings;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CalendarRestaurant {

    private TreeSet<Day> notWorkingDays;

    private Set<DayOfWeek> defaultNotWorkingDaysOfWeek;

    private static CalendarRestaurant calendarRestaurant = new CalendarRestaurant();

    private CalendarRestaurant () {
        this.notWorkingDays = new TreeSet<>(new CompareDaysByDate());
        this.defaultNotWorkingDaysOfWeek = new HashSet<>();
    };

    public static CalendarRestaurant getInstance() {
           return calendarRestaurant;
       }

    public TreeSet<Day> getNotWorkingDays() {
        return notWorkingDays;
    }

    public void setNotWorkingDays(TreeSet<Day> notWorkingDays) {
        this.notWorkingDays = notWorkingDays;
    }

    public Set<DayOfWeek> getDefaultNotWorkingDaysOfWeek() {
        return defaultNotWorkingDaysOfWeek;
    }

    public void setDefaultNotWorkingDaysOfWeek(Set<DayOfWeek> defaultNotWorkingDaysOfWeek) {
        this.defaultNotWorkingDaysOfWeek = defaultNotWorkingDaysOfWeek;
    }

    public static CalendarRestaurant getCalendarRestaurant() {
        return calendarRestaurant;
    }

    public static void setCalendarRestaurant(CalendarRestaurant calendarRestaurant) {
        CalendarRestaurant.calendarRestaurant = calendarRestaurant;
    }

    public void removeNotWorkingDay (LocalDate date, CalendarBookings calendarBookings) {
        Day targetDay = getDayByDate(date);
        if(calendarBookings.checkDateInCalendar(date)) {
            try {
                calendarBookings.setWorkingDay(date, WorkingDayEnum.WORKING);
            } catch (Exception e) {  //Non si presenterà mai
                System.out.println(e.getMessage());
            }
        }
        notWorkingDays.remove(targetDay);
    }

    public void addNotWorkingDay (LocalDate date,CalendarBookings calendarBookings) throws Exception {
        if(calendarBookings.checkDateInCalendar(date)){
            Day targetDay = calendarBookings.getDayByDate(date);
            targetDay.setWorkingDay(WorkingDayEnum.NOT_WORKING); //si blocca se ci sono già prenotazioni
        }else {
            notWorkingDays.add(new Day(date, WorkingDayEnum.NOT_WORKING));
        }
    }

    public Day getDayByDate (LocalDate date) {
        return notWorkingDays.stream()
                                .filter(day -> day.getDate().equals(date))
                                .findFirst()
                                .get();
    }

    public boolean checkDateInNotWorkingDays (LocalDate date) {
        return notWorkingDays.stream()
                .map(day -> day.getDate())
                .collect(Collectors.toSet())
                .contains(date);
    }

    public void addDefaultNotWorkingDayOfWeek (DayOfWeek dayOfWeek,CalendarBookings calendarBookings) throws Exception {
        defaultNotWorkingDaysOfWeek.add(dayOfWeek);
        for(Day day : calendarBookings.getBookingsMap().keySet()){
            if(day.getDate().getDayOfWeek() == dayOfWeek){
                calendarBookings.setWorkingDay(day.getDate(),WorkingDayEnum.NOT_WORKING);
            }
        }
    }

    public void removeDefaultNotWorkingDayOfWeek (DayOfWeek dayOfWeek,CalendarBookings calendarBookings) throws Exception {
        defaultNotWorkingDaysOfWeek.remove(dayOfWeek);
        for(Day day : calendarBookings.getBookingsMap().keySet()){
            if(day.getDate().getDayOfWeek() == dayOfWeek){
                calendarBookings.setWorkingDay(day.getDate(),WorkingDayEnum.WORKING);
            }
        }
    }

    public void reset () {
        notWorkingDays = new TreeSet<>(new CompareDaysByDate());
        defaultNotWorkingDaysOfWeek = new HashSet<>();
    }

    public String getDetails ( ){
        String defaultNotWorkingDaysStr = "Default not working days: ";
        for(DayOfWeek dayOfWeek : defaultNotWorkingDaysOfWeek){
            defaultNotWorkingDaysStr += " - " + dayOfWeek.name().toLowerCase();
        }
        String notWorkingDaysStr = "Not working days: " ;
        for(Day day : notWorkingDays){
            notWorkingDaysStr += "\n " + day.getDetails();
        }
        return defaultNotWorkingDaysStr + "\n" + notWorkingDaysStr;
    }

    public void printDetails (){
        System.out.println("---------------CALENDAR RESTAURANT----------------");
        System.out.println(getDetails());
        System.out.println("---------------------------------------------------");
    }
}
