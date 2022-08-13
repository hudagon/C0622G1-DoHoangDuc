package bai_tap_them.bai_1.service.impl;

import bai_tap_them.bai_1.model.Student;
import bai_tap_them.bai_1.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    static int size = 0;

    Scanner scanner = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(123, "A", "1/1/2000","Nam", 8, "C06"));
        students.add(new Student(456, "B", "2/2/2000","Nữ", 8, "C06"));
    }


    public void addStudent() {
        students.add(this.getInfo());
        System.out.println("Thêm mới học sinh thành công");
        size++;
    }

    public Student getInfo() {
        System.out.print("xin mời nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("xin mời nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("xin mời nhập ngày sinh: ");
        String birthday = scanner.nextLine();
        System.out.print("xin mời nhập điểm: ");
        double point = Double.parseDouble(scanner.nextLine());
        System.out.print("xin mời nhập lớp: ");
        String className = scanner.nextLine();
        System.out.print("Xin mời nhập giới tính: ");
        String gender = scanner.nextLine();
        return new Student(id, name, birthday, gender, point, className);
    }

    public Student findStudent() {
        System.out.print("nhập id học sinh muốn tìm: ");
        int idDelete = Integer.parseInt(scanner.nextLine());

        for (Student student : students) {
            if (student.getId() == idDelete) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void deleteStudent() {
        Student studentDelete = this.findStudent();
        if (studentDelete == null) {
            System.out.println("Không tìm thấy id học sinh cần xóa");
        } else {
            System.out.print("Bạn có chắc chắn muốn xóa học sinh này không? 1. Có 2. Không: ");
            int choiceDelete = Integer.parseInt(scanner.nextLine());
            if (choiceDelete == 1) {
                students.remove(studentDelete);
                System.out.println("Xóa thành công");
            }
        }
    }

    @Override
    public void display() {
        if (size == 0) {
            System.out.println("Không có học sinh nào để hiển thị");
        }

        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    @Override
    public void editStudentInfo() {
        Student studentEdit = this.findStudent();
        if (studentEdit == null) {
            System.out.println("Không tìm thấy học sinh muốn sửa thông tin");
        } else {
            while (true) {
                int positionEdit = students.indexOf(studentEdit);
                System.out.print("Bạn muốn thay đổi thông tin gì?\n" +
                        "1. Tên học sinh\n" +
                        "2. Id học sinh\n" +
                        "3. Ngày sinh học sinh\n" +
                        "4. Điểm học sinh\n" +
                        "5. Tên lớp học sinh\n" +
                        "6. Giới tính\n" +
                        "7. Kết thúc\n" +
                        "--> Xin mời nhập ở đây: ");
                int choiceEdit = Integer.parseInt(scanner.nextLine());

                switch (choiceEdit) {
                    case 1:
                        System.out.println("Bạn muốn sửa tên học sinh lại như thế nào");
                        String newName = scanner.nextLine();
                        students.get(positionEdit).setName(newName);
                        System.out.println("Đã sửa tên thành công");
                        break;
                    case 2:
                        System.out.println("Bạn muốn sửa id học sinh lại như thế nào");
                        int newId = Integer.parseInt(scanner.nextLine());
                        students.get(positionEdit).setId(newId);
                        System.out.println("Đã sửa id thành công");
                        break;
                    case 3:
                        System.out.println("Bạn muốn sửa ngày sinh học sinh lại như thế nào");
                        String newBirthday = scanner.nextLine();
                        students.get(positionEdit).setBirthday(newBirthday);
                        System.out.println("Đã sửa ngày sinh thành công");
                        break;
                    case 4:
                        System.out.println("Bạn muốn sửa điểm học sinh lại như thế nào");
                        double newPoint = Double.parseDouble(scanner.nextLine());
                        students.get(positionEdit).setPoint(newPoint);
                        System.out.println("Đã sửa điểm thành công");
                        break;
                    case 5:
                        System.out.println("Bạn muốn sửa tên lớp lại như thế nào");
                        String newClassname = scanner.nextLine();
                        students.get(positionEdit).setClassName(newClassname);
                        System.out.println("Đã sửa tên lớp thành công");
                        break;
                    case 6:
                        System.out.println("Bạn muốn sửa giới tính lại như thế nào");
                        String newGender = scanner.nextLine();
                        students.get(positionEdit).setGender(newGender);
                        System.out.println("Đã sửa giới tính thành công");
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Số nhập vào không hợp lệ");
                }
            }
        }
    }
}
