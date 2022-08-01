import java.util.Scanner;

public class LeapYearCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year;

        System.out.println("Which year do you want to check?");
        year = scanner.nextInt();

        if(year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.println(year + " is a leap year!");
                } else {
                    System.out.println(year + " isn't a leap year!");
                }
            } else {
                System.out.println(year + " ins't a leap year");
            }
        } else {
            System.out.println(year + " ins't a leap year");
        }

    }
}
