package com.tomasdelizia.problem.string;

import java.util.ArrayList;
import java.util.List;

public class Reverse {
    public static String reverseWithStack(String string) {
        List<Character> stack = new ArrayList<>();
        int n = string.length();
        for (int i = 0; i < n; i++) {
            stack.add(string.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            result.append(stack.remove(i));
        }
        return result.toString();
    }
}
