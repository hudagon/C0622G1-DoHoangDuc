package bai_tap_them.bai_1.service.impl;

import bai_tap_them.bai_1.model.Teacher;
import bai_tap_them.bai_1.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    static int size = 0;

    Scanner scanner = new Scanner(System.in);
    static List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher(123, "A Hải", "12/12/1212", "Nam", "Đủ thứ"));
        teachers.add(new Teacher(456, "A Quang", "13/13/1313", "Nam", "Đủ thứ"));
        teachers.add(new Teacher(789, "A Công", "13/13/1313", "Nam", "Đủ thứ"));
    }

    public Teacher getInfo() {
        System.out.print("xin mời nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("xin mời nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("xin mời nhập ngày sinh: ");
        String birthday = scanner.nextLine();
        System.out.print("Xin mời nhập giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Xin mời nhập chuyên môn: ");
        String expertiseAt = scanner.nextLine();
        return new Teacher(id, name, birthday, gender, expertiseAt);
    }

    public Teacher findTeacher1() {
        System.out.print("nhập id học sinh muốn tìm: ");
        int idDelete = Integer.parseInt(scanner.nextLine());

        for (Teacher teacher : teachers) {
            if (teacher.getId() == idDelete) {
                return teacher;
            }
        }
        return null;
    }

    @Override
    public void addTeacher() {
        teachers.add(this.getInfo());
        System.out.println("Thêm mới giáo viên thành công");
        size++;
    }

    @Override
    public void findTeacher() {
        System.out.println("Bạn muốn tìm kiếm dựa theo tên hay id? 1. tên 2. Id");
        System.out.print("Nhập ở đây: ");
        int findChoice = Integer.parseInt(scanner.nextLine());

        if (findChoice == 1) {
            System.out.print("Nhập tên giáo viên: ");
            String nameFind = scanner.nextLine();
            for (Teacher teacher : teachers) {
                if (teacher.getName().contains(nameFind)) {
                    System.out.println(teacher.toString());
                }
            }
        } else if (findChoice == 2) {
            System.out.print("Nhập id giáo viên bạn muốn thao tác: ");
            int idFind = Integer.parseInt(scanner.nextLine());
            for (Teacher teacher : teachers) {
                if (teacher.getId() == (idFind)) {
                    System.out.println(teacher.toString());
                }
            }
        } else {
            System.out.println("Nhập sai!");
        }
    }

    @Override
    public void deleteTeacher() {
        Teacher teacherDelete = this.findTeacher1();
        if (teacherDelete == null) {
            System.out.println("Không tìm thấy id giáo viên cần xóa");
        } else {
            System.out.print("Bạn có chắc chắn muốn xóa giáo viên này không? 1. Có 2. Không: ");
            int choiceDelete = Integer.parseInt(scanner.nextLine());
            if (choiceDelete == 1) {
                teachers.remove(teacherDelete);
                System.out.println("Xóa thành công");
            }
        }
    }

    @Override
    public void display() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
    }

    @Override
    public void editTeacherInfo() {
        Teacher teacherEdit = this.findTeacher1();
        if (teacherEdit == null) {
            System.out.println("Không tìm thấy giáo viên muốn sửa thông tin");
        } else {
            while (true) {
                int positionEdit = teachers.indexOf(teacherEdit);
                System.out.print("Bạn muốn thay đổi thông tin gì?\n" +
                        "1. Tên giáo viên\n" +
                        "2. Id giáo viên\n" +
                        "3. Ngày sinh giáo viên\n" +
                        "4. Chuyên môn giáo viên\n" +
                        "5. Giới tính\n" +
                        "6. Kết thúc\n" +
                        "--> Xin mời nhập ở đây: ");
                int choiceEdit = Integer.parseInt(scanner.nextLine());

                switch (choiceEdit) {
                    case 1:
                        System.out.println("Bạn muốn sửa tên giáo viên lại như thế nào");
                        String newName = scanner.nextLine();
                        teachers.get(positionEdit).setName(newName);
                        System.out.println("Đã sửa tên thành công");
                        break;
                    case 2:
                        System.out.println("Bạn muốn sửa id giáo viên lại như thế nào");
                        int newId = Integer.parseInt(scanner.nextLine());
                        teachers.get(positionEdit).setId(newId);
                        System.out.println("Đã sửa id thành công");
                        break;
                    case 3:
                        System.out.println("Bạn muốn sửa ngày sinh giáo viên lại như thế nào");
                        String newBirthday = scanner.nextLine();
                        teachers.get(positionEdit).setBirthday(newBirthday);
                        System.out.println("Đã sửa ngày sinh thành công");
                        break;
                    case 4:
                        System.out.println("Bạn muốn sửa chuyên môn lại như thế nào");
                        String newExpertise = scanner.nextLine();
                        teachers.get(positionEdit).setExpertiseAt(newExpertise);
                        System.out.println("Đã sửa chuyên môn thành công");
                        break;
                    case 5:
                        System.out.println("Bạn muốn sửa giới tính lại như thế nào");
                        String newGender = scanner.nextLine();
                        teachers.get(positionEdit).setGender(newGender);
                        System.out.println("Đã sửa giới tính thành công");
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Số nhập vào không hợp lệ");
                }
            }
        }
    }

    @Override
    public void sortTeacher() {
        for (int i = 1; i < teachers.size(); i++) {
            Teacher temp1 = teachers.get(i);
            int j;
            for (j = i - 1; j >= 0 && teachers.get(j).getName().compareTo(temp1.getName()) > 0; j--) {
                teachers.set(j + 1, teachers.get(j));
            }
            teachers.set(j + 1, temp1);
        }
        System.out.println("Đã sắp xếp!");
    }
}
