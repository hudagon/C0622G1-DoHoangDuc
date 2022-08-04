package ss4_oop.practice.rectangle_class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double height, width;

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the height: ");
        height = Double.parseDouble(sc.nextLine());
        System.out.print("Enter the width: ");
        width = Double.parseDouble(sc.nextLine());

        Rectangle rectangle1 = new Rectangle(width, height);

        System.out.println("Display rectangle area: " + rectangle1.getArea());
        System.out.println("Display rectangle perimeter: " + rectangle1.getPerimeter());
        System.out.println("Display rectangle info: " + rectangle1.display());

    }
}
