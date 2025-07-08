package com.tomasdelizia.hash.problem;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> anagramsPerString = new Hashtable<>();
        for (String string : strings) {
            char[] chars = string.toCharArray();
            insertionSort(chars);
            String canonic = String.valueOf(chars);
            if (anagramsPerString.containsKey(canonic)) {
                anagramsPerString.get(canonic).add(string);
                continue;
            }
            anagramsPerString.put(canonic, new ArrayList<>());
            anagramsPerString.get(canonic).add(string);
        }
        return new ArrayList<>(anagramsPerString.values());
    }

    private static void insertionSort(char[] chars) {
        int n = chars.length;
        if (n <= 1) return;
        for (int j = 1; j < n; j++) {
            char current = chars[j];
            int k = j-1;
            while (k >= 0 && current < chars[k]) {
                chars[k+1] = chars[k];
                k--;
            }
            chars[k+1] = current;
        }
    }
}
