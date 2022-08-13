package bai_tap_them.bai_1.view;

import bai_tap_them.bai_1.controller.StudentController;
import bai_tap_them.bai_1.controller.TeacherController;

import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("Chào Mừng Đến Với Hệ Thống Quản Lý CodeGym");
            System.out.println();
            System.out.println("Bạn muốn thao tác với giáo viên hay học sinh? \n" +
                    "1. Học sinh  \n" +
                    "2. Giáo Viên\n" +
                    "3. Kết thúc chương trình");
            System.out.print("Xin mời nhập số bạn muốn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    StudentController studentController = new StudentController();
                    studentController.menuManagement();
                    break;
                case 2:
                    TeacherController teahcerController = new TeacherController();
                    teahcerController.menuManagement();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Số bạn nhập không hợp lệ, vui lòng nhập lại");
            }

        }
    }
}
