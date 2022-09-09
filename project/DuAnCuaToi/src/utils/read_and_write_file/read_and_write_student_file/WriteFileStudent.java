package utils.read_and_write_file.read_and_write_student_file;

import models.Employee;
import models.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFileStudent {
    public static void writeStudentFile(String path, List<Student> students) {
        try {
            File file = new File(path);
            FileWriter writer = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            List<String> result = listStudentConvertedToListString(students);

            for (String student : result) {
                bufferedWriter.write(student);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Something went wrong!");
        }
    }

    public static List<String> listStudentConvertedToListString(List<Student> students) {
        List<String> result = new ArrayList<>();
        for (Student x : students) {
            result.add(x.getInfo());
        }
        return result;
    }
}
