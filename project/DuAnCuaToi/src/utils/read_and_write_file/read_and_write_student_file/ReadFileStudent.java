package utils.read_and_write_file.read_and_write_student_file;

import models.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class ReadFileStudent {
    static public List<Student> readCustomerFile(String path) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        List<Student> customers = new LinkedList<>();

        try {
            File file = new File(path);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] elements;
            while ((line = bufferedReader.readLine()) != null) {
                elements = line.split(",");
                customers.add(new Student(
                        elements[0],
                        elements[1],
                        elements[2],
                        elements[3],
                        elements[4],
                        Double.parseDouble(elements[5]),
                        elements[6],
                        dateFormat.parse(elements[7])));

            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("404 File Not Found!");
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
        return customers;
    }
}
