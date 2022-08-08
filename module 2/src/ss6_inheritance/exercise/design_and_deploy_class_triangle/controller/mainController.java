package ss6_inheritance.exercise.design_and_deploy_class_triangle.controller;

import ss6_inheritance.exercise.design_and_deploy_class_triangle.models.Triangle;

import java.util.Scanner;

public class mainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double side1;
        double side2;
        double side3;
        String color;

        do {
            System.out.print("Input the fist side of the triangle: ");
            side1 = Double.parseDouble(scanner.nextLine());
            System.out.print("Input the second side of the triangle: ");
            side2 = Double.parseDouble(scanner.nextLine());
            System.out.print("Input the third side of the triangle: ");
            side3 = Double.parseDouble(scanner.nextLine());
            System.out.print("Input the color of the triangle: ");
            color = scanner.nextLine();

            if ((side1 + side2) < side3 || (side1 + side3) < side2 || (side3 + side2) < side1) {
                System.out.println("Incorrect input, please try again!");
            } else {
                break;
            }

        } while (true);

        Triangle triangle1 = new Triangle(color, side1, side2, side3);

        System.out.println(triangle1.getInsideTheSquare());
    }
}
