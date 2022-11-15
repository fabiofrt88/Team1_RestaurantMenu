package it.team1Restaurant.bookings;

import java.time.LocalDate;

public class Day {

    private WorkingDayEnum workingDay;

    private LocalDate date;

    public Day (LocalDate date, WorkingDayEnum workingDay){
        this.date = date;
        this.workingDay = workingDay;
    }

    public WorkingDayEnum getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(WorkingDayEnum workingDay) {
        this.workingDay = workingDay;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
