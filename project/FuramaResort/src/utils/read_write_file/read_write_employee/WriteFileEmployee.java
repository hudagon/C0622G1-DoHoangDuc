package utils.read_write_file.read_write_employee;

import models.creatures.Employee;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFileEmployee {
    public static void writeEmployeeFile(String path, boolean append, List<Employee> employees) {
        try {
            File file = new File(path);

            FileWriter writer = new FileWriter(file, append);

            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            List<String> result = listStudentConvertedToListString(employees);

            for (String employee : result) {
                bufferedWriter.write(employee);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public static List<String> listStudentConvertedToListString(List<Employee> employees) {
        List<String> result = new ArrayList<>();
        for (Employee x : employees) {
            result.add(convertEmployeeToStringInRightFormat(x));
        }
        return result;
    }

    public static String convertEmployeeToStringInRightFormat(Employee employee) {
        return employee.getName() + "," +
                employee.getBirthday() + "," +
                employee.getGender() + "," +
                employee.getCitizenIdentityNumber() + "," +
                employee.getPhoneNumber() + "," +
                employee.getEmailAddress() + "," +
                employee.getId() + "," +
                employee.getEmployeeQualifications() + "," +
                employee.getEmployeePosition() + "," +
                employee.getEmployeeSalary();
    }
}
