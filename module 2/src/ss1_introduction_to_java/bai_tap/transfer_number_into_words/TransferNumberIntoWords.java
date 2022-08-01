package ss1_introduction_to_java.bai_tap.transfer_number_into_words;

import java.util.Scanner;

public class TransferNumberIntoWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a,b,c;

        String toWord = "";

        System.out.println("Input your a figure here!");
        a = scanner.nextInt();

        System.out.println("Input your b figure here!");
        b = scanner.nextInt();

        System.out.println("Input your c figure here!");
        c = scanner.nextInt();

        if (a == 0 && b == 0) {
            switch (c) {
                case 1:
                    toWord = "One";
                    break;
                case 2:
                    toWord = "Two";
                    break;
                case 3:
                    toWord = "Three";
                    break;
                case 4:
                    toWord = "Four";
                    break;
                case 5:
                    toWord = "Five";
                    break;
                case 6:
                    toWord = "Six";
                    break;
                case 7:
                    toWord = "Seven";
                    break;
                case 8:
                    toWord = "Eight";
                    break;
                case 9:
                    toWord = "Nine";
                    break;
                case 0:
                    toWord = "Zero";
                default:
                    System.out.println("Out of ability");
            }
        } else if (a == 0 && b == 1) {
            switch (c) {
                case 1:
                    toWord = "Eleven";
                    break;
                case 2:
                    toWord = "Twelve";
                    break;
                case 3:
                    toWord = "Thirteen";
                    break;
                case 4:
                    toWord = "Fourteen";
                    break;
                case 5:
                    toWord = "Fifteen";
                    break;
                case 6:
                    toWord = "Sixteen";
                    break;
                case 7:
                    toWord = "Seventeen";
                    break;
                case 8:
                    toWord = "Eighteen";
                    break;
                case 9:
                    toWord = "Nineteen";
                    break;
                case 0:
                    toWord = "Ten";
            }
        } else if (a == 0 && b >= 2) {
            switch (b) {
                case 2:
                    toWord = "Twenty";
                    break;
                case 3:
                    toWord = "Thirty";
                    break;
                case 4:
                    toWord = "Fourty";
                    break;
                case 5:
                    toWord = "Fifty";
                    break;
                case 6:
                    toWord = "Sixty";
                    break;
                case 7:
                    toWord = "Seventy";
                    break;
                case 8:
                    toWord = "Eighty";
                    break;
                case 9:
                    toWord = "Ninety";
                    break;
            }
            switch (c) {
                case 1:
                    toWord += "One";
                    break;
                case 2:
                    toWord += "Two";
                    break;
                case 3:
                    toWord += "Three";
                    break;
                case 4:
                    toWord += "Four";
                    break;
                case 5:
                    toWord += "Five";
                    break;
                case 6:
                    toWord += "Six";
                    break;
                case 7:
                    toWord += "Seven";
                    break;
                case 8:
                    toWord += "Eight";
                    break;
                case 9:
                    toWord += "Nine";
                    break;
                case 0:
                    toWord += "";
                    break;
            }
        } else {
            switch (a) {
                case 1:
                    toWord = "One Hundred";
                    break;
                case 2:
                    toWord = "Two Hundred";
                    break;
                case 3:
                    toWord = "Three Hundred";
                    break;
                case 4:
                    toWord = "Four Hundred";
                    break;
                case 5:
                    toWord = "Five Hundred";
                    break;
                case 6:
                    toWord = "Six Hundred";
                    break;
                case 7:
                    toWord = "Seven Hundred";
                    break;
                case 8:
                    toWord = "Eight Hundred";
                    break;
                case 9:
                    toWord = "Nine Hundred";
                    break;
            }
            if (b == 0 && c !=0) {
                switch (c) {
                    case 1:
                        toWord += " And One";
                        break;
                    case 2:
                        toWord += " And Two";
                        break;
                    case 3:
                        toWord += " And Three";
                        break;
                    case 4:
                        toWord += " And Four";
                        break;
                    case 5:
                        toWord += " And Five";
                        break;
                    case 6:
                        toWord += " And Six";
                        break;
                    case 7:
                        toWord += " And Seven";
                        break;
                    case 8:
                        toWord += " And Eight";
                        break;
                    case 9:
                        toWord += " And Nine";
                        break;
                }
            }
            if (b == 1) {
                switch (c) {
                    case 1:
                        toWord += " And Eleven";
                        break;
                    case 2:
                        toWord += " And Twelve";
                        break;
                    case 3:
                        toWord += " And Thirteen";
                        break;
                    case 4:
                        toWord += " And Fourteen";
                        break;
                    case 5:
                        toWord += " And Fifteen";
                        break;
                    case 6:
                        toWord += " And Sixteen";
                        break;
                    case 7:
                        toWord += " And Seventeen";
                        break;
                    case 8:
                        toWord += " And Eighteen";
                        break;
                    case 9:
                        toWord += " And Nineteen";
                        break;
                }
            }
            if (b >= 2) {
                switch (b) {
                    case 2:
                        toWord += " And Twenty";
                        break;
                    case 3:
                        toWord += " And Thirty";
                        break;
                    case 4:
                        toWord += " And Forty";
                        break;
                    case 5:
                        toWord += " And Fifty";
                        break;
                    case 6:
                        toWord += " And Sixty";
                        break;
                    case 7:
                        toWord += " And Seventy";
                        break;
                    case 8:
                        toWord += " And Eighty";
                        break;
                    case 9:
                        toWord += " And Ninety";
                        break;
                }
                switch (c) {
                    case 1:
                        toWord += "One";
                        break;
                    case 2:
                        toWord += "Two";
                        break;
                    case 3:
                        toWord += "Three";
                        break;
                    case 4:
                        toWord += "Four";
                        break;
                    case 5:
                        toWord += "Five";
                        break;
                    case 6:
                        toWord += "Six";
                        break;
                    case 7:
                        toWord += "Seven";
                        break;
                    case 8:
                        toWord += "Eight";
                        break;
                    case 9:
                        toWord += "Nine";
                        break;
                }
            }
        }
        System.out.println(toWord);
    }
}
