package utils.read_write_file.read_write_contract;

import models.things.Booking;
import models.things.Contract;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

public class WriteFileContract {
    public static void writeFileBooking(String path, List<Contract> contracts) {
        List<String> result = listContractConvertedToString(contracts);
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

    public static List<String> listContractConvertedToString (List<Contract> contracts) {
        List<String> result = new LinkedList<>();

        for (Contract x : contracts) {
            result.add(contractConvertedToStringInTheRightFormat(x));
        }

        return result;
    }

    public static String contractConvertedToStringInTheRightFormat (Contract contract) {
        return contract.getContractNumber() + "," +
                contract.getBookingCode() + "," +
                contract.getDeposit() + "," +
                contract.getTotalPayment() + "," +
                contract.getCustomerId();
    }
}
