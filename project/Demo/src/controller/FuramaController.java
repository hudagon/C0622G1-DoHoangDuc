package controller;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class FuramaController {
    EmployeeController employeeController = new EmployeeController();
    CustomerController customerController = new CustomerController();
    Scanner scanner = new Scanner(System.in);
    public void furamaMenu() {
        System.out.println("---------Welcome---------");
        System.out.println("1. EmployeeController \n" +
                "2. CustomerController \n" +
                "3. Exit");
        System.out.print("Xin moi nhap vao o day: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                employeeController.employeeMenu();
                break;
            case 2:
                customerController.customerMenu();
                break;
            case 3:
                System.out.println("Hẹn gặp lại");
                return;
            default:
                System.out.println("Nhập không đúng số!");
        }
    }
}
