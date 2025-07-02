package com.tomasdelizia.hashtable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashTableTest {
    @Test
    void testGetSetValuesHashTable() {
        HashTable<String, Integer> hashTable = new HashTable<>();
        hashTable.set("one", 1);
        hashTable.set("two", 2);
        hashTable.set("three", 3);
        hashTable.set("four", 4);
        hashTable.set("five", 5);
        hashTable.set("six", 6);
        hashTable.set("seven", 7);
        hashTable.printHashTable();

        assertEquals(1, hashTable.get("one"));
        assertEquals(2, hashTable.get("two"));
        assertEquals(3, hashTable.get("three"));
        assertEquals(4, hashTable.get("four"));
        assertEquals(5, hashTable.get("five"));
        assertEquals(6, hashTable.get("six"));
        assertEquals(7, hashTable.get("seven"));
        System.out.println("Keys: " + hashTable.keys());
    }
}