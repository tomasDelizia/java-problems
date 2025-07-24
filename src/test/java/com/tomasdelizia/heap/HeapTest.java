package com.tomasdelizia.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HeapTest {
    @Test
    void testHeap() {
        Heap<Integer> heap = new Heap<>();
        assertTrue(heap.getHeap().isEmpty());

        heap.insert(10);
        assertEquals(1, heap.getHeap().size());
        assertEquals(10, heap.getHeap().getFirst());
        System.out.println(heap.getHeap());

        heap.insert(20);
        assertEquals(2, heap.getHeap().size());
        assertEquals(20, heap.getHeap().getFirst());
        System.out.println(heap.getHeap());

        heap.insert(5);
        assertEquals(3, heap.getHeap().size());
        assertEquals(5, heap.getHeap().get(2));
        System.out.println(heap.getHeap());

        assertEquals(20, heap.remove());
        System.out.println(heap.getHeap());
        assertEquals(10, heap.remove());
        System.out.println(heap.getHeap());
        assertEquals(5, heap.remove());
        System.out.println(heap.getHeap());
    }

    @Test
    void testHeapify() {
        Integer[] values = {10, 20, 5, 15, 30};
        Heap<Integer> heap = new Heap<>(values);
        assertEquals(5, heap.getHeap().size());
        assertEquals(30, heap.getHeap().getFirst());
        System.out.println(heap.getHeap());

        heap.insert(25);
        assertEquals(6, heap.getHeap().size());
        assertEquals(30, heap.getHeap().getFirst());
        System.out.println(heap.getHeap());

        assertEquals(30, heap.remove());
        System.out.println(heap.getHeap());
    }

}