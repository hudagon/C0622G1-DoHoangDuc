package demo;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Employee> employees;
        employees = readFile("src\\demo\\data.txt");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
        writeFile("src\\demo\\ok.txt", false, employees);
    }


    public static List<Employee> readFile(String path) throws IOException {
        List<Employee> employees = new LinkedList<>();

        File file = new File(path);

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lines = line.split(",");
            employees.add(new Employee(lines[0], lines[1]));
        }
        return employees;
    }

    public static void writeFile(String path, boolean append, List<Employee> employees) throws IOException {
        File file = new File(path);

        FileWriter writer = new FileWriter(file, append);

        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        List<String> result = listStudentConvertedToListString(employees);

        for (String employee : result) {
            bufferedWriter.write(employee);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static List<String> listStudentConvertedToListString(List<Employee> employees) {
        List<String> result = new ArrayList<String>();
        for (Employee x : employees) {
            result.add(convertEmployeeToStringInRightFormat(x));
        }
        return result;
    }

    public static String convertEmployeeToStringInRightFormat(Employee employee) {
        return employee.getName() + "," + employee.getId();
    }
}
