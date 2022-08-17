package ss13.search_algorithm.exercise.find_the_longest_ascending_string.controller;

import java.util.LinkedList;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert string here: ");
        String str = scanner.nextLine();
        LinkedList<Character> strArr2 = new LinkedList<>();
//   -------------------------------------------------
        for (int i = 0; i < str.length(); i++) {
            LinkedList<Character> strArr1 = new LinkedList<>();

            strArr1.add(str.charAt(i));

            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > strArr1.getLast()) {
                    strArr1.add(str.charAt(j));
                }
            }

            if (strArr1.size() >= strArr2.size()) {
                strArr2.clear();
                strArr2.addAll(strArr1);
            }
            strArr1.clear();
        }
//   -------------------------------------------------
        for (Character character : strArr2) {
            System.out.print(character);
        }
    }

    /*********************************************************************************
     * 	Tính toán độ phức tạp của bài toán:                                           *
     * 	1 vòng lặp bên ngoài = n;                                                     *
     * 	1 vòng lặp bên trong = n - 1;                                                 *
     *  1 câu lệnh = 1                                                                *
     * 	1 vòng lặp * 1 câu lệnh = 1;                                                  *
     *  T(n) = (n * (n - 1)) + (1 + 1);                                               *
     *  T(n) = O(n^2) + O(n);                                                         *
     * 	T(n) = O(n^2);                                                                *
     * 	=> Độ phức tạp bài toán này là O(n^2)                                         *
     *********************************************************************************/
}
