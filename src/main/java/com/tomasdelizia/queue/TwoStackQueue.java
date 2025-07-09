package com.tomasdelizia.queue;

import java.util.Stack;

public class TwoStackQueue<T> {
    private final Stack<T> stack1;
    private final Stack<T> stack2;

    public TwoStackQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void enqueue(T value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public T dequeue() {
        if (isEmpty()) return null;
        return stack1.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public T peek() {
        return stack1.peek();
    }
}
