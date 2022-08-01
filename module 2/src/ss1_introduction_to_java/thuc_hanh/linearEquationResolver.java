import java.util.Scanner;

public class linearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given an equation as 'a * x + b = c', please enter the constants:");

        Scanner scanner = new Scanner(System.in);

        System.out.println("a: ");
        double a = scanner.nextDouble();

        System.out.println("b: ");
        double b = scanner.nextDouble();

        System.out.println("c: ");
        double c = scanner.nextDouble();

        if (a != 0) {
            double answer = (c - b) / a;
            System.out.println("The answer is: x = " + answer);
        } else if (b == c) {
            System.out.println("The solution is all X!");
        } else {
            System.out.println("No solution!");
        }
    }
}
