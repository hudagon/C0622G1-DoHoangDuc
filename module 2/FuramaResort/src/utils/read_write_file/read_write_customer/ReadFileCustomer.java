package utils.read_write_file.read_write_customer;

import models.creatures.Customer;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadFileCustomer {
    public static List<Customer> readFileCustomer(String path) {
        List<Customer> customers = new LinkedList<>();
        try {
            File fileToRead = new File(path);
            FileReader fileReader = new FileReader(fileToRead);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] elements;
            while ((line = bufferedReader.readLine()) != null) {
                elements = line.split(",");
                customers.add(new Customer(
                        elements[0],
                        elements[1],
                        elements[2],
                        Integer.parseInt(elements[3]),
                        elements[4],
                        elements[5],
                        elements[6],
                        elements[7],
                        elements[8]
                ));
            }

            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("404 File Not Found");
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
        return customers;
    }
}
