package ss4_oop.exercise.build_quadratic_equation_class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double a, b, c;
        Scanner sc = new Scanner(System.in);

        System.out.print("Input a: ");
        a = Double.parseDouble(sc.nextLine());
        System.out.print("Input b: ");
        b = Double.parseDouble(sc.nextLine());
        System.out.print("Input b: ");
        c = Double.parseDouble(sc.nextLine());

        QuadraticEquation quadraticEquation1 = new QuadraticEquation(a,b,c);

        if (quadraticEquation1.getDiscriminat() == 0) {
            System.out.println("The equation has one root: " + quadraticEquation1.getRoo1());
        } else if (quadraticEquation1.getDiscriminat() > 0) {
            System.out.println("The equation has 2 root:" + quadraticEquation1.getRoo1() + " and " + quadraticEquation1.getRoo2());
        } else {
            System.out.println("The equation has no root!");
        }
    }
}
