package services.impl;

import models.things.Booking;
import services.IBookingService;
import utils.comparator.SortByStartDateThenEndDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingService implements IBookingService {
    private Scanner scanner = new Scanner(System.in);
    CustomerService customerService = new CustomerService();
    FacilityService facilityService = new FacilityService();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static Set<Booking> bookings = new TreeSet<>(new SortByStartDateThenEndDate());

    static {
        try {
            bookings.add(new Booking("NO.001", dateFormat.parse("01/11/2000"), dateFormat.parse("14/12/2000"), "KH001", "HOUSE001", "None"));
            bookings.add(new Booking("NO.002", dateFormat.parse("01/01/2000"), dateFormat.parse("05/5/2000"), "KH002", "ROOM001", "None"));
            bookings.add(new Booking("NO.003", dateFormat.parse("01/01/2000"), dateFormat.parse("14/07/2000"), "KH003", "VILLA001", "None"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewBooking() {
        System.out.println("------Adding new booking------");
        System.out.println("Here is the customer list");
        customerService.display();
        System.out.print("Input customer ID: ");
        String customerId = scanner.nextLine();
        System.out.println("Here is the service list");
        facilityService.display();
        System.out.print("Input bookingCode: ");
        String bookingCode = scanner.nextLine();

        Date endDate = null;
        Date startDate = null;
        try {
            System.out.print("Input start date: ");
            startDate = dateFormat.parse(scanner.nextLine());
            System.out.print("Input end date: ");
            endDate = dateFormat.parse(scanner.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.print("Input service name: ");
        String serviceName = scanner.nextLine();
        System.out.print("Input service type");
        String serviceType = scanner.nextLine();

        Booking newBooking = new Booking(bookingCode, startDate, endDate, customerId, serviceName, serviceType);
        for (Booking x : bookings) {
            if (x.equals(newBooking)) {
                System.out.println("There is already a booking with the same booking code!");
                return;
            }
        }
        bookings.add(newBooking);
        facilityService.addingValueToFacilityService(newBooking.getServiceName());

    }

    @Override
    public void displayListBooking() {
        for (Booking x : bookings) {
            System.out.println(x.toString());
        }
    }

    @Override
    public Set<Booking> getBookings() {
        return bookings;
    }

    @Override
    public void createNewContract() {

    }

    @Override
    public void displayListContract() {

    }

    @Override
    public void editContract() {

    }
}
