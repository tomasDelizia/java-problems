package com.tomasdelizia.problem.string;

import java.util.Stack;

public class ParenthesesBalanced {
    public static boolean parentheseseBalanced(String string) {
        int n = string.length();
        if (n == 0) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        if (string.charAt(0) == ')') {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = n / 2; i < n; i++) {
            stack.push(string.charAt(i));
        }
        for (int i = 0; i < n / 2; i++) {
            char fromString = string.charAt(i);
            char fromStack = stack.pop();
            if (fromStack == fromString) {
                return false;
            }
        }
        return true;
    }

    public static boolean parentheseseBalancedOneFor(String string) {
        int n = string.length();
        if (n % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char p : string.toCharArray()) {
            if (p == '(') {
                stack.push(p);
            } else if (p == ')' && (stack.isEmpty() || stack.pop() == ')')) {
                return false;
            }
        }
        return true;
    }
}
