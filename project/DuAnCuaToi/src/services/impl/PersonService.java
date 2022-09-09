package services.impl;

import models.Employee;
import models.Person;
import models.Student;
import services.IPersonService;
import utils.exception.DuplicatePersonalRecordException;
import utils.read_and_write_file.read_and_write_employee_file.ReadFileEmployee;
import utils.read_and_write_file.read_and_write_employee_file.WriteFileEmployee;
import utils.read_and_write_file.read_and_write_student_file.ReadFileStudent;
import utils.read_and_write_file.read_and_write_student_file.WriteFileStudent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PersonService implements IPersonService {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private static final String STUDENT_PATH = "src\\data\\student_record.csv";
    private static final String EMPLOYEE_PATH = "src\\data\\employee_record.csv";
    private final Scanner scanner = new Scanner(System.in);
    private List<Student> students = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();


    @Override
    public void add() throws ParseException {
        students = ReadFileStudent.readCustomerFile(STUDENT_PATH);
        employees = ReadFileEmployee.readEmployeeFile(EMPLOYEE_PATH);
        System.out.print("----------Adding new person----------\n" +
                "Choose kind of person:\n" +
                "1. Add new employee\n" +
                "2. Add new student\n" +
                "3. Return\n" +
                "Input here: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                Employee newEmployee = this.getEmployeeInfo();
                employees.add(newEmployee);
                System.out.println("New employee added successfully!");
                WriteFileEmployee.writeEmployeeFile(EMPLOYEE_PATH, employees);
                break;
            case 2:
                Student newStudent = this.getStudentInfo();
                students.add(newStudent);
                System.out.println("New student added successfully!");
                WriteFileStudent.writeStudentFile(STUDENT_PATH, students);
                break;
            case 3:
                return;
            default:
                System.out.println("Wrong input!");
        }
    }

    @Override
    public void display() {
        students = ReadFileStudent.readCustomerFile(STUDENT_PATH);
        employees = ReadFileEmployee.readEmployeeFile(EMPLOYEE_PATH);
        for (Student x : students) {
            System.out.println(x.toString());
        }
        for (Employee x : employees) {
            System.out.println(x);
        }
    }

    @Override
    public void delete() {
        Person personToDelete = this.findPerson();
        System.out.print("Do you really want to delete?\n" +
                "1. Yes\n" +
                "2. No\n" +
                "Input here: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                if (personToDelete.getId().contains("HV")) {
                    students.remove(personToDelete);
                    WriteFileStudent.writeStudentFile(STUDENT_PATH, students);
                } else {
                    employees.remove(personToDelete);
                    WriteFileEmployee.writeEmployeeFile(EMPLOYEE_PATH, employees);
                }
                System.out.println("Delete successfully!");
                this.display();
                break;
            case 2:
                break;
        }
    }

    @Override
    public Employee getEmployeeInfo() {
        String id;
        while (true) {
            try {
                System.out.print("Input id: ");
                id = scanner.nextLine();
                for (Employee x : employees) {
                    if (x.getId().equals(id)) {
                        throw new DuplicatePersonalRecordException("There is already a employee with the given id");
                    }
                }
                break;
            } catch (DuplicatePersonalRecordException e) {
                System.out.println(e.getMessage());
            }
        }


        System.out.print("Input name: ");
        String name = scanner.nextLine();
        System.out.print("Input birthday: ");
        String birthday = scanner.nextLine();
        System.out.print("Input address: ");
        String address = scanner.nextLine();
        System.out.print("Input phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Input salary: ");
        double salary = Double.parseDouble(scanner.nextLine());
        System.out.print("Input department: ");
        String department = scanner.nextLine();
        System.out.print("Input position: ");
        String position = scanner.nextLine();

        return new Employee(id, name, birthday, address, phoneNumber, salary, department, position);
    }

    @Override
    public Student getStudentInfo() throws ParseException {
        String id;
        while (true) {
            try {
                System.out.print("Input id: ");
                id = scanner.nextLine();
                for (Student x : students) {
                    if (x.getId().equals(id)) {
                        throw new DuplicatePersonalRecordException("There is already a student with the given id");
                    }
                }
                break;
            } catch (DuplicatePersonalRecordException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Input name: ");
        String name = scanner.nextLine();
        System.out.print("Input birthday: ");
        String birthday = scanner.nextLine();
        System.out.print("Input address: ");
        String address = scanner.nextLine();
        System.out.print("Input phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Input score: ");
        double score = Double.parseDouble(scanner.nextLine());
        System.out.print("Input class name: ");
        String className = scanner.nextLine();
        System.out.print("Input starting date: ");
        Date startingDate = dateFormat.parse(scanner.nextLine());


        return new Student(id, name, birthday, address, phoneNumber, score, className, startingDate);
    }

    @Override
    public Person findPerson() {
       while (true) {
           System.out.print("Input the id of the person: ");
           String id = scanner.nextLine();

           Person person = null;
           for (Student x : students) {
               if (x.getId().equals(id)) {
                   person = x;
               }
           }
           for (Employee x : employees) {
               if (x.getId().equals(id)) {
                   person = x;
               }
           }
           if (person != null) {
               return person;
           }
           System.out.println("Can't find person, try again!");
       }
    }
}
