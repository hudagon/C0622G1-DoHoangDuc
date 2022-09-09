package utils.read_and_write_file.read_and_write_employee_file;

import models.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFileEmployee {
    public static void writeEmployeeFile(String path, List<Employee> employees) {
        try {
            File file = new File(path);
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            List<String> result = listEmployeeConvertedToListString(employees);

            for (String employee : result) {
                bufferedWriter.write(employee);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public static List<String> listEmployeeConvertedToListString(List<Employee> employees) {
        List<String> result = new ArrayList<>();
        for (Employee x : employees) {
            result.add(x.getInfo());
        }
        return result;
    }
}
