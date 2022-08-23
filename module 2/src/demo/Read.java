package demo;

import java.io.*;

public class Read {
    public static void main(String[] args) throws IOException {
        write();

    }

    public static void read() throws IOException {
        File file = new File("C:\\Users\\Xuan Vinh\\Desktop\\okokok.txt");

        FileReader reader = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("")) {
                continue;
            }
            System.out.println(line);
        }
        bufferedReader.close();
    }

    public static void write() throws IOException {
        File file1 = new File("C:\\Users\\Xuan Vinh\\Desktop\\okok123.txt");

        FileWriter writer = new FileWriter(file1);

        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        File file2 = new File("C:\\Users\\Xuan Vinh\\Desktop\\okokok.txt");

        FileReader reader = new FileReader(file2);

        BufferedReader bufferedReader = new BufferedReader(reader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("")) {
                continue;
            }
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        bufferedReader.close();
    }
}
