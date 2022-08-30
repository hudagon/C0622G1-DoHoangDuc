package service.impl;

import model.creature.Employee;
import service.IEmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    Scanner scanner = new Scanner(System.in);
    static List<Employee> employeeList = new ArrayList<>();


    static {
        employeeList.add(new Employee("Nguyễn văn A", 20, "NV001"));
        employeeList.add(new Employee("Nguyễn văn B", 21, "NV002"));
        employeeList.add(new Employee("Nguyễn văn C", 22, "NV003"));
    }

    public Employee layThongTinNhanVien() {
        System.out.println("Xin moi nhap ten nhan vien!");
        String employeeName = scanner.nextLine();
        System.out.println("Xin moi nhap tuoi nhan vien");
        int employeeAge = Integer.parseInt(scanner.nextLine());
        System.out.println("Xin moi nhap ma nhan vien");
        String employeeId = scanner.nextLine();

        return new Employee(employeeName, employeeAge, employeeId);
    }

    @Override
    public void hienThiMaNhanVien() {
        for (int i = 0; i < employeeList.size() ; i++) {
            System.out.println(employeeList.get(i).getEmployeeId());
        }
    }

    @Override
    public void themMoi() {
        Employee employeeNew = this.layThongTinNhanVien();
        employeeList.add(employeeNew);
        System.out.println("Da them moi thanh cong");
    }

    @Override
    public void hienThi() {
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
    }
}
