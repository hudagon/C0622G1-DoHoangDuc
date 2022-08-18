package bai_tap_them.bai_1.controller;

import bai_tap_them.bai_1.service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    TeacherService teacherService = new TeacherService();
    Scanner scanner = new Scanner(System.in);


    public void menuManagement() {
        while (true) {
            System.out.println("-------------------------------");
            System.out.println("1. Hiển thị thông tin giáo viên");
            System.out.println("2. Thêm mới giáo viên");
            System.out.println("3. Sửa đổi thông tin ");
            System.out.println("4. Xóa giáo viên");
            System.out.println("5. Tìm kiếm giáo viên");
            System.out.println("6. Sắp xếp theo tên giáo viên");
            System.out.println("7. Kết thúc chương trình");
            System.out.print("Xin mời quý khách nhập số để chọn chức năng (1->5): ");
            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    teacherService.display();
                    break;
                case 2:
                    teacherService.addTeacher();
                    break;
                case 3:
                    teacherService.editTeacherInfo();
                    break;
                case 4:
                    teacherService.deleteTeacher();
                    break;
                case 5:
                    teacherService.findTeacher();
                    break;
                case 6:
                    teacherService.sortTeacher();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Quý khách nhập không hợp lệ");
            }
        }
    }
}
