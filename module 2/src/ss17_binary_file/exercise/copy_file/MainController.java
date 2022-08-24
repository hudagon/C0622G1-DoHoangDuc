package ss17_binary_file.exercise.copy_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        copy();
    }

    public static void writeFile(String path, String readPath) {
        List<String> fileData = readFile(readPath);
        try {
            FileInputStream fileInputStream = new FileInputStream(readPath);
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            long size = fileInputStream.getChannel().size();
            System.out.println("the file size is " + size);

            objectOutputStream.writeObject(fileData);

        } catch (FileNotFoundException e) {
            System.out.println("404 File Not Found");
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

    public static List<String> readFile(String path) {
        List<String> files = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            files = (List<String>) objectInputStream.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("404: File not found");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error!");
        }
        return files;
    }

    public static void copy() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input source file: ");
        String source = scanner.nextLine();
        System.out.print("Input target file: ");
        String target = scanner.nextLine();
        readFile(source);
        writeFile(target, source);
        System.out.println("file copied successfully");
    }
}
