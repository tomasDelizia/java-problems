package com.tomasdelizia.stack.problem;

import java.util.Stack;

public class SortStack {
    public static <T> void sortStack(Stack<T> stack) {
        Stack<T> sorted = new Stack<>();
        while (!stack.isEmpty()) {
            T top = stack.pop();
            // Sort in descending order.
            while (!sorted.isEmpty() && compare(top, sorted.peek()) < 0) {
                stack.push(sorted.pop());
            }
            sorted.push(top);
        }
        // Add the elements from sorted to the original stack so it ends up in ascending order.
        while (!sorted.isEmpty()) {
            stack.push(sorted.pop());
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> int compare(Object k1, Object k2) {
        return ((Comparable<? super T>) k1).compareTo((T) k2);
    }
}
