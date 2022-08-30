package controller;

import service.impl.EmployeeService;

import java.util.Scanner;

public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();
    Scanner scanner = new Scanner(System.in);
    public void employeeMenu() {
        while (true) {
            System.out.println("--------EmployeeMenu--------");
            System.out.println("1. Thêm mới \n" +
                    "2. Hiển thị\n" +
                    "3. Hiển thị mã nhân viên\n" +
                    "4. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    employeeService.themMoi();
                    break;
                case 2:
                    employeeService.hienThi();
                    break;
                case 3:
                    employeeService.hienThiMaNhanVien();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Nhap sai, xin moi nhap lai!");
            }
        }
    }
}
