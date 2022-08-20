package ss15_exception.exercise.using_illegaltriangleexception_class;

import java.util.Scanner;

public class IllegalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double edge1 = 0;
        double edge2 = 0;
        double edge3 = 0;

        while (true) {
            try {
                System.out.print("Input the first edge's length: ");
                edge1 = Double.parseDouble(scanner.nextLine());
                if (edge1 < 0) {
                    throw new TriangleException("Illegal triangle length!");
                }
                System.out.print("Input the second edge's length: ");
                edge2 = Double.parseDouble(scanner.nextLine());
                if (edge2 < 0) {
                    throw new TriangleException("Illegal triangle length!");
                }
                System.out.print("Input the third edge's length: ");
                edge3 = Double.parseDouble(scanner.nextLine());
                if (edge3 < 0) {
                    throw new TriangleException("Illegal triangle length!");
                }
                if ((edge1 + edge2) <= edge3 || (edge1 + edge3) <= edge2 || (edge2 + edge3) <= edge1) {
                    throw new TriangleException("Sum of the two triangle edge's length must be greater than the other");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Wrong input!");
            } catch (TriangleException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Incorrect input!");
            }
        }

        System.out.print("The lengths of the 3 sides respectively are: " + edge1 + ", " + edge2 + ", " + edge3);
    }
}
