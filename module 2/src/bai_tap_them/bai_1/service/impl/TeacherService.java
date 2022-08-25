package bai_tap_them.bai_1.service.impl;

import bai_tap_them.bai_1.model.Student;
import bai_tap_them.bai_1.model.Teacher;
import bai_tap_them.bai_1.service.ITeacherService;
import bai_tap_them.bai_1.service.utils.exception.IdException;
import bai_tap_them.bai_1.utils.validation.name_validate.NameValidate;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {

    Scanner scanner = new Scanner(System.in);
    static List<Teacher> teachers = new ArrayList<>();

    public Teacher getInfo() {
        int id;
        while (true) {
            try {
                System.out.print("Xin mời nhập id: ");
                id = Integer.parseInt(scanner.nextLine());

                for (Teacher teacher : teachers) {
                    if (teacher.getId() == id) {
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
                if (NameValidate.validate(name)) {
                    break;
                } else {
                    System.out.println("Tên không đúng định dạng, vui lòng nhập lại!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không phải là chữ. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }

        String birthday;
        while (true) {
            try {
                System.out.print("Mời bạn nhập ngày sinh theo định dạng ngày/tháng/năm: ");
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

        String expertiseAt;
        while (true) {
            try {
                System.out.print("Mời bạn nhập chuyên môn: ");
                expertiseAt = scanner.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Bạn nhập không phải là chữ. Vui lòng nhập lại.");
            } catch (Exception e) {
                System.out.println("Bạn nhập không hợp lệ");
            }
        }
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

    public List<Teacher> readFile(String path) {
        List<Teacher> teachers = new ArrayList<>();
        try {
            File fileTeacher = new File(path);

            if (!fileTeacher.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileTeacher));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] teacher = line.split(",");
                teachers.add(new Teacher(Integer.parseInt(teacher[0]), teacher[1],
                        teacher[2], teacher[3], teacher[4]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teachers;
    }

    public void writeFile(String path, boolean append,List<String> str) {
        try {
            File fileTeacher = new File(path);

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTeacher));
            for (String teachers : str) {
                bufferedWriter.write(teachers);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println("File đã tồn tại!");
        }
    }

    public String ConvertStudentFormat(Teacher teacher) {
        return teacher.getId() + "," + teacher.getName() + "," + teacher.getBirthday() + "," + teacher.getGender() + ","
                + teacher.getExpertiseAt();
    }

    public List<String> listTeacherConvertedToString() {
        List<String> result = new ArrayList<>();
        for (Teacher teacher : teachers) {
            result.add(ConvertStudentFormat(teacher));
        }
        return result;
    }

    @Override
    public void addTeacher() {
        readFile("src\\bai_tap_them\\bai_1\\data\\teachers.txt");
        teachers.add(this.getInfo());
        System.out.println("Thêm mới giáo viên thành công");
        writeFile("src\\bai_tap_them\\bai_1\\data\\teachers.txt",true,listTeacherConvertedToString());
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
        readFile("src\\bai_tap_them\\bai_1\\data\\teachers.txt");
        Teacher teacherDelete = this.findTeacher1();
        if (teacherDelete == null) {
            System.out.println("Không tìm thấy id giáo viên cần xóa");
        } else {
            System.out.print("Bạn có chắc chắn muốn xóa giáo viên này không? 1. Có 2. Không: ");
            int choiceDelete = Integer.parseInt(scanner.nextLine());
            if (choiceDelete == 1) {
                teachers.remove(teacherDelete);
                writeFile("src\\bai_tap_them\\bai_1\\data\\teachers.txt",true,listTeacherConvertedToString());
                System.out.println("Xóa thành công");
            }
        }
    }

    @Override
    public void display() {
        teachers = readFile("src\\bai_tap_them\\bai_1\\data\\teachers.txt");
        if (teachers.size() == 0) {
            System.out.println("Không có thông tin để hiện thị");
        }
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
    }

    @Override
    public void editTeacherInfo() {
        readFile("src\\bai_tap_them\\bai_1\\data\\teachers.txt");
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
                        writeFile("src\\bai_tap_them\\bai_1\\data\\teachers.txt",true,listTeacherConvertedToString());
                        System.out.println("Đã sửa tên thành công");
                        break;
                    case 2:
                        System.out.println("Bạn muốn sửa id giáo viên lại như thế nào");
                        int newId = Integer.parseInt(scanner.nextLine());
                        teachers.get(positionEdit).setId(newId);
                        writeFile("src\\bai_tap_them\\bai_1\\data\\teachers.txt",true,listTeacherConvertedToString());
                        System.out.println("Đã sửa id thành công");
                        break;
                    case 3:
                        System.out.println("Bạn muốn sửa ngày sinh giáo viên lại như thế nào");
                        String newBirthday = scanner.nextLine();
                        teachers.get(positionEdit).setBirthday(newBirthday);
                        writeFile("src\\bai_tap_them\\bai_1\\data\\teachers.txt",true,listTeacherConvertedToString());
                        System.out.println("Đã sửa ngày sinh thành công");
                        break;
                    case 4:
                        System.out.println("Bạn muốn sửa chuyên môn lại như thế nào");
                        String newExpertise = scanner.nextLine();
                        teachers.get(positionEdit).setExpertiseAt(newExpertise);
                        writeFile("src\\bai_tap_them\\bai_1\\data\\teachers.txt",true,listTeacherConvertedToString());
                        System.out.println("Đã sửa chuyên môn thành công");
                        break;
                    case 5:
                        System.out.println("Bạn muốn sửa giới tính lại như thế nào");
                        String newGender = scanner.nextLine();
                        teachers.get(positionEdit).setGender(newGender);
                        writeFile("src\\bai_tap_them\\bai_1\\data\\teachers.txt",true,listTeacherConvertedToString());
                        System.out.println("Đã sửa giới tính thành công");
                        break;
                    case 6:
                        writeFile("src\\bai_tap_them\\bai_1\\data\\teachers.txt",true,listTeacherConvertedToString());
                        return;
                    default:
                        System.out.println("Số nhập vào không hợp lệ");
                }
            }
        }
    }

    @Override
    public void sortTeacher() {
        readFile("src\\bai_tap_them\\bai_1\\data\\teachers.txt");
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
