package services;

import models.things.Booking;

import java.text.ParseException;

public interface IBookingService {
    void addNewBooking() throws ParseException;

    void displayListBooking();

    Booking getBookingInfo();
}
