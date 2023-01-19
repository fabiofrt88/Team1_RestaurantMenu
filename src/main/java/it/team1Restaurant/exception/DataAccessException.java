package it.team1Restaurant.exception;

public class DataAccessException extends RuntimeException {

    public DataAccessException() {
        super("Database persistence error occurred");
    }

}
