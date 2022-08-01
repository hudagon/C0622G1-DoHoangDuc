import java.util.Scanner;

public class dayOfMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Which month do you want to count days?");
        int month = scanner.nextInt();

        switch (month) {
            case 1:
                System.out.println("The first month of the year has 31 days");
                break;
            case 2:
                System.out.println("The second month of the year has 28 days");
                break;
            case 3:
                System.out.println("The third month of the year has 31 days");
                break;
            case 4:
                System.out.println("The fourth month of the year has 30 days");
                break;
            case 5:
                System.out.println("The fifth month of the year has 31 days");
                break;
            case 6:
                System.out.println("The sixth month of the year has 30 days");
                break;
            case 7:
                System.out.println("The seventh month of the year has 31 days");
                break;
            case 8:
                System.out.println("The eighth month of the year has 31 days");
                break;
            case 9:
                System.out.println("The ninth month of the year has 30 days");
                break;
            case 10:
                System.out.println("The tenth month of the year has 31 days");
                break;
            case 11:
                System.out.println("The Eleventh month of the year has 30 days");
                break;
            default:
                System.out.println("The twelve month of the year has 31 days");
        }
    }
}
