package utils.read_write_file.read_write_contract;

import models.things.Contract;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileContract {
    public static List<Contract> readFileContract(String path) {
        List<Contract> contracts = new ArrayList<>();

        try {
            File fileToRead = new File(path);
            FileReader fileReader = new FileReader(fileToRead);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] elements;
            while ((line = bufferedReader.readLine()) != null) {
                elements = line.split(",");
                contracts.add(new Contract(
                        Integer.parseInt(elements[0]),
                        elements[1],
                        Double.parseDouble(elements[2]),
                        Double.parseDouble(elements[3]),
                        elements[4]
                ));
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("404 File Not Found");
        }
        return contracts;
    }
}
