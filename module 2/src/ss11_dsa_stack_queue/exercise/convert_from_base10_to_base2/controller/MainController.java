package ss11_dsa_stack_queue.exercise.convert_from_base10_to_base2.controller;

import java.util.Stack;

public class MainController {
    public static void main(String[] args) {
        int number = 6;
        Stack<Integer> stack = new Stack<>();

        while (number > 0) {
            stack.push(number % 2);
            number /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
