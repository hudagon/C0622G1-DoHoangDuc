package utils.read_write_file.read_write_booking;

import models.creatures.Customer;
import models.things.Booking;
import utils.comparator.SortByStartDateThenEndDate;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TreeSet;

public class ReadFileBooking {
    public static Set<Booking> readFileBooking(String path) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Set<Booking> bookings = new TreeSet<>(new SortByStartDateThenEndDate());
        try {
            File fileToRead = new File(path);
            FileReader fileReader = new FileReader(fileToRead);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] elements;
            while ((line = bufferedReader.readLine()) != null) {
                elements = line.split(",");
                bookings.add(new Booking(
                        elements[0],
                        dateFormat.parse(elements[1]),
                        dateFormat.parse(elements[2]),
                        elements[3],
                        elements[4],
                        elements[5]
                ));
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("404 File Not Found");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}
