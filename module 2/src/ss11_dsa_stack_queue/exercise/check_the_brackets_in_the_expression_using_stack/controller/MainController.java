package ss11_dsa_stack_queue.exercise.check_the_brackets_in_the_expression_using_stack.controller;

import sun.awt.Symbol;

import java.util.Stack;

public class MainController {
    public static void main(String[] args) {
        String str = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))";
        String[] strArr = str.split("");
        Stack<String> stack1 = new Stack<>();
        boolean check = true;
        String left = "";

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals("(")) {
                stack1.push(strArr[i]);
            } else if (strArr[i].equals(")")) {
                if (stack1.isEmpty()) {
                    check = false;
                    break;
                } else {
                    left = stack1.pop();
                    if (!left.equals("(") || !strArr[i].equals(")")) {
                        check = false;
                        break;
                    }
                }
            }
            if (i == strArr.length - 1) {
                check = stack1.isEmpty();
            }
        }

        if (check) {
            System.out.println("This expression is fine");
        } else {
            System.out.println("This expression is not fine");
        }
    }
}
