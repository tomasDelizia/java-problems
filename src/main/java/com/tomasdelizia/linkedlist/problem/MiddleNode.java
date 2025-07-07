package com.tomasdelizia.linkedlist.problem;

import java.util.Iterator;
import java.util.LinkedList;

public class MiddleNode {
    public static <T> T findMiddleValue(LinkedList<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Iterator<T> slow = list.iterator(), fast = list.iterator();
        T middle = null;
        while (fast.hasNext()) {
            middle = slow.next();
            fast.next();
            if (fast.hasNext()) {
                fast.next();
            }
        }
        return middle;
    }
}
