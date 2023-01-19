package it.team1Restaurant.dao;

import it.team1Restaurant.bookings.Booking;
import it.team1Restaurant.foods.Dish;
import it.team1Restaurant.foods.TypeCourseEnum;
import it.team1Restaurant.jdbc.DriverJDBC;
import it.team1Restaurant.user.Client;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    public void createTable() {

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            // this is a multiline string, definitely better for writing a SQL query
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS booking
                    ( id INTEGER(10) NOT NULL AUTO_INCREMENT,
                      booked_at VARCHAR(30) NOT NULL,
                      date DATE NOT NULL,
                      time TIME NOT NULL,
                      client_id INTEGER(10),
                      CONSTRAINT client_pk PRIMARY KEY (id),
                      CONSTRAINT client_FK_1 FOREIGN KEY (client_id) REFERENCES client(id)
                      ON UPDATE CASCADE ON DELETE CASCADE
                    );
                    """;

            statement.executeUpdate(createQuery);
            System.out.printf("Created table booking in the database %s\n\n", conn.getCatalog());

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public void insertBooking(Booking booking){

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String insertQuery =
                    """ 
                     INSERT INTO booking (booked_at, date, time, client_id)
                     VALUES ('""" + booking.getBookedAt() + "', '" + Date.valueOf(booking.getDate()) + "', '"
                            + Time.valueOf(booking.getTime()) + "', '" + booking.getClient().getId() + "');";

            statement.executeUpdate(insertQuery);

            System.out.printf("Booking inserted\n\n");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

    }

    public List<Booking> selectAllBookings(){

        List<Booking> bookingList = new ArrayList<>();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT booking.*, client.* FROM booking
                    INNER JOIN client ON booking.client_id = client.id;""";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){

                Integer bookingId = resultSet.getInt("booking.id");
                String bookingBookedAt = resultSet.getString("booking.booked_at");
                LocalDate bookingDate = resultSet.getDate("booking.date").toLocalDate();
                LocalTime bookingTime = resultSet.getTime("booking.time").toLocalTime();

                Integer clientId = resultSet.getInt("client.id");
                String clientName = resultSet.getString("client.name");
                String clientSurname = resultSet.getString("client.surname");
                String clientEmail = resultSet.getString("client.email");
                String clientPhoneNumber = resultSet.getString("client.phone_number");
                Client client = new Client(clientId, clientName, clientSurname, clientEmail, clientPhoneNumber, null);

                Booking booking = new Booking(bookingId, client, bookingBookedAt, bookingDate, bookingTime);
                bookingList.add(booking);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return bookingList;

    }

    public Booking selectBookingById(Integer id){

        Booking booking = null;

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT booking.*, client.* FROM booking
                    INNER JOIN client ON booking.client_id = client.id
                    WHERE booking.id =\040""" + id + ";";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){

                Integer bookingId = resultSet.getInt("booking.id");
                String bookingBookedAt = resultSet.getString("booking.booked_at");
                LocalDate bookingDate = resultSet.getDate("booking.date").toLocalDate();
                LocalTime bookingTime = resultSet.getTime("booking.time").toLocalTime();

                Integer clientId = resultSet.getInt("client.id");
                String clientName = resultSet.getString("client.name");
                String clientSurname = resultSet.getString("client.surname");
                String clientEmail = resultSet.getString("client.email");
                String clientPhoneNumber = resultSet.getString("client.phone_number");
                Client client = new Client(clientId, clientName, clientSurname, clientEmail, clientPhoneNumber, null);

                booking = new Booking(bookingId, client, bookingBookedAt, bookingDate, bookingTime);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return booking;

    }

    public List<Booking> selectBookingsByClient(Client client){

        List<Booking> bookingList = new ArrayList<>();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT booking.*, client.* FROM booking
                    INNER JOIN client ON booking.client_id = client.id
                    WHERE client.id =\040""" + client.getId() + ";";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){

                Integer bookingId = resultSet.getInt("booking.id");
                String bookingBookedAt = resultSet.getString("booking.booked_at");
                LocalDate bookingDate = resultSet.getDate("booking.date").toLocalDate();
                LocalTime bookingTime = resultSet.getTime("booking.time").toLocalTime();

                Integer clientId = resultSet.getInt("client.id");
                String clientName = resultSet.getString("client.name");
                String clientSurname = resultSet.getString("client.surname");
                String clientEmail = resultSet.getString("client.email");
                String clientPhoneNumber = resultSet.getString("client.phone_number");
                Client bookingClient = new Client(clientId, clientName, clientSurname, clientEmail, clientPhoneNumber, null);

                Booking booking = new Booking(bookingId, bookingClient, bookingBookedAt, bookingDate, bookingTime);
                bookingList.add(booking);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return bookingList;

    }

    public List<Booking> selectBookingsByDate(LocalDate date){

        List<Booking> bookingList = new ArrayList<>();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT booking.*, client.* FROM booking
                    INNER JOIN client ON booking.client_id = client.id
                    WHERE booking.date ='\040""" + Date.valueOf(date) + "';";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){

                Integer bookingId = resultSet.getInt("booking.id");
                String bookingBookedAt = resultSet.getString("booking.booked_at");
                LocalDate bookingDate = resultSet.getDate("booking.date").toLocalDate();
                LocalTime bookingTime = resultSet.getTime("booking.time").toLocalTime();

                Integer clientId = resultSet.getInt("client.id");
                String clientName = resultSet.getString("client.name");
                String clientSurname = resultSet.getString("client.surname");
                String clientEmail = resultSet.getString("client.email");
                String clientPhoneNumber = resultSet.getString("client.phone_number");
                Client bookingClient = new Client(clientId, clientName, clientSurname, clientEmail, clientPhoneNumber, null);

                Booking booking = new Booking(bookingId, bookingClient, bookingBookedAt, bookingDate, bookingTime);
                bookingList.add(booking);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return bookingList;

    }

    public List<Booking> selectBookingsByInterval(LocalDate startDate, LocalDate endDate){

        List<Booking> bookingList = new ArrayList<>();

        try (Connection conn = DriverJDBC.getConnection()) {

            // print out a message
            System.out.printf("Connected to database %s successfully.\n\n", conn.getCatalog());

            Statement statement = conn.createStatement();

            String selectQuery =
                    """
                    SELECT booking.*, client.* FROM booking
                    INNER JOIN client ON booking.client_id = client.id
                    WHERE booking.date BETWEEN'\040""" + Date.valueOf(startDate) + "' AND '" + Date.valueOf(endDate) + "';";

            ResultSet resultSet = statement.executeQuery(selectQuery);

            while(resultSet.next()){

                Integer bookingId = resultSet.getInt("booking.id");
                String bookingBookedAt = resultSet.getString("booking.booked_at");
                LocalDate bookingDate = resultSet.getDate("booking.date").toLocalDate();
                LocalTime bookingTime = resultSet.getTime("booking.time").toLocalTime();

                Integer clientId = resultSet.getInt("client.id");
                String clientName = resultSet.getString("client.name");
                String clientSurname = resultSet.getString("client.surname");
                String clientEmail = resultSet.getString("client.email");
                String clientPhoneNumber = resultSet.getString("client.phone_number");
                Client bookingClient = new Client(clientId, clientName, clientSurname, clientEmail, clientPhoneNumber, null);

                Booking booking = new Booking(bookingId, bookingClient, bookingBookedAt, bookingDate, bookingTime);
                bookingList.add(booking);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage() + "\n");
        }

        return bookingList;

    }

}
