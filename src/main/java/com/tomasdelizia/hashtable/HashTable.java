package com.tomasdelizia.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HashTable<K, V> {
    private final int size = 7;
    private final Node<K, V>[] dataMap;

    @SuppressWarnings("unchecked")
    public HashTable() {
        dataMap = (Node<K, V>[]) new Node[size];
    }

    public void printHashTable() {
        for (int i = 0; i < size; i++) {
            Node<K, V> current = dataMap[i];
            System.out.print("Index " + i + ": ");
            while (current != null) {
                System.out.print(current);
                if (current.next != null) {
                    System.out.print(" -> ");
                }
                current = current.next;
            }
            System.out.println();
        }
    }

    private int hash(K key) {
        int hash = 7;
        hash = 61 * hash + key.hashCode();
        // Use modulo to ensure the hash fits within the array bounds
        return hash % dataMap.length;
    }

    public void set(K key, V value) {
        int index = hash(key);
        Node<K, V> node = new Node<>(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = node;
            return;
        }
        // Will point to the "head" node at the array index
        Node<K, V> current = dataMap[index];
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public V get(K key) {
        int index = hash(key);
        Node<K, V> current = dataMap[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (Node<K, V> current : dataMap) {
            while (current != null) {
                keys.add(current.key);
                current = current.next;
            }
        }
        return keys;
    }

    public static class Node<K, V> {
        private final K key;
        private final V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
