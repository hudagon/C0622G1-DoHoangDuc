package ss1_introduction_to_java.bai_tap.display_greetings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name;

        System.out.println("Please input your name here: ");
        name = scanner.nextLine();

        System.out.println("Hello " + name + " !");
    }
}
