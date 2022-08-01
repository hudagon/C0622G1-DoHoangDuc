package ss1_introduction_to_java.bai_tap.currency_transfer;

import java.util.Scanner;

public class CurrencyTransfer {
    public static void main(String[] args) {
        double rate = 23000, USD, VND;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input USD here: ");
        USD = scanner.nextDouble();

        VND = USD * rate;

        System.out.println("The amount of money in VND is: " + VND);
    }
}
