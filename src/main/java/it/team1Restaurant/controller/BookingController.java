package it.team1Restaurant.controller;

import com.google.gson.*;
import it.team1Restaurant.bookings.Booking;
import it.team1Restaurant.dao.ServiceDAOFactory;
import it.team1Restaurant.exception.NotFoundException;
import it.team1Restaurant.service.BookingService;
import it.team1Restaurant.service.ClientService;
import it.team1Restaurant.service.ServiceEnum;
import it.team1Restaurant.user.Client;
import it.team1Restaurant.utils.gson.serializer.LocalDateSerializer;
import it.team1Restaurant.utils.gson.serializer.LocalTimeSerializer;
import spark.Request;
import spark.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class BookingController {

    private BookingService bookingService = (BookingService) ServiceDAOFactory.getService(ServiceEnum.BOOKING);
    private ClientService clientService = (ClientService) ServiceDAOFactory.getService(ServiceEnum.CLIENT);

    public String getAllBookings(Request request, Response response){
        List<Booking> bookingList = bookingService.selectAllBookings();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalTime.class, new LocalTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateSerializer());

        return gsonBuilder.setPrettyPrinting().create().toJson(bookingList);
    }

    public String getBookingById(Request request, Response response){
        Integer id = Integer.parseInt(request.params(":id"));
        Booking booking = bookingService.selectBookingById(id);
        if(booking == null) {
            throw new NotFoundException();
        }

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalTime.class, new LocalTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateSerializer());

        return gsonBuilder.setPrettyPrinting().create().toJson(booking);
    }

    public String getBookingsByClient(Request request, Response response){
        Integer clientId = Integer.parseInt(request.params(":id"));
        Client client = clientService.selectClientById(clientId);
        if(client == null) {
            throw new NotFoundException();
        }

        List<Booking> bookingList = bookingService.selectBookingsByClient(client);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalTime.class, new LocalTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateSerializer());

        return gsonBuilder.setPrettyPrinting().create().toJson(bookingList);
    }

    public String getBookingsByDate(Request request, Response response){
        LocalDate date = LocalDate.parse(request.params(":date"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Booking> bookingList = bookingService.selectBookingsByDate(date);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalTime.class, new LocalTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateSerializer());

        return gsonBuilder.setPrettyPrinting().create().toJson(bookingList);
    }

    public String getBookingsByInterval(Request request, Response response){
        LocalDate startDate = LocalDate.parse(request.params(":startDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate endDate = LocalDate.parse(request.params(":endDate"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Booking> bookingList = bookingService.selectBookingsByInterval(startDate, endDate);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateSerializer());
        gsonBuilder.registerTypeAdapter(LocalTime.class, new LocalTimeSerializer());
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateSerializer());

        return gsonBuilder.setPrettyPrinting().create().toJson(bookingList);
    }

}
