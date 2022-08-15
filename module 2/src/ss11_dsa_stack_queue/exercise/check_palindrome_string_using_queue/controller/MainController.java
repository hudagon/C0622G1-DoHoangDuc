package ss11_dsa_stack_queue.exercise.check_palindrome_string_using_queue.controller;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MainController {
    public static void main(String[] args) {
        String str = "able was I ere I sae elba";
        String[] arrStr = str.split("");
        int count = 0;

        Stack<String> stack1 = new Stack<>();
        Queue<String> queue1 = new LinkedList<>();

        for (String s : arrStr) {
            stack1.add(s);
            queue1.add(s);
        }

        for (int i = 0; i < arrStr.length; i++) {
            if (!stack1.pop().equals(queue1.poll())) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println("This is a palindrome string");
        } else {
            System.out.println("This is not a palindrome string");
        }

    }
}
