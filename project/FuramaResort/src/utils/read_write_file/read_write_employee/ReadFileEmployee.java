package utils.read_write_file.read_write_employee;

import models.creatures.Employee;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class ReadFileEmployee {
    static public List<Employee> readEmployeeFile(String path) {
        List<Employee> employees = new LinkedList<>();

        try {
            File file = new File(path);

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lines = line.split(",");
                employees.add(new Employee(
                        lines[0],
                        lines[1],
                        lines[2],
                        Integer.parseInt(lines[3]),
                        lines[4],
                        lines[5],
                        lines[6],
                        lines[7],
                        lines[8],
                        Double.parseDouble(lines[9])));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("404 File Not Found!");
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
        return employees;
    }
}
