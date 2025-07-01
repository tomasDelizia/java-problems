package com.tomasdelizia.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueTest {
    @Test
    void testEnqueue() {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        assertEquals(1, queue.getLength());
        assertEquals(1, queue.getFirst());
        assertEquals(1, queue.getLast());
        queue.enqueue(2);
        assertEquals(2, queue.getLength());
        assertEquals(1, queue.getFirst());
        assertEquals(2, queue.getLast());
        queue.enqueue(3);
        assertEquals(3, queue.getLength());
        assertEquals(1, queue.getFirst());
        assertEquals(3, queue.getLast());
        queue.printQueue(); // Expected output: 1 2 3 4 5
    }

    @Test
    void testDequeue() {
        Queue<Integer> queue = new Queue<>(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Integer dequeued = queue.dequeue();
        assertEquals(1, dequeued);
        assertEquals(2, queue.getLength());
        assertEquals(2, queue.getFirst());
        assertEquals(3, queue.getLast());

        dequeued = queue.dequeue();
        assertEquals(2, dequeued);
        assertEquals(1, queue.getLength());
        assertEquals(3, queue.getFirst());
        assertEquals(3, queue.getLast());

        dequeued = queue.dequeue();
        assertEquals(3, dequeued);
        assertEquals(0, queue.getLength());
    }
}