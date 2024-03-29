package bai_tap_them.bai_1.controller;

import bai_tap_them.bai_1.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    StudentService studentService = new StudentService();
    Scanner scanner = new Scanner(System.in);


    public void menuManagement() {
        while (true) {
            System.out.println("-------------------------------");
            System.out.println("1. Hiển thị thông tin học sinh");
            System.out.println("2. Thêm mới học sinh");
            System.out.println("3. Sửa đổi thông tin ");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Tìm kiếm học sinh");
            System.out.println("6. Sắp xếp theo tên học sinh");
            System.out.println("7. Kết thúc chương trình");
            System.out.print("Xin mời quý khách nhập số để chọn chức năng (1->5): ");
            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    studentService.display();
                    break;
                case 2:
                    studentService.addStudent();
                    break;
                case 3:
                    studentService.editStudentInfo();
                    break;
                case 4:
                    studentService.deleteStudent();
                    break;
                case 5:
                    studentService.findStudent();
                    break;
                case 6:
                    studentService.sortStudent();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Quý khách nhập không hợp lệ");
            }
        }
    }
}
