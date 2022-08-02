package ss2_loop_in_java.exercise.add_elements_into_array;

import java.util.Scanner;

public class AddElementsIntoArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {1,2,3,4,5,6,7,8,9,0,0,0,0};
        int x, index;

        System.out.print("Input the number you want to add here:");
        x = scanner.nextInt();

        System.out.print("Input the index you want to add here:");
        index = scanner.nextInt();

        while (index <= -1 || index > (arr.length - 1)) {
            System.out.print("Error, please input again here:");
            index = scanner.nextInt();
        }

        for (int i = (arr.length - 1) ; i >= (index + 1); i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = x;

        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[arr.length-1]);

    }
}
