package ss11_dsa_stack_queue.exercise.reverse_elements_in_integer_stack.controller;

import java.util.Stack;

public class MainController {


    public static void main(String[] args) {
//      Đảo ngược mảng sử dụng Stack
        int[] arr = {1, 2, 3, 4, 5};
        Stack<Integer> integerStack = new Stack<>();

        for (int value : arr) {
            integerStack.push(value);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = integerStack.pop();
        }

//      Đảo ngược chuỗi sử dụng Stack
        String str = "Hello World I love you";
        StringBuilder str2 = new StringBuilder();
        String[] arrStr = str.split(" ");

        Stack<String> stringStack = new Stack<>();

        for (String value : arrStr) {
            stringStack.push(value);
        }

        for (int i = 0; i < arrStr.length; i++) {
            arrStr[i] = stringStack.pop();
        }

        for (String s : arrStr) {
            str2.append(s).append(" ");
        }

        System.out.println(str2);
    }
}

