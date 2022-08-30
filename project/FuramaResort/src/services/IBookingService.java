package services;

import models.things.Booking;

import java.text.ParseException;
import java.util.Set;

public interface IBookingService {
    void addNewBooking() throws ParseException;

    void displayListBooking();

    void createNewContract();

    void displayListContract();

    void editContract();

    Set<Booking> getBookings();
}
