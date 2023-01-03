package it.team1Restaurant.dao;

import it.team1Restaurant.bookings.Booking;
import it.team1Restaurant.jdbc.DriverJDBC;

import java.sql.*;

public class BookingDAO {

    public void createTable(){

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
                      client_id INTEGER(10)
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

}
