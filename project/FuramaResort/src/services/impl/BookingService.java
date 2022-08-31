package services.impl;

import models.things.Booking;
import models.things.Facility;
import services.IBookingService;
import utils.comparator.SortByStartDateThenEndDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingService implements IBookingService {
    Scanner scanner = new Scanner(System.in);
    CustomerService customerService = new CustomerService();
    FacilityService facilityService = new FacilityService();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static Set<Booking> bookings = new TreeSet<>(new SortByStartDateThenEndDate());

    static {
        try {
            bookings.add(new Booking("NO.001", dateFormat.parse("05/08/2022"), dateFormat.parse("22/08/2022"), "KH001", "HOUSE001", "None"));
            bookings.add(new Booking("NO.002", dateFormat.parse("07/08/2022"), dateFormat.parse("15/08/2022"), "KH002", "ROOM001", "None"));
            bookings.add(new Booking("NO.003", dateFormat.parse("07/08/2022"), dateFormat.parse("13/08/2022"), "KH003", "VILLA001", "None"));
            bookings.add(new Booking("NO.004", dateFormat.parse("07/07/2022"), dateFormat.parse("13/07/2022"), "KH003", "VILLA001", "None"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static Set<Booking> getBookings() {
        return bookings;
    }

    @Override
    public void addNewBooking() {
        Booking newBooking = getBookingInfo();
        if (newBooking == null) return;
        bookings.add(newBooking);
        System.out.println("Booking successfully!");
        facilityService.addingValueToFacilityService(newBooking.getServiceName());
    }

    @Override
    public Booking getBookingInfo() {
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

        String serviceName = "";
        boolean temp = true;
        while (temp) {
            temp = false;
            System.out.print("Input service name: ");
             serviceName = scanner.nextLine();

            for (Facility x : facilityService.getFacilityMaintenanceList().keySet()) {
                if (serviceName.equals(x.getServiceName())) {
                    System.out.println("The service has been used over 5 times, it will be maintained, try again!");
                    temp = true;
                }
            }
        }


        System.out.print("Input service type: ");
        String serviceType = scanner.nextLine();

        Booking newBooking = new Booking(bookingCode, startDate, endDate, customerId, serviceName, serviceType);
        for (Booking x : bookings) {
            if (x.equals(newBooking)) {
                System.out.println("There is already a booking with the same booking code!");
                return null;
            }
        }
        return newBooking;
    }

    @Override
    public void displayListBooking() {
        for (Booking x : bookings) {
            System.out.println(x.toString());
        }
    }
}
