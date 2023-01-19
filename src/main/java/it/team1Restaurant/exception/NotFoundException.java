package it.team1Restaurant.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(){
        super("Resource not found");
    }

}
