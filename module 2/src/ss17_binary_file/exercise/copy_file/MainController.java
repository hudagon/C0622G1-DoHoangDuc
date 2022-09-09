package ss17_binary_file.exercise.copy_file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) throws IOException {
        copy();
    }

    public static void writeFile(String path, List<String> files) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(files);

            objectOutputStream.close();
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

            objectInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("404: File not found");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error!");
        }
        return files;
    }

    public static void copy() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input source file: ");
        String source = scanner.nextLine();
        System.out.print("Input target file: ");
        String target = scanner.nextLine();

        FileInputStream inputStream = new FileInputStream(source);
        List<String> files = readFile(source);
        writeFile(target, files);
        System.out.println("The file's size is " + inputStream.available());
        System.out.println("file copied successfully");
    }
}