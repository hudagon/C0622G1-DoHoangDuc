package bai_tap_them.bai_1.service.impl;

import bai_tap_them.bai_1.model.Student;
import bai_tap_them.bai_1.model.Teacher;
import bai_tap_them.bai_1.service.IStudentService;
import bai_tap_them.bai_1.service.utils.exception.IdException;
import bai_tap_them.bai_1.service.utils.exception.PointException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {

    Scanner scanner = new Scanner(System.in);
    static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(123, "Nguyễn Văn D", "1/1/2000", "Nam", 8, "C06"));
        students.add(new Student(456, "Nguyễn Văn C", "2/2/2000", "Nữ", 8, "C06"));
        students.add(new Student(789, "Nguyễn Văn B", "2/2/2000", "Nữ", 8, "C06"));
        students.add(new Student(101112, "Nguyễn Văn A", "2/2/2000", "Nữ", 8, "C06"));
    }

    public Student getInfo() {
        int id;
        while (true) {
            try {
                System.out.print("Xin mời nhập id: ");
                id = Integer.parseInt(scanner.nextLine());

                for (Student student : students) {
                    if (student.getId() == id) {
                        throw new IdException("Id này đã tồn tại. Vui lòng nhập id khác.");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Vui lòng nhập lại.");
            } catch (IdException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String name;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên: ");
                name = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không phải là chữ. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String birthday;
        while (true) {
            try {
                System.out.print("Mời bạn nhập ngày sinh theo định dạng ngày/tháng/năm:  ");
                birthday = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không đúng định dạng. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String gender;
        while (true) {
            try {
                System.out.print("Mời bạn nhập giới tính: ");
                gender = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không phải là chữ. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        double point;
        while (true) {
            try {
                System.out.print("Mời bạn nhập điểm: ");
                point = Integer.parseInt(scanner.nextLine());
                if (point < 0 || point > 100) {
                    throw new PointException("Bạn không thể nhập điểm nhỏ hơn 0 và lớn hơn 100");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Bạn nhập không phải là số. Yêu cầu nhập lại.");
            } catch (PointException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String className;
        while (true) {
            try {
                System.out.print("Mời bạn nhập tên lớp: ");
                className = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không phải là chữ. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }
        return new Student(id, name, birthday, gender, point, className);
    }

    public Student findStudent1() {
        System.out.print("Nhập id học sinh bạn muốn thao tác: ");
        int findChoice = Integer.parseInt(scanner.nextLine());

        for (Student student : students) {
            if (student.getId() == findChoice) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void addStudent() {
        students.add(this.getInfo());
        System.out.println("Thêm mới học sinh thành công");
    }

    @Override
    public void findStudent() {
        System.out.println("Bạn muốn tìm kiếm dựa theo tên hay id? 1. tên 2. Id");
        System.out.print("Nhập ở đây: ");
        int findChoice = Integer.parseInt(scanner.nextLine());

        if (findChoice == 1) {
            System.out.print("Nhập tên học sinh: ");
            String nameFind = scanner.nextLine();
            for (Student student : students) {
                if (student.getName().contains(nameFind)) {
                    System.out.println(student.toString());
                }
            }
        } else if (findChoice == 2) {
            System.out.print("Nhập id học sinh bạn muốn thao tác: ");
            int idFind = Integer.parseInt(scanner.nextLine());
            for (Student student : students) {
                if (student.getId() == (idFind)) {
                    System.out.println(student.toString());
                }
            }
        } else {
            System.out.println("Nhập sai!");
        }
    }

    @Override
    public void sortStudent() {

        for (int i = 1; i < students.size(); i++) {
            Student temp1 = students.get(i);
            int j;
            for (j = i - 1; j >= 0 && students.get(j).getName().compareTo(temp1.getName()) > 0; j--) {
                students.set(j + 1, students.get(j));
            }
            students.set(j + 1, temp1);
        }

        System.out.println("Đã sắp xếp!");
    }

    @Override
    public void deleteStudent() {
        Student studentDelete = this.findStudent1();
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
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    @Override
    public void editStudentInfo() {
        Student studentEdit = this.findStudent1();
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
