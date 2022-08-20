package ss15_exception.practice.using_numberformatexception_class;

import java.util.Scanner;

public class CalculationExample {
    public static void calculate(int x, int y) {
        try {
            double a = x + y;
            double b = x - y;
            double c = x / y;
            double d = x * y;
            System.out.println("Tổng bằng: " + a);
            System.out.println("Hiệu bằng: " + b);
            System.out.println("Tích bằng: " + c);
            System.out.println("Thương bằng: " + d);
        } catch (Exception e) {
            System.out.println("Lỗi " + e.getMessage() + " rồi");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hãy nhập x và y");
        System.out.print("Nhập x: ");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập y: ");
        int y = Integer.parseInt(scanner.nextLine());

        calculate(x, y);
    }
}
