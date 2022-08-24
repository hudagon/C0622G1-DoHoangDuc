package ss17_binary_file.practice.read_and_write_binary_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToObject(String path, List<Student> students) throws IOException {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(students);
        oos.close();
    }

    public static List<Student> readDataFromFile(String path) throws IOException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        students = (List<Student>) ois.readObject();
        ois.close();

        return students;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        students.add(new Student("ok",1.2));
        students.add(new Student("ok",1.2));
        students.add(new Student("ok",1.2));

        writeToObject("src\\ss17_binary_file\\practice\\read_and_write_binary_file\\data.dat", students);

        List<Student> students1 = readDataFromFile("src\\ss17_binary_file\\practice\\read_and_write_binary_file\\data.dat");
        for (Student student : students1) {
            System.out.println(student);

        }
    }
}
