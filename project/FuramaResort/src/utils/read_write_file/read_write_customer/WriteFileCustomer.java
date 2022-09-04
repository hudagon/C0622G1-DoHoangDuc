package utils.read_write_file.read_write_customer;

import models.creatures.Customer;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class WriteFileCustomer {
    public static void writeFileCustomer(String path, List<Customer> customers) {
        List<String> result = listCustomerConvertedToString(customers);
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

    public static List<String> listCustomerConvertedToString (List<Customer> customers) {
        List<String> result = new LinkedList<>();

        for (Customer x : customers) {
            result.add(customerConvertedToStringInTheRightFormat(x));
        }

        return result;
    }

    public static String customerConvertedToStringInTheRightFormat (Customer customer) {
        return customer.getName() + "," +
                customer.getBirthday() + "," +
                customer.getGender() + "," +
                customer.getCitizenIdentityNumber() + "," +
                customer.getPhoneNumber() + "," +
                customer.getEmailAddress() + "," +
                customer.getId() + "," +
                customer.getCustomerClassification() + "," +
                customer.getAddress();
    }
}
