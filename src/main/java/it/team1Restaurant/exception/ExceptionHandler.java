package it.team1Restaurant.exception;

import com.google.gson.JsonIOException;
import spark.Request;
import spark.Response;

import java.time.format.DateTimeParseException;

public class ExceptionHandler {

    public Response handleInternalServerError(DataAccessException e, Request request, Response response) {
        System.out.println(e.getMessage()+ "\n");
        response.status(500);
        response.body("{\"error\":{\"code\": 500,\"message\":\"500 Internal Server Error\"}}");
        return response;
    }

    public Response handleJsonIOException(JsonIOException e, Request request, Response response) {
        System.out.println(e.getMessage());
        response.status(500);
        response.body("{\"error\":{\"code\": 500,\"message\":\"500 Internal Server Error\"}}");
        return response;
    }

    public Response handleDateTimeParseException(DateTimeParseException e, Request request, Response response) {
        System.out.println(e.getMessage());
        response.status(500);
        response.body("{\"error\":{\"code\": 500,\"message\":\"500 Internal Server Error\"}}");
        return response;
    }

    public Response handleClassCastException(ClassCastException e, Request request, Response response) {
        System.out.println(e.getMessage()+ "\n");
        response.status(500);
        response.body("{\"error\":{\"code\": 500,\"message\":\"500 Internal Server Error\"}}");
        return response;
    }

    public Response handleNotFoundException(NotFoundException e, Request request, Response response) {
        System.out.println(e.getMessage()+ "\n");
        response.status(404);
        response.body("{\"error\":{\"code\": 404,\"message\":\"404 Resource not found\"}}");
        return response;
    }

    public Response handleNumberFormatException(NumberFormatException e, Request request, Response response) {
        System.out.printf("NumberFormatException %s\n\n", e.getMessage());
        response.status(400);
        response.body("{\"error\":{\"code\": 400,\"message\":\"Bad request\"}}");
        return response;
    }

}