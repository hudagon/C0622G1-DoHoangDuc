package controller;

import java.util.Scanner;

public class CustomerController {
    Scanner scanner = new Scanner(System.in);
    public void customerMenu() {
        System.out.println("--------CustomerMenu--------");
        System.out.println("1. Thêm mới \n" +
                "2. Hiển thị\n" +
                "3. Hiển thị địa chỉ khách hàng\n" +
                "4. Thoát");
        int choice = Integer.parseInt(scanner.nextLine());
    }
}
