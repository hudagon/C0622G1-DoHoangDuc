package utils.read_write_file.read_write_booking;

import models.things.Booking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WriteFileBooking {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public void writeFileBooking(String path, Set<Booking> bookings) {
        List<String> result = listBookingConvertedToString(bookings);
        try {
            File fileToWrite = new File(path);
            FileWriter fileWriter = new FileWriter(fileToWrite);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String line : result) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }

    public List<String> listBookingConvertedToString (Set<Booking> bookings) {
        List<String> result = new LinkedList<>();

        for (Booking x : bookings) {
            result.add(customerConvertedToStringInTheRightFormat(x));
        }

        return result;
    }

    public String customerConvertedToStringInTheRightFormat (Booking booking) {
        return booking.getBookingCode() + "," +
                dateFormat.format(booking.getStartDate()) + "," +
                dateFormat.format(booking.getEndDate()) + "," +
                booking.getCustomerId() + "," +
                booking.getServiceName() + "," +
                booking.getServiceType();
    }
}
