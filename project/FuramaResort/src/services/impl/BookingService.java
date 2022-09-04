package services.impl;

import models.things.Booking;
import models.things.Facility;
import services.IBookingService;
import utils.read_write_file.read_write_booking.ReadFileBooking;
import utils.read_write_file.read_write_booking.WriteFileBooking;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class BookingService implements IBookingService {
    WriteFileBooking writeFileBooking = new WriteFileBooking();
    Scanner scanner = new Scanner(System.in);
    CustomerService customerService = new CustomerService();
    FacilityService facilityService = new FacilityService();
    private  final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static Set<Booking> bookings;
    static String PATH = "src\\data\\booking.csv";

    static {
        bookings = ReadFileBooking.readFileBooking(PATH);
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    @Override
    public void addNewBooking() {
        bookings = ReadFileBooking.readFileBooking(PATH);
        Booking newBooking = getBookingInfo();
        if (newBooking == null) return;
        bookings.add(newBooking);
        System.out.println("Booking successfully!");
        facilityService.addingValueToFacilityService(newBooking.getServiceName());
        writeFileBooking.writeFileBooking(PATH, bookings);
    }

    @Override
    public Booking getBookingInfo() {
        bookings = ReadFileBooking.readFileBooking(PATH);
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
        bookings = ReadFileBooking.readFileBooking(PATH);
        for (Booking x : bookings) {
            System.out.println(x.toString());
        }
    }
}
