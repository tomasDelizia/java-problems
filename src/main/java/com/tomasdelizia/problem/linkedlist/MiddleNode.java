package com.tomasdelizia.problem.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class MiddleNode {
    public static <T> T findMiddleValue(LinkedList<T> list) {
        Iterator<T> slowIterator = list.iterator(), fastIterator = list.iterator();
        while (fastIterator.hasNext()) {
            fastIterator.next();
            if (fastIterator.hasNext()) fastIterator.next();
            else return slowIterator.next();
            if (!fastIterator.hasNext()) return slowIterator.next();
            slowIterator.next();
        }
        return slowIterator.next();
    }
}
