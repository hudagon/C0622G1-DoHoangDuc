package ss1_introduction_to_java.thuc_hanh.bmi_calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double height, weight, bmi;

        System.out.println("Input your height here (in meters): ");
        height = scanner.nextDouble();

        System.out.println("Input your weight here (in kilograms): ");
        weight = scanner.nextDouble();

        bmi = weight / (height * height);

        if (bmi < 18.5) {
            System.out.println("You are underweight!");
        } else if (bmi < 25) {
            System.out.println("You are nomarl!");
        } else if (bmi < 30) {
            System.out.println("You are overweight!");
        } else {
            System.out.println("You are obese!");
        }
    }

}
